package team.tjusw.elmboot.service.impl;
import team.tjusw.elmboot.bo.ScoreBO;
import team.tjusw.elmboot.bo.ScoreStoreBO;
import team.tjusw.elmboot.entity.ScoreEntity;
import team.tjusw.elmboot.entity.ScoreStoreEntity;
import team.tjusw.elmboot.mapper.ScoreMapper;
import team.tjusw.elmboot.mapper.ScoreStoreMapper;
import team.tjusw.elmboot.service.ScoreService;
import team.tjusw.elmboot.util.CommonUtil;
import team.tjusw.elmboot.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;
	@Autowired
	private ScoreStoreMapper scoreStoreMapper;
	
	@Override
	public int saveCredit(ScoreVO scoreVO) {
		// TODO Auto-generated method stub
		ScoreEntity score = new ScoreEntity();
		score.setUserId(scoreVO.getUserId());
		score.setCredit(scoreVO.getCredit());
		score.setChannelId(scoreVO.getChannelId());
		score.setCreateDate(CommonUtil.getCurrentDate());
		//计算过期时间
		score.setExpireDate(CommonUtil.getNextData(scoreVO.getTime()));
		ScoreStoreEntity scoreStoreEntity = new ScoreStoreEntity(score);
		scoreStoreMapper.saveScoreStore(scoreStoreEntity);
		return scoreMapper.saveScore(score);
	}

	@Override
	public int expendCredit(ScoreVO scoreVO) {
		// TODO Auto-generated method stub
		String userId = scoreVO.getUserId();
		Integer credit = scoreVO.getCredit();
		if(getCreditByUserId(userId)<credit)//如果积分不够，返回0，不进行任何操作
			return 0;
		
		ScoreEntity score = new ScoreEntity();
		score.setUserId(userId);
		score.setCredit(-credit);
		score.setChannelId(scoreVO.getChannelId());
		score.setCreateDate(CommonUtil.getCurrentDate());
		//计算scorestore
		List<ScoreStoreEntity> list = scoreStoreMapper.listScoreStoreByUserId(userId,CommonUtil.getCurrentDate());
		List<ScoreStoreBO> scoreStores = new ArrayList<ScoreStoreBO>();
		for(int i=0;i<list.size();i++)
			scoreStores.add(new ScoreStoreBO(list.get(i)));
		for(int i=0;i<scoreStores.size();i++) {
			int left = scoreStores.get(i).useScore(credit);
			
			if(left == -1) {
				//本条积分store够用，update
				ScoreStoreEntity tmp = new ScoreStoreEntity();
				tmp.setScorestoreId(scoreStores.get(i).getScorestoreId());
				tmp.setScore(scoreStores.get(i).getScore());
				scoreStoreMapper.updateScoreStore(tmp);
				break;
			}else if(left == 0){
				//本条积分store正好用完，delete
				scoreStoreMapper.removeScoreStore(scoreStores.get(i).getScorestoreId());
				break;
			}else {
				//本条积分store不够用，delete，继续用下一个
				scoreStoreMapper.removeScoreStore(scoreStores.get(i).getScorestoreId());
				credit = left;
			}
		}
		return scoreMapper.saveScore(score);
	}

	@Override
	public int getCreditByUserId(String userId) {
		// TODO Auto-generated method stub
		String date = CommonUtil.getCurrentDate();
		List<ScoreStoreEntity> list = scoreStoreMapper.listScoreStoreByUserId(userId, date);
		int sum = 0;
		for(int i=0;i<list.size();i++)
			sum += list.get(i).getScore();
		return sum;
	}

	@Override
	public List<ScoreBO> listGainScoresByUserId(String userId) {
		// TODO Auto-generated method stub
		List<ScoreEntity> list = scoreMapper.listGainScoreByUserId(userId);
		List<ScoreBO> res = new ArrayList<ScoreBO>();
		for(int i=0;i<list.size();i++)
			res.add(new ScoreBO(list.get(i)));
		return res;
	}
	
	@Override
	public List<ScoreBO> listUseScoresByUserId(String userId) {
		// TODO Auto-generated method stub
		List<ScoreEntity> list = scoreMapper.listUseScoreByUserId(userId);
		List<ScoreBO> res = new ArrayList<ScoreBO>();
		for(int i=0;i<list.size();i++)
			res.add(new ScoreBO(list.get(i)));
		return res;
	}
	
//	@Override
//	public int saveCredit(String userId) {
//		// TODO Auto-generated method stub
//		ScoreEntity score = new ScoreEntity();
//		score.setCredit(777);
//		score.setUserId(userId);
//		score.setCreateDate(CommonUtil.getCurrentDate());
//		score.setExpireDate(CommonUtil.getCurrentDate());
//		//ScoreStoreEntity scoreStoreEntity = new ScoreStoreEntity(score);
//		//scoreStoreMapper.saveScoreStore(scoreStoreEntity);
//		return scoreMapper.saveScore(score);
//	}

}

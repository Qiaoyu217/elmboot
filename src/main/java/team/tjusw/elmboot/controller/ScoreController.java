package team.tjusw.elmboot.controller;

import team.tjusw.elmboot.bo.ScoreBO;
import team.tjusw.elmboot.service.ScoreService;
import team.tjusw.elmboot.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ScoreController")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping("/gainCredit")
	public int gainCredit(ScoreVO scoreVO) {
		return scoreService.saveCredit(scoreVO);
	}
	
	@RequestMapping("/expendCredit")
	public int expendCredit(ScoreVO scoreVO) {
		return scoreService.expendCredit(scoreVO);
	}
	
	@RequestMapping("/getCredit")
	public int getCredit(ScoreVO scoreVO) {
		return scoreService.getCreditByUserId(scoreVO.getUserId());
	}
	
	@RequestMapping("/listGainLog")
	public List<ScoreVO> listGainLog(ScoreVO scoreVO) {
		List<ScoreBO> list = scoreService.listGainScoresByUserId(scoreVO.getUserId());
		List<ScoreVO> log = new ArrayList<ScoreVO>();
		for(int i=0;i<list.size();i++)
			log.add(new ScoreVO(list.get(i)));
		return log;
	}
	
	@RequestMapping("/listUseLog")
	public List<ScoreVO> listUseLog(ScoreVO scoreVO) {
		List<ScoreBO> list = scoreService.listUseScoresByUserId(scoreVO.getUserId());
		List<ScoreVO> log = new ArrayList<ScoreVO>();
		for(int i=0;i<list.size();i++)
			log.add(new ScoreVO(list.get(i)));
		return log;
	}
}

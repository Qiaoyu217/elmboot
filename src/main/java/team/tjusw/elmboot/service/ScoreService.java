package team.tjusw.elmboot.service;

import team.tjusw.elmboot.bo.ScoreBO;
import team.tjusw.elmboot.vo.ScoreVO;

import java.util.List;

public interface ScoreService {

	public int saveCredit(ScoreVO scoreVO);
	//public int saveCredit(String userId);
	
	public int expendCredit(ScoreVO scoreVO);
	
	public int getCreditByUserId(String userId);
	
	public List<ScoreBO> listGainScoresByUserId(String userId);
	
	public List<ScoreBO> listUseScoresByUserId(String userId);
}

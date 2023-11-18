package team.tjusw.elmboot.mapper;

import team.tjusw.elmboot.entity.ScoreEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreMapper {

	@Insert("insert into score values(null,#{userId},#{channelId},#{eventId},#{credit},#{createDate},#{expireDate})")
	public int saveScore(ScoreEntity scoreEntity);
	
	@Select("select * from score where userId=#{userId} and credit>0 order by createDate desc")
	public List<ScoreEntity> listGainScoreByUserId(String userId);
	
	@Select("select * from score where userId=#{userId} and credit<0 order by createDate desc")
	public List<ScoreEntity> listUseScoreByUserId(String userId);
}

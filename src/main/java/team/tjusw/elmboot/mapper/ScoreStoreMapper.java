package team.tjusw.elmboot.mapper;

import team.tjusw.elmboot.entity.ScoreStoreEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreStoreMapper {

	@Insert("insert into scorestore values(null,#{userId},#{score},#{expireDate})")
	public int saveScoreStore(ScoreStoreEntity scoreStoreEntity);
	
	@Update("update scorestore set score=#{score} where scorestoreId=#{scorestoreId}")
	public int updateScoreStore(ScoreStoreEntity scoreStoreEntity);
	
	@Delete("delete from scorestore where scorestoreId=#{scorestoreId}")
	public int removeScoreStore(Integer scorestoreId);
	
	@Select("select * from scorestore where userId=#{userId} and score>=0 and expireDate>#{date} order by expireDate")
	public List<ScoreStoreEntity> listScoreStoreByUserId(String userId,String date);
}

package team.tjusw.elmboot.entity;

public class ScoreStoreEntity {

	private Integer scorestoreId;
	private String userId;
	private Integer score;
	private String expireDate;
	
	public ScoreStoreEntity() {}
	
	public ScoreStoreEntity(ScoreEntity score) {
		this.userId = score.getUserId();
		this.score = score.getCredit();
		this.expireDate = score.getExpireDate();
	}
	
	public Integer getScorestoreId() {
		return scorestoreId;
	}
	public void setScorestoreId(Integer scorestoreId) {
		this.scorestoreId = scorestoreId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
}

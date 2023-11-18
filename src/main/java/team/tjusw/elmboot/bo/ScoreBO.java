package team.tjusw.elmboot.bo;

import team.tjusw.elmboot.entity.ScoreEntity;

public class ScoreBO {
	private Integer channelId = null;
	private Integer eventId = null;
	private Integer credit;
	private String createDate;
	private String expireDate;
	
	public ScoreBO(ScoreEntity s) {
		this.credit = s.getCredit();
		this.createDate = s.getCreateDate();
		this.expireDate = s.getExpireDate();
		this.channelId = s.getChannelId();
		this.eventId = s.getEventId();
	}
	
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
}

package com.noel.mysite03.User;

public class BoardVo {

	private Long no;
	private String title;
	private String content;
	private String userName;
	private int hit;
	private String regDate;
	private Long userNo;

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "\n BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", userName=" + userName
				+ ", hit=" + hit + ", regDate=" + regDate + ", userNo=" + userNo + "]";
	}



	
	
}

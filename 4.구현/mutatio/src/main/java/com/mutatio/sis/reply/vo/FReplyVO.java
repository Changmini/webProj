package com.mutatio.sis.reply.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FReplyVO {

	private int freeNo;                /*부모글번호 */
	private int freeReNo;             /*댓글번호*/
	private int freeReParentNo;       /*부모댓글 번호*/
	private String freeReMemId;       /*작성자ID*/
	private String freeReContent;     /*댓글 내용*/
	private String freeReRegDate;     /*댓글 등록일자*/
	private String freeReModDate;     /*댓글 수정일자*/
	private String freeReDelYn;     /*댓글 삭제여부*/
	
	// 대댓글 쿼리에 필요한 vo
	private int commentLevel;
	

	private String freeReMemName;    /*reMemId를 가지고 DB에 연결해서 조회해서 얻으면 됨*/
	private String reContent; //???
	private String freeTitle; // 조회용
	private String freeCategory;
	
	
	
	
	
	public int getCommentLevel() {
		return commentLevel;
	}
	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}
	
	public String getReContent() {
		return reContent;
	}
	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	public int getFreeNo() {
		return freeNo;
	}
	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

	public int getFreeReNo() {
		return freeReNo;
	}

	public void setFreeReNo(int freeReNo) {
		this.freeReNo = freeReNo;
	}

	public int getFreeReParentNo() {
		return freeReParentNo;
	}

	public void setFreeReParentNo(int freeReParentNo) {
		this.freeReParentNo = freeReParentNo;
	}

	public String getFreeReMemId() {
		return freeReMemId;
	}

	public void setFreeReMemId(String freeReMemId) {
		this.freeReMemId = freeReMemId;
	}

	public String getFreeReContent() {
		return freeReContent;
	}

	public void setFreeReContent(String freeReContent) {
		this.freeReContent = freeReContent;
	}

	public String getFreeReRegDate() {
		return freeReRegDate;
	}

	public void setFreeReRegDate(String freeReRegDate) {
		this.freeReRegDate = freeReRegDate;
	}

	public String getFreeReModDate() {
		return freeReModDate;
	}

	public void setFreeReModDate(String freeReModDate) {
		this.freeReModDate = freeReModDate;
	}

	public String getFreeReDelYn() {
		return freeReDelYn;
	}

	public void setFreeReDelYn(String freeReDelYn) {
		this.freeReDelYn = freeReDelYn;
	}

	public String getFreeReMemName() {
		return freeReMemName;
	}

	public void setFreeReMemName(String freeReMemName) {
		this.freeReMemName = freeReMemName;
	}
	public String getFreeTitle() {
		return freeTitle;
	}
	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}
	public String getFreeCategory() {
		return freeCategory;
	}
	public void setFreeCategory(String freeCategory) {
		this.freeCategory = freeCategory;
	}

	

	
	
	
}

package com.mutatio.sis.question.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class QuesVO {
	@NotNull(groups = {Default.class})
	private int quesNo;             /*문의게시글번호*/
	private Integer quesThesisNo;   /*문의논문번호*/
	
	@NotBlank(message = "글 분류 코드 필수") /*groups -> Default.class*/
	private String quesCategory;    /*문의게시글코드*/
	@NotBlank(message = "글 제목 필수")    /*groups -> Default.class*/
	private String quesTitle;       /*문의게시글제목*/
	private String quesWriter;      /*문의작성자*/
	private String quesPass;        /*문의비밀번호*/
	@NotBlank(message = "글 내용 필수")   /*groups -> Default.class*/
	private String quesContent;     /*문의내용*/
	private int quesHit;            /*문의논문조회수*/
	private String quesRegDate;     /*문의논문작성일*/
	private String quesModDate;     /*문의논문수정일*/
	private String quesDelYn;       /*문의논문게시글삭제여부*/
	
	private String commNm;          /*코드테이블 코드네임*/
	private String reCnt;           /*답글갯수*/
	
	private String errClass;        /*문의글오류발생시*/
	

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

	public int getQuesNo() {
		return quesNo;
	}

	public void setQuesNo(int quesNo) {
		this.quesNo = quesNo;
	}

	public Integer getQuesThesisNo() {
		return quesThesisNo;
	}

	public void setQuesThesisNo(Integer quesThesisNo) {
		this.quesThesisNo = quesThesisNo;
	}

	public String getQuesCategory() {
		return quesCategory;
	}

	public void setQuesCategory(String quesCategory) {
		this.quesCategory = quesCategory;
	}

	public String getQuesTitle() {
		return quesTitle;
	}

	public void setQuesTitle(String quesTitle) {
		this.quesTitle = quesTitle;
	}

	public String getQuesWriter() {
		return quesWriter;
	}

	public void setQuesWriter(String quesWriter) {
		this.quesWriter = quesWriter;
	}

	public String getQuesPass() {
		return quesPass;
	}

	public void setQuesPass(String quesPass) {
		this.quesPass = quesPass;
	}

	public String getQuesContent() {
		return quesContent;
	}

	public void setQuesContent(String quesContent) {
		this.quesContent = quesContent;
	}

	public int getQuesHit() {
		return quesHit;
	}

	public void setQuesHit(int quesHit) {
		this.quesHit = quesHit;
	}

	public String getQuesRegDate() {
		return quesRegDate;
	}

	public void setQuesRegDate(String quesRegDate) {
		this.quesRegDate = quesRegDate;
	}

	public String getQuesModDate() {
		return quesModDate;
	}

	public void setQuesModDate(String quesModDate) {
		this.quesModDate = quesModDate;
	}

	public String getQuesDelYn() {
		return quesDelYn;
	}

	public void setQuesDelYn(String quesDelYn) {
		this.quesDelYn = quesDelYn;
	}
	
	public String getCommNm() {
		return commNm;
	}

	public void setCommNm(String commNm) {
		this.commNm = commNm;
	}
	public String getReCnt() {
		return reCnt;
	}
	
	public void setReCnt(String reCnt) {
		this.reCnt = reCnt;
	}
	
	public String getErrClass() {
		return errClass;
	}
	
	public void setErrClass(String errClass) {
		this.errClass = errClass;
	}

	
	
	
}// class







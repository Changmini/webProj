<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.mutatio.sis.common.util.CookieUtils"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>My Info</title>
<%@include file="/WEB-INF/inc/frame.jsp"%>
<%@include file="/WEB-INF/inc/onload.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/style_memberEdit.css">
</head>
<script>
	
	/* modal (.cap_pw 버튼을 눌렀을 때 modal창이 열림.) */
	$(function(){
		$(".cap_pw").click(function(){
			$(".modal").fadeIn();
		});
		
		$(".close").click(function(){
			$(".modal").fadeOut();
		});
	});

	
	function ps_save() {
		let mem_pass_v = document.getElementById("memPass").value;
		let mem_pass_ch_v = document.getElementById("memPassCh").value;
		let mem_pass_label = $(".modal label[for='memPass']");
		let mem_pass_ch_label = $(".modal label[for='memPassCh']");
		
		mem_pass_label.removeClass("warning");
		mem_pass_ch_label.removeClass("warning");
		
		if (mem_pass_v == null || mem_pass_v == "" || mem_pass_v == undefined) {
			mem_pass_label.addClass("warning");
			alert("비밀번호를 입력해주세요.");
			return false;		
		} else if (mem_pass_ch_v == null || mem_pass_ch_v == "" || mem_pass_ch_v == undefined) {
			mem_pass_ch_label.addClass("warning");
			alert("비밀번호를 확인해주세요.");
			return false;
		} else if(mem_pass_v != mem_pass_ch_v){
			alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
		} else {
			alert("비밀번호가 성공적으로 저장되었습니다.");
			modal.submit();
		}
	} //save()
</script>
<body>

	<div id="wrap">

		<div class="header"></div>
		<!-- header -->

		<!-- ================================================================== -->

		<div id="sub_title_div"></div>
		<!-- sub_title_div -->

		<!-- ================================================================== -->

		<div class="contents">
			<div class="center">
				<div class="textArea">
					<c:if test="${not empty error}">
						<div class="warning">${error}</div>
					</c:if>
					<section class="myInfo_section">
						<h1>회원정보 수정</h1>
						<div class="form_div">
							<form name="myInfo_form" action="memberBasicModify.do"
								method="post">
								<sec:csrfInput />
								<!--아이디-->
								<div class="int-area">
									<label for="mem_id">ID</label>
									<p>${member.memId }
									<p>
								</div>
								<!-- 이름 -->
								<div class="int-area">
									<input type="text" id="mem_name" name="memName"
										value="${member.memName }" required> <label
										for="mem_name">NAME</label>
								</div>
								<!-- 생년월일 -->
								<div class="int-area">
									<input type="date" id="mem_bir" name="memBir"
										value="${member.memBir }" required> <label
										for="mem_bir">생년월일</label>
								</div>
								<!-- 직업 -->
								<div class="int-area">
									<select id="mem_jb" name="memJob" title="직업">
										<!-- DB에서 쓰는 이름 name에 적기 -->
										<c:forEach items="${jobCodeList }" var="i">
											<option value="${i.commCd}"
												${member.memJob eq i.commCd? 'selected="selected"':""}>${i.commNm}</option>
										</c:forEach>
									</select> <label for="mem_job">직업</label>
								</div>

								<!-- 관심분야 -->
								<div class="int-area mem_cc">
									<!-- 체크리스트 S -->
									<label for="mem_cc">관심분야</label>
									<div class="checkList">
										<c:forEach items="${conCodeList}" var="i" varStatus="index">
											<c:if test="${index.count == 1}">
											<span class="checkList1">
											</c:if>
											
											<c:if test="${index.count <= 4 }">
												<input id="ChkList${index.count}" class="chkBoxType_input"
													type="checkbox" name="conCode" value="${i.commCd}"
													onclick="countChecked(this)" 
													${ (member.conCode[0] eq i.commCd) || (member.conCode[1] eq i.commCd)
																							? 'checked="checked"':""}>
												<label for="ChkList${index.count}" class="chkBoxType">
													<span class="checkBox">${i.commNm}</span>
												</label>
											</c:if>
				
											<c:if test="${index.count == 4 }">
											</span>	
											<span class="checkList2">
											</c:if>
												
											<c:if test="${index.count > 4 }">
												<input id="ChkList${index.count}" class="chkBoxType_input"
													type="checkbox" name="conCode" value="${i.commCd}"
													onclick="countChecked(this)"
													${ (member.conCode[0] eq i.commCd) || (member.conCode[1] eq i.commCd)
																							? 'checked="checked"':""}>
												<label for="ChkList${index.count}" class="chkBoxType">
													<span class="checkBox">${i.commNm}</span>
												</label>
											</c:if>
										
											<c:if test="${index.count == 8 }">
											</span>
											</c:if>
										</c:forEach>									
									</div> <!-- checkList E -->
								
								</div>
								<!-- 관심분야 E -->

								<!-- 이메일 -->
								<div class="int-area">
									<input type="email" id="mem_mail" name="memMail"
										value="${member.memMail}" required> <label
										for="mem_mail">EMAIL</label>
								</div>

								<div class="btn_div">
									<button type="button" class="cap_save"
									 onclick="javascript:fn_save()">SAVE</button>

									<div class="cap_delPw">
										<button type="submit" formaction="memberDelete.do" class="cap_del">DELETE</button>
										<button type="button" class="cap_pw">비밀번호 변경</button>
									</div>
								</div>
							</form>
						</div>
					</section>
				</div>
				<!-- textArea -->
			</div>
			<!-- center -->
		</div>
		<!-- contents E -->

		<!-- modal 창 추가 -->
		<form class="modal" name="modal"
			action='<c:url value="/member/memberPassModify.do"/>' method="post">
			<sec:csrfInput />
			<div class="modal" id="modal">
				<div class="modal_content">
					<span class="close">&times;</span>
					<div class="memPass">
						<label for="memPass">비밀번호</label> <input id="memPass"
							type="password" name="memPass" pattern="\w{4,}" title="비밀번호 입력"
							aria-describedby="memPassMsg" maxlength="20">
					</div>
					<div class="memPassCh">
						<label for="memPassCh">비밀번호 재확인</label> <input id="memPassCh"
							type="password" name="memPassCh" pattern="\w{4,}"
							title="비밀번호 재확인" aria-describedby="memPassChMsg" maxlength="20">
					</div>
					<div class="modal_save">
						<button type="button" id="pwSave" name="pwSave"
							onclick="javascript:ps_save()">비밀번호 저장</button>
					</div>
				</div>
				<!-- modal_content E -->
			</div>
			<!-- modal E -->
		</form>
		<!-- form modal E -->


	</div>
	<!-- wrap -->
	<footer id="page_footer"> </footer>
	<!-- footer -->

</body>
<script type="text/javascript">
// 관심분야를 2개 이상 선택했을 때 발생하는 이벤트
let maxCount = 2;
let jb_cnt = $('input.chkBoxType_input:checked').length;
function countChecked(field) {
	if (field.checked) {
		jb_cnt += 1;
	} else {
		jb_cnt -= 1;
	}
	if (jb_cnt > maxCount) {
		alert("관심분야는 최대 2개 까지 선택해주세요.");
		field.checked = false;
		jb_cnt -= 1;
	}
}

//관심분야를 2개 미만으로 선택했을 때 발생하는 이벤트
function fn_save() {
	if (confirm("저장하시겠습니까?")) {
		if (jb_cnt == 2) {
			$('form[name="myInfo_form"]').submit();		
		} else {
			alert("관심분야를 2가지 선택해주세요.");
		}
	} // if
}
</script>
</html>

















<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
document.addEventListener("DOMContentLoaded", ()=> {
	document.querySelector("form#score button.btn_save").addEventListener("click", (e)=>{
		let form = document.querySelector("form#score");
		let st_name = form.querySelector("input#sc_subject");
		let st_dept = form.querySelector("input#sc_score");
		
		if(sc_subject.value === "") {
			alert("과목은 반드시 입력해주세요!");
			sc_subject.focus();
			return false;
		}
		if(sc_score.value === "") {
			alert("점수는 반드시 입력해주세요!");
			sc_score.focus();
			return false;
		} else if(sc_score.value < 0 || sc_score.value > 100 ){
			alert("점수 범위는 0 ~ 100 입니다!");
			sc_score.focus();
			return false;
		}
		
		form.submit();
		
	});
})	
</script>
</head>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<body>
<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
<section class="main_sec">
		<form id="score" method="POST">
			<fieldset>
				<legend>성적 입력</legend>
				<div>
					<label>학번</label> <input name="sc_stnum" value="${STNUM}" readonly >
				</div>
				<div>
					<label>과목</label> <input name="sc_subject" id="sc_subject">
				</div>
				<div>
					<label>점수</label> <input name="sc_score" id="sc_score">
				</div>
				<div class="btn_box">
					<button type="button" class="btn_save">저장</button>
					<button type="reset" class="btn_reset">다시작성</button>
				</div>
			</fieldset>
		</form>
	</section>
</body>
</html>
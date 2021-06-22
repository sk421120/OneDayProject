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
	document.querySelector("form#student button.btn_save").addEventListener("click", (e)=>{
		let form = document.querySelector("form#student");
		let st_name = form.querySelector("input#st_name");
		let st_dept = form.querySelector("input#st_dept");
		let st_grade = form.querySelector("input#st_grade");
		let st_tel = form.querySelector("input#st_tel");
		
		if(st_name.value === "") {
			alert("이름은 반드시 입력해주세요!");
			st_name.focus();
			return false;
		}
		if(st_dept.value === "") {
			alert("전공은 반드시 입력해주세요!");
			st_dept.focus();
			return false;
		}
		if(st_grade.value === "") {
			alert("학년은 반드시 입력해주세요!");
			st_grade.focus();
			return false;
		} else if(st_grade.value < 1 || st_grade.value > 4 ){
			alert("학년 범위는 1 ~ 4 입니다!");
			st_grade.focus();
			return false;
		}
		
		form.submit();
	});
})
</script>
</head>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<section class="main_sec">
		<form id="student" method="POST">
			<fieldset>
				<legend>${STUDENT.st_num }</legend>
				<div>
					<label>이름</label> <input name="st_name" id="st_name" value="${STUDENT.st_name}">
				</div>
				<div>
					<label>전공</label> <input name="st_dept" id="st_dept" value="${STUDENT.st_dept}">
				</div>
				<div>
					<label>학년</label> <input name="st_grade" id="st_grade" value="${STUDENT.st_grade}">
				</div>
				<div>
					<label>전화번호</label> <input name="st_tel" id="st_tel" type="tel" value="${STUDENT.st_tel}">
				</div>
				<div>
					<label>주소</label> <input name="st_addr" id="st_addr" value="${STUDENT.st_addr}">
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
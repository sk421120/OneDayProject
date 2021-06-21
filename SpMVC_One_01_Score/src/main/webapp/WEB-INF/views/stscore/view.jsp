<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>학번</th>
		<td>${SCOREDTO.st_num}</td>
		<th>전공</th>
		<td>${SCOREDTO.st_dept}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${SCOREDTO.st_name}</td>
		<th>학년</th>
		<td>${SCOREDTO.st_grade}</td>
	</tr>
	<div class="btn_box">
		<button id="btn_update">학생정보 수정</button>
	</div>
</table>
<table>
	<tr>
		<th>No.</th>
		<th>과목명</th>
		<th>점수</th>
	</tr>
	<c:forEach items="${SCORELIST}" var="SC">
	<tr>
		<td>index</td>
		<td>${SC.sc_subject}</td>
		<td>${SC.sc_score}</td>
	</tr>
	</c:forEach>
	<tr>
		<td></td>
		<td>${SCOREDTO.st_subcount}</td>
		<td>${SCOREDTO.st_total}</td>
	</tr>
	<div class="btn_box">
		<button id="btn_insert">성적추가</button>
	</div>
</table>
</body>
</html>
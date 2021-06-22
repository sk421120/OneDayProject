<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table th, td {
	border-bottom: 1px solid gray;
}

table.scoreview tr:hover, .scorelist tr:hover {
	cursor:default;
}

table tr td {
	text-align: center;
}

</style>
<script>
	var rootPath="${rootPath}";
	var st_num = "${SCOREDTO.st_num}";
</script>
<script src="${rootPath}/static/js/score_view.js?ver=2021-06-22-000"></script>
</head>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<body>
<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
<table class="scoreview">
	<tr data-seq="${SCOREDTO.st_num}">
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
<table class="scorelist">
	<tr>
		<th>No.</th>
		<th>과목명</th>
		<th>점수</th>
	</tr>
	<c:forEach items="${SCORELIST}" var="SC"  varStatus="index">
	<tr>
		<td>${index.count}</td>
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
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
/* #216e39  #30a14e #40c463 #9be9a8 #ebedf0 */
	p {
		margin-top:20px;
		text-align: center;
	}
</style>
<script>
document.addEventListener("DOMContentLoaded", function() {
	document.querySelector("table#scList").addEventListener("click", function(ev){
		
		// 가장 안쪽 tag TD의 이름을 가져와라
		let tag_name = ev.target.tagName;
		
		if(tag_name == "TD") {
			let st_seq = ev.target.closest("TR").dataset.seq;
			document.location.href="${rootPath}/stscore/view?st_num=" + st_seq;
		}
	})	// table의 click
})
</script>
</head>
<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
<body>
<%@ include file="/WEB-INF/views/include/include_header.jspf" %>
<c:if test="${not empty SCOREDTO}">
<table id="scList">
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>전공</th>
		<th>학년</th>
		<th>응시과목</th>
		<th>총점</th>
		<th>평균</th>
	</tr>
	<c:forEach items="${SCOREDTO}" var="ST">
		<tr data-seq="${ST.st_num}">
			<td>${ST.st_num }</td>
			<td>${ST.st_name }</td>
			<td>${ST.st_dept }</td>
			<td>${ST.st_grade }</td>
			<td>${ST.st_subcount }</td>
			<td>${ST.st_total }</td>
			<td>${ST.st_avg }</td>
		</tr>
	</c:forEach>
</table>
</c:if>

<c:if test="${empty SCOREDTO }">
	<p>성적정보가 없습니다!!</p>
	<p>성적정보를 입력해주세요!!</p>
</c:if>
</body>
</html>
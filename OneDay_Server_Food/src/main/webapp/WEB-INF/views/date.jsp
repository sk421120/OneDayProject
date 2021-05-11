<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/myfood">메인으로 가기</a>
	<form method="POST">
		<p> 날짜 <input name="m_date" value='${DATE }'/>
		<button>조회</button>
	</form>
	<p>${RESULT }</p>

	<c:if test='${not empty DAILYS }'>
	<table>
		<tr>
			<th> 번호 </th>
			<th> 날짜 </th>
			<th> 식품명 </th>
			<th> 섭취량 </th>
			<th> 총내용량 </th>
			<th> 에너지 </th>
			<th> 단백질 </th>
			<th> 지방 </th>
			<th> 탄수화물 </th>
			<th> 총당류 </th>
		</tr>
		<c:forEach items="${ DAILYS }" var="D">
		<tr>
			<th>${D.m_seq }</th>
			<th>${D.m_date }</th>
			<th>${D.f_name }</th>
			<th>${D.m_intake }</th>
			<th>${D.f_cap }</th>
			<th>${D.f_energy }</th>
			<th>${D.f_protein }</th>
			<th>${D.f_fat }</th>
			<th>${D.f_carbo }</th>
			<th>${D.f_sugar }</th>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>
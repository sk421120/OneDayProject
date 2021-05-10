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
	<h1>다이어트를 도와줘!</h1>
	<h3>[ 2021년 다이어트 작심삼일이라도 해보려는 마음 ]</h3>
	<h4>어제보다 군것질을 줄여서 다이어트에 성공해보자..</h4>
	
	<p>
	<c:if test="${empty DAILY}"> <h4>섭취 기록이 없습니다</h4> </c:if>
	<p>
	<c:forEach items="${ DAILY }" var="D">
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
	
	<a href="food">섭취정보 등록</a>
	<form method="post">
	날짜 <input name="date" value='${DATE }'/>
	<button>조회</button>
	</form>
	
</body>
</html>
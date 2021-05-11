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
	<h2>섭취 정보 등록</h2>
	
	<c:if test='${empty FOODS }'>
	<form method="POST">
		<p> 날짜 <input name="m_date" value='${DATE }'/>
		<p> 식품명 <input name="f_name" value='${NAME }'/>
		<button>입력</button>
	</form>
	</c:if>
	
	<p> ${RESULT } </p>
	
	<c:if test='${not empty FOODS }'>
	
	<form action="POST">
		<p> 날짜 ${DATE } </p>
		<p> 식품명 ${NAME } 의 조회 목록 입니다. </p>
	</form>
	
	<a href="/myfood/daily">다시 조회 하기</a>
	<table>
		<tr>
			<th> 이름 </th>
			<th> 제조사 </th>
			<th> 분류 </th>
			<th> 1회제공량 </th>
			<th> 총내용량 </th>
			<th> 에너지 </th>
			<th> 단백질 </th>
			<th> 지방 </th>
			<th> 탄수화물 </th>
			<th> 총당류 </th>
		</tr>
		<c:forEach items="${ FOODS }" var="F">
		<tr>
			<th><a href="/myfood/insert?code=${F.f_code }&date=${DATE}">${F.f_name }</a></th>
			<th>${F.f_ccode }</th>
			<th>${F.f_icode }</th>
			<th>${F.f_serv }</th>
			<th>${F.f_cap }</th>
			<th>${F.f_energy }</th>
			<th>${F.f_protein }</th>
			<th>${F.f_fat }</th>
			<th>${F.f_carbo }</th>
			<th>${F.f_sugar }</th>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>

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
		<p> 날짜 : <input name="m_date" value='${DATE }' readonly/>
		<p> 식품명 : <input name="m_fname" value='${NAME }' readonly/>
		<p> 섭취량 <input name="m_intake"/>
		<button>입력</button>
	</form>
	<p> ${RESULT } </p> 
</body>
</html>
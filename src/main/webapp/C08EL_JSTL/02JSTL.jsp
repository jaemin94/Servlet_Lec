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
	<!-- 변수지정 -->
	<c:set var="num" value="123"/>
	<!-- 변수출력 -->
	<c:out value="${num }" />
	${num }<br/>
	<!-- 배열지정 -->
	<c:set var="arr" value="${[10,20,30,40,50] }" />
	<c:out value="${arr }"/>
	<c:out value="${arr[2] }" />
	
	<!-- if문 -->
	<c:set var="flag" value="true" />
	<c:if test ="${empty flag }">
		<c:out value="[if] True"/>
	</c:if>
	<c:if test="${not empty flag }">
		<c:out value="[if] False"/>
	</c:if>
	
	
		
</body>
</html>
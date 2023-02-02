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

	<h3>목록화면</h3>
	
	
	<!-- for(ScoreVO article : list){
	}
	아래와 같은 것 -->
	
	<c:forEach var="article" items="${list }" varStatus="num">
		${num.index }
		${article.name }
		${article.kor }
		${article.eng }	
		<a href="delete?num=${num.index }">삭제</a> <!-- 삭제는 원래 post방식으로 하는것.  -->
		<br/>
	</c:forEach>
	

</body>
</html>
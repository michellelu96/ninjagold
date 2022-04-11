<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Your Gold: ${totalGold }</h1>

	<div class="container d-flex justify-content-around bd-highlight mb-2">
		<div class="smallBoxes p-2 bd-highlight">
			<form method="post" action="/getGold">
				<h3>Farm</h3>
				<p>(earns 10 - 20 gold)</p>
				<input type="hidden" name="amtGold" value="farm">
				<button>Find Gold!</button>
			</form>
		</div>
		<div class="smallBoxes p-2 bd-highlight">
			<form method="post" action="/getGold">
				<h3>Cave</h3>
				<p>(earns 10 - 20 gold)</p>
				<input type="hidden" name="amtGold" value="cave">
				<button>Find Gold!</button>
			</form>
		</div>
		<div class="smallBoxes p-2 bd-highlight">
			<form method="post" action="/getGold">
				<h3>House</h3>
				<p>(earns 10 - 20 gold)</p>
				<input type="hidden" name="amtGold" value="house">
				<button>Find Gold!</button>
			</form>
		</div>
		<div class="smallBoxes p-2 bd-highlight">
			<form method="post" action="/getGold">
				<h3>Quest</h3>
				<p>(earns/takes 50 gold)</p>
				<input type="hidden" name="amtGold" value="quest">
				<button>Find Gold!</button>
			</form>
		</div>
	</div>

	<h1>Activities</h1>
	<div class = "activities">
		<p>
			<c:forEach var="message" items="${messages }">
				<c:choose>
					<c:when test="${message.contains('failed')}">
					<p class= "redText">
						${message }
					</p>
					</c:when>
					<c:otherwise>
					<p class="greenText">
						${message }
					</p>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</p>
	</div>
</body>
</html>
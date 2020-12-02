<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Bibliotetic</title>
	
	<base href="${pageContext.request.contextPath}/"/>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<c:if test="${sessionScope.email != null}">
					<li class="nav-item"><a class="nav-link" href="#">Features</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
				</c:if>

			</ul>
			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${sessionScope.email = null}">
						<li class="nav-item"><a class="nav-link" href="#">Login</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><span class="navbar-text">${SessionScope.email}</span></li>
						<li class="nav-item"><a class="nav-link" href="#">Desconectar</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabeza.jsp"%>

<table class="table table-striped table-bordered table-hover table-sm">
	<thead class="thead-dark">
		<tr>
			<th>ISBN</th>
			<th>Título</th>
			<th>Páginas</th>
			<th>Formato</th>
			<th>Fecha</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="libro">
			<tr>
				<th>${libro.isbn}</th>
				<td>${libro.titulo}</td>
				<td>${libro.paginas}</td>
				<td>${libro.formato}</td>
				<td>${libro.fecha}</td>
				<td>
				<% // TODO action  %>
					<form class="form-inline" action="admin/libro" method="post">
						<a class="btn btn-primary" href="admin/libro?isbn=${libro.isbn}">Editar</a>

						<input type="hidden" name="isbn" value="${libro.isbn}">
						<button class="btn btn-secondary">Editar con Post</button>

						<a class="btn btn-danger"
							onclick="return confirm('¿Estás seguro?')" href="admin/borrar-libro?isbn=${libro.isbn}">Borrar</a>

					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="/WEB-INF/includes/pie.jsp"%>
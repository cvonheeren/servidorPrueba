<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabeza.jsp"%>

<div class="row">
	<h1 class="col-12">Edición de libro</h1>

	<div class="col-12">
	<% //TODO meter el action %>
		<form action="/servidorPrueba/admin/guardar" method="post">		
			 <div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label">ISBN</label>
				<div class="col-sm-10">
					<input type="number" class="form-control ${libro.errorIsbn != null ? 'is-invalid' : '' }" id="isbn" name="isbn"
						value="${libro.isbn}" ${libro.isbn != null ? 'readonly' : ''}>
					<div class="invalid-feedback">${libro.errorIsbn}</div>
				</div>
			</div> 
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Título</label>
				<div class="col-sm-10">
					<input type="text"
						class="form-control ${libro.errorTitulo != null ? 'is-invalid' : '' }"
						id="titulo" name="titulo" placeholder="El título de la película"
						value="${libro.titulo}">
					<div class="invalid-feedback">${libro.errorTitulo}</div>
				</div>
			</div>

			<div class="form-group row">
				<label for="genero" class="col-sm-2 col-form-label">Páginas</label>
				<div class="col-sm-10">
					<input type="number" class="form-control ${libro.errorPaginas != null ? 'is-invalid' : '' }" id="paginas" name="paginas"
						value="${libro.paginas}">
				</div>
				<div class="invalid-feedback">${libro.errorPaginas}</div>
			</div>
			
			<div class="form-group row">
				<label for="fecha-estreno" class="col-sm-2 col-form-label">Formato</label>
				<div class="col-sm-10">
					<input type="text"
						class="form-control ${libro.errorFormato != null ? 'is-invalid' : '' }"
						id="formato" name="formarto"
						value="${libro.formato}">
					<div class="invalid-feedback">${libro.errorFormato}</div>
				</div>
			</div>


			<div class="form-group row">
				<label for="fecha-estreno" class="col-sm-2 col-form-label">Fecha
					de publicación</label>
				<div class="col-sm-10">
					<input type="date"
						class="form-control ${libro.errorFechas != null ? 'is-invalid' : '' }"
						id="fecha" name="fecha"
						value="${libro.fecha}">
					<div class="invalid-feedback">${libro.errorFechas}</div>
				</div>
			</div>

			<!-- botones -->
			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Aceptar</button>
					<a class="btn btn-danger" href="login">Cancelar</a>
				</div>
			</div>
		</form>

	</div>


</div>

<%@ include file="/WEB-INF/includes/pie.jsp"%>
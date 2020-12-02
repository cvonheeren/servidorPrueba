package com.ipartek.cvh.server.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.cvh.server.accesoadatos.AccesoDatosException;
import com.ipartek.cvh.server.modelo.Libro;

@WebServlet("/admin/guardar")
public class GuardarLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//TODO que no se pueda teclear la direccion
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recepción de parámetros
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String paginas = request.getParameter("paginas");
		String formato = request.getParameter("formato");
		String fecha = request.getParameter("fecha");

		// 2. Empaquetar en objeto del modelo (entidad)

		Libro libro = new Libro(isbn, titulo, paginas, formato, fecha);

		if (!libro.isCorrecto()) {
			request.setAttribute("libro", libro);
			request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp").forward(request, response);
			return;
		}

		String alertaMensaje, alertaTipo, op = null;

		try {
			if (libro.getIsbn() == null) {
				op = "inserción";
				Configuracion.dao.insertar(libro);

			} else {
				op = "modificación";
				Configuracion.dao.modificar(libro);
			}

			alertaMensaje = "La " + op + " se ha hecho correctamente";
			alertaTipo = "success";
		} catch (AccesoDatosException e) {
			alertaMensaje = "Ha habido un error en la " + op + ": " + e.getMessage();
			alertaTipo = "danger";
		}

		// 4. Preparar el modelo para la siguiente pantalla
		HttpSession session = request.getSession();

		session.setAttribute("alertamensaje", alertaMensaje);
		session.setAttribute("alertatipo", alertaTipo);

		// 5. Redireccionar a la siguiente pantalla
		//TODO poner el link bien a donde sea
		response.sendRedirect("login");

	}

}

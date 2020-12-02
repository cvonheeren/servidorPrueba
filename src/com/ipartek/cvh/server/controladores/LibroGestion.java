package com.ipartek.cvh.server.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.cvh.server.modelo.Libro;

@WebServlet("/admin/libro")
public class LibroGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");

		if (isbn != null) {
			

			Libro libro = Configuracion.dao.obtenerPorId(isbn);

			request.setAttribute("libro", libro);
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/vistas/libro.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

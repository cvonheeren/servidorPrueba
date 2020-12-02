package com.ipartek.cvh.server.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {

	private String titulo;
	private String isbn;
	private Integer paginas;
	private Boolean formato;
	private LocalDate fecha;
	
	private Boolean correcto = true;
	private String errorTitulo, errorIsbn, errorPaginas, errorFormato, errorFechas;

	
	//TODO quitar throws, limpiar errores, poner el objeto a correcto
	public Libro(String titulo, String isbn, Integer paginas, String formato, LocalDate fecha) {
		setTitulo(titulo);
		setISBN(isbn);
		setPaginas(paginas);
		setFormato(formato);
		setFecha(fecha);
	}
	
	public Libro(String titulo, String isbn, String paginas, String formato, String fecha) {
		setTitulo(titulo);
		setISBN(isbn);
		setPaginas(paginas);
		setFormato(formato);
		setFecha(fecha);
	}

	/**
	 * Valida que el titulo sea en el formato que queremos
	 * @param titulo
	 */
	public void setTitulo(String titulo) {		
		if(titulo.length() < 2 || titulo.length() > 151) {
			this.titulo = titulo;
			errorTitulo = "La longitud del título debe ser mayor de 3 y menor de 150";
			correcto = false;
			return;
		} else if(titulo.trim().length() == 0) {
			this.titulo = titulo;
			errorTitulo = "Solo hay espacios en blanco";
			correcto = false;
			return;
		}
		
		this.titulo = titulo;
		correcto = true;
	}
	
	/**
	 * Valida que el ISBN sea en el formato que queremos
	 * @param iSBN
	 */
	public void setISBN(String iSBN) {
		if(!iSBN.matches("[0-9]{10}")) {
			this.isbn = iSBN;
			errorIsbn = "El ISBN debe ser un número de al menos 10 caracteres";
			correcto = false;
			return;
		}
		
		this.isbn = iSBN;
		correcto = true;
	}
	
	/**
	 * 
	 * @param paginas
	 */
	public void setPaginas(String paginas) {
		Integer pag = -1;
		try {
			pag = Integer.parseInt(paginas);
			this.paginas = pag;
		} catch (NumberFormatException e) {
			errorPaginas = "Introduce un número válido por favor";
			correcto = false;
			return;
		}
			
		setPaginas(pag);
	}
	
	/**
	 * Valida que las páginas sean en el formato que queremos
	 * @param paginas
	 */
	public void setPaginas(Integer paginas) {
		if(paginas < 1 || paginas > 10000) {
			errorPaginas = "El número de páginas debe ser mayor a 1 y menor de 10000";
			correcto = false;
			return;
		}
		
		this.paginas = paginas;
		correcto = true;
	}
	
	/**
	 * Valida que se introduce el formato adecuadamente
	 * @param formato
	 */
	public void setFormato(String formato) {
		if (formato == null) {
			formato = "";
		}
		
		if ("digital".equalsIgnoreCase(formato.trim())) {
			this.formato = true;
			correcto = true;
		} else if ("papel".equalsIgnoreCase(formato.trim())) {
			this.formato = false;
			correcto = true;
		} else {
			errorFormato = "El formato debe ser o digital o papel";
			correcto = false;
		}
	}
	
	/**
	 * 
	 * @param fechaS
	 */
	public void setFecha(String fechaS) {
		LocalDate fechLD;
		try {
			fechLD = LocalDate.parse(fechaS, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			setFecha(fechLD);
		} catch (Exception e) {
			errorFechas = "La fecha debe tener un formato 1234-12-12";
			correcto = false;
		}
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public Integer getPaginas() {
		return paginas;
	}

	public Boolean getFormato() {
		return formato;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
		correcto = true;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public void setFormato(Boolean formato) {
		this.formato = formato;
	}

	
	//
	public Boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(Boolean correcto) {
		this.correcto = correcto;
	}

	public String getErrorTitulo() {
		return errorTitulo;
	}

	public void setErrorTitulo(String errorTitulo) {
		this.errorTitulo = errorTitulo;
	}

	public String getErrorIsbn() {
		return errorIsbn;
	}

	public void setErrorIsbn(String errorIsbn) {
		this.errorIsbn = errorIsbn;
	}

	public String getErrorPaginas() {
		return errorPaginas;
	}

	public void setErrorPaginas(String errorPaginas) {
		this.errorPaginas = errorPaginas;
	}

	public String getErrorFormato() {
		return errorFormato;
	}

	public void setErrorFormato(String errorFormato) {
		this.errorFormato = errorFormato;
	}

	public String getErrorFechas() {
		return errorFechas;
	}

	public void setErrorFechas(String errorFechas) {
		this.errorFechas = errorFechas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (formato == null) {
			if (other.formato != null)
				return false;
		} else if (!formato.equals(other.formato))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (paginas == null) {
			if (other.paginas != null)
				return false;
		} else if (!paginas.equals(other.paginas))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	/**
	 * Transforma el booleano en lo que significa realmente para el usuario
	 * @return
	 */
	public String formatoToString() {
		if (this.formato) {
			return "Digital";
		} else {
			return "Papel";
		}
	}	

	@Override
	public String toString() {
		String formatoS = this.formatoToString();
		return "Libro [titulo=" + titulo + ", isbn=" + isbn + ", paginas=" + paginas + ", formato=" + formato
				+ ", fecha=" + fecha + formatoS + "]";
	}

	
}

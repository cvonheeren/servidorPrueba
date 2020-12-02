package com.ipartek.cvh.server.accesoadatos;

import java.time.LocalDate;
import java.util.TreeMap;

import com.ipartek.cvh.server.modelo.Libro;

public class LibrosDaoTreeMap implements Dao<Libro> {

	private TreeMap<String, Libro> libros = new TreeMap<>();
	
	private LibrosDaoTreeMap() {
		libros.put("8497364678", new Libro("Don quijote de la Mancha", "8497364678", 600, "digital", LocalDate.of(2020, 1, 8)));
		libros.put("8403094264", new Libro("Obras completas Cervantes", "8403094264", 999, "digital", LocalDate.of(2020, 1, 8)));
	}
	
	private static LibrosDaoTreeMap singleton = new LibrosDaoTreeMap();
	
	public static LibrosDaoTreeMap getInstance() {
		return singleton;
	}

	
	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro obtenerPorId(String id) {
		return libros.get(id);
	}

	@Override
	public void insertar(Libro objeto) {
		libros.put(objeto.getIsbn(), objeto);		
	}

	@Override
	public void modificar(Libro objeto) {
		if(!libros.containsKey(objeto.getIsbn())) {
			throw new AccesoDatosException("No existe ese id");
		}
		libros.put(objeto.getIsbn(), objeto);
	}

	@Override
	public void borrar(String id) {
		if(!libros.containsKey(id)) {
			throw new AccesoDatosException("No existe ese id");
		}
		libros.remove(id);
		
	}
	
}

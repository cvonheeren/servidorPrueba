package com.ipartek.cvh.server.accesoadatos;

public interface Dao<T> {

	Iterable<T> obtenerTodos();
	T obtenerPorId(String id);
	void insertar(T objeto);
	void modificar(T objeto);
	void borrar(String id);
	
}

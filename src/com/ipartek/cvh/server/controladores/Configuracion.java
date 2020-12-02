package com.ipartek.cvh.server.controladores;

import com.ipartek.cvh.server.accesoadatos.Dao;
import com.ipartek.cvh.server.accesoadatos.LibrosDaoTreeMap;
import com.ipartek.cvh.server.modelo.Libro;

public class Configuracion {

	public static Dao<Libro> dao = LibrosDaoTreeMap.getInstance();
	
}

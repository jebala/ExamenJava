package com.modelo.persistencia.memoria;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.modelo.entidad.Colega;

public class BaseDeDatosMemoria {
	private Map<Integer, Colega> tablaColega = null;

//Me permite inicializar la tabla de Colega, en sql CREATE COLEGA
 
public void createTablaColegas(){
	tablaColega = new HashMap<>();
}

public void insertarUnColega(Colega colega){
	tablaColega.put(colega.getId(), colega);
}

public void borrarUnColegaPorId(int id){
	tablaColega.remove(id);
}

//@param colega tendra el id antiguo, el ya existente, ya que nose modifica por ser PK 
 
public void modificarUnColega(Colega colega){
	this.insertarUnColega(colega);
}


public Colega consultarUnLibroPorId(int id){
	
	return tablaColega.get(id);
}	

public Collection<Colega> consultarTodosLosColegas(){
	
	return tablaColega.values();
	}

}

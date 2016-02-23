package com.modelo.persistencia;

import java.sql.SQLException;
import java.util.Collection;

import com.modelo.entidad.Colega;

public interface ColegaDao {
	
	
	void alta(Colega colega) throws SQLException;
	
	void bajaPorId(int id) throws SQLException;
	
	void modifica(Colega colega) throws SQLException ;
	
	Colega consultaPorId(int id) throws SQLException ;
	
	Collection<Colega> consultaTodos() throws SQLException ;


	
}

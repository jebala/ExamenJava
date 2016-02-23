package com.modelo.persistencia;

import java.util.Collection;

import com.modelo.entidad.Colega;
import com.modelo.persistencia.memoria.BaseDeDatosMemoria;

public class MemoriaColegaDao implements ColegaDao {

	private BaseDeDatosMemoria bd;
	
	
	public MemoriaColegaDao(BaseDeDatosMemoria bd) {
		super();
		this.bd = bd;
	}

	@Override
	public void alta(Colega colega) {
		bd.insertarUnColega(colega);
	}

	@Override
	public void bajaPorId(int id) {
		bd.borrarUnColegaPorId(id);	
	}

	@Override
	public void modifica(Colega colega) {
		bd.modificarUnColega(colega);	
	}

	@Override
	public Colega consultaPorId(int id) {
		return bd.consultarUnColegaPorId(id);
	}

	@Override
	public Collection<Colega> consultaTodos() {
		return bd.consultarTodosLosColegas();
	}

}

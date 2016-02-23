package com.modelo.negocio;

import java.sql.SQLException;
import java.util.Collection;


import com.modelo.entidad.Colega;
import com.modelo.persistencia.ColegaDao;

public abstract class ServicioGestionColegaImpl implements ColegaDao {
	
	private ColegaDao colegaDao;
	

	public ServicioGestionColegaImpl(ColegaDao colegaDao) {
		super();
		this.colegaDao = colegaDao;
	}

	@Override
	public void alta(Colega colega) throws SQLException {
		 colegaDao.alta(colega);

	}

	@Override
	public void bajaPorId(int id) throws SQLException {
		int loguin = 0;
		colegaDao.bajaPorId(loguin);

	}
	

}

package com.modelo.negocio;

import java.util.Collection;

import com.modelo.entidad.Colega;


public interface ServicioGestionColega {
	
	public void darDeAltaUnNuevoColegaEnLaAplicacion(Colega colega) ;
	
	public void darDeBajaUnNuevoColegaEnLaAplicacion(int loguin) ;
	
}

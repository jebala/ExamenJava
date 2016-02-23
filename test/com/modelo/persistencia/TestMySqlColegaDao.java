package com.modelo.persistencia;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;


import com.modelo.entidad.Colega;

public class TestMySqlColegaDao {

	@Test
	public void test() throws SQLException{
		
		//Datos de entrada
				Colega colega = new Colega(1, "Pedro", "Madrid", 545);
				
				BasicDataSource ds = new BasicDataSource();
				
				ds.setUrl("jdbc:mysql://localhost:3306/colega");//cadena de conexion
				ds.setUsername("root");
				ds.setPassword("rootroot");
				ds.setDriverClassName("com.mysql.jdbc.Driver");
		
				//sut
				MySqlColegaDao sut = new MySqlColegaDao(ds);
				
				//Ejecucion
				
				
				try {
					
					sut.alta(colega);
					Colega colegaObtenido = sut.consultaPorId(colega.getId());
					
					//Assertos
					assertEquals(colega, colegaObtenido);
				} catch (SQLException e) {
					e.printStackTrace();
					fail("Se produce un SQLException y no deberia: " + e.getMessage());
				}
			
			}
			
		}

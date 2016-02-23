package com.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import javax.sql.DataSource;


import com.modelo.entidad.Colega;

public class MySqlColegaDao implements ColegaDao {
	
	
	private static final String INSERT_COLEGA = "INSERT INTO Colega (id,nombre,ciudad,fecha) "
	+ "VALUES (?,?,?,?)";
	
	private static final String DELETE_COLEGA = " DELETE FROM Colega " + "WHERE id = ? ";
	
	private static final String UPDATE_COLEGA = "UPDATE Colega " + "SET nombre = ?, ciudad = ?, "
			+ "fecha = ? " + " WHERE id = ? ";
	
	private static final String SELECT_COLEGA_BY_ID = "SELECT * " + "FROM Colega "
			+  "WHERE id = ? " ;
	
	private static final String SELECT_COLEGA = "SELECT * FROM Colega ";
	
	private DataSource ds;
	
	
	public MySqlColegaDao(DataSource ds) {
		super();
		this.ds = ds;
	}

	
	@Override
	public void alta(Colega colega) throws SQLException {
		//1-Obtener la conexion
		Connection connection = null;
		try {
			connection = ds.getConnection();
			//2-Obtener el statement
			PreparedStatement ps = connection.prepareStatement(INSERT_COLEGA);
			ps.setInt(1, colega.getId());
			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCiudad());
			ps.setDate(4,new java.sql.Date (colega.getFecha().getTime()));
			
			//3-Ejecutar la sentencia
			ps.executeUpdate();
			//4-(Opcional), Solo cuando sea una sentencia de tipo
			//(executeQuery) Procesado de los resultados.
		} finally {
			//5-Cerrar la conexion. Esto podria no llegarse a producir si existiera una excepcion
			if(connection !=null){
			connection.close();
			}
		}
	}

	@Override
	public void bajaPorId(int id) throws SQLException {
		//1-Obtener la conexion
		Connection connection = null;
		try {
			connection = ds.getConnection();
			//2-Obtener el statement
			PreparedStatement ps = connection.prepareStatement(DELETE_COLEGA);
			ps.setInt(1, id);
			
			//3-Ejecutar la sentencia
			ps.executeUpdate();
			//4-(Opcional), Solo cuando sea una sentencia de tipo
			//(executeQuery) Procesado de los resultados.
		} finally {
			//5-Cerrar la conexion. Esto podria no llegarse a producir si existiera una excepcion
			if(connection !=null){
			connection.close();
			}
		}
	}
	@Override
	public void modifica(Colega colega) throws SQLException {
		//1-Obtener la conexion
		Connection connection = null;
		try {
			connection = ds.getConnection();
			//2-Obtener el statement
			PreparedStatement ps = connection.prepareStatement(UPDATE_COLEGA);
			ps.setString(1, colega.getNombre());
			ps.setString(2, colega.getCiudad());
			ps.setDate(3,new java.sql.Date (colega.getFecha().getTime()));
			ps.setInt(4, colega.getId());
			
			//3-Ejecutar la sentencia
			ps.executeUpdate();
			//4-(Opcional), Solo cuando sea una sentencia de tipo
			//(executeQuery) Procesado de los resultados.
		} finally {
			//5-Cerrar la conexion. Esto podria no llegarse a producir si existiera una excepcion
			if(connection !=null){
			connection.close();
			}
		}

}

	@Override
	public Colega consultaPorId(int id) throws SQLException {
		//1-Obtener la conexion
		Connection connection = null;
		try {
			connection = ds.getConnection();
			//2-Obtener el statement
			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA_BY_ID);
			ps.setInt(1, id);
			//3-Ejecutar la sentencia
			 ResultSet rs = ps.executeQuery(); //nos ayuda a recorrer los elementos dentro del cursor
			//4-(Opcional), Solo cuando sea una sentencia de tipo (executeQuery) 
			 
			 //Posiciono el cursor
			if(rs.first()){
				
				//Accedo a los campos del registro al que apunta el cursor
				return new Colega(id,
										rs.getString("nombre"),
										rs.getString("ciudad"),
										rs.getDate("fecha"));
			 }
			return null;//sino se hace lo de arriba, se retorna null
			 
		} finally {
			//5-Cerrar la conexion. Esto podria no llegarse a producir si existiera una excepcion
			if(connection !=null){
			connection.close();
			}
		}
}

	@Override
	public Collection<Colega> consultaTodos() throws SQLException {
		Collection<Colega> resultado = new HashSet<>();
	
		Connection connection = null;
		try {
			//1-Obtener la conexion
			connection = ds.getConnection();
			//2-Obtener el statement
			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA);
			//3-Ejecutar la sentencia
			 ResultSet rs = ps.executeQuery(); //nos ayuda a recorrer los elementos dentro del cursor
			//4-(Opcional), Solo cuando sea una sentencia de tipo (executeQuery) Procesa los resultados.
			 
			 //Me posiciono en el primero
			if(rs.first()) {
			 
			 //Proceso el libro hasta que no haya siguiente
			 do {
				 //Procesar Libro
				Colega libro = new Colega(
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getString("ciudad"),
							rs.getDate("fecha"));
				
				resultado.add(libro);
			 } while(rs.next());
			 
			} 
			return resultado;
			
		} finally {
			//5-Cerrar la conexion. Esto podria no llegarse a producir si existiera una excepcion
			if(connection !=null){
			connection.close();
			}
		}

	}
	
}


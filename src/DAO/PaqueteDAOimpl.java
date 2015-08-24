package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import utils.DBManager;
import DAO.PaqueteDAO;
import entidades.Paquete;
import Exceptions.PaqueteException;

public class PaqueteDAOimpl implements PaqueteDAO{

	@Override
	public void insertarPaquete(Paquete paquete) throws PaqueteException {
		String sql = "INSERT INTO paquetes (nombre, telefono, tipoDePaquete, origen, destino, estado, precio) VALUES ('"
				+ paquete.getNombre() + "', '" + paquete.getTelefono() + "', '"
				+ paquete.getTipoDePaquete() + "', '" + paquete.getOrigen() + "', '"
				+ paquete.getDestino() + "', '" + paquete.getEstado() + "', '"
				+ paquete.getPrecio() + "')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				throw new PaqueteException("Error al insertar paquete.");
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new PaqueteException("Error al intentar hacer rollback.");
			} finally {
				try {
					c.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new PaqueteException("Error al cerrar base de datos...");
				}
			}
		}	
	}

	@Override
	public void deletePaquete(Paquete paquete) throws PaqueteException {
		String sql = "DELETE FROM paquetes WHERE nombre = '" + paquete.getNombre() + "'";
		Connection c = DBManager.connect(); // Conexion con base de datos
		//Si hay un error con la conexion lo atrapo.
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {	//Al atrapar el error hago un rollback
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new PaqueteException("Error al borrar paquete");
			} finally { //Siempre cierra la conexion.
				try {
					c.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					throw new PaqueteException("Error al cerrar base de datos...");
				}
			}
		}
	}

	@Override
	public void updatePaquete(Paquete paquete) throws PaqueteException {
		String sql = "UPDATE paquetes set telefono = '" + paquete.getTelefono() + "', tipoDePaquete = '" + paquete.getTipoDePaquete()
				+ "', origen = '" + paquete.getOrigen() + "', destino = '" + paquete.getDestino()
				+ "', estado = '" + paquete.getEstado() + "', precio = '" + paquete.getPrecio()
				+ "' WHERE nombre = '" + paquete.getNombre() + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new PaqueteException("Error al actualizar paquete.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new PaqueteException("Error al cerrar base de datos...");
			}
		}
	}

	@Override
	public Paquete getPaquete(Paquete paquete) throws PaqueteException {
		Paquete retorna = null;
		String sql = "SELECT * FROM paquetes WHERE nombre = '" + paquete.getNombre() + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				String n = rs.getString("nombre");
				String t = rs.getString("telefono");
				String tp = rs.getString("tipoDePaquete");
				String o = rs.getString("origen");
				String d = rs.getString("destino");
				String e = rs.getString("estado");
				String pr = rs.getString("precio");
				retorna = new Paquete();
				retorna.setNombre(n);
				retorna.setTelefono(t);
				retorna.setTipoDePaquete(tp);
				retorna.setOrigen(o);
				retorna.setDestino(d);
				retorna.setEstado(e);
				retorna.setPrecio(Integer.parseInt(pr));
			}		
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new PaqueteException("No se pudo acceder al paquete");	
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new PaqueteException("No se pudo cerrar base de datos...");
			}
		}			
						
		return retorna;
	}

	@Override
	public List<Paquete> getAllPaquetes() throws PaqueteException {
		Paquete retorna = null;
		List<Paquete>listaDePaquetes = new LinkedList<Paquete>();
		String sql = "SELECT * FROM paquetes";
		Connection c = DBManager.connect();
		
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String n = rs.getString("nombre");
				String t = rs.getString("telefono");
				String tp = rs.getString("tipoDePaquete");
				String o = rs.getString("origen");
				String d = rs.getString("destino");
				String e = rs.getString("estado");
				String pr = rs.getString("precio");
				retorna = new Paquete();
				retorna.setNombre(n);
				retorna.setTelefono(t);
				retorna.setTipoDePaquete(tp);
				retorna.setOrigen(o);
				retorna.setDestino(d);
				retorna.setEstado(e);
				retorna.setPrecio(Integer.parseInt(pr));
				listaDePaquetes.add(retorna);
				
			}
		}catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new PaqueteException("Error al obtener todos los paquetes.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new PaqueteException("Error al cerrar base de datos...");
			}
		}
		return listaDePaquetes;
	}

}

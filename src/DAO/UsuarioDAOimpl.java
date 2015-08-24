package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import utils.DBManager;
import DAO.UsuarioDAO;
import Exceptions.UsuarioException;
import entidades.Usuario;

public class UsuarioDAOimpl implements UsuarioDAO{

	/**
	 * pre: Ingreso usuario.
	 * post: Inserto usuario en base de datos.
	 */
	@Override
	public void insertarUsuario(Usuario usuario) throws UsuarioException{
		String sql = "INSERT INTO usuarios (user, email, pass) VALUES ('" + usuario.getUsername() + "', '" + usuario.getEmail() + "', '" + usuario.getPassword() + "')";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
				throw new UsuarioException("Error al insertar usuario.");
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UsuarioException("Error al intentar hacer rollback.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UsuarioException("Error al cerrar base de datos...");
			}
		}
		
	}
	
	/**
	 * pre: Ingreso usuario.
	 * post: Se elimina usuario de base de datos.
	 */
	@Override
	public void deleteUsuario(Usuario usuario) throws UsuarioException { 		
		String sql = "DELETE FROM usuarios WHERE user = '" + usuario.getUsername() + "'";
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
				throw new UsuarioException("Error al borrar usuario...");
			}
		} finally { //Siempre cierra la conexion.
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UsuarioException("Error al cerrar base de datos...");
			}
		}
	}
	
	/**
	 * pre: Ingreso usuario.
	 * post: Modifico el usuario en la base de datos.
	 */
	@Override
	public void updateUsuario(Usuario usuario) throws UsuarioException {
		String sql = "UPDATE usuarios set email = '" + usuario.getEmail() + "', pass = '" + usuario.getPassword() + "' WHERE user = '" + usuario.getUsername() + "'";
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
				throw new UsuarioException("Error al actualizar usuario.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UsuarioException("Error al cerrar base de datos...");
			}
		}
		
	}
	
	/**
	 * pre: Ingreso usuario.
	 * post: Devuelvo un usuario de la base de datos.
	 */
	@Override
	public Usuario getUsuario(Usuario usuario) throws UsuarioException { 
		Usuario retorna = null;
		String sql = "SELECT * FROM usuarios WHERE user = '" + usuario.getUsername() + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
				String u = rs.getString("user");
				String e = rs.getString("email");
				String p = rs.getString("pass");
				retorna = new Usuario();
				retorna.setEmail(e);
				retorna.setPassword(p);
				retorna.setUsername(u);
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UsuarioException("No se pudo insertar el usuario");
				
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UsuarioException("No se pudo cerrar base de datos...");
			}
		}
		return retorna;
	}

	/**
	 * post: Devuelve todos los uduarios de la base de datos.
	 */
	@Override
	public List<Usuario> getAllUsuarios() throws UsuarioException {
		Usuario retorna = null;
		List<Usuario> listaDeUsuarios  = new LinkedList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		Connection c = DBManager.connect();
		
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				String u = rs.getString("user");
				String e = rs.getString("email");
				String p = rs.getString("pass");
				retorna = new Usuario();
				retorna.setEmail(e);
				retorna.setPassword(p);
				retorna.setUsername(u);
				listaDeUsuarios.add(retorna);
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UsuarioException("Error al obtener todos los usuarios.");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new UsuarioException("Error al cerrar base de datos...");
			}
		}
		return listaDeUsuarios;
	}
	
}

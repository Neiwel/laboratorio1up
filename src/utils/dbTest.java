package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import DAO.UsuarioDAOimpl;
import Exceptions.UsuarioException;
import entidades.Paquete;
import entidades.Usuario;


public class dbTest {
	
	
	//@Test (expected=UsuarioException.class)
	public void esperaDeErrorAlIngresarUsuarioTest() throws UsuarioException{
		Usuario usuario = new Usuario();
		usuario.setUsername("ññññ¬'or'¬¬||");
		UsuarioDAOimpl dao = new UsuarioDAOimpl();
		dao.insertarUsuario(usuario);
	}

	//@Test
	public void borrarUsuarioTest() throws UsuarioException{
		UsuarioDAOimpl dao = new UsuarioDAOimpl();
		Usuario usuario = new Usuario();
		usuario.setUsername("jorge");
		dao.deleteUsuario(usuario);
	}
	
	//@Test
	public void obtenerTodosLosUsuarios(){
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
			
			System.out.println(listaDeUsuarios.toString());
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		//	throw new Exception("", e);
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	//@Test
	public void agregarPaqueteTest(){
		
		Paquete paquete = new Paquete();
		paquete.setNombre("Juan");
		paquete.setTelefono("12345678");
		paquete.setTipoDePaquete("CHICO");
		paquete.setOrigen("Argentina");
		paquete.setDestino("Brazil");
		paquete.setEstado("EN PROGRESO");
		paquete.setPrecio(250);
		
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	//@Test
	public void crearTablaTest() {
		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE usuarios ( id INTEGER IDENTITY, user VARCHAR(256), email VARCHAR(256), pass VARCHAR(10))";
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}

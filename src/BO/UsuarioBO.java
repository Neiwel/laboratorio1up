package BO;

import java.util.List;

import DAO.UsuarioDAOimpl;
import DAO.UsuarioDAO;
import Exceptions.UsuarioException;
import entidades.Usuario;

public class UsuarioBO {
	
	//Atributos
	private UsuarioDAO dao;

	//Constructor
	public UsuarioBO() {
		setDao(new UsuarioDAOimpl());
	}

	/**
	 * @pre: Ingresa usuario.
	 * @post: Chequea usuario(verifica que los campos no esten vacios), 
	 * inserta el usuario en base de datos a menos que salte un error en el chequeo o no exista.
	 * @param usuario
	 * @return
	 * @throws UsuarioException
	 */
	public void insertarUsuario(Usuario usuario) throws UsuarioException {
		chequearUsuario(usuario);
		existeUsuario(usuario);
		getDao().insertarUsuario(usuario);
	}

	/**
	 * @pre: Ingresa Usuario.
	 * @post: Chequea usuario(verifica que los campos no esten vacios),
	 * borra el usuario de la base de datos a menos que devuelva un error el chequeo.
	 * @param usuario
	 * @return
	 * @throws UsuarioException
	 */
	public void deleteUsuario(Usuario usuario) throws UsuarioException {
		chequearUsuario(usuario);

		getDao().deleteUsuario(usuario);
	}

	/**
	 * @pre: Ingresa Usuario.
	 * @post: Chequea usuario(verifica que los campos no esten vacios),
	 * modifica el usuario en la base de datos a menos que salte el error en el chequeo.
	 * @param usuario
	 * @return
	 * @throws UsuarioException
	 */
	public void updateUsuario(Usuario usuario) throws UsuarioException {
		chequearUsuario(usuario);
		
		getDao().updateUsuario(usuario);
	}

	/**
	 * @pre: Ingresa Usuario.
	 * @post: Chequea usuario(verifica que los campos no esten vacios),
	 * devuelve el usuario a menos que salte el error en el chequeo.
	 * @param usuario
	 * @return
	 * @throws UsuarioException
	 */
	public Usuario getUsuario(Usuario usuario) throws UsuarioException {
		chequearUsuario(usuario);
		Usuario user = getDao().getUsuario(usuario);
		return user;
	}

	/**
	 * @post: Devuelve la lista de todos los usuarios.
	 * @return
	 * @throws UsuarioException
	 */
	public List<Usuario> getAllUsuarios() throws UsuarioException {
		return getDao().getAllUsuarios();
	}

	
	/**
	 * @pre: Ingresa usuario.
	 * @post: Devuelve un usuario distinto de null y que no exista previamente.
	 * @param usuario
	 * @return
	 * @throws UsuarioException: si el usuario es distinto de null devuelve "Usuario nulo o existente"
	 */
	public boolean existeUsuario(Usuario usuario) throws UsuarioException{
		Usuario resultado = getUsuario(usuario);
		
		if(resultado !=(null))
			throw new UsuarioException("Usuario nulo o existente.");
		
		return resultado != null;
	}

	/**
	 * @pre: Ingresa usuario.
	 * @post: Devuelve verdadero siempre que ninguno de los campos de usuario este vacio.
	 * @param usuario
	 * @return
	 * @throws UsuarioException 
	 */
	private void chequearUsuario(Usuario usuario) throws UsuarioException {
		if (usuario.getUsername().equals("")
				|| usuario.getPassword().equals("") || usuario.getEmail().equals("")) {
			throw new UsuarioException("Campos obligatorios son requeridos");
		}
	}
	
	public boolean chequearPass(Usuario usuario, Usuario usuario2) throws UsuarioException{
		if(usuario != null && usuario2 != null){
			return usuario.getPassword().equals(usuario2.getPassword());
		}else{
			throw new UsuarioException("Error, no existe el usuario o password invalida...");
		}
	}
	
	
	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}
	
	public UsuarioDAO getDao() {
		return this.dao;
	}
}

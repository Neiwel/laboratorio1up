package DAO;

import java.util.List;

import Exceptions.UsuarioException;
import entidades.Usuario;

public interface UsuarioDAO {

	public void insertarUsuario(Usuario usuario) throws UsuarioException;
	public void deleteUsuario(Usuario usuario) throws UsuarioException;
	public void updateUsuario(Usuario usuario) throws UsuarioException;
	public Usuario getUsuario(Usuario usuario) throws UsuarioException;
	public List<Usuario> getAllUsuarios() throws UsuarioException;
	
}

package handler;

import java.util.List;

import javax.swing.JOptionPane;

import entidades.Paquete;
import entidades.Usuario;
import BO.PaqueteBO;
import BO.UsuarioBO;
import Exceptions.PaqueteException;
import Exceptions.UsuarioException;
import UI.FrameLogin;
import UI.MiFrame;
import UI.PanelAltaPaquete;
import UI.PanelAltaUsuario;
import UI.PanelConsultaPaquete;
import UI.PanelConsultaUsuario;
import UI.PanelLogin;
import UI.PanelModificarPaquete;
import UI.PanelModificarUsuario;

public class Handler {

	//Atributos
	private MiFrame frame;
	private FrameLogin frameLogin;
	private UsuarioBO usuarioBO;
	private PaqueteBO paqueteBO;
	
	//Inicio el Frame Principal
	public void init() {
		frameLogin = new FrameLogin("Login",this);
		usuarioBO = new UsuarioBO();
		paqueteBO = new PaqueteBO();
		frameLogin.setVisible(true);
		showLogin();
	}
	
	//Metodos SHOW PANELS ----------------------------------------------------------------
	
	//Usuarios
	public void showAltaUsuario() { //Muestra el panel Alta usuario
		frame.cambiarPanel(new PanelAltaUsuario(this));
	}
	
	public void showConsultaUsuario()  {	// Muestra el panel de Consulta
		try {
			frame.cambiarPanel(new PanelConsultaUsuario(this));
		} catch (UsuarioException e) {
			showError(e);
			e.printStackTrace();
		}
	}
	
	public void showEditUsuario(Usuario user){	// Muestra el panel de Modificacion
		frame.cambiarPanel(new PanelModificarUsuario(this,user));
	}
	
	public void showError(UsuarioException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	}
	
	//Paquetes
	public void showAltaPaquete() { //Muestra el panel Alta paquete
		frame.cambiarPanel(new PanelAltaPaquete(this));
	}
	
	public void showConsultaPaquete()  {	// Muestra el panel de Paquete
		try {
			frame.cambiarPanel(new PanelConsultaPaquete(this));
		} catch (PaqueteException e) {
			showError(e);
			e.printStackTrace();
		}
	}
	
	public void showEditPaquete(Paquete paquete){	// Muestra el panel de Modificacion
		frame.cambiarPanel(new PanelModificarPaquete(this,paquete));
	}
	
	public void showError(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	}
	
	//Login
	public void showLogin() { //Muestra el panel Alta paquete
		PanelLogin login = new PanelLogin(this);
		this.frameLogin.cambiarPanel(login);
		
	}
	
	//Metodos Alta/Baja/Edit  -----------------------------------------------------------------------------
	
	//Usuarios
	public void altaUsuario(Usuario nuevoUsuario) {	// Llama al usuarioBO para insertar el usuario
		try {
			usuarioBO.insertarUsuario(nuevoUsuario);
			JOptionPane.showMessageDialog(null,"Usuario creado exitosamente.");
		} catch (UsuarioException e) {
			showError(e);
		}
	}
	
	public void bajaUsuario(Usuario nuevoUsuario) {	// Llama al usuarioBO para borrar el usuario
		try{
			usuarioBO.deleteUsuario(nuevoUsuario);
			JOptionPane.showMessageDialog(null,"Usuario borrado exitosamente.");
		}
		catch(UsuarioException e){
			showError(e);
		}
	}
	
	public void editUsuario(Usuario nuevoUsuario){	// Llama al usuarioBO para modificar el user en la Base de datos
		try{
			usuarioBO.updateUsuario(nuevoUsuario);
			JOptionPane.showMessageDialog(null,"Usuario modificado exitosamente.");
		}
		catch(UsuarioException e){
			showError(e);
		}
	}	
	
	//Paquetes
	public void altaPaquete(Paquete nuevoPaquete){
		try{
			paqueteBO.insertarPaquete(nuevoPaquete);
			JOptionPane.showMessageDialog(null,"Paquete creado exitosamente.");
		}
		catch(PaqueteException e){
			showError(e);
		}
	}
	
	public void bajaPaquete(Paquete nuevoPaquete){
		try{
			paqueteBO.deletePaquete(nuevoPaquete);
			JOptionPane.showMessageDialog(null, "Paquete borrado exitosamente.");
		}
		catch(PaqueteException e){
			showError(e);
		}
	}
	
	public void editPaquete(Paquete nuevoPaquete){
		try{
			paqueteBO.updatePaquete(nuevoPaquete);
			JOptionPane.showMessageDialog(null, "Paquete modificado exitosamente.");
		}
		catch(PaqueteException e){
			showError(e);
		}
	}
	
	//Metodos GET ----------------------------------------------------------
	
	//Usuarios
	public List<Usuario> getAllUsuarios(){
		List<Usuario> lista = null;
		try {
			lista = this.usuarioBO.getAllUsuarios();
		} 
		catch (UsuarioException e) {
			showError(e);
			e.printStackTrace();
		}
		return lista;
	}
	
	public Usuario getUsuario(Usuario usuario){
		Usuario usuarioBuscado = null;
		try{
			usuarioBuscado = this.usuarioBO.getUsuario(usuario);
		}
		catch (UsuarioException e){
			showError(e);
			e.printStackTrace();
		}
		return usuarioBuscado;
	}
		
	//Paquetes	
	public List<Paquete> getAllPaquetes(){
		List<Paquete> lista = null;
		try {
			lista = this.paqueteBO.getAllPaquetes();
		} 
		catch (PaqueteException e) {
			showError(e);
			e.printStackTrace();
		}
		return lista;
	}
	//------------------------------------------------------------------
	
	//Chequeo de password para Login	
	public boolean chequearPass(Usuario usuario,Usuario usuario2){
		boolean chequeo = false;
		try {
			chequeo = this.usuarioBO.chequearPass(usuario, usuario2);
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
		return chequeo;
	}
	
	//Acceso al Frame Principal
	public void loginCorrecto(){
		frameLogin.dispose();
		this.frame = new MiFrame("Correo v1.9", this);
		frame.setVisible(true);
	}
}
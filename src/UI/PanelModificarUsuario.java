package UI;

import handler.Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import entidades.Usuario;

public class PanelModificarUsuario extends PlantillaUsuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario user;
	
	//Constructor
	public PanelModificarUsuario(Handler handler,Usuario user){
		super(handler);
		setHandler(handler);
		setUser(user);
		agregarDatosUsuario();
		agregarBotones();
	}
	
	private void agregarDatosUsuario(){
		getNombre().setText(getUser().getUsername());
		getNombre().setEnabled(false);
		getEmail().setText(getUser().getUsername());
		getPass().setText(getUser().getUsername());
	}
	
	protected JPanel agregarBotones() {
		JPanel aux = new JPanel();
		JButton botonCancelar = new JButton("Cancelar");
		aux.add(botonCancelar);
		JButton botonModificarUsuario = new JButton("MODIFICAR");
		aux.add(botonModificarUsuario);

	
		botonModificarUsuario.addActionListener(new ActionListener() {
			/**
			 * @pre: Se presiona el boton de modificar.
			 * @post: Toma los valores de los campos los guarda en nuevoUsuario
			 * y llama a editarUsuario.
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setUsername(getNombre().getText());
				nuevoUsuario.setEmail(getEmail().getText());
				nuevoUsuario.setPassword(getPass().getText());		
				getHandler().editUsuario(nuevoUsuario);
			}
		});
		
		botonCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					getHandler().showConsultaUsuario();
			}
			
		});
		
		return aux;
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
		
}

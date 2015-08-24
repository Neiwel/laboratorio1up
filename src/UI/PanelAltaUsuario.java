package UI;

import handler.Handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import entidades.Usuario;

public class PanelAltaUsuario extends PlantillaUsuario {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructor
	public PanelAltaUsuario(Handler handler) {
		super(handler);
		setHandler(handler);
		agregarBotones();
	}
	
	//Crea la interfaz
	protected JPanel agregarBotones() {
		JPanel aux = new JPanel();
		
		JButton botonCancelar = new JButton("Cancelar");
		aux.add(botonCancelar);
		JButton botonAltaUsuario = new JButton("ALTA");
		aux.add(botonAltaUsuario);
		
		botonAltaUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setUsername(getNombre().getText());
				nuevoUsuario.setEmail(getEmail().getText());
				nuevoUsuario.setPassword(getPass().getText());
				getHandler().altaUsuario(nuevoUsuario);
			}});
	
		botonCancelar.addActionListener(new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
					getHandler().showConsultaUsuario();
			}
			
		});
		
		return aux;
	}

}

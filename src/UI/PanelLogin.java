package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.Handler;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Usuario;

public class PanelLogin extends PlantillaUsuario {
	
	public PanelLogin(Handler handler){
		super(handler);
		getEmail().setEnabled(false);
		getEmail().setVisible(false);
		
	}


	@Override
	protected JPanel agregarBotones() {
		JPanel login = new JPanel();
		JButton botonLogin = new JButton("Login");
		login.add(botonLogin);
		botonLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setUsername(getNombre().getText());
				nuevoUsuario.setEmail("mail");
				nuevoUsuario.setPassword(getPass().getText());
				Usuario usuarioBuscado = getHandler().getUsuario(nuevoUsuario);
				if(!getHandler().chequearPass(usuarioBuscado, nuevoUsuario)){
					JOptionPane.showMessageDialog(null,("Error, no existe el usuario o password invalida..."));
				}
				else{
					getHandler().loginCorrecto();
				}
			}
		});
		return login;
	}
}

//Hacer un frame para el login. Usar dispouse para  sacar de memoria el frame y poner Miframe
// en el BO hacer metodo login.
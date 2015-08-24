package UI;

import handler.Handler;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class PlantillaUsuario extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField email;
	private JTextField pass;
	private Handler handler;
	
	public PlantillaUsuario(Handler handler){
		setHandler(handler);
		createUI();
	}
	
	private void createUI(){
		setLayout(new GridLayout(4,2));
		
		add(new JLabel("Nombre"));
		nombre = new JTextField(20);
		add(nombre);		
		
		add(new JLabel("E-mail"));
		email = new JTextField(20);
		add(email);
		
		add(new JLabel("Password"));
		pass = new JTextField(20);
		add(pass);
		
		add(new JLabel());
		add(agregarBotones()); // Cambiar plantillla Paquete
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JTextField getPass() {
		return pass;
	}

	public void setPass(JTextField pass) {
		this.pass = pass;
	}
	
	protected abstract JPanel agregarBotones();
	
}

package UI;

import java.awt.GridLayout;

import handler.Handler;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class PlantillaPaquete extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Atributos
	private JTextField nombre;
	private JTextField telefono;
	private JTextField tipo;
	private JTextField origen;
	private JTextField destino;
	private JTextField estado;
	private JTextField precio;
	private Handler handler;
	private String[] tipoDePaqueteStrings = {"CHICO","MEDIANO","GRANDE"};
	JComboBox<String> listaTiposDePaquete = new JComboBox<String>(tipoDePaqueteStrings);
	
	public PlantillaPaquete(Handler handler){
		setHandler(handler);
		createUI();
	}
	
	private void createUI(){
		setLayout(new GridLayout(8,1));
		add(new JLabel("Nombre"));
		nombre = new JTextField(20);
		add(nombre);
		add(new JLabel("Telefono"));
		telefono = new JTextField(20);
		add(telefono);
		add(new JLabel("Tipo de Paquete"));
		
		listaTiposDePaquete.setSelectedIndex(0);
		add(listaTiposDePaquete);
		
		//tipo = new JTextField(20);
		//add(tipo);	
		add(new JLabel("Origen"));
		origen = new JTextField(20);
		add(origen);	
		add(new JLabel("Destino"));
		destino = new JTextField(20);
		add(destino);
		add(new JLabel("Estado"));
		estado = new JTextField(20);
		add(estado);
		add(new JLabel("Precio"));
		precio = new JTextField(20);
		add(precio);	
		
	}
	
	//Metodos
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
	
	public JTextField getTelefono() {
		return telefono;
	}
	
	public void setTelefono(JTextField telefono) {
		this.telefono = telefono;
	}
	
	public JTextField getTipo() {
		return tipo;
	}
	
	public void setTipo(JTextField tipo) {
		this.tipo = tipo;
	}
	
	public JTextField getOrigen() {
		return origen;
	}
	
	public void setOrigen(JTextField origen) {
		this.origen = origen;
	}
	
	public JTextField getDestino() {
		return destino;
	}
	
	public void setDestino(JTextField destino) {
		this.destino = destino;
	}
	
	public JTextField getEstado() {
		return estado;
	}
	
	public void setEstado(JTextField estado) {
		this.estado = estado;
	}
	
	public JTextField getPrecio() {
		return precio;
	}
	
	public void setPrecio(JTextField precio) {
		this.precio = precio;
	}
	
	protected abstract void agregarBotones();
}

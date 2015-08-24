package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entidades.Paquete;
import handler.Handler;

public class PanelModificarPaquete extends PlantillaPaquete{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Paquete paquete;


	public PanelModificarPaquete(Handler handler, Paquete paquete) {
		super(handler);
		setHandler(handler);
		setPaquete(paquete);
		agregarDatosPaquete();
		agregarBotones();

	}
	
	private void agregarDatosPaquete(){
		getNombre().setText(getPaquete().getNombre());
		getTelefono().setText(getPaquete().getTelefono());
		getTipo().setText(getPaquete().getTipoDePaquete());
		getOrigen().setText(getPaquete().getOrigen());
		getDestino().setText(getPaquete().getDestino());
		getEstado().setText(getPaquete().getEstado());
		//getPrecio().setText(getPaquete().getPrecio());
	}

	protected void agregarBotones(){
		JButton botonCancelar = new JButton("Cancelar");
		add(botonCancelar);
		JButton botonModificarPaquete = new JButton("MODIFICAR");
		add(botonModificarPaquete);
		
		botonModificarPaquete.addActionListener(new ActionListener() {
			/**
			 * @pre: Se presiona el boton de modificar.
			 * @post: Toma los valores de los campos los guarda en nuevoUsuario
			 * y llama a editarUsuario.
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Paquete nuevoPaquete = new Paquete();
				nuevoPaquete.setNombre(getNombre().getText());
				nuevoPaquete.setTelefono(getTelefono().getText());
				nuevoPaquete.setTipoDePaquete(getTipo().getText());
				nuevoPaquete.setOrigen(getOrigen().getText());
				nuevoPaquete.setDestino(getDestino().getText());
				nuevoPaquete.setEstado(getEstado().getText());
				nuevoPaquete.setPrecio(Integer.parseInt(getPrecio().getText()));
				getHandler().editPaquete(nuevoPaquete);
			}
		});
		
		botonCancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
					getHandler().showConsultaPaquete();
			}
		});
	}

	public Paquete getPaquete() {
		return paquete;
	}
	
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
}

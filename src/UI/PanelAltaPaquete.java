package UI;

import handler.Handler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import entidades.Paquete;

public class PanelAltaPaquete extends PlantillaPaquete{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructor
	public PanelAltaPaquete(Handler handler) {
		super(handler);
		setHandler(handler);
		agregarBotones();
	}
	
	//Crea la interfaz
	protected void agregarBotones(){
		JButton botonCancelar = new JButton("Cancelar");
		add(botonCancelar);
		JButton botonAltaPaquete = new JButton("ALTA");
		add(botonAltaPaquete);
		
		botonAltaPaquete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Paquete nuevoPaquete = new Paquete();
				nuevoPaquete.setNombre(getNombre().getText());
				nuevoPaquete.setTelefono(getTelefono().getText());
				nuevoPaquete.setTipoDePaquete((String)listaTiposDePaquete.getSelectedItem());
				nuevoPaquete.setOrigen(getOrigen().getText());
				nuevoPaquete.setDestino(getDestino().getText());
				nuevoPaquete.setEstado(getEstado().getText());
				nuevoPaquete.setPrecio(Integer.parseInt(getPrecio().getText()));
				getHandler().altaPaquete(nuevoPaquete);
			}
		});
		
		botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getHandler().showConsultaPaquete();
			}
		});
	}
}

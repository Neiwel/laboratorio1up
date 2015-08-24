package UI;

import handler.Handler;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import Exceptions.PaqueteException;
import entidades.Paquete;
import UI.TablaPaqueteModelo;

public class PanelConsultaPaquete extends JPanel{

	private static final long serialVersionUID = -129371458853996649L;
	private Handler handler;

	private List<Paquete> listaDePaquetes;
	
	public PanelConsultaPaquete(Handler handler) throws PaqueteException {
		setHandler(handler);
		setListaDePaquetes(handler.getAllPaquetes());
		createUI();
	}
	
	//Crea la interfaz
	private void createUI() {
		setLayout(new GridLayout(3,1));
		final JTable tabla = new JTable(new TablaPaqueteModelo(getListaDePaquetes()));
		ScrollPane scroll = new ScrollPane();
		scroll.add(tabla);
		add(scroll);
			
		JButton botonBajaPaquete = new JButton("BAJA");
		JButton botonEditarPaquete = new JButton("MODIFICAR");
		add(botonBajaPaquete);
		add(botonEditarPaquete);
		
		botonBajaPaquete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = tabla.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(null,new JLabel("Error! Debe seleccionar un paquete."));
				}
				else{
					int respuesta = JOptionPane.showConfirmDialog(null ,new JLabel("Desea eliminar paquete?"));
						if(respuesta == 0){
								TablaPaqueteModelo tablaPaqueteoModelo = (TablaPaqueteModelo)tabla.getModel(); //Tengo que comparar el objeto de la lista con el objeto en memoria
								Paquete p = tablaPaqueteoModelo.getDatos().get(index);
								handler.bajaPaquete(p);
								tablaPaqueteoModelo.removePaquete(p); //Antes habia puesto new, eso esta mal porque es como tirarlo y hacer uno nuevo.
						}
				}			
			}
		});
		
	
		botonEditarPaquete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = tabla.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(null,new JLabel("Error! Debe seleccionar un paquete."));
				}
				else{
						Paquete paquete = ((TablaPaqueteModelo)tabla.getModel()).getDatos().get(index);
						handler.showEditPaquete(paquete);
				}
			}
		});
	}
	
	//Metodos
	
	public List<Paquete> getListaDePaquetes(){
		return listaDePaquetes;
	}
	
	public void setListaDePaquetes(List<Paquete> listaDePaquetes){
		this.listaDePaquetes = listaDePaquetes;
		
	}

	public Handler getHandler() {
		return handler;
	}
	
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}

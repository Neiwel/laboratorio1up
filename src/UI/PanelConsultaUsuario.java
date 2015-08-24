package UI;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import handler.Handler;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import Exceptions.UsuarioException;
import entidades.Usuario;

public class PanelConsultaUsuario extends JPanel {

	//Atributos
	private static final long serialVersionUID = -7626157703545757227L;
	private Handler handler;
	private List<Usuario> listaDeUsuarios; 


	//Constructor
	public PanelConsultaUsuario(Handler handler) throws UsuarioException {
		setHandler(handler);
		setListaDeUsuarios(handler.getAllUsuarios());
		createUI();
	}

	//Crea la interfaz
	private void createUI() {
		setLayout(new GridLayout(3,1));
		final JTable tabla = new JTable(new TablaUsuarioModelo(getListaDeUsuarios()));
		ScrollPane scroll = new ScrollPane();
		scroll.add(tabla);
		add(scroll);
		
		JButton botonBajaUsuario = new JButton("BAJA");
		JButton botonEditarUsuario = new JButton("MODIFICAR");
		add(botonBajaUsuario);
		add(botonEditarUsuario);
		
		// Hacer un metodo abstracto con esta parte que se repite
		botonBajaUsuario.addActionListener(new ActionListener() {
			
		@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = tabla.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(null,new JLabel("Error! Debe seleccionar un usuario."));
				}
				else{
					int respuesta = JOptionPane.showConfirmDialog(null ,new JLabel("Desea eliminar usuario?"));
						if(respuesta == 0){
								TablaUsuarioModelo tablaUsuarioModelo = (TablaUsuarioModelo)tabla.getModel(); //Tengo que comparar el objeto de la lista con el objeto en memoria
								Usuario u = tablaUsuarioModelo.getDatos().get(index);
								handler.bajaUsuario(u);
								tablaUsuarioModelo.removeUsuario(u); //Antes habia puesto new, eso esta mal porque es como tirarlo y hacer uno nuevo.
						}
				}			
			}
		});

		botonEditarUsuario.addActionListener(new ActionListener() {
			
			/**
			 * @pre: Se presiona el boton de Modificacion
			 * @post: Toma el indice del usuario seleccionado en la tabla, lo guarda en user 
			 * y llama a mostrar el panel de Modificacion.
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = tabla.getSelectedRow();
				if(index == -1){
					JOptionPane.showMessageDialog(null,new JLabel("Error! Debe seleccionar un usuario."));
				}
				else{
						Usuario user = ((TablaUsuarioModelo)tabla.getModel()).getDatos().get(index);
						handler.showEditUsuario(user);
				}
			}
		});
		
	}
	
	//Metodos

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Handler getHandler() {
		return this.handler;
	}

	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public void setListaDeUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

}

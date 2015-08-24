package UI;

import handler.Handler;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MiFrame extends JFrame{

	//Atributos
	private static final long serialVersionUID = -1096467965616284728L;
	private Handler handler;

	//Constructor
	public MiFrame(String title, Handler handler) {
		super(title);
		this.handler = handler;
		createUI();
	}

	//Crea la interfaz del frame
	private void createUI() {
		setJMenuBar(createMenuBar());
		getContentPane().setLayout(new BorderLayout());
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Mata el proceso cuando apreto la X
	}

	//Crea la barra de menues
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		/*
		JMenu fileMenu1 = new JMenu("Login");
		
		fileMenu1.add(new JMenuItem("User"));
		fileMenu1.add(new JMenuItem("Admin"));
		menuBar.add(fileMenu1);
		*/
		
		JMenu fileMenu2 = new JMenu("Usuario");
		JMenuItem menuAltaUser = new JMenuItem("Alta");
		JMenuItem menuConsultaUser = new JMenuItem("Consulta");
		JMenuItem menuSalir = new JMenuItem("Salir");
		fileMenu2.add(menuAltaUser);
		fileMenu2.add(menuConsultaUser);
		fileMenu2.add(menuSalir);
		menuBar.add(fileMenu2);
		
		JMenu fileMenu3 = new JMenu("Paquete");
		JMenuItem menuAltaPaquete = new JMenuItem("Alta");
		JMenuItem menuConsultaPaquete = new JMenuItem("Consulta");
		fileMenu3.add(menuAltaPaquete);
		fileMenu3.add(menuConsultaPaquete);
		menuBar.add(fileMenu3);
		
		//Escucha cuando se presiona el menu
		menuAltaUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.showAltaUsuario();
			}
		});
		
		menuConsultaUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					handler.showConsultaUsuario();
			}
		});
		
		menuAltaPaquete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				handler.showAltaPaquete();
			}
		});
		
		menuConsultaPaquete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				handler.showConsultaPaquete();
			}
		});
		
		return menuBar;
	}

	public void cambiarPanel(JComponent component) {
		getContentPane().removeAll();
		getContentPane().add(BorderLayout.CENTER, component);
		getContentPane().validate();
	}
}

package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.Handler;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidades.Usuario;

public class FrameLogin extends JFrame {
	
	//Atributos
	private Handler handler;

	//Constructor
	public FrameLogin(String title,Handler handler){
		super(title);
		this.handler = handler;
		createUI();
	}
	
	private void createUI(){
		getContentPane().setLayout(new BorderLayout());
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Mata el proceso cuando apreto la X
		
	}
	
	public void cambiarPanel(JComponent component) {
		getContentPane().removeAll();
		getContentPane().add(BorderLayout.CENTER, component);
		getContentPane().validate();
	}
}

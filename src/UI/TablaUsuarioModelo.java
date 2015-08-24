package UI;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import entidades.Usuario;

public class TablaUsuarioModelo extends AbstractTableModel{

	private static final long serialVersionUID = 6787681878958700298L;

	private static final int NOMBRE = 0;
	private static final int MAIL = 1;
	private static final String[] columnas = { "NOMBRE", "MAIL" };
	private List<Usuario> datos;
	
	public TablaUsuarioModelo(List<Usuario> list){
		this.setDatos(list);
	}
	
	public String getColumnName(int column){
		return columnas[column];
	}
	
	public int getCount(){
		return getDatos().size();
	}
	
	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return getCount();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Usuario usuario = getDatos().get(row);
		
		switch(col){
		case NOMBRE:
			return usuario.getUsername();
		case MAIL:
			return usuario.getEmail();
		default:
			return null;
		}
		
	}
	public List<Usuario> getDatos() {
		return (List<Usuario>) datos;
	}
	public void setDatos(List<Usuario> list) {
		this.datos = list;
		fireTableDataChanged(); // Redibuja la tabla
	}
	
	public void removeUsuario(Usuario usuario) {
		datos.remove(usuario);
		fireTableDataChanged(); //Re-dibuja la tabla
	}

	public void addUsuario(Usuario usuario) {
		datos.add(usuario);
		fireTableDataChanged();
	}
}

package UI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Paquete;

public class TablaPaqueteModelo extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int NOMBRE = 0;
	private static final int TELEFONO = 1;
	private static final int TIPODEPAQUETE = 2;
	private static final int ORIGEN = 3;
	private static final int DESTINO = 4;
	private static final int ESTADO = 5;
	private static final int PRECIO = 6;
	private static final String[] columnas = { "NOMBRE","TELEFONO","TIPODEPAQUETE","ORIGEN","DESTINO","ESTADO","PRECIO" };
	private List<Paquete> datos;
	

	public TablaPaqueteModelo(List<Paquete> list){
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
		Paquete paquete = getDatos().get(row);
		switch(col){
		case NOMBRE:
			return paquete.getNombre();
		case TELEFONO:
			return paquete.getTelefono();
		case TIPODEPAQUETE:
			return paquete.getTipoDePaquete();
		case ORIGEN:
			return paquete.getOrigen();
		case DESTINO:
			return paquete.getDestino();
		case ESTADO:
			return paquete.getEstado();
		case PRECIO:
			return paquete.getPrecio();
		default:
			return null;
		}
	}

	public List<Paquete> getDatos() {
		return (List<Paquete>) datos;
	}
	
	public void setDatos(List<Paquete> list) {
		this.datos = list;
		fireTableDataChanged();
	}
	
	public void removePaquete(Paquete paquete){
		datos.remove(paquete);
		fireTableDataChanged();
	}
	
	public void addPaquete(Paquete paquete){
		datos.add(paquete);
		fireTableDataChanged();
	}
}

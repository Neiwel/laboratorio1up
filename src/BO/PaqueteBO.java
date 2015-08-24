package BO;

import java.util.List;

import entidades.Paquete;
import DAO.PaqueteDAO;
import DAO.PaqueteDAOimpl;
import Exceptions.PaqueteException;

public class PaqueteBO {

	//Atributos
	private PaqueteDAO dao;
	
	//Constructor
	public PaqueteBO(){
		setDao(new PaqueteDAOimpl());
	}

	//Metodos
	
	public void insertarPaquete(Paquete paquete) throws PaqueteException{
		chequearPaquete(paquete);
		existePaquete(paquete);
		getDao().insertarPaquete(paquete);
	}
	
	public void deletePaquete(Paquete paquete) throws PaqueteException{
		chequearPaquete(paquete);
		getDao().deletePaquete(paquete);
	}
	
	public void updatePaquete(Paquete paquete) throws PaqueteException{
		chequearPaquete(paquete);
		getDao().updatePaquete(paquete);
	}
	
	public Paquete getPaquete(Paquete paquete) throws PaqueteException{
		chequearPaquete(paquete);
		paquete = getDao().getPaquete(paquete);
		return paquete;
	}
	
	public List<Paquete> getAllPaquetes() throws PaqueteException{
		return getDao().getAllPaquetes();
	}
	
	//Chequeos
	private void chequearPaquete(Paquete paquete) throws PaqueteException{
		if(		   paquete.getNombre().equals("")
				|| paquete.getTelefono().equals("")
				|| paquete.getTipoDePaquete().equals("")
				|| paquete.getOrigen().equals("")
				|| paquete.getDestino().equals("")
				|| paquete.getEstado().equals("")
				|| paquete.getPrecio() < 0
		)throw new PaqueteException("Campos obligatorios son requeridos");
	}
	
	public boolean existePaquete(Paquete paquete) throws PaqueteException{
		Paquete resultado = getPaquete(paquete);
		if(resultado !=(null))
			throw new PaqueteException("Paquete nulo o existente.");
		return resultado != null;
	}
	
	//Metodos
	public PaqueteDAO getDao() {
		return dao;
	}

	public void setDao(PaqueteDAO dao) {
		this.dao = dao;
	}
}

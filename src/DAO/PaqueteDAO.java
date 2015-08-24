package DAO;

import java.util.List;

import Exceptions.PaqueteException;
import entidades.Paquete;

public interface PaqueteDAO {
	public void insertarPaquete(Paquete paquete) throws PaqueteException;
	public void deletePaquete(Paquete paquete) throws PaqueteException;
	public void updatePaquete(Paquete paquete) throws PaqueteException;
	public Paquete getPaquete(Paquete paquete) throws PaqueteException;
	public List<Paquete> getAllPaquetes() throws PaqueteException;
}

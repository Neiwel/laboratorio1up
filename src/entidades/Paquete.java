package entidades;

public class Paquete {
	
	//Atributos
	private String nombre;
	private String telefono;
	private String tipoDePaquete;
	private String origen;
	private String destino;
	private String estado;
	private int precio;
	
	//Metodos
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoDePaquete() {
		return tipoDePaquete;
	}
	
	public void setTipoDePaquete(String tipoDePaquete) {
		this.tipoDePaquete = tipoDePaquete;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Paquete [nombre=" + nombre + "telefono=" + telefono + "tipo de paquete=" + tipoDePaquete
				+ "origen=" + origen + "destino=" + destino + "precio=" + precio;
	}
}

package modelo;

public class Persona {
	private String documento;
	private String nombre;
	private int edad;
	private CitaMedica[] citasMedicas;
	private int contadorCitas;
	
	public Persona(String documento, String nombre, int edadIngresada) {
		this.documento = documento;
		this.nombre = nombre;
		edad = edadIngresada;
		citasMedicas = new CitaMedica[3];
		contadorCitas = 0;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public CitaMedica[] getCitasMedicas() {
		return citasMedicas;
	}
	
	public int getContadorCitas() {
		return contadorCitas;
	}
	
	public void setContadorCitas(int contadorCitas) {
		this.contadorCitas = contadorCitas;
	}
	
	@Override
	public String toString() {
		return "Persona \n Documento: " + documento + " \n Nombre: " + nombre + " \n Edad: " + edad;
	}
	
}

package modelo;

public class Gestion {
	private Persona personas[];
	private int contador;
	
	public Gestion() {
		personas = new Persona[10];
		contador = 0;
	}
	
	public String crearPersona(String documento, String nombre, int edadIngresada){
		personas[contador] = new Persona(documento, nombre, edadIngresada);
		contador++;
		return "LA PERSONA SE CREO CON EXITO";
	}
	
	public int buscarPersona(String cedula){
		int posicionPersona = -1;
		
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] == null) {
				break;
			}else{
				if (personas[i].getDocumento().equals(cedula)) {
					posicionPersona = i;
					break;
				}
			}
		}
		
		return posicionPersona;
	}
	
	public String mostrarPersona(String cedulaBuscar){
		int posicionPersona = buscarPersona(cedulaBuscar);
		if (posicionPersona == -1) {
			return null;
		}else{
			return personas[posicionPersona].toString();
		}
	}
	
	public String modificarPersona(int posicionPersona, String nombre, int edadIngresada){
		
		if (!nombre.equals("")) {
			personas[posicionPersona].setNombre(nombre);
		}
		if (edadIngresada != 0) {
			personas[posicionPersona].setEdad(edadIngresada);
		}
		
		if (!nombre.equals("") || edadIngresada != 0) {
			return "LA PERSONA SE MODIFICO CORRECTAMENTE";
		}else{
			return "NO SE INGRESARON VALORES A MODIFICAR";
		}
	}
	
	public String crearCita(String cedula, String codigo, String motivo, double costo){
		int posicionPersona = buscarPersona(cedula);
		int posicionCita = personas[posicionPersona].getContadorCitas();
		
		CitaMedica citaMedica = new CitaMedica(codigo, motivo, costo);
		
		personas[posicionPersona].getCitasMedicas()[posicionCita] = citaMedica;
		personas[posicionPersona].setContadorCitas(personas[posicionPersona].getContadorCitas() + 1);
		
		return "SE CREO LA CITA CORRECTAMENTE";
	}
	
	public CitaMedica[] mostrarCitas(String cedula){
		int posicionPersona = buscarPersona(cedula);
		
		return personas[posicionPersona].getCitasMedicas();
	}
	
	public int getContador() {
		return contador;
	}
	
	public Persona[] getPersonas() {
		return personas;
	}
	
}

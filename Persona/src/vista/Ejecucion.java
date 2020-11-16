package vista;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import modelo.CitaMedica;
import modelo.Gestion;
import modelo.Persona;

public class Ejecucion {

	public static void menu(){
		Scanner scanner = new Scanner(System.in);
		Gestion gestion = new Gestion();
		int opcion = 0;
		while (opcion != 3) {
			System.out.println("Seleccione la opcion que desea");
			System.out.println("0. PERSONAS");
			System.out.println("1. CITAS");
			System.out.println("2. SALIR");
			opcion = scanner.nextInt();

			if (opcion == 0) {
				int opcionDos = 0;
				while(opcionDos != 4){
					System.out.println("Seleccione la opcion que desea realizar");
					System.out.println("0. Mostrar persona");
					System.out.println("1. Crear persona");
					System.out.println("2. Modificar persona");
					System.out.println("3. Ver persona");
					System.out.println("4. Salir");
					opcionDos = scanner.nextInt();
					if (opcionDos == 0) {
						for (int i = 0; i < gestion.getPersonas().length; i++) {
							if (gestion.getPersonas()[i] == null) {
								break;
							}else{
								System.out.println("--------------------------------------------");
								System.out.println(gestion.getPersonas()[i].toString());
								System.out.println("--------------------------------------------");
							}
						}
					} else if (opcionDos == 1) {
						scanner.nextLine();
						System.out.println("INGRESA EL DOCUMENTO");
						String documento = scanner.nextLine();
						System.out.println("INGRESE EL NOMBRE");
						String nombre = scanner.nextLine();
						System.out.println("INGRESE LA EDAD");
						int edad = scanner.nextInt();
						System.out.println(gestion.crearPersona(documento, nombre, edad));
					} else if(opcionDos == 2){
						if (gestion.getContador() != 0) {
							scanner.nextLine();
							System.out.println("INGRESE LA CEDULA DE LA PERSONA A MODIFICAR");
							String cedula = scanner.nextLine();
							int posicionPersona = gestion.buscarPersona(cedula);

							if (posicionPersona != -1) {
								String nombre = "";
								int edad = 0;

								System.out.println("DESEA MODIFICA EL NOMBRE Y/N");
								String desicion = scanner.nextLine();

								if (desicion.equals("Y")) {
									System.out.println("INGRESE EL NUEVO NOMBRE");
									nombre = scanner.nextLine();
								}

								System.out.println("DESEA MODIFICA LA EDAD Y/N");
								desicion = scanner.nextLine();

								if (desicion.equals("Y")) {
									System.out.println("INGRESE LA NUEVA EDAD");
									edad = scanner.nextInt();
								}

								System.out.println(gestion.modificarPersona(posicionPersona ,nombre, edad));
							}else{
								System.out.println("LA PERSONA CON LA CEDULA " + cedula + " NO EXISTE EN EL SISTEMA");
							}
						}else{
							System.out.println("NO EXISTE NINGUNA PERSONA");
						}
					}else if(opcionDos == 3){
						if (gestion.getContador() != 0) {
							scanner.nextLine();
							System.out.println("INGRESE LA CEDULA DE LA PERSONA QUE DESEA VER");
							String cedula = scanner.nextLine();
							System.out.println(gestion.mostrarPersona(cedula));
						}else{
							System.out.println("NO EXISTE NINGUNA PERSONA");
						}
					}
				}

			} else if(opcion == 1){
				int opcionDos = 0;
				while (opcionDos != 4) {
					System.out.println("Seleccione la opcion que desea realizar");
					System.out.println("0. Mostrar citas");
					System.out.println("1. Crear cita");
					System.out.println("2. Modificar cita");
					System.out.println("3. Salir");
					opcionDos = scanner.nextInt();
					
					if (opcionDos == 0) {
						scanner.nextLine();
						System.out.println("INGRESA CEDULA PERSONA");
						String cedula = scanner.nextLine();
						
						CitaMedica[] citas = gestion.mostrarCitas(cedula);
						
						for (int i = 0; i < citas.length; i++) {
							System.out.println(citas[i].toString());
						}
						
					}else if (opcionDos == 1){
						scanner.nextLine();
						System.out.println("INGRESE LA CEDULA DE LA PERSONA");
						String cedula = scanner.nextLine();
						System.out.println("INGRESE EL CODIGO DE LA CITA MEDICA");
						String codigo = scanner.nextLine(); 
						System.out.println("INGRESE EL MOTIVO DE LA CITA MEDICA");
						String motivo = scanner.nextLine(); 
						System.out.println("INGRESE EL COSTO DE LA CITA MEDICA");
						double costo = scanner.nextDouble(); 
						
						System.out.println(gestion.crearCita(cedula, codigo, motivo, costo));
					}else if (opcionDos == 2){
						System.out.println("Opcion DOS");
					}
				}
			}

		}



	}

	public static void main(String[] args) {
		menu();
	}
}

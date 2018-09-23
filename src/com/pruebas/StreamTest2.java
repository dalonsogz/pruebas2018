package com.pruebas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.pruebas.beans.Alumno;
import com.pruebas.beans.Escuela;
import com.pruebas.beans.Municipio;

public class StreamTest2 {

	public StreamTest2() {
		super();

			Municipio municipio1 = new Municipio("Alcorcon", "Madrid"); 
			Municipio municipio2 = new Municipio("Mostoles", "Madrid"); 
			Municipio municipio3 = new Municipio("Talavera", "Toledo"); 
			Municipio municipio4 = new Municipio("Benidorm", "Alicante"); 
		
			Escuela escuela1 = new Escuela("I.B.LuisBuñuel", municipio1, 1, LocalDate.of(1990,2,28));
			Escuela escuela2 = new Escuela("I.B.Calleja", municipio1, 1, LocalDate.of(1980,1,20));
			Escuela escuela3 = new Escuela("I.B.Remuel", municipio2, 1, LocalDate.of(1985,6,11));
			Escuela escuela4 = new Escuela("I.B.Playa", municipio4, 1, LocalDate.of(1992,11,7));

			Alumno alumno1 = new Alumno("Daniel", "Alonso", 20, LocalDate.of(1990,1,30), escuela1);
			Alumno alumno2 = new Alumno("Paco", "Perez", 21, LocalDate.of(1989,3,15), escuela1);
			Alumno alumno3 = new Alumno("Rosa", "Gutierrez", 20, LocalDate.of(1990,7,12), escuela1);
			Alumno alumno4 = new Alumno("Ramon", "Garcia", 23, LocalDate.of(1987,4,23), escuela2);
			Alumno alumno5 = new Alumno("Daniel", "Perez", 18, LocalDate.of(1992,12,5), escuela2);
			Alumno alumno6 = new Alumno("Daniel", "Gomez", 25, LocalDate.of(1985,10,7), escuela3);
			Alumno alumno7 = new Alumno("Elena", "Cortes", 32, LocalDate.of(1978,5,10), escuela3);
			Alumno alumno8 = new Alumno("Juana", "Martin", 23, LocalDate.of(1987,1,20), escuela4);
			
			List<Municipio> municipios = Arrays.asList(municipio1,municipio2,municipio3,municipio4);
			List<Escuela> escuelas = Arrays.asList(escuela1,escuela2,escuela3,escuela4);
			List<Alumno> alumnos = Arrays.asList(alumno1,alumno2,alumno3,alumno4,alumno5,alumno6,alumno7,alumno8);

			List<String> strListFiltered = alumnos.stream().map(it -> ("["+it.getNombre()+"]")).collect(Collectors.toList());
			print(new ArrayList(strListFiltered));
						
			List alumnoListFiltered = alumnos.stream().filter(it -> it.getEscuela().equals(escuela1)).collect(Collectors.toList());
			print(new ArrayList(alumnoListFiltered));

			alumnoListFiltered = alumnos.stream().filter(it -> it.getEscuela().equals(escuela1)).filter(it -> it.getEdad()<21).collect(Collectors.toList());
			print(new ArrayList(alumnoListFiltered));

			System.out.println("------------------------------------------");

			Map<Escuela,List<Alumno>> alumnoEscuelaMap = alumnos.stream().collect(Collectors.groupingBy(Alumno::getEscuela));
//			print2(alumnoEscuelaMap);
//			System.out.println(alumnoEscuelaMap);
			alumnoEscuelaMap.forEach((escuela,it) -> System.out.println(escuela.getNombre() + "-" + it));

			System.out.println("------------------------------------------");
			
			Map<Municipio,List<Alumno>> alumnoMunicipioMap = alumnos.stream().collect(Collectors.groupingBy(it -> it.getEscuela().getMunicipio()));
			printMap(alumnoMunicipioMap);
			System.out.println("------------------------------------------");
			alumnoMunicipioMap.forEach((municipio,it) -> System.out.println(municipio.getNombre() + "-" + it));
//			System.out.println(alumnoMunicipioMap);

			System.out.println("------------------------------------------");
			System.out.println("DONE!");
	}
	
	private void print (List<?> lista) {
		System.out.println("------------------------------------------");
		for (Object obj:lista)
			System.out.println(obj);
	}
	
	private <T,E> void printMap (Map<T, List<E>> object) {
		System.out.println("------------------------------------------");
		Set<T> keys = object.keySet();
		for (Object obj:keys) {
			List<E> objs = object.get(obj);
			System.out.println(obj);
			for (Object objAux:objs) {
				System.out.println("\t"+objAux);
			}
		}
	}
}

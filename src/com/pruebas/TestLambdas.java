package com.pruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.pruebas.beans.Direccion;
import com.pruebas.beans.Usuario;

/**
 * @see <a href=
 *      "https://www.ecodeup.com/entendiendo-paso-a-paso-las-expresiones-lambda-en-java/">TUTORIAL
 *      DE EXPRESIONES LAMBDA EN JAVA 8 PASO A PASO</a>
 * @author dalonso
 *
 */
public class TestLambdas {

	public static void main(String[] args) {
		List<Usuario> names = new ArrayList<Usuario>();
		names.add(new Usuario("Elivar", "Oswaldo", null, new Direccion("San Pedro")));
		names.add(new Usuario("Antonio", "Carrion", 15, new Direccion("bellavista")));
		names.add(new Usuario("Juan", "Andrade", 12, new Direccion("San Pedro1")));
		names.add(new Usuario("Luis", "Aguilar", 17, new Direccion("San Pedro2")));
		names.add(new Usuario("Fidel", "Narvaez", 8, new Direccion("San Pedro3")));
		names.add(new Usuario("Paul", "Guevara", 5, new Direccion("San Pedro4")));
		
		// Test with optional age
		Integer sum = names.stream()
				.map ( a -> a.getEdad())
				.reduce( 0, (a,b) -> a+b);
		System.out.println("---->" + sum);
		
		// Predicate<Tipo>
		// predicado: obtiene le número de usuarios con edad mayor 'eadad' años
		int edad = 14;
		Predicate<Usuario> mayorEdad = x -> x.getEdad() > edad;
		System.out.println("Ejemplo de predicado:");
		System.out.println("Usuarios mayores a " + edad + " años: " + names.stream().filter(mayorEdad).count());
		System.out.println(names.get(0).getNombre() + "[" + names.get(0).getEdad() + "] mayor que " + edad + ":"
									+ mayorEdad.test(names.get(0)));
		System.out.println(names.get(1).getNombre() + "[" + names.get(1).getEdad() + "] mayor que " + edad + ":"
									+ mayorEdad.test(names.get(1)));

		// Function<T,R>
		// Funcion: Obtiene la dirección que corresponde al usuario de la posición 0 de
		// la lista
		System.out.println("\nEjemplo de función:");
		Function<Usuario, Direccion> funDireccion = v -> v.getDir();
		System.out.println(funDireccion.apply(names.get(0)).getNombre());

		// Consumer<Tipo>
		// ejemplo consumidor: Actualiza el apellido del usuario de la posición 0 de la
		// lista
		System.out.println("\nEjemplo de consumidor:");
		Consumer<Usuario> cambiaApellido = u -> u.setApellido("Aguirre");
		cambiaApellido.accept(names.get(0));

		// imprime usuario actualizado
		names.forEach(System.out::println);

		// Supplier<Tipo>
		// proveedor: Crea un nuevo usuario y lo imprime con la función get
		System.out.println("\nEjemplo de proveedor:");
		Supplier<Usuario> u = () -> new Usuario("Augusto", "Velez", 5, new Direccion("Cayambe"));
		System.out.println(u.get());
	}
}
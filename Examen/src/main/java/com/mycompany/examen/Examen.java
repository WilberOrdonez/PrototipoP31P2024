/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen;
        import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author wilbe
 */
public class Examen {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String mejorCampeonato = "";
        double mejorPromedio = Double.MIN_VALUE;

        while (true) {
            System.out.println("BIENVENIDO AL SISTEMA DE CAMPEONATOS DEPORTIVOS");
            System.out.println("Seleccione el tipo de campeonato:");
            System.out.println("1. Atletismo");
            System.out.println("2. Natación");
            System.out.println("3. Baloncesto");
            System.out.print("Ingrese el número correspondiente al tipo de campeonato (1-3): ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            String[] deportes = {"Atletismo", "Natación", "Baloncesto"};
            String tipoCampeonato = deportes[opcion - 1];

            System.out.println("\nCAMPEONATO DE " + tipoCampeonato);

            // Ingresar los nombres de los equipos
            System.out.println("Ingrese los nombres de los 5 equipos:");
            String[] equipos = new String[5];
            for (int i = 0; i < equipos.length; i++) {
                System.out.print("Equipo " + (i + 1) + ": ");
                equipos[i] = scanner.nextLine();
            }

            // Crear matriz para almacenar las puntuaciones
            int[][] puntuaciones = new int[5][4]; // Cinco equipos, cuatro años

            // Generar puntuaciones aleatorias
            for (int equipo = 0; equipo < 5; equipo++) {
                for (int año = 0; año < 4; año++) {
                    puntuaciones[equipo][año] = random.nextInt(51);
                }
            }

            // Calcular promedios y mostrar detalles del campeonato
            System.out.println("\nDetalles del Campeonato:");
            System.out.printf("%-15s%-10s%-10s%-10s%-10s%n", "Equipo", "Año 1", "Año 2", "Año 3", "Año 4");

            double promedioCampeonato = 0;
            int puntuacionMasAlta = Integer.MIN_VALUE;
            int puntuacionMasBaja = Integer.MAX_VALUE;

            for (int equipo = 0; equipo < 5; equipo++) {
                System.out.printf("%-15s", equipos[equipo]);
                for (int año = 0; año < 4; año++) {
                    int puntuacion = puntuaciones[equipo][año];
                    System.out.printf("%-10d", puntuacion);
                    promedioCampeonato += puntuacion;

                    // Actualizar puntuación más alta y más baja
                    if (puntuacion > puntuacionMasAlta) {
                        puntuacionMasAlta = puntuacion;
                    }
                    if (puntuacion < puntuacionMasBaja) {
                        puntuacionMasBaja = puntuacion;
                    }
                }
                System.out.println();
            }

            promedioCampeonato /= 5 * 4;
            System.out.println("\nPromedio del Campeonato: " + promedioCampeonato);

            // Verificar si este campeonato tiene el mejor promedio
            if (promedioCampeonato > mejorPromedio) {
                mejorPromedio = promedioCampeonato;
                mejorCampeonato = tipoCampeonato;
            }

            // Mostrar el mejor campeonato y su promedio
            System.out.println("\nMejor Campeonato hasta ahora: " + mejorCampeonato + " con un promedio de " + mejorPromedio + "\n");

            // Preguntar si el usuario quiere iniciar un nuevo campeonato
            System.out.print("¿Desea iniciar un nuevo campeonato? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break; // Salir del bucle si la respuesta no es "s"
            }
        }

        System.out.println("¡GRACIAS POR USAR EL SISTEMA DE CAMPEONATOS!");
        scanner.close();
    }
}


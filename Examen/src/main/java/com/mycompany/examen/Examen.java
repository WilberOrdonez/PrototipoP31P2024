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

        String mejorLiga = "";
        double mejorPromedio = Double.MIN_VALUE;

        while (true) {
            System.out.println("CAMPEONATO DEPORTIVO");

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

            // Calcular promedios y mostrar detalles de cada liga
            System.out.println("\nDetalles del Campeonato:");
            System.out.printf("%-15s%-10s%-10s%-10s%-10s%n", "Equipo", "Año 1", "Año 2", "Año 3", "Año 4");

            double promedioLiga = 0;
            int puntuacionMasAlta = Integer.MIN_VALUE;
            int puntuacionMasBaja = Integer.MAX_VALUE;

            for (int equipo = 0; equipo < 5; equipo++) {
                System.out.printf("%-15s", equipos[equipo]);
                for (int año = 0; año < 4; año++) {
                    int puntuacion = puntuaciones[equipo][año];
                    System.out.printf("%-10d", puntuacion);
                    promedioLiga += puntuacion;

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

            promedioLiga /= 5 * 4;
            System.out.println("\nPromedio del Campeonato: " + promedioLiga);

            // Verificar si esta liga tiene el mejor promedio
            if (promedioLiga > mejorPromedio) {
                mejorPromedio = promedioLiga;
                mejorLiga = "Este Campeonato";
            }

            // Mostrar la mejor liga y su promedio
            System.out.println("\nMejor Campeonato hasta ahora: " + mejorLiga + " con un promedio de " + mejorPromedio + "\n");

            // Preguntar si el usuario quiere iniciar un nuevo campeonato
            System.out.print("\n¿Desea iniciar un nuevo campeonato? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break; // Salir del bucle si la respuesta no es "s"
            }
        }

        System.out.println("¡BUEN CAMPEONATO!");
        scanner.close();
    }
}


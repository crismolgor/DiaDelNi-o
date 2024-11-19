package PrimerParcial;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Niño> niños = new ArrayList<>();
    private static ArrayList<Rifa> rifas = new ArrayList<>();
    private static int contadorRifa = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

      
        rifas.add(new Rifa(1, "Play 5"));
        rifas.add(new Rifa(2, "Pc gamer"));
        rifas.add(new Rifa(3, "Bono de H&M"));

        while (continuar) {
            System.out.println("1. Registrar Niño");
            System.out.println("2. Asignar Refrigerio y Bebida");
            System.out.println("3. Asignar Número de Rifa");
            System.out.println("4. Realizar Sorteo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarNiño(sc);
                    break;
                case 2:
                    asignarRefrigerioYBebida(sc);
                    break;
                case 3:
                    asignarNumeroRifa();
                    break;
                case 4:
                    realizarSorteo();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }

    private static void registrarNiño(Scanner sc) {
        System.out.print("Ingrese DNI del niño: ");
        String dni = sc.nextLine();
        System.out.print("Ingrese nombres del niño: ");
        String nombres = sc.nextLine();
        System.out.print("Ingrese apellidos del niño: ");
        String apellidos = sc.nextLine();
        System.out.print("Ingrese edad del niño: ");
        int edad = sc.nextInt();
        sc.nextLine(); 

        if (edad > 13) {
            System.out.println("El niño no cumple con la edad permitida para el evento.");
            return;
        }

        System.out.print("Ingrese teléfono del padre: ");
        String telefonoPadre = sc.nextLine();

        Niño niño = new Niño(dni, nombres, apellidos, edad, telefonoPadre);
        niños.add(niño);
        System.out.println("Niño registrado exitosamente.");
    }

    private static void asignarRefrigerioYBebida(Scanner sc) {
        if (niños.isEmpty()) {
            System.out.println("No hay niños registrados.");
            return;
        }

        System.out.print("Ingrese DNI del niño para asignar refrigerio y bebida: ");
        String dni = sc.nextLine();
        Niño niño = buscarNiño(dni);

        if (niño != null) {
            System.out.println("Escriba la opcion que desea de refrigerio:");
            System.out.println("Perro Caliente");
            System.out.println("Hamburguesa");
            System.out.println("Papitas McDonald");
            String refrigerio = sc.nextLine();
            niño.setRefrigerio(refrigerio);
            System.out.println("Escriba la opcion que desea de bebida:");
            System.out.println("Gaseosa");
            System.out.println("Agua");
            String bebida = sc.nextLine();
            niño.setBebida(bebida);

            System.out.println("Refrigerio y bebida asignados: " + refrigerio + " con " + bebida);
        } else {
            System.out.println("Niño no encontrado.");
        }
    }

    private static void asignarNumeroRifa() {
        if (niños.isEmpty()) {
            System.out.println("No hay niños registrados.");
            return;
        }

        for (Niño niño : niños) {
            niño.setNumeroRifa(contadorRifa++);
        }
        System.out.println("Números de rifa asignados a todos los niños registrados.");
    }

    private static void realizarSorteo() {
        if (niños.isEmpty()) {
            System.out.println("No hay niños registrados.");
            return;
        }

        if (rifas.isEmpty()) {
            System.out.println("No hay rifas disponibles.");
            return;
        }

        int indexGanador = (int) (Math.random() * niños.size());
        Niño ganador = niños.get(indexGanador);

        if (!ganador.isGanoRifa()) {
            ganador.setGanoRifa(true);
            Rifa rifaGanada = rifas.remove(0); 
            System.out.println("Ganador:");
            System.out.println("Número de Rifa: " + ganador.getNumeroRifa());
            System.out.println("Nombres: " + ganador.getNombres() + " " + ganador.getApellidos());
            System.out.println("Premio: " + rifaGanada.getDescripcion());
        } else {
            System.out.println("Este niño ya ganó una rifa.");
        }
    }

    private static Niño buscarNiño(String dni) {
        for (Niño niño : niños) {
            if (niño.getDni().equals(dni)) {
                return niño;
            }
        }
        return null;
    }
}

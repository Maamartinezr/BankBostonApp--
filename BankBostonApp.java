/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankbostonapp;

import java.util.*;


/**
 *
 * @author marialex
 */
public class BankBostonApp {

    private static Map<String, Cliente> clientes = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int opcion;

        do {
            System.out.println("\n=== MENÚ BANK BOSTON ===");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Ver datos personales del cliente");
            System.out.println("3. Hacer depósito");
            System.out.println("4. Hacer giro");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> verDatosCliente();
                case 3 -> hacerDeposito();
                case 4 -> hacerGiro();
                case 5 -> consultarSaldo();
                case 6 -> System.out.println("¡Gracias por usar Bank Boston!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private static void registrarCliente() {
        System.out.print("RUT: ");
        String rut = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido paterno: ");
        String apellidoPaterno = sc.nextLine();
        System.out.print("Apellido materno: ");
        String apellidoMaterno = sc.nextLine();
        System.out.print("Domicilio: ");
        String domicilio = sc.nextLine();
        System.out.print("Comuna: ");
        String comuna = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Número de cuenta (9 dígitos): ");
        int numeroCuenta = sc.nextInt();
        System.out.print("Saldo inicial: ");
        int saldo = sc.nextInt(); sc.nextLine();

        CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, saldo);
        Cliente cliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, cuenta);
        clientes.put(rut, cliente);

        System.out.println("Cliente registrado correctamente.");
    }

    private static void verDatosCliente() {
        Cliente c = buscarCliente();
        if (c != null) c.mostrarDatos();
    }

    private static void hacerDeposito() {
        Cliente c = buscarCliente();
        if (c != null) {
            System.out.print("Monto a depositar: ");
            int monto = sc.nextInt(); sc.nextLine();
            c.getCuenta().depositar(monto);
            System.out.println("Depósito realizado exitosamente.");
        }
    }

    private static void hacerGiro() {
        Cliente c = buscarCliente();
        if (c != null) {
            System.out.print("Monto a girar: ");
            int monto = sc.nextInt(); sc.nextLine();
            if (c.getCuenta().girar(monto)) {
                System.out.println("Giro realizado exitosamente.");
            } else {
                System.out.println("Fondos insuficientes.");
            }
        }
    }

    private static void consultarSaldo() {
        Cliente c = buscarCliente();
        if (c != null) {
            System.out.println("Saldo actual: $" + c.getCuenta().getSaldo());
        }
    }

    private static Cliente buscarCliente() {
        System.out.print("Ingrese el RUT del cliente: ");
        String rut = sc.nextLine();
        Cliente cliente = clientes.get(rut);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        }
        return cliente;
    }
}
    
    


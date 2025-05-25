/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankbostonapp;

/**
 *
 * @author marialex
 */
class Cliente {
   private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private CuentaBancaria cuenta;

    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String domicilio, String comuna, String telefono, CuentaBancaria cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }

    public void mostrarDatos() {
        System.out.println("RUT: " + rut);
        System.out.println("Nombre completo: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Cuenta Corriente: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: $" + cuenta.getSaldo());
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    public String getRut() {
        return rut;
    }
} 


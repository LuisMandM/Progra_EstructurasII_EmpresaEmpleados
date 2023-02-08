package com.ikasgela;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Empleado {
    protected String nombre;
    protected String apellidos;
    protected LocalDate fecha_Contrato;
    protected LocalDate fecha_Nacimiento;

    //Associations
    protected Empresa empresa;

    //Constructors:


    public Empleado(String nombre, String apellidos, LocalDate fecha_Contrato, LocalDate fecha_Nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_Contrato = fecha_Contrato;
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public Empleado(String nombre, String apellidos, LocalDate fecha_Contrato, LocalDate fecha_Nacimiento,
                    Empresa empresa) {
        this.nombre = nombre;
        this.apellidos = apellidos;

        this.fecha_Contrato = fecha_Contrato;
        this.empresa = empresa;
        this.fecha_Nacimiento = fecha_Nacimiento;

    }

    public Empleado() {
    }


    //Methods
    public int DiasContratado() {
        return (int) ChronoUnit.DAYS.between(this.fecha_Contrato, LocalDate.now());
    }

    public int Edad() {
        return (int) ChronoUnit.YEARS.between(this.fecha_Nacimiento, LocalDate.now());
    }

    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFecha_Contrato() {
        return fecha_Contrato;
    }

    public void setFecha_Contrato(LocalDate fecha_Contrato) {
        this.fecha_Contrato = fecha_Contrato;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %-5s Apellido: %-5s Edad: %-5d \nContratacion:%td %tb %tY" +
                        "\nDias Laborados: %-5d dias\n"
                , nombre, apellidos, Edad(), fecha_Contrato, fecha_Contrato,
                fecha_Contrato, DiasContratado());

    }


}

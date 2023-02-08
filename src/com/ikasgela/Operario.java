package com.ikasgela;

import java.time.LocalDate;

public class Operario extends Empleado {
    private double salario_hora;
    private int horas_Contrato;


    //Constructors
    public Operario(String nombre, String apellidos, LocalDate fecha_Contrato,
                    LocalDate fecha_Nacimiento, double salario_hora, int horas_Contrato) {
        super(nombre, apellidos, fecha_Contrato, fecha_Nacimiento);
        this.salario_hora = salario_hora;
        this.horas_Contrato = horas_Contrato;
    }

    public Operario(String nombre, String apellidos, LocalDate fecha_Contrato,
                    LocalDate fecha_Nacimiento, Empresa empresa, double salario_hora, int horas_Contrato) {
        super(nombre, apellidos, fecha_Contrato, fecha_Nacimiento, empresa);
        this.salario_hora = salario_hora;
        this.horas_Contrato = horas_Contrato;
    }

    //Getters And Setters

    public double getSalario_hora() {
        return salario_hora;
    }

    public void setSalario_hora(double salario_hora) {
        this.salario_hora = salario_hora;
    }

    public int getHoras_Contrato() {
        return horas_Contrato;
    }

    public void setHoras_Contrato(int horas_Contrato) {
        this.horas_Contrato = horas_Contrato;
    }

    @Override
    public String toString() {
        return String.format("Operario:\nNombre: %-5s Apellido: %-5s Edad: %-5d \nContratacion:%td %tb %tY" +
                        "\nDias Laborados: %-5d dias\nSalario Hora: %-5.2f Horas Contrato: %-5d\n"
                , nombre, apellidos, Edad(), fecha_Contrato, fecha_Contrato,
                fecha_Contrato, DiasContratado(), salario_hora, horas_Contrato);

    }
}

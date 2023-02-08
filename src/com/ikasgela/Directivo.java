package com.ikasgela;

import java.time.LocalDate;

public class Directivo extends Empleado {
    private double salario_Anual;
    private double bonus_Personal;

    //Constructors
    public Directivo(String nombre, String apellidos, LocalDate fecha_Contrato,
                     LocalDate fecha_Nacimiento, double salario_Anual, double bonus_Personal) {
        super(nombre, apellidos, fecha_Contrato, fecha_Nacimiento);
        this.salario_Anual = salario_Anual;
        this.bonus_Personal = bonus_Personal;
    }

    public Directivo(String nombre, String apellidos, LocalDate fecha_Contrato,
                     LocalDate fecha_Nacimiento, Empresa empresa, double salario_Anual, double bonus_Personal) {
        super(nombre, apellidos, fecha_Contrato, fecha_Nacimiento, empresa);
        this.salario_Anual = salario_Anual;
        this.bonus_Personal = bonus_Personal;
    }


    //Getters and Setters
    public double getSalario_Anual() {
        return salario_Anual;
    }

    public void setSalario_Anual(double salario_Anual) {
        this.salario_Anual = salario_Anual;
    }

    public double getBonus_Personal() {
        return bonus_Personal;
    }

    public void setBonus_Personal(double bonus_Personal) {
        this.bonus_Personal = bonus_Personal;
    }

    @Override
    public String toString() {
        return String.format("Directivo:\nNombre: %-5s Apellido: %-5s Edad: %-5d \nContratacion:%td %tb %tY" +
                        "\nDias Laborados: %-5d dias\nSalario Anual: %-5.2f Bonus Personal: %-5.2f\n"
                , nombre, apellidos, Edad(), fecha_Contrato, fecha_Contrato,
                fecha_Contrato, DiasContratado(), salario_Anual, bonus_Personal);

    }
}

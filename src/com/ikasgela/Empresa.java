package com.ikasgela;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Empresa {


    private String nombre;
    private LocalDate anyo_Fundacion;

    //Constructors
    public Empresa(String nombre, LocalDate fecha_Fundacion) {
        this.nombre = nombre;
        this.anyo_Fundacion = fecha_Fundacion;
    }

    public Empresa() {
    }

    //Associations
    private List<Empleado> empleados = new LinkedList<>();

    //Getter and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getAnyo_Fundacion() {
        return anyo_Fundacion;
    }

    public void setAnyo_Fundacion(LocalDate anyo_Fundacion) {
        this.anyo_Fundacion = anyo_Fundacion;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void addEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    public void ShowEmpresa() {
        System.out.println("Nombre: " + this.nombre + "\nAño de fundacion: " +
                anyo_Fundacion.getYear());

        System.out.println("---PLANTILLA---");
        for (Empleado emple : this.empleados) {
            System.out.println(emple);
        }

        System.out.println();


    }
}

package com.ikasgela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Empresa> empresas_Ingresadas = new ArrayList<>();
    public static List<Empleado> empleados_Ingresados = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;
        do {
            System.out.print("\n1. Empresa\n2. Añadir empleados (a una empresa)\n3. Listados\n4. Salir\nOpcion: ");
            try {
                int opcion_Init = Integer.parseInt(br.readLine());
                switch (opcion_Init) {
                    case 1:
                        System.out.print("a. Crear nueva empresa\n" +
                                "b. Borrar una empresa\n(otra).Volver\nOpcion: ");
                        char opcion_Empresas = br.readLine().toLowerCase().charAt(0);
                        switch (opcion_Empresas) {
                            case 'a':
                                AniadirEmpresa(br);
                                break;
                            case 'b':
                                EliminarEmpresa(br);
                                break;
                            default:
                                System.out.println("ERROR: Opcion Invalida");
                                break;
                        }
                        break;
                    case 2:

                        System.out.println("Indique la empresa que desea gestionar");
                        VisualizarEmpresas();
                        System.out.print("Opcion: ");
                        int empresa_elec = Integer.parseInt(br.readLine()) - 1;

                        if (empresa_elec >= empresas_Ingresadas.size() || empresa_elec < 0) {
                            System.out.println("Error: Opción fuera de los limites");
                            return;
                        }
                        Empresa empresa_actual = empresas_Ingresadas.get(empresa_elec);
                        System.out.print("a. Añadir operario\n" +
                                "b. Añadir directivo\n" +
                                "c. Listar empleados (de la empresa)\n(otra).Volver\nOpcion: ");

                        char opcion_Emple = br.readLine().toLowerCase().charAt(0);
                        switch (opcion_Emple) {
                            case 'a':
                                AniadirOperario(br, empresa_actual);
                                break;
                            case 'b':
                                AniadirDirectivo(br, empresa_actual);
                                break;
                            case 'c':
                                empresa_actual.ShowEmpresa();
                                break;
                            default:
                                System.out.println("ERROR: Opcion Invalida");
                                break;
                        }

                        break;
                    case 3:
                        System.out.print("a. Todas las empresas\n" +
                                "b. Todos los empleados\n" +
                                "c. Listado por empresa y empleado\n(otra).Volver\nOpcion: ");
                        char opcion_Listados = br.readLine().toLowerCase().charAt(0);
                        switch (opcion_Listados) {
                            case 'a':
                                VisualizarEmpresas();
                                break;
                            case 'b':
                                if (empleados_Ingresados.size() > 0) {
                                    for (Empleado empleado_ing : empleados_Ingresados) {
                                        System.out.println(empleado_ing);
                                    }
                                } else {
                                    System.out.println("Sin Empleados que mostrar.\n");
                                }
                                break;
                            case 'c':
                                if (empresas_Ingresadas.size() > 0) {
                                    for (Empresa empresa_ing : empresas_Ingresadas) {
                                        empresa_ing.ShowEmpresa();
                                    }
                                } else {
                                    System.out.println("Sin Empresas Creadas Aun.\n");
                                }
                                break;
                            default:
                                System.out.println("ERROR: Opcion Invalida");
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo..");
                        running = false;
                        break;
                    default:
                        System.out.println("ERROR: Opcion Invalida");
                        break;


                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Opcion Invalida");
            }
        } while (running);


    }

    private static void AniadirEmpresa(BufferedReader br) throws IOException {
        System.out.print("Ingrese el nombre de la empresa: ");
        String nom_Empresa = br.readLine();

        try {

            System.out.print("Ingrese el dia de fundacion de la empresa, formato DD: ");
            int dia_Fun = Integer.parseInt(br.readLine());
            if (dia_Fun <= 0 || dia_Fun > 31) {
                System.out.println("Error: dato de DIA fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el mes de fundacion de la empresa, formato MM: ");
            int mes_Fun = Integer.parseInt(br.readLine());
            if (mes_Fun <= 0 || mes_Fun > 12) {
                System.out.println("Error: dato de MES fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el año de fundacion de la empresa, formato YYYY: ");
            int anio_Fun = Integer.parseInt(br.readLine());
            if (anio_Fun <= 0) {
                System.out.println("Error: dato de AÑO fuera de los valores validos\n");
                return;
            }
            try {
                LocalDate fecha_fun = LocalDate.of(anio_Fun, mes_Fun, dia_Fun);

                Empresa empresa_actual = new Empresa(nom_Empresa, fecha_fun);
                empresas_Ingresadas.add(empresa_actual);
            } catch (DateTimeException e) {
                System.out.println("Error: Fecha invalida\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Tipo de entrada invalida\n");
        }
    }

    private static void VisualizarEmpresas() {


        if (empresas_Ingresadas.size() > 0) {
            System.out.println("Empresas creadas:");
            for (int i = 0; i < empresas_Ingresadas.size(); i++) {
                System.out.println((i + 1) + "-" + empresas_Ingresadas.get(i).getNombre());
            }
        } else {
            System.out.println("Sin Empresas Creadas Aun.");
        }
        System.out.println();
    }

    private static void EliminarEmpresa(BufferedReader br) throws IOException {
        if (empresas_Ingresadas.size() > 0) {
            try {
                System.out.println("Indique la empresa a eliminar: ");
                VisualizarEmpresas();
                System.out.print("Opcion: ");
                int empresa_elec = Integer.parseInt(br.readLine()) - 1;

                if (empresa_elec >= empresas_Ingresadas.size() || empresa_elec < 0) {
                    System.out.println("Error: Opción fuera de los limites");
                    return;
                }

                Empresa empre_delete = empresas_Ingresadas.get(empresa_elec);

                for (Empleado empleado_empresa : empre_delete.getEmpleados()) {
                    empleados_Ingresados.remove(empleado_empresa);
                }

                empre_delete.getEmpleados().clear();
                empresas_Ingresadas.remove(empresa_elec);
                System.out.println("Empresa Eliminada correctamente");
            } catch (NumberFormatException e) {
                System.out.println("Error: Opcion tecleada invalida");
            }
        } else {
            System.out.println("Sin empresas creadas aún;");
        }
    }


    private static void AniadirOperario(BufferedReader br, Empresa empresa) throws IOException {
        System.out.print("Ingrese el nombre del Operario: ");
        String nombre_Emple = br.readLine();
        System.out.print("Ingrese el apellido del Operario: ");
        String apellido_Emple = br.readLine();

        try {
            System.out.print("Ingrese el salario por hora del Operario: ");
            double salario_Hora = Double.parseDouble(br.readLine());
            System.out.print("Ingrese las horas de contrato del Operario: ");
            int horas_Contrato = Integer.parseInt(br.readLine());

            System.out.print("Ingrese el dia de nacimiento, formato DD: ");
            int dia_Nac = Integer.parseInt(br.readLine());
            if (dia_Nac <= 0 || dia_Nac > 31) {
                System.out.println("Error: dato de DIA fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el mes de nacimiento, formato MM: ");
            int mes_Nac = Integer.parseInt(br.readLine());
            if (mes_Nac <= 0 || mes_Nac > 12) {
                System.out.println("Error: dato de MES fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el año de nacimiento, formato YYYY: ");
            int anio_Nac = Integer.parseInt(br.readLine());
            if (anio_Nac <= 0) {
                System.out.println("Error: dato de AÑO fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el dia de contratacion, formato DD: ");
            int dia_Con = Integer.parseInt(br.readLine());
            if (dia_Con <= 0 || dia_Con > 31) {
                System.out.println("Error: dato de DIA fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el mes de contratacion, formato MM: ");
            int mes_Con = Integer.parseInt(br.readLine());
            if (mes_Con <= 0 || mes_Con > 12) {
                System.out.println("Error: dato de MES fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el año de contratacion, formato YYYY: ");
            int anio_Con = Integer.parseInt(br.readLine());
            if (anio_Con <= 0) {
                System.out.println("Error: dato de AÑO fuera de los valores validos\n");
                return;
            }

            try {
                LocalDate fecha_Contra = LocalDate.of(anio_Con, mes_Con, dia_Con);
                LocalDate fecha_nac = LocalDate.of(anio_Nac, mes_Nac, dia_Nac);

                Operario operario_actual = new Operario(nombre_Emple, apellido_Emple,
                        fecha_Contra, fecha_nac, empresa, salario_Hora, horas_Contrato);

                empresa.addEmpleado(operario_actual);
                empleados_Ingresados.add(operario_actual);
                System.out.println("Operario añadido correctamente.");

            } catch (DateTimeException e) {
                System.out.println("Error: Fecha invalida\n");
            }


        } catch (NumberFormatException e) {
            System.out.println("Error: Tipo de entrada invalida\n");
        }
    }

    private static void AniadirDirectivo(BufferedReader br, Empresa empresa) throws IOException {
        System.out.print("Ingrese el nombre del Directivo: ");
        String nombre_Emple = br.readLine();
        System.out.print("Ingrese el apellido del Directivo: ");
        String apellido_Emple = br.readLine();

        try {
            System.out.print("Ingrese el salario por anual del Directivo: ");
            double salario_Anual = Double.parseDouble(br.readLine());
            System.out.print("Ingrese el valor de bonus personal del Directivo: ");
            double bonus = Double.parseDouble(br.readLine());

            System.out.print("Ingrese el dia de nacimiento, formato DD: ");
            int dia_Nac = Integer.parseInt(br.readLine());
            if (dia_Nac <= 0 || dia_Nac > 31) {
                System.out.println("Error: dato de DIA fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el mes de nacimiento, formato MM: ");
            int mes_Nac = Integer.parseInt(br.readLine());
            if (mes_Nac <= 0 || mes_Nac > 12) {
                System.out.println("Error: dato de MES fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el año de nacimiento, formato YYYY: ");
            int anio_Nac = Integer.parseInt(br.readLine());
            if (anio_Nac <= 0) {
                System.out.println("Error: dato de AÑO fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el dia de contratacion, formato DD: ");
            int dia_Con = Integer.parseInt(br.readLine());
            if (dia_Con <= 0 || dia_Con > 31) {
                System.out.println("Error: dato de DIA fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el mes de contratacion, formato MM: ");
            int mes_Con = Integer.parseInt(br.readLine());
            if (mes_Con <= 0 || mes_Con > 12) {
                System.out.println("Error: dato de MES fuera de los valores validos\n");
                return;
            }

            System.out.print("Ingrese el año de contratacion, formato YYYY: ");
            int anio_Con = Integer.parseInt(br.readLine());
            if (anio_Con <= 0) {
                System.out.println("Error: dato de AÑO fuera de los valores validos\n");
                return;
            }

            try {
                LocalDate fecha_Contra = LocalDate.of(anio_Con, mes_Con, dia_Con);
                LocalDate fecha_nac = LocalDate.of(anio_Nac, mes_Nac, dia_Nac);

                Directivo directivo_actual = new Directivo(nombre_Emple, apellido_Emple, fecha_Contra,
                        fecha_nac, empresa, salario_Anual, bonus);
                empresa.addEmpleado(directivo_actual);
                empleados_Ingresados.add(directivo_actual);

                System.out.println("Operario añadido correctamente.");

            } catch (DateTimeException e) {
                System.out.println("Error: Fecha invalida\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Tipo de entrada invalida\n");
        }
    }

}

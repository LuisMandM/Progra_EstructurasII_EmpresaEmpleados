# Empresa y empleados (con herencia)

Queremos construir una aplicación que permita almacenar la información relevante sobre empresas y sus empleados, tal
como aparecen en el siguiente diagrama de clases:

```plantuml
@startuml
skinparam classAttributeIconSize 0
skinparam nodesep 100
skinparam ranksep 80

class Empresa {
- nombre: String
- anyoFundacion: LocalDate
}

abstract class Empleado {
# nombre: String
# apellidos: String
# fechaNacimiento: LocalDate
# fechaContrato: LocalDate
+ edad(): int
+ diasContratado(): int
}

class Directivo {
- salarioAnual: double
- bonusPersonal: double
}

class Operario {
- salarioHora: double
- horasContrato: int
}

Empresa - "1..*" Empleado

Empleado <|-- Directivo
Empleado <|-- Operario

@enduml
```

El programa mostrará un menú como el siguiente:

```plaintext
1. Empresa
	a. Crear nueva empresa
	b. Borrar una empresa
2. Añadir empleados (a una empresa)
	a. Añadir operario
	b. Añadir directivo
	c. Listar empleados (de la empresa)
3. Listados
	a. Todas las empresas
	b. Todos los empleados
	c. Listado por empresa y empleado
4. Salir
```

El programa principal pedirá al usuario todos los datos necesarios y creará los objetos necesarios.

## Restricciones

- No hay límite en el número de empresas ni de empleados.
- El programa no termina hasta que se elija la opción de salir.
- Es obligatorio tratar las posibles excepciones de forma adecuada.

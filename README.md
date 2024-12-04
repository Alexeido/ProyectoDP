# DP Ciclismo

**DP Ciclismo** es un proyecto que desarrollamos como parte de la asignatura **Desarrollo de Programas** de **2º de Ingeniería Informática del Software** en la **Universidad de Extremadura (UEx)** durante el curso 2022-2023.

Este fue nuestro primer proyecto en **Java**, y uno de los principales objetivos era aprender a trabajar en grupo y profundizar en conceptos como la **Herencia** y el **Polimorfismo**. El proyecto fue realizado por **Alejandro Barrena Millán**, **Pablo Natera Muñoz** y **Raúl Martín-Romo Sánchez**, y obtuvimos una calificación de **10** en la última entrega.

## Descripción del Proyecto

Nuestro proyecto simula un campeonato de ciclismo donde tanto los **Ciclistas** como los **Equipos** compiten por obtener el menor tiempo acumulado a lo largo de varias etapas.

### Objetivo
El objetivo de cada **Ciclista** es completar cada **Etapa** en el menor tiempo posible para mejorar su posición individual y ayudar a su **Equipo** a ganar el campeonato colectivo.

Además, este proyecto nos permitió aplicar y experimentar con los conceptos de **Herencia** y **Polimorfismo** en un entorno práctico, aprovechando la jerarquía de clases como **Ciclista** y **Bicicleta**, y sus subtipos.

---

## Clases principales

### **Bicicleta**
- Representa el medio principal que usan los ciclistas para competir.
- La velocidad de la bicicleta en una etapa depende de la dificultad de esta.
- Tipos de bicicletas disponibles:
  - **BicicletaNormal**
  - **BicicletaRapida**
  - **BicicletaPrototipo** 
- Solo se puede crear un objeto de un tipo de bicicleta por vez.

### **BicicletaRapida**
- Calcula su velocidad y el tiempo necesario para terminar la etapa según el ciclista que la utiliza.

### **Ciclista**
- Representa a un participante en la competición.
- Funcionalidades principales:
  - Asignación y uso de bicicletas.
  - Gestión de resultados por etapas.
  - Cálculo de su destreza.
- Subtipos:
  - **CiclistaNovato**
  - **CiclistaExperimentado**
  - **CiclistaEstrella**

### **Equipo**
- Agrupa a los ciclistas y bicicletas.
- Funcionalidades principales:
  - Ordenar ciclistas y bicicletas.
  - Calcular el tiempo acumulado de los ciclistas.
  - Gestionar las asignaciones y participaciones en etapas.

---

## Funcionalidades principales

1. **Herencia y Polimorfismo**:
   - Aprovechamos la **herencia** para crear clases específicas como **CiclistaNovato**, **CiclistaExperimentado** y **CiclistaEstrella** a partir de la clase base **Ciclista**.
   - Aplicamos **polimorfismo** al trabajar con métodos que dependen del tipo específico de bicicleta o ciclista, como el cálculo de velocidad o destreza.

2. **BicicletaRapida**:
   - Calcula su velocidad y el tiempo necesario para completar una etapa en función del ciclista.

3. **Ciclista**:
   - Asignación de bicicletas.
   - Gestión de resultados de etapas.
   - Cálculo de destreza para mejorar el rendimiento en etapas.

4. **Equipo**:
   - Ordenación y asignación de ciclistas y bicicletas.
   - Gestión del tiempo acumulado en el campeonato.
   - Envío de ciclistas con sus bicicletas asignadas a las etapas.

---

## Lecciones aprendidas

### Aspectos destacados:
- Fue nuestra primera experiencia grupal en programación.
- Aprendimos a usar **Git** para gestionar el control de versiones y colaborar eficientemente.
- Profundizamos en conceptos clave de **Java**, como la **Herencia** y el **Polimorfismo**, aplicándolos en un caso práctico.
- Experimentamos con diseño de clases y estructuras jerárquicas.

### Aspectos a mejorar:
- La organización de las carpetas y la estructura del proyecto:
  - Muchos archivos `.java` quedaron sueltos en un mismo nivel, dificultando la navegación y el mantenimiento del código. En futuros proyectos, cuidaremos más este aspecto.

---

## Instalación y ejecución

### Requisitos previos
- **Java JDK** (versión compatible).
- Un entorno de desarrollo, como **Eclipse**, **IntelliJ IDEA** o **NetBeans**.

### Pasos para la ejecución
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/usuario/DP-Ciclismo.git
   cd DP-Ciclismo
   ```

2. Abrir el proyecto en el entorno de desarrollo elegido.

3. Compilar y ejecutar el proyecto desde el archivo principal:
   - Localiza el archivo que contiene el método `main` (posiblemente `Main.java`).
   - Compílalo y ejecútalo desde el IDE o utilizando el terminal:
     ```bash
     javac Main.java
     java Main
     ```

---

## Autores

- **Alejandro Barrena Millán**
- **Pablo Natera Muñoz**
- **Raúl Martín-Romo Sánchez**

## Licencia

Este proyecto fue desarrollado exclusivamente para fines académicos y no cuenta con una licencia pública.

---

¡Gracias por revisar nuestro proyecto!

package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.time.LocalDate;
import java.util.HashMap;


import javax.swing.JOptionPane;

public class Biblioteca {

    private String nombre;

    private int numeroLibros;

    private int cantidadBibliotecarios;

    private int numeroPrestamos;
    
    private LinkedList<Libro> listaLibros = new LinkedList<>();
    private ArrayList<Bibliotecario>listaBibliotecarios= new ArrayList<>();
    private HashMap<String, Prestamo> prestamo = new HashMap<>();
   
    public Biblioteca(String nombre, int numeroLibros, int cantidadBibliotecarios){
        this.nombre=nombre;
        
        this.numeroLibros=numeroLibros;
        this.cantidadBibliotecarios=cantidadBibliotecarios;
        

    }


    

    

    public String getNombre() {
        return nombre;
    }






    public void setNombre(String nombre) {
        this.nombre = nombre;
    }






    public int getNumeroLibros() {
        return numeroLibros;
    }






    public void setNumeroLibros(int numeroLibros) {
        this.numeroLibros = numeroLibros;
    }






    public LinkedList<Libro> getListaLibros() {
        return listaLibros;
    }






    public void setListaLibros(LinkedList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }




    






  






    public int getCantidadBibliotecarios() {
        return cantidadBibliotecarios;
    }






    public void setCantidadBibliotecarios(int cantidadBibliotecarios) {
        this.cantidadBibliotecarios = cantidadBibliotecarios;
    }






    public ArrayList<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }






    public void setListaBibliotecarios(ArrayList<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    


    






    public HashMap<String, Prestamo> getPrestamo() {
        return prestamo;
    }






    public void setPrestamo(HashMap<String, Prestamo> prestamo) {
        this.prestamo = prestamo;
    }



    public int getNumeroPrestamos() {
        return numeroPrestamos;
    }






    public void setNumeroPrestamos(int numeroPrestamos) {
        this.numeroPrestamos = numeroPrestamos;
    }

    






   






  






    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", numeroLibros=" + numeroLibros + ", cantidadBibliotecarios="
                + cantidadBibliotecarios + ", numeroPrestamos=" + numeroPrestamos + ", listaLibros=" + listaLibros
                + ", listaBibliotecarios=" + listaBibliotecarios + ", prestamo=" + prestamo + "]";
    }






    public String crearLibro(Libro nuevoLibro) {
        if (nuevoLibro == null) {
            return "El Libro no puede ser nulo";
        }

        if (numeroLibros >= listaLibros.size()) {
            return "No hay cupo para un nuevo Libro";
        }

        if (buscaLibro(nuevoLibro.getCodigo()) != null) {
            return "El libro ya está registrado";
        }

        listaLibros.add(nuevoLibro); // Add the new book to the list
        return "El libro ha sido registrado exitosamente";
    }

    public Libro buscaLibro(String codigo) {
        for (Libro libroAux : listaLibros) {
            if (libroAux != null && libroAux.getCodigo().equals(codigo)) {
                return libroAux;
            }
        }
        return null;
    }


    public static String contarPrestamosPorTitulo(HashMap<String, Integer> prestamosPorLibro, String tituloBuscado) {
        
        for (String titulo : prestamosPorLibro.keySet()) {
            int cantidad = prestamosPorLibro.get(titulo); 
            if (titulo.equals(tituloBuscado)) {
                return "El libro '" + tituloBuscado + "' ha sido prestado " + cantidad + " veces.";
            }
        }
    
        
        return "El libro '" + tituloBuscado + "' no ha sido prestado.";
    }
    
    

   



    public String reemplazarLibro(String codigo, String nuevoCodigo, String isbn, String nuevoIsbn, 
                              String autor, String nuevoAutor, String titulo, String nuevoTitulo, 
                              String editorial, String nuevaEditorial, LocalDate fechaPublicacion, 
                              LocalDate nuevaFechaPublicacion) {

    Libro libroEncontrado = buscaLibro(codigo); 
    if (libroEncontrado != null) {
        libroEncontrado.setCodigo(nuevoCodigo);
        libroEncontrado.setIsbn(nuevoIsbn);
        libroEncontrado.setAutor(nuevoAutor);
        libroEncontrado.setTitulo(nuevoTitulo);
        libroEncontrado.setEditorial(nuevaEditorial);  
        libroEncontrado.setFechaPublicacion(nuevaFechaPublicacion);  
        return "Libro actualizado exitosamente";
    }
    return "Libro no encontrado";
}










    public void listarBibliotecarios() {
        if (listaBibliotecarios.size() == 0) {
            JOptionPane.showMessageDialog(null, "No hay bibliotecarios para listar.");
        } else {
            for (Bibliotecario bibliotecario : listaBibliotecarios) {
                JOptionPane.showMessageDialog(null, "Nombre: " + bibliotecario.getNombre() +
                        "\nCédula: " + bibliotecario.getCedula() +
                        "\nTeléfono: " + bibliotecario.getTelefono() +
                        "\nCorreo: " + bibliotecario.getCorreo() +
                        "\nSalario: " + bibliotecario.getSalario());
            }
        }
    }



    public String crearPrestamo(Prestamo nuevoPrestamo) {
        if (nuevoPrestamo == null) {
            return "El préstamo no puede ser nulo";
        }
    
        if (numeroPrestamos >= prestamo.size()) {  
            return "No hay cupo para un nuevo préstamo";
        }
    
        if (buscarPrestamo(nuevoPrestamo.getCodigo()) != null) {
            return "El préstamo ya está registrado";
        }
    
        
        prestamo.put(nuevoPrestamo.getCodigo(), nuevoPrestamo);
    
        
        numeroPrestamos++;  
    
        return "El préstamo ha sido registrado exitosamente";
    }
    



    private Prestamo buscarPrestamo(String codigo) {
        return prestamo.get(codigo); 
    }







    
    
    




    public String crearBibliotecario(Bibliotecario nuevoBibliotecario) {
        if (nuevoBibliotecario == null) {
            return "El Libro no puede ser nulo";
        }

        if (cantidadBibliotecarios >= listaBibliotecarios.size()) {
            return "No hay cupo para un nuevo Libro";
        }

        if (buscarBibliotecario(nuevoBibliotecario.getCedula()) != null) {
            return "El libro ya está registrado";
        }

        listaBibliotecarios.add(nuevoBibliotecario); // Add the new book to the list
        return "El libro ha sido registrado exitosamente";
    }



    private Bibliotecario buscarBibliotecario(String cedula) {
        for (Bibliotecario bibliotecarioAux : listaBibliotecarios) {
            if (bibliotecarioAux != null && bibliotecarioAux.getCedula().equals(cedula)) {
                return bibliotecarioAux;
            }
        }
        return null;
    }



    public String adicionarLibroAlPrestamo(String codigoLibro, String codigoPrestamo) {
        // Buscar el libro
        Libro libro = buscaLibro(codigoLibro);
        if (libro == null) {
            return "El libro no existe en la biblioteca.";
        }
    
        // Verificar si el libro está disponible
        if (libro.getUnidadesDisponibles() <= 0) {
            return "El libro no tiene unidades disponibles.";
        }
    
        // Buscar el préstamo
        Prestamo prestamo = buscarPrestamo(codigoPrestamo);
        if (prestamo == null) {
            return "El préstamo no existe.";
        }
    
        // Disminuir las unidades disponibles del libro
        libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - 1);
    
        // Si ya no hay unidades disponibles, modificar el estado del libro
        if (libro.getUnidadesDisponibles() == 0) {
            libro.setDisponible(false);  // Se marca el libro como no disponible
        }
    
        // Agregar el libro al préstamo
        prestamo.adicionarLibroAlPrestamo(libro);
    
        return "El libro ha sido agregado al préstamo exitosamente.";
    }





    public String entregarPrestamo(String codigoPrestamo) {
        // Buscar el préstamo
        Prestamo prestamo = buscarPrestamo(codigoPrestamo);
        if (prestamo == null) {
            return "El préstamo no existe.";
        }
    
        // Calcular el costo del préstamo
        long diasPrestamo = LocalDate.now().toEpochDay() - prestamo.getFechaPrestamo().toEpochDay();
        double costo = diasPrestamo * 1.0; // Suponiendo que el costo es 1 unidad monetaria por día
    
        // Actualizar unidades del libro
        for (Libro libro : prestamo.getListaLibros()) {
            libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() + 1);
            if (!libro.isDisponible()) {
                libro.setDisponible(true); // Si había 0 unidades, ahora está disponible
            }
        }
    
    
        return "El préstamo ha sido entregado. Costo: " + costo + " unidades monetarias.";
    }




    public String consultarPrestamo(String codigoPrestamo) {
        
        Prestamo prestamo = buscarPrestamo(codigoPrestamo);
        if (prestamo == null) {
            return "El préstamo no existe.";
        }
    
        
        StringBuilder detalles = new StringBuilder();
        detalles.append("Detalles del Préstamo:\n");
        detalles.append("Nombre: ").append(prestamo.getNombre()).append("\n");
        detalles.append("Código: ").append(prestamo.getCodigo()).append("\n");
        detalles.append("Fecha de Préstamo: ").append(prestamo.getFechaPrestamo()).append("\n");
        detalles.append("Fecha de Entrega: ").append(prestamo.getFechaEntregaPrestamo()).append("\n");
    
        return detalles.toString();
    }



    public void mostrarPrestamosPorBibliotecario() {
        HashMap<String, Integer> prestamosPorBibliotecario = new HashMap<>();
    
        
        for (Prestamo prestamo : prestamo.values()) {
            String nombreBibliotecario = prestamo.getNombre(); 
            prestamosPorBibliotecario.put(nombreBibliotecario, prestamosPorBibliotecario.getOrDefault(nombreBibliotecario, 0) + 1);
        }
    
        
        if (prestamosPorBibliotecario.isEmpty()) {
            System.out.println("No se han realizado préstamos.");
        } else {
            System.out.println("Cantidad de préstamos realizados por cada bibliotecario:");
            for (String bibliotecario : prestamosPorBibliotecario.keySet()) {
                System.out.println("Bibliotecario: " + bibliotecario + ", Préstamos: " + prestamosPorBibliotecario.get(bibliotecario));
            }
        }
    }



    public void mostrarEstudianteConMasPrestamos(ArrayList<Prestamo> listaPrestamos) {
        String estudianteConMasPrestamos = null;
        int maxPrestamos = 0;
    
        for (Prestamo prestamo : listaPrestamos) {
            String nombreEstudiante = prestamo.getNombre(); 
            int contadorPrestamos = 0;
    
            
            for (Prestamo p : listaPrestamos) {
                if (p.getNombre().equals(nombreEstudiante)) {
                    contadorPrestamos++;
                }
            }
    
           
            if (contadorPrestamos > maxPrestamos) {
                maxPrestamos = contadorPrestamos;
                estudianteConMasPrestamos = nombreEstudiante;
            }
        }
    
       
        if (estudianteConMasPrestamos == null) {
            System.out.println("No se han realizado préstamos.");
        } else {
            System.out.println("El estudiante con más préstamos es: " + estudianteConMasPrestamos + " con " + maxPrestamos + " préstamos.");
        }
    }



    public double totalDineroRecaudado() {
        double totalRecaudado = 0.0;
    
        for (Prestamo prestamo : prestamo.values()) {
           
            long diasPrestamo = LocalDate.now().toEpochDay() - prestamo.getFechaPrestamo().toEpochDay();
            double costo = diasPrestamo * 1.0; 
    
            totalRecaudado += costo; 
        }
    
        return totalRecaudado; 
    }

    public double calcularTotalPagoBibliotecarios() {
        double totalPago = 0;
    
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            int añosAntiguedad = bibliotecario.getAniosAntiguedad();
            double totalPrestamosBibliotecario = 0;
    
            for (Prestamo prestamo : prestamo.values()) {
                if (prestamo.getNombre().equals(bibliotecario.getNombre())) {
                    
                    double costoPrestamo = 1.0; 
                    totalPrestamosBibliotecario += costoPrestamo; 
                }
            }
    
           
            double pagoBase = totalPrestamosBibliotecario * 0.20;
            
            
            double bonificacion = pagoBase * (0.02 * añosAntiguedad);
    
            
            double pagoBibliotecario = pagoBase + bonificacion;
            totalPago += pagoBibliotecario;
        }
    
        return totalPago;
    }
    
    
    



    
}
    




    
    
    
    
    
    
    






    





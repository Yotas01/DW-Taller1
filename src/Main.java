import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Main {
    public static void main(String args[]) throws Exception {
        Control controlador = new Control("src/Libros.txt");
        List<Libro> libros = controlador.leerArchivo();
        int opcion;
        libros.forEach(n -> System.out.println(n.toString()));
        do {
            System.out.println("\t\t----- Bienvenido a la tienda de libros -----\t\t");
            System.out.println("Presione una de las siguientes opciones:\n1) Crear Libro\n2) Listar los libros de un " +
                    "autor\n3) Detallar un libro\n4) Salir");
            Scanner scanner = new Scanner(System.in);
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    libros.add(controlador.crearLibro());
                    libros.forEach(n -> System.out.println(n.toString()));
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del autor");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del autor");
                    String apellido = scanner.nextLine();
                    for (Libro l: libros) {
                        if(l.getAutor().getNombre().equals(nombre) && l.getAutor().getApellido().equals(apellido))
                            System.out.println("Titulo: "+l.getTitulo()+"\nAutor: "+nombre+" "+apellido);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el titulo del libro");
                    String titulo = scanner.nextLine();
                    for (Libro l: libros) {
                        if(l.getTitulo().equals(titulo))
                            System.out.println("Titulo: "+titulo+"\nDescripcion: "+l.getDescripcion()+"\nPrecio: "
                                    +l.getPrecio()+"\nPublicacion: "+l.getPublicacion()+"\nPaginas: "+l.getPaginas());;
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Digite una opcion correcta");
            }
        }while(opcion != 4);
    }
}

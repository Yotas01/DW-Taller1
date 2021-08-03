import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Control {
    String archivo;
    public List<Libro> leerArchivo() throws Exception {
        List<Libro> libros = new ArrayList<>();
        File file = new File(archivo);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while((linea = br.readLine()) != null){
            String [] palabras = linea.split(",");
            libros.add(new Libro(palabras[0],palabras[1],Integer.parseInt(palabras[2]),new Autor(palabras[3],
                    palabras[4]),Integer.parseInt(palabras[5]),Integer.parseInt(palabras[6])));
        }
        return libros;
    }
    public Libro crearLibro() throws IOException {
        Boolean valido;
        Scanner scanner = new Scanner(System.in);
        String titulo, descripcion, nombre, apellido;
        int precio, publicacion,paginas;
        System.out.println("\t\t----- Crear Libro -----\t\t");
         do{
             System.out.println("Ingrese el titulo del libro (Recuerde que debe tener entre 5 y 100 caracteres): ");
            titulo = scanner.nextLine();
            valido = titulo.length() >= 5 && titulo.length() < 100;
        }while(!valido);
        do{
            System.out.println("Ingrese la descripcion del libro (No puede tener mas de 200 caracteres): ");
            descripcion = scanner.nextLine();
            valido = descripcion.length() < 200;
        }while(!valido);
        do{
            System.out.println("Ingrese el precio del libro (No puede tener un precio mayor a 10000): ");
            precio = Integer.parseInt(scanner.nextLine());
            valido = precio > 0 && precio <= 10000;
        }while(!valido);
        System.out.println("Ingrese el nombre del autor: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del autor: ");
        apellido = scanner.nextLine();
        Autor autor = new Autor(nombre,apellido);
        do{
            System.out.println("Ingrese el anio de publicacion del libro: ");
            publicacion = scanner.nextInt();
            valido = publicacion > 999 && publicacion <= 2021;
        }while(!valido);
        do{
            System.out.println("Ingrese la cantidad de paginas del libro (No puede tener mas de 1500): ");
            paginas = scanner.nextInt();
            valido = paginas > 0 && paginas <= 1500;
        }while(!valido);
        String linea = "\n"+titulo+","+descripcion+","+precio+","+nombre+","+apellido+","+publicacion+","+paginas;
        Files.write(Paths.get(archivo),linea.getBytes(), StandardOpenOption.APPEND);
        return new Libro(titulo,descripcion,precio,autor,publicacion,paginas);
    }
    public Control(String archivo) {
        this.archivo = archivo;
    }
}

import java.io.*;
import java.util.Scanner;

public class ObjetosLibro {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //Almacenar datos de la clase Libro en el fichero BibliotecaObjetos.dat
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("BibliotecaObjetos.dat"));
            System.out.println("===========");
            System.out.println("Ingrese los datos del Libro");
            System.out.println("ISBN: ");
            Long isbn = scanner.nextLong();
            System.out.println("Titulo: ");
            String titulo = scanner.next();
            System.out.println("Autor: ");
            String autor = scanner.next();
            System.out.println("===========");

            Libro libro = new Libro(isbn, autor, titulo);
            objectOutputStream.writeObject(libro);

            System.out.println("Libro almacenado en el fichero BibliotecaObjetos.");
        }catch (IOException e){
            e.printStackTrace();
        }

        //Mostrar los datos insertado en el fichero BbliotecaObjetos.dat
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("BibliotecaObjetos.dat"));

            System.out.println("Mostrando datos de libros insertados");

            Libro libro = (Libro) objectInputStream.readObject();
            libro.mostrarLibro();

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

package Ejercicio3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class RecorrerFicheroinstituto {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            File fichero = new File("C:\\Users\\asusp\\Downloads\\Instituto.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fichero);
            document.getDocumentElement().normalize();

            // Obtener la lista de nodos del elemento raíz
            NodeList alumnoList = document.getElementsByTagName("alumno");

            // Recorrer los nodos de alumno
            for (int i = 0; i < alumnoList.getLength(); i++) {
                Node alumnoNode = alumnoList.item(i);

                // Verificar si el nodo es un elemento
                if (alumnoNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element alumnoElement = (Element) alumnoNode;

                    // Obtener atributo nmat del elemento alumno
                    String nmat = alumnoElement.getAttribute("nmat");

                    // Obtener los valores de los elementos dentro del nodo alumno
                    String nombre = alumnoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String apellidos = alumnoElement.getElementsByTagName("apellidos").item(0).getTextContent();
                    String telefono = alumnoElement.getElementsByTagName("telefono").item(0).getTextContent();

                    // Imprimir la información del alumno
                    System.out.println("Alumno " + nmat + ":");
                    System.out.println("  Nombre: " + nombre);
                    System.out.println("  Apellidos: " + apellidos);
                    System.out.println("  Teléfono: " + telefono);

                    // Obtener la lista de nodos cursosmat
                    NodeList cursosmatList = alumnoElement.getElementsByTagName("cursosmat");

                    // Recorrer los nodos de cursosmat
                    for (int j = 0; j < cursosmatList.getLength(); j++) {
                        Node cursosmatNode = cursosmatList.item(j);

                        // Verificar si el nodo es un elemento
                        if (cursosmatNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element cursosmatElement = (Element) cursosmatNode;

                            // Obtener el atributo id del elemento cursosmat
                            String idCursosmat = cursosmatElement.getAttribute("id");

                            // Obtener la lista de nodos curso dentro de cursosmat
                            NodeList cursoList = cursosmatElement.getElementsByTagName("curso");

                            // Imprimir la información de cursosmat
                            System.out.println("  Cursosmat ID: " + idCursosmat);

                            // Recorrer los nodos de curso dentro de cursosmat
                            for (int k = 0; k < cursoList.getLength(); k++) {
                                Node cursoNode = cursoList.item(k);

                                // Verificar si el nodo es un elemento
                                if (cursoNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element cursoElement = (Element) cursoNode;

                                    // Obtener el contenido del elemento curso
                                    String curso = cursoElement.getTextContent();

                                    // Imprimir la información del curso
                                    System.out.println("    Curso: " + curso);
                                }
                            }
                        }
                    }

                    System.out.println(); // Separador entre alumnos
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

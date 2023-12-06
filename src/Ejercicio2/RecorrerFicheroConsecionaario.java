package Ejercicio2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import java.io.File;

public class RecorrerFicheroConsecionaario {
    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            File Fichero = new File("C:\\Users\\asusp\\Downloads\\Concesionario.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(Fichero);
            document.getDocumentElement().normalize();

            // Obtener la lista de nodos del elemento raíz
            NodeList cocheList = document.getElementsByTagName("coche");

            // Recorrer los nodos de coche
            for (int i = 0; i < cocheList.getLength(); i++) {
                Node cocheNode = cocheList.item(i);

                // Verificar si el nodo es un elemento
                if (cocheNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element cocheElement = (Element) cocheNode;

                    // Obtener los atributos del elemento coche
                    String id = cocheElement.getAttribute("id");
                    String matricula = cocheElement.getAttribute("matricula");

                    // Obtener los valores de los elementos dentro del nodo coche
                    String marca = cocheElement.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo = cocheElement.getElementsByTagName("modelo").item(0).getTextContent();
                    String cilindrada = cocheElement.getElementsByTagName("cilindrada").item(0).getTextContent();

                    // Imprimir la información
                    System.out.println("Coche " + id + ":");
                    System.out.println("  Matrícula: " + matricula);
                    System.out.println("  Marca: " + marca);
                    System.out.println("  Modelo: " + modelo);
                    System.out.println("  Cilindrada: " + cilindrada);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

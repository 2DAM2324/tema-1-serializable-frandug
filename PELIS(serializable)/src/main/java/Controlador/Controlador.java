/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Almacena;
import Modelo.Alquila;
import Modelo.Cliente;
import Modelo.Tienda;
import Vista.Ventana1;
import java.io.File;
import Modelo.Cinta;
import Modelo.Pelicula;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.util.ArrayList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Controlador {

    private ArrayList<Tienda> tiendas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Alquila> alquileres;
    private Ventana1 nueva_ventana;
    private ArrayList<Cinta> cintas;
    private ArrayList<Pelicula>peliculas;

    public Controlador() throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException {
        this.tiendas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.cintas = new ArrayList<>();
        this.peliculas = new  ArrayList<>();
        
      

        escribirTiendaserializable();
        escribirClientesSerializables();
        escribirCintaSerializable();

        escribirPeliculasAXML();

        System.out.println("entre a escribir");

        cargarTiendasserializable("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\PELIS(serializable)\\src\\main\\TiendasSerializable.xml");
        cargarDatosClientesSerializable("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\PELIS(serializable)\\src\\main\\ClientesSerializable.xml");
        cargarDatoCintasSerializable("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\PELIS(serializable)\\src\\main\\CintasSerializable.xml");
        cargarDatosPeliculasSerializable("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\PELIS(serializable)\\src\\main\\PeliculasSerializable.xml");

        System.out.println("cintas del controlador tiene " + cintas.size());
        this.nueva_ventana = new Ventana1(tiendas, this, clientes, cintas,peliculas);
        nueva_ventana.setVisible(true);

    }

public void escribirClientesSerializables() {
    String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\PELIS(serializable)\\src\\main\\ClientesSerializable.xml";
    try {
        // Inicializa la lista de clientes con algunos datos de ejemplo aquí
        this.clientes = new ArrayList<>();
        
        // Crear y agregar objetos Cliente con datos de ejemplo
        Cliente cliente1 = new Cliente("123456789A", "NombreCliente1", "1234567890", null, null);
        Cliente cliente2 = new Cliente("987654321B", "NombreCliente2", "9876543210", null, null);
        
        this.clientes.add(cliente1);
        this.clientes.add(cliente2);

        // Utiliza un ObjectOutputStream para escribir la lista de objetos Cliente
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));

        // Escribe la lista de clientes en el archivo
        oos.writeObject(this.clientes);

        // Cierra el ObjectOutputStream
        oos.close();

        System.out.println("Datos de clientes serializables escritos en el archivo.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}



public void agregarTiendaAClienteXML(String rutaArchivo, Cliente cliente, Tienda tienda) {
    try {
        // Cargar el documento XML existente
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(rutaArchivo);

        // Obtener la raíz del documento
        Element root = document.getDocumentElement();

        // Buscar el nodo del cliente por DNI
        NodeList clienteNodes = root.getElementsByTagName("Cliente");
        Element clienteElement = null;

        for (int i = 0; i < clienteNodes.getLength(); i++) {
            Element clienteNode = (Element) clienteNodes.item(i);
            String dniCliente = clienteNode.getElementsByTagName("DNI").item(0).getTextContent();

            if (dniCliente.equals(cliente.getDni())) {
                clienteElement = clienteNode;
                break;
            }
        }

        // Verificar si se encontró el cliente
        if (clienteElement != null) {
            // Crear un nuevo nodo para la tienda
            Element tiendaElement = document.createElement("Tienda");

            // Agregar los datos de la tienda
            Element idTiendaElement = document.createElement("idTienda");
            idTiendaElement.appendChild(document.createTextNode(tienda.getId_tienda()));
            tiendaElement.appendChild(idTiendaElement);

            Element nombreElement = document.createElement("nombre");
            nombreElement.appendChild(document.createTextNode(tienda.getNombre()));
            tiendaElement.appendChild(nombreElement);

            Element direccionElement = document.createElement("direccion");
            direccionElement.appendChild(document.createTextNode(tienda.getDireccion()));
            tiendaElement.appendChild(direccionElement);

            // Agregar el nodo de la tienda al cliente
            Element tiendasElement = (Element) clienteElement.getElementsByTagName("Tiendas").item(0);
            tiendasElement.appendChild(tiendaElement);

            // Guardar el documento modificado en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

            System.out.println("Tienda agregada al cliente en el archivo XML de clientes.");
        } else {
            System.err.println("Cliente no encontrado en el archivo XML.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


public void agregarClienteXML(String rutaArchivo, Cliente nuevoCliente) {
    try {
        File archivoXML = new File(rutaArchivo);
        boolean existe = archivoXML.exists();

        // Crea un nuevo documento DOM o carga el documento existente si existe
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document document;

        if (!existe) {
            document = docBuilder.newDocument();
        } else {
            document = docBuilder.parse(archivoXML);
        }

        // Crea el elemento "Cliente" para el nuevo cliente
        Element clienteElement = document.createElement("Cliente");

        Element dniElement = document.createElement("DNI");
        dniElement.appendChild(document.createTextNode(nuevoCliente.getDni()));
        clienteElement.appendChild(dniElement);

        Element nombreElement = document.createElement("Nombre");
        nombreElement.appendChild(document.createTextNode(nuevoCliente.getNombre()));
        clienteElement.appendChild(nombreElement);

        Element telfElement = document.createElement("Telf");
        telfElement.appendChild(document.createTextNode(nuevoCliente.getTlf()));
        clienteElement.appendChild(telfElement);

        // Agrega las tiendas del nuevo cliente, si las hay
        ArrayList<Tienda> tiendas = nuevoCliente.getTiendas_del_cliente();
        Element tiendasElement = document.createElement("Tiendas");
        if (tiendas != null) {
            for (Tienda tienda : tiendas) {
                Element tiendaElement = document.createElement("Tienda");

                Element idTiendaElement = document.createElement("Id_tienda");
                idTiendaElement.appendChild(document.createTextNode(tienda.getId_tienda()));
                tiendaElement.appendChild(idTiendaElement);

                Element nombreTiendaElement = document.createElement("nombre");
                nombreTiendaElement.appendChild(document.createTextNode(tienda.getNombre()));
                tiendaElement.appendChild(nombreTiendaElement);

                Element direccionTiendaElement = document.createElement("direccion");
                direccionTiendaElement.appendChild(document.createTextNode(tienda.getDireccion()));
                tiendaElement.appendChild(direccionTiendaElement);

                tiendasElement.appendChild(tiendaElement);
            }
        }
        clienteElement.appendChild(tiendasElement);

        // Agrega los alquileres del nuevo cliente, si los hay
        ArrayList<Alquila> alquileres = nuevoCliente.getAlquileres_del_cliente();
        Element alquileresElement = document.createElement("Alquileres");
        if (alquileres != null) {
            for (Alquila alquila : alquileres) {
                Element alquilaElement = document.createElement("Alquila");

                Element dniAlquilaElement = document.createElement("DNI");
                dniAlquilaElement.appendChild(document.createTextNode(alquila.getId_cliente()));
                alquilaElement.appendChild(dniAlquilaElement);

                Element fechaElement = document.createElement("Fecha");
                fechaElement.appendChild(document.createTextNode(alquila.getFecha()));
                alquilaElement.appendChild(fechaElement);

                Element codCintaElement = document.createElement("COD_CINTA");
                codCintaElement.appendChild(document.createTextNode(alquila.getId_cinta()));
                alquilaElement.appendChild(codCintaElement);

                alquileresElement.appendChild(alquilaElement);
            }
        }
        clienteElement.appendChild(alquileresElement);

        // Agrega el nuevo cliente al elemento raíz "Clientes"
        Element rootElement;
        if (!existe) {
            rootElement = document.createElement("Clientes");
            document.appendChild(rootElement);
        } else {
            rootElement = document.getDocumentElement();
        }

        rootElement.appendChild(clienteElement);

        // Escribe el documento actualizado en el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(archivoXML);
        transformer.transform(source, result);

        System.out.println("Cliente agregado al archivo XML.");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void agregarPeliculaACintaXML(Cinta cinta, Pelicula pelicula, String rutaArchivo) {
    try {
        File archivoXML = new File(rutaArchivo);

        if (archivoXML.exists()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivoXML);

            NodeList cintaNodes = document.getElementsByTagName("Cinta");
            for (int i = 0; i < cintaNodes.getLength(); i++) {
                Element cintaElement = (Element) cintaNodes.item(i);
                String codCint = cintaElement.getElementsByTagName("cod_cint").item(0).getTextContent();

                if (codCint.equals(cinta.getCod_cint())) {
                    // La cinta se encuentra en el archivo XML, actualiza los datos necesarios

                    Element peliculaElement = document.createElement("pelicula");

                    Element codPeliculaElement = document.createElement("cod_pelicula");
                    codPeliculaElement.appendChild(document.createTextNode(pelicula.getCod_pelicula()));
                    peliculaElement.appendChild(codPeliculaElement);

                    Element tituloElement = document.createElement("titulo");
                    tituloElement.appendChild(document.createTextNode(pelicula.getTitulo()));
                    peliculaElement.appendChild(tituloElement);

                    Element generoElement = document.createElement("genero");
                    generoElement.appendChild(document.createTextNode(pelicula.getGenero()));
                    peliculaElement.appendChild(generoElement);

                    Element fechaEstrenoElement = document.createElement("fecha_estreno");
                    fechaEstrenoElement.appendChild(document.createTextNode(pelicula.getFecha_estreno()));
                    peliculaElement.appendChild(fechaEstrenoElement);

                    cintaElement.appendChild(peliculaElement);

                    // Guarda el documento modificado en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(archivoXML);
                    transformer.transform(source, result);

                    System.out.println("Película añadida a la cinta en el archivo XML.");
                    return;
                }
            }

            System.out.println("La cinta no se encontró en el archivo XML.");
        } else {
            System.err.println("El archivo XML de cintas no existe.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}



 
 public void escribirCintaSerializable() {
    try {
        // Ruta del archivo para almacenar objetos serializables
        String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\PELIS(serializable)\\src\\main\\CintasSerializable.xml";

        // Crear un ObjectOutputStream para escribir objetos serializables
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));

        // Crear una instancia de la clase Cinta
        Cinta cinta = new Cinta("CT01", "DVD", new Pelicula("MV01", "Interestelar", "Ciencia Ficción", "07/11/2014", null));

        // Escribir la instancia en el archivo
        oos.writeObject(cinta);

        // Cerrar el ObjectOutputStream
        oos.close();

        System.out.println("Objeto serializable de cinta escrito en el archivo.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
public void agregarClienteAtiendaXML(Cliente cliente) {
    try {
        // Ruta del archivo XML
        String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Tiendas.xml";

        File archivoXML = new File(rutaArchivo);

        // Verificar si el archivo XML ya existe
        if (archivoXML.exists()) {
            // Cargar el documento XML existente
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivoXML);

            // Obtener el elemento raíz "Tiendas"
            Element root = document.getDocumentElement();

            // Crear un nuevo elemento "Cliente"
            Element clienteElement = document.createElement("Cliente");

            // Crear elementos para los atributos del cliente
            Element dniElement = document.createElement("DNI");
            dniElement.appendChild(document.createTextNode(cliente.getDni()));
            Element nombreElement = document.createElement("Nombre");
            nombreElement.appendChild(document.createTextNode(cliente.getNombre()));
            Element telfElement = document.createElement("Telf");
            telfElement.appendChild(document.createTextNode(cliente.getTlf()));

            // Agregar los elementos de atributos al elemento "Cliente"
            clienteElement.appendChild(dniElement);
            clienteElement.appendChild(nombreElement);
            clienteElement.appendChild(telfElement);

            // Agregar el elemento "Cliente" a la etiqueta "Clientes" en la raíz
            Element clientesElement = (Element) root.getElementsByTagName("Clientes").item(0);
            clientesElement.appendChild(clienteElement);

            // Guardar el documento modificado en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(archivoXML);
            transformer.transform(source, result);

            System.out.println("Cliente agregado al archivo XML exitosamente.");
        } else {
            System.out.println("El archivo XML no existe. No se puede agregar el cliente.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void escribirTiendaserializable() {
        try {
            // Ruta del archivo XML de tiendas
            String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\PELIS(serializable)\\src\\main\\TiendasSerializable.xml";

            // Crear una instancia de ObjectOutputStream para escribir objetos serializables
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo));

            // Crear un objeto de la clase Tienda
            Tienda tienda = new Tienda("T01", "Tienda A", "Dirección A", new ArrayList<Cliente>());

            // Agregar un cliente a la tienda
            Cliente cliente = new Cliente("123456789A", "FRANCISCO", "6524747", new ArrayList<Alquila>(), new ArrayList<Tienda>());
            tienda.getClientes().add(cliente);

            // Escribir el objeto Tienda en el archivo XML
            oos.writeObject(tienda);

            // Cerrar el flujo de ObjectOutputStream
            oos.close();

            System.out.println("Objeto serializable de la tienda con cliente escrito en el archivo XML.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void agregarPeliculaAXML(Pelicula pelicula) {
    try {
        String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Peliculas.xml";
        File archivoXML = new File(rutaArchivo);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;

        if (archivoXML.exists()) {
            // Si el archivo existe, cargar el contenido actual
            document = builder.parse(archivoXML);
        } else {
            // Si el archivo no existe, crea un nuevo documento XML
            document = builder.newDocument();
            document.appendChild(document.createElement("Peliculas"));
        }

        // Crear un nuevo elemento "Pelicula" con los datos de la película
        Element peliculaElement = document.createElement("Pelicula");

        Element codPeliculaElement = document.createElement("cod_pelicula");
        codPeliculaElement.appendChild(document.createTextNode(pelicula.getCod_pelicula()));
        peliculaElement.appendChild(codPeliculaElement);

        Element tituloElement = document.createElement("titulo");
        tituloElement.appendChild(document.createTextNode(pelicula.getTitulo()));
        peliculaElement.appendChild(tituloElement);

        Element generoElement = document.createElement("genero");
        generoElement.appendChild(document.createTextNode(pelicula.getGenero()));
        peliculaElement.appendChild(generoElement);

        Element fechaEstrenoElement = document.createElement("fecha_estreno");
        fechaEstrenoElement.appendChild(document.createTextNode(pelicula.getFecha_estreno()));
        peliculaElement.appendChild(fechaEstrenoElement);

        // Agregar la información de la cinta (incluso si es nula)
        Cinta cinta = pelicula.getCinta_donde_se_almacena();
        Element cintaElement = document.createElement("Cinta");

        if (cinta != null) {
            Element codCintElement = document.createElement("cod_cint");
            codCintElement.appendChild(document.createTextNode(cinta.getCod_cint()));
            cintaElement.appendChild(codCintElement);

            Element formatoElement = document.createElement("formato");
            formatoElement.appendChild(document.createTextNode(cinta.getFormato()));
            cintaElement.appendChild(formatoElement);
        }

        peliculaElement.appendChild(cintaElement);

        // Agregar el nuevo elemento "Pelicula" al documento
        document.getDocumentElement().appendChild(peliculaElement);

        // Escribir el contenido actualizado en el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(archivoXML);
        transformer.transform(source, result);

        System.out.println("Película añadida al archivo XML exitosamente.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}



        public void escribirPeliculasAXML() {
    try {
        String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\PELIS(serializable)\\src\\main\\PeliculasSerializable.xml";
        File archivoXML = new File(rutaArchivo);

        if (!archivoXML.exists()) {
            XMLOutputFactory xmlFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlWriter = xmlFactory.createXMLStreamWriter(new FileOutputStream(archivoXML), "UTF-8");

            xmlWriter.writeStartDocument("UTF-8", "1.0");
            xmlWriter.writeStartElement("Peliculas");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(archivoXML));

            Pelicula pelicula = new Pelicula("MV01", "Interestelar", "Ciencia Ficcion", "7/11/2014",null);

            objectOutputStream.writeObject(pelicula);
            objectOutputStream.close();

            xmlWriter.writeEndElement(); 
            xmlWriter.writeEndDocument();
            xmlWriter.close();

            System.out.println("Datos de películas y cintas serializables guardados en el archivo XML.");
        } else {
            System.out.println("El archivo de películas serializables XML ya existe. No se sobrescribe.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void actualizarPeliculaConCintaXML(Pelicula pelicula, String rutaArchivo) {
    try {
        File archivoXML = new File(rutaArchivo);

        // Verificar si el archivo XML de películas existe
        if (archivoXML.exists()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivoXML);

            // Busca la película correspondiente por título
            NodeList peliculaNodes = document.getElementsByTagName("Pelicula");
            for (int i = 0; i < peliculaNodes.getLength(); i++) {
                Element peliculaElement = (Element) peliculaNodes.item(i);
                String tituloPelicula = peliculaElement.getElementsByTagName("titulo").item(0).getTextContent();

                if (tituloPelicula.equals(pelicula.getTitulo())) {
                    // La película se encuentra en el archivo XML, actualiza los datos de la cinta
                    if (pelicula.getCinta_donde_se_almacena() != null) {
                        Element cintaElement = document.createElement("Cinta");

                        Element codCintaElement = document.createElement("cod_cint");
                        codCintaElement.appendChild(document.createTextNode(pelicula.getCinta_donde_se_almacena().getCod_cint()));
                        cintaElement.appendChild(codCintaElement);

                        Element formatoElement = document.createElement("formato");
                        formatoElement.appendChild(document.createTextNode(pelicula.getCinta_donde_se_almacena().getFormato()));
                        cintaElement.appendChild(formatoElement);

                        // Agrega el nodo de la cinta a la película
                        peliculaElement.appendChild(cintaElement);
                    }

                    // Guarda el documento modificado en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(archivoXML);
                    transformer.transform(source, result);

                    System.out.println("Película actualizada con información de cinta en el archivo XML.");
                    return;
                }
            }

            System.out.println("La película no se encontró en el archivo XML.");
        } else {
            System.err.println("El archivo XML de películas no existe.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void modificarPeliculaEnXML(String codPelicula, String nuevoTitulo, String nuevoGenero, String nuevaFechaEstreno, String codPeliOrig) {
    try {
        String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Peliculas.xml";
        File archivoXML = new File(rutaArchivo);

        if (archivoXML.exists()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivoXML);

            NodeList peliculaNodes = document.getElementsByTagName("Pelicula");

            for (int i = 0; i < peliculaNodes.getLength(); i++) {
                Element peliculaElement = (Element) peliculaNodes.item(i);
                String codPeliculaActual = peliculaElement.getElementsByTagName("cod_pelicula").item(0).getTextContent();
                System.out.println(codPeliculaActual+ "codigo de peli ");
                if (codPeliculaActual.equals(codPeliOrig)) {
                    // Encuentra la película que coincide con el código proporcionado y actualiza los datos
                   if (!codPelicula.isEmpty()){
                       peliculaElement.getElementsByTagName("cod_pelicula").item(0).setTextContent(codPelicula);
                   }
                   if (!nuevoTitulo.isEmpty()) {
                        peliculaElement.getElementsByTagName("titulo").item(0).setTextContent(nuevoTitulo);
                    }
                    if (!nuevoGenero.isEmpty()) {
                        peliculaElement.getElementsByTagName("genero").item(0).setTextContent(nuevoGenero);
                    }
                    if (!nuevaFechaEstreno.isEmpty()) {
                        peliculaElement.getElementsByTagName("fecha_estreno").item(0).setTextContent(nuevaFechaEstreno);
                    }
                    // Guarda el documento modificado en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(archivoXML);
                    transformer.transform(source, result);

                    System.out.println("Película modificada exitosamente.");
                    return; // Termina el método después de modificar la película
                }
            }

            System.out.println("Película no encontrada: No se realizaron modificaciones.");
        } else {
            System.out.println("El archivo de películas XML no existe.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public void modificarClienteXML(String rutaArchivo, String dniOriginal, Cliente clienteModificado) {
        try {
            File archivoXML = new File(rutaArchivo);
            if (!archivoXML.exists()) {
                System.out.println("El archivo XML de clientes no existe.");
                return;
            }

            // Carga el documento XML existente
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document document = docBuilder.parse(archivoXML);

            // Obtiene la lista de nodos "Cliente" en el documento
            NodeList clientesList = document.getElementsByTagName("Cliente");

            for (int i = 0; i < clientesList.getLength(); i++) {
                Element clienteElement = (Element) clientesList.item(i);
                Node dniNode = clienteElement.getElementsByTagName("DNI").item(0);

                if (dniNode != null) {
                    String dni = dniNode.getTextContent();

                    // Comprueba si el DNI coincide con el DNI original que deseas modificar
                    if (dni.equals(dniOriginal)) {
                        // Elimina el cliente existente
                        Element parent = (Element) clienteElement.getParentNode();
                        parent.removeChild(clienteElement);

                        // Crea un nuevo elemento "Cliente" con los datos actualizados
                        Element nuevoClienteElement = document.createElement("Cliente");

                        Element nuevoDniElement = document.createElement("DNI");
                        nuevoDniElement.appendChild(document.createTextNode(clienteModificado.getDni()));
                        nuevoClienteElement.appendChild(nuevoDniElement);

                        Element nuevoNombreElement = document.createElement("Nombre");
                        nuevoNombreElement.appendChild(document.createTextNode(clienteModificado.getNombre()));
                        nuevoClienteElement.appendChild(nuevoNombreElement);

                        Element nuevoTelfElement = document.createElement("Telf");
                        nuevoTelfElement.appendChild(document.createTextNode(clienteModificado.getTlf()));
                        nuevoClienteElement.appendChild(nuevoTelfElement);

                        // Agrega los alquileres del cliente modificado, si los hay
                        ArrayList<Alquila> alquileres = clienteModificado.getAlquileres_del_cliente();
                        if (alquileres != null && !alquileres.isEmpty()) {
                            Element alquileresElement = document.createElement("Alquileres");

                            for (Alquila alquila : alquileres) {
                                Element alquilaElement = document.createElement("Alquila");

                                Element dniAlquilaElement = document.createElement("DNI");
                                dniAlquilaElement.appendChild(document.createTextNode(alquila.getId_cliente()));
                                alquilaElement.appendChild(dniAlquilaElement);

                                Element fechaElement = document.createElement("Fecha");
                                fechaElement.appendChild(document.createTextNode(alquila.getFecha()));
                                alquilaElement.appendChild(fechaElement);

                                Element codCintaElement = document.createElement("COD_CINTA");
                                codCintaElement.appendChild(document.createTextNode(alquila.getId_cinta()));
                                alquilaElement.appendChild(codCintaElement);

                                alquileresElement.appendChild(alquilaElement);
                            }
                            nuevoClienteElement.appendChild(alquileresElement);
                        }

                        // Agrega el cliente modificado al elemento raíz "Clientes"
                        Element rootElement = document.getDocumentElement();
                        rootElement.appendChild(nuevoClienteElement);

                        // Escribe el documento actualizado en el archivo XML
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(document);
                        StreamResult result = new StreamResult(archivoXML);
                        transformer.transform(source, result);

                        System.out.println("Cliente con DNI " + dniOriginal + " modificado en el archivo XML.");
                        return; // Termina la función después de modificar el cliente
                    }
                }
            }

            // Si no se encontró un cliente con el DNI original, muestra un mensaje de error
            System.out.println("Cliente con DNI " + dniOriginal + " no encontrado en el archivo XML.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void borrarPeliculaDelXML(String codPelicula) {
    try {
        String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Peliculas.xml";
        File archivoXML = new File(rutaArchivo);

        if (archivoXML.exists()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivoXML);

            NodeList peliculaNodes = document.getElementsByTagName("Pelicula");

            for (int i = 0; i < peliculaNodes.getLength(); i++) {
                Element peliculaElement = (Element) peliculaNodes.item(i);
                String codPeliculaActual = peliculaElement.getElementsByTagName("cod_pelicula").item(0).getTextContent();

                if (codPeliculaActual.equals(codPelicula)) {
                    // Encuentra la película que coincide con el código proporcionado y la elimina
                    peliculaElement.getParentNode().removeChild(peliculaElement);

                    // Guarda el documento modificado en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(archivoXML);
                    transformer.transform(source, result);

                    System.out.println("Película eliminada exitosamente.");
                    return; // Termina el método después de eliminar la película
                }
            }

            System.out.println("Película no encontrada: No se realizaron eliminaciones.");
        } else {
            System.out.println("El archivo de películas XML no existe.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void eliminarCintaDeXML(String codCinta) {
    try {
        File archivoXML = new File("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Cintas.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(archivoXML);

        NodeList cintaNodes = document.getElementsByTagName("Cinta");

        for (int i = 0; i < cintaNodes.getLength(); i++) {
            Element cintaElement = (Element) cintaNodes.item(i);
            String cod_cint = cintaElement.getElementsByTagName("cod_cint").item(0).getTextContent();

            if (cod_cint.equals(codCinta)) {
                // Encuentra la cinta que deseas eliminar y quítala del documento
                cintaElement.getParentNode().removeChild(cintaElement);

                // Guarda el documento modificado en el archivo XML
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(archivoXML);
                transformer.transform(source, result);

                System.out.println("Cinta eliminada del archivo XML.");
                return; // Termina la función después de eliminar la cinta
            }
        }

        System.out.println("Cinta no encontrada: No se realizaron eliminaciones.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void modificarCintaEnXML(String codCinta, String nuevoFormato, Pelicula nuevaPelicula, String cod_cinta_orig) {
        try {
            File archivoXML = new File("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Cintas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(archivoXML);

            NodeList cintaNodes = document.getElementsByTagName("Cinta");

            for (int i = 0; i < cintaNodes.getLength(); i++) {
                Element cintaElement = (Element) cintaNodes.item(i);
                String cod_cint = cintaElement.getElementsByTagName("cod_cint").item(0).getTextContent();
                if (cod_cint.equals(cod_cinta_orig)) {
                    if (!codCinta.isEmpty()) {
                        cintaElement.getElementsByTagName("cod_cint").item(0).setTextContent(codCinta);

                    }
                    if (!nuevoFormato.isEmpty()) {
                        cintaElement.getElementsByTagName("formato").item(0).setTextContent(nuevoFormato);

                    }
                } else {
                    System.err.println("No coincide el id ");
                }
            }
            // Guardar el documento modificado en el archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(archivoXML);
            transformer.transform(source, result);
            System.out.println("Cinta no encontrada: No se realizaron modificaciones.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

       public void modificarTiendaXML(Tienda tiendaModificada, String id_copia) {
    try {
        File archivoXML = new File("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Tiendas.xml");

        // Cargar el documento XML existente
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(archivoXML);

        // Obtener la lista de nodos 'tienda'
        NodeList tiendaNodes = document.getElementsByTagName("Tienda");

        for (int i = 0; i < tiendaNodes.getLength(); i++) {
            Element tiendaElement = (Element) tiendaNodes.item(i);
            String idTienda = tiendaElement.getElementsByTagName("idTienda").item(0).getTextContent();

            // Comparar el ID de la tienda con la tienda a modificar
            if (idTienda.equals(id_copia)) {
                if (!tiendaModificada.getId_tienda().isEmpty()) {
                    tiendaElement.getElementsByTagName("idTienda").item(0).setTextContent(tiendaModificada.getId_tienda());
                }

                if (!tiendaModificada.getNombre().isEmpty()) {
                    tiendaElement.getElementsByTagName("nombre").item(0).setTextContent(tiendaModificada.getNombre());
                }

                if (!tiendaModificada.getDireccion().isEmpty()) {
                    tiendaElement.getElementsByTagName("direccion").item(0).setTextContent(tiendaModificada.getDireccion());
                }

                // Modificar la información de los clientes asociados
                NodeList clientesNodes = tiendaElement.getElementsByTagName("Clientes");
                for (int j = 0; j < clientesNodes.getLength(); j++) {
                    Element clientesElement = (Element) clientesNodes.item(j);

                    NodeList clienteNodes = clientesElement.getElementsByTagName("Cliente");
                    for (int k = 0; k < clienteNodes.getLength(); k++) {
                        Element clienteElement = (Element) clienteNodes.item(k);
                        
                        // Modificar aquí la información del cliente según tus necesidades
                    }
                }
            } else {
                System.out.println("ID de tienda original: " + idTienda);
                System.out.println("ID de tienda modificada: " + id_copia);
                System.err.println("No coincide el ID de la tienda.");
            }
        }

        // Guardar el documento modificado en el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(archivoXML);
        transformer.transform(source, result);

        System.out.println("Archivo XML modificado exitosamente.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void eliminarTienda(String idTienda) {
        // Buscar la tienda en el archivo XML y eliminarla
        try {
            File archivoXML = new File("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Tiendas.xml");

            // Cargar el documento XML existente
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivoXML);

            // Obtener la lista de nodos 'tienda'
            NodeList tiendaNodes = document.getElementsByTagName("tienda");

            for (int i = 0; i < tiendaNodes.getLength(); i++) {
                Element tiendaElement = (Element) tiendaNodes.item(i);
                String tiendaId = tiendaElement.getElementsByTagName("idTienda").item(0).getTextContent();

                if (tiendaId.equals(idTienda)) {
                    // Eliminar el nodo 'tienda' del archivo XML
                    tiendaElement.getParentNode().removeChild(tiendaElement);
                    // Guardar el documento modificado en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(archivoXML);
                    transformer.transform(source, result);
                    break;
                }
            }

            System.out.println("Tienda eliminada del XML exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente(String dniCliente) {
        try {
            File archivoXML = new File("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Clientes.xml");

            // Cargar el documento XML existente
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivoXML);

            // Obtener la lista de nodos 'Cliente'
            NodeList clienteNodes = document.getElementsByTagName("Cliente");

            for (int i = 0; i < clienteNodes.getLength(); i++) {
                Element clienteElement = (Element) clienteNodes.item(i);
                String clienteDni = clienteElement.getElementsByTagName("DNI").item(0).getTextContent();

                if (clienteDni.equals(dniCliente)) {
                    // Eliminar el nodo 'Cliente' del archivo XML
                    clienteElement.getParentNode().removeChild(clienteElement);
                    // Guardar el documento modificado en el archivo XML
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(document);
                    StreamResult result = new StreamResult(archivoXML);
                    transformer.transform(source, result);
                    break;
                }
            }

            System.out.println("Cliente eliminado del XML exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarTienda(String id, String nuevoNombre, String nuevaDireccion) {
        // Buscar la tienda correspondiente
        for (Tienda tienda : tiendas) {
            if (tienda.getId_tienda().equals(id)) {
                tienda.setNombre(nuevoNombre);
                tienda.setDireccion(nuevaDireccion);
                // Actualizar el archivo XML
                escribirTiendaserializable();
                return;
            }
        }
    }

    public void aniadirXML(Tienda nuevaTienda, String rutaArchivo) {

        try {
            // Configurar el analizador XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Parsear el archivo XML existente
            Document doc = docBuilder.parse(rutaArchivo);

            // Obtener el elemento raíz
            Element root = doc.getDocumentElement();

            // Crear un nuevo elemento para la tienda
            Element nuevaTiendaElement = doc.createElement("tienda");

            // Crear elementos para idTienda, nombre y dirección
            Element idTiendaElement = doc.createElement("idTienda");
            idTiendaElement.appendChild(doc.createTextNode(nuevaTienda.getId_tienda()));

            Element nombreElement = doc.createElement("nombre");
            nombreElement.appendChild(doc.createTextNode(nuevaTienda.getNombre()));

            Element direccionElement = doc.createElement("direccion");
            direccionElement.appendChild(doc.createTextNode(nuevaTienda.getDireccion()));

            // Agregar los elementos al elemento de la nueva tienda
            nuevaTiendaElement.appendChild(idTiendaElement);
            nuevaTiendaElement.appendChild(nombreElement);
            nuevaTiendaElement.appendChild(direccionElement);

            // Agregar la nueva tienda al elemento raíz
            root.appendChild(nuevaTiendaElement);

            // Escribir el documento modificado de vuelta al archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

            System.out.println("Nueva tienda agregada y XML actualizado exitosamente.");
        } catch (ParserConfigurationException | TransformerException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

public void cargarTiendasserializable(String rutaArchivo) {
    try {
        // Utiliza un ObjectInputStream para deserializar los objetos de las tiendas
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo));

        // Lee el objeto Tienda desde el archivo
        Tienda tiendaCargada = (Tienda) ois.readObject();

        // Cierra el ObjectInputStream
        ois.close();

        // Agrega la tienda cargada a tu lista de tiendas
        this.tiendas.add(tiendaCargada);

        System.out.println("Tiendas cargadas desde el archivo XML.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}   



public void cargarDatosClientesSerializable(String rutaArchivo) {
    try {
        // Utiliza un ObjectInputStream para deserializar la lista de objetos Cliente
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo));

        // Lee la lista de objetos Cliente desde el archivo
        ArrayList<Cliente> clientesCargados = (ArrayList<Cliente>) ois.readObject();

        // Cierra el ObjectInputStream
        ois.close();

        // Asigna la lista de clientes cargados a tu lista de clientes
        this.clientes = clientesCargados;

        System.out.println("Datos de clientes cargados desde el archivo XML.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}




public void cargarDatoCintasSerializable(String rutaArchivo) {
    try {
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo));

      
        Cinta cintaCargada = (Cinta) ois.readObject();

        // Cierra el ObjectInputStream
        ois.close();

   
        System.out.println("Datos de cintas cargados desde el archivo serializable.");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
public void cargarDatosPeliculasSerializable(String rutaArchivo) {
    try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo));

        ArrayList<Pelicula> peliculasCargadas = (ArrayList<Pelicula>) ois.readObject();
        ois.close();

  
        this.peliculas = peliculasCargadas;

        System.out.println("Datos de películas cargados desde el archivo XML.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}


private String getElementTextContent(Element element, String tagName) {
    Node node = element.getElementsByTagName(tagName).item(0);
    return (node != null) ? node.getTextContent() : "N/A";
}

public void agregarCintaAXML(Cinta cinta) {
    try {
        String rutaArchivo = "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Cintas.xml";
        File archivoXML = new File(rutaArchivo);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;

        if (archivoXML.exists()) {
            // Si el archivo existe, cargar el contenido actual
            document = builder.parse(archivoXML);
        } else {
            // Si el archivo no existe, crea un nuevo documento XML
            document = builder.newDocument();
            document.appendChild(document.createElement("Cintas"));
        }

        // Crear un nuevo elemento "Cinta" con los datos de la cinta
        Element cintaElement = document.createElement("Cinta");

        Element codCintElement = document.createElement("cod_cint");
        codCintElement.appendChild(document.createTextNode(cinta.getCod_cint()));
        cintaElement.appendChild(codCintElement);

        Element formatoElement = document.createElement("formato");
        formatoElement.appendChild(document.createTextNode(cinta.getFormato()));
        cintaElement.appendChild(formatoElement);

        // Crear un elemento "Pelicula" incluso si la película es null
        Element peliculaElement = document.createElement("pelicula");

        Pelicula pelicula = cinta.getPelicula_almacenada();
        if (pelicula != null) {
            Element codPeliculaElement = document.createElement("cod_pelicula");
            codPeliculaElement.appendChild(document.createTextNode(pelicula.getCod_pelicula()));
            peliculaElement.appendChild(codPeliculaElement);

            Element tituloElement = document.createElement("titulo");
            tituloElement.appendChild(document.createTextNode(pelicula.getTitulo()));
            peliculaElement.appendChild(tituloElement);

            Element generoElement = document.createElement("genero");
            generoElement.appendChild(document.createTextNode(pelicula.getGenero()));
            peliculaElement.appendChild(generoElement);

            Element fechaEstrenoElement = document.createElement("fecha_estreno");
            fechaEstrenoElement.appendChild(document.createTextNode(pelicula.getFecha_estreno()));
            peliculaElement.appendChild(fechaEstrenoElement);
        }

        // Agregar el elemento "Pelicula" al elemento "Cinta"
        cintaElement.appendChild(peliculaElement);

        // Agregar el nuevo elemento "Cinta" al documento
        document.getDocumentElement().appendChild(cintaElement);

        // Escribir el contenido actualizado en el archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(archivoXML);
        transformer.transform(source, result);

        System.out.println("Cinta añadida al archivo XML exitosamente.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public Cinta cargarDatosDeUnaCintaXML(String rutaArchivo, String cod_peli , Pelicula peli_de_una_cinta ){
        Cinta cinta_relacionada_con_la_pelicula = null;
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(rutaArchivo);
            Element root = document.getDocumentElement();
            NodeList peliNodes = root.getElementsByTagName("Pelicula");
            for (int i = 0; i < peliNodes.getLength(); i++) {
                Element peliElement = (Element) peliNodes.item(i);
                
                Node cod_peliNode = peliElement.getElementsByTagName("cod_pelicula").item(0);
                String peli_cod = (cod_peliNode !=null) ? cod_peliNode.getTextContent():"N/A";
                if (peli_cod.equals(cod_peli)){
                    Node cintaNode = peliElement.getElementsByTagName("Cinta").item(0);
                    
                     if (cintaNode != null) {
                        Element cintaElement = (Element) cintaNode;
                        String codcinta = cintaElement.getElementsByTagName("cod_cint").item(0).getTextContent();
                        String formato = cintaElement.getElementsByTagName("formato").item(0).getTextContent();
                    
          
                        cinta_relacionada_con_la_pelicula = new Cinta(codcinta, formato, peli_de_una_cinta);
                       
                    }
                     break;
                }else{
                     System.out.println("No se encontro la cinta donde esta almacenada la peli");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cinta_relacionada_con_la_pelicula;    
    }
    public Pelicula cargarDatosDeUnaPeliculaXML(String rutaArchivo, String codCinta, Cinta cinta_de_esta_peli) {
        Pelicula pelicula = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(rutaArchivo);

            Element root = document.getDocumentElement();
            NodeList cintaNodes = root.getElementsByTagName("Cinta");

            for (int i = 0; i < cintaNodes.getLength(); i++) {
                Element cintaElement = (Element) cintaNodes.item(i);

                Node codCintaNode = cintaElement.getElementsByTagName("CodCinta").item(0);
                String cintaCod = (codCintaNode != null) ? codCintaNode.getTextContent() : "N/A";

                if (cintaCod.equals(codCinta)) {
                   

                   
                    Node peliculaNode = cintaElement.getElementsByTagName("Pelicula").item(0);

                    // Extrae los datos de la película
                    if (peliculaNode != null) {
                        Element peliculaElement = (Element) peliculaNode;
                        String codPelicula = peliculaElement.getElementsByTagName("CodPelicula").item(0).getTextContent();
                        String titulo = peliculaElement.getElementsByTagName("Titulo").item(0).getTextContent();
                        String genero = peliculaElement.getElementsByTagName("Genero").item(0).getTextContent();
                        String fechaEstreno = peliculaElement.getElementsByTagName("FechaEstreno").item(0).getTextContent();

                      
                        pelicula = new Pelicula(codPelicula, titulo, genero, fechaEstreno, cinta_de_esta_peli);
                    }
                    break;
                } else {
                    System.out.println("No se encontro la peli de esta cinta ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pelicula;
    }

    public ArrayList<Alquila> CargarDatosAlquilaXML(String rutaArchivo, String dniCliente) {
        ArrayList<Alquila> alquileres = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(rutaArchivo));

            Element root = document.getDocumentElement();
            NodeList alquilaNodes = root.getElementsByTagName("Alquila");

            for (int i = 0; i < alquilaNodes.getLength(); i++) {
                Element alquilaElement = (Element) alquilaNodes.item(i);

                Node dniClienteNode = alquilaElement.getElementsByTagName("DNI").item(0);
                String dni = (dniClienteNode != null) ? dniClienteNode.getTextContent() : "N/A";

                if (dni.equals(dniCliente)) {
                    Node fechaAlquilaNode = alquilaElement.getElementsByTagName("Fecha").item(0);
                    String fecha = (fechaAlquilaNode != null) ? fechaAlquilaNode.getTextContent() : "N/A";

                    Node codCintaNode = alquilaElement.getElementsByTagName("COD_CINTA").item(0);
                    String codCinta = (codCintaNode != null) ? codCintaNode.getTextContent() : "N/A";

                    Alquila alquila = new Alquila(dni, fecha, codCinta);
                    alquileres.add(alquila);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return alquileres;
    }
    public ArrayList<Tienda>CargarDatosTiendadeunClienteXML(String rutaArchivo,String dncliente){
        ArrayList <Tienda> tiendadelcliente = new ArrayList<>();
        
        
        return tiendadelcliente;
        
    }
    public void agregarTienda(String idTienda, String nombre, String direccion , ArrayList<Cliente>clientesagregados) {
        Tienda tienda = new Tienda(idTienda, nombre, direccion,clientesagregados);
        this.tiendas.add(tienda);

    }

    // TODO TERMINAR EL AGREGAR CLIENTES CON EL ARRAY LIST 
    public void agregarCliente(String Dni, String Nombre, String Telf, ArrayList<Alquila> alquileres,ArrayList<Tienda>tiendasagregadas) {
        Cliente clientenuevo = new Cliente(Dni, Nombre, Telf, alquileres,tiendasagregadas);
        this.clientes.add(clientenuevo);
    }

//   public boolean eliminarTienda(String idTienda) {
//        Tienda tienda = encontrarTiendaPorId(idTienda);
//       if (tienda != null) {
//            tiendas.remove(tienda);
//           return true;
//       }
//        return false;
//    }
    public Tienda encontrarTiendaPorId(String idTienda) {
        for (Tienda tienda : tiendas) {
            if (tienda.getId_tienda().equals(idTienda)) {
                return tienda;
            }
        }
        return null;
    }

    public List<Tienda> obtenerTodasLasTiendas() {
        return new ArrayList<>(tiendas);
    }
    public List<Pelicula>obtenerTodasLasPeliculas(){
        return new ArrayList<>(peliculas);
    }
    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes);
    }

    public List<Cinta> obtenerTodasLasCintas() {
        return new ArrayList<>(cintas);
    }

    public void agregarCinta(String codCinta, String formato, Pelicula peliculaAlmacenada) {
        System.out.println("agregando la cinta y ahora tiene " + this.cintas.size());
        Cinta cinta_nueva = new Cinta(codCinta, formato, peliculaAlmacenada);
        this.cintas.add(cinta_nueva);
        System.out.println("agregando la cinta y ahora tiene " + this.cintas.size());

    }
    public void agregarPelicula(String cod_peli ,String titulo , String Genero ,String fecha ,Cinta cinta_donde_se_almacena  ){
        Pelicula nueva_peli = new Pelicula(cod_peli, titulo, Genero, fecha, cinta_donde_se_almacena);
        this.peliculas.add(nueva_peli);
         System.out.println("agregando la peli y ahora tiene " + this.peliculas.size());
    }
}

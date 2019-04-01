package corto2;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Control {

    ArrayList<Alumno> alumnoList = new ArrayList<>();
    Alumno alumSelect = new Alumno();
    DefaultListModel modeloLista = new DefaultListModel();

    public void Agregar(String nombre, String apellido, Integer grado) {
        alumSelect.setNombre(nombre);
        alumSelect.setApellido(apellido);
        alumSelect.setCarnet(generadorCarne(nombre, apellido));
        alumSelect.setGrado(grado);
        alumnoList.add(alumSelect);
        modeloLista.addElement(alumSelect.nombre + " " + alumSelect.apellido + " " + alumSelect.carnet + " " + alumSelect.grado);
        alumSelect = new Alumno();
    }

    public String generadorCarne(String nombre, String apellido) {
        String unir;
        StringBuilder sb = new StringBuilder();
        char nom = nombre.charAt(0);
        char ape = apellido.charAt(0);
        sb.append(nom);
        sb.append(ape);
        String anio = JOptionPane.showInputDialog(null, "Ingrese el año de ingreso ");
        alumSelect.setIngreso(Integer.parseInt(anio));
        char a = anio.charAt(2);
        char b = anio.charAt(3);
        sb.append(a);
        sb.append(b);
        sb.append("0");
        Random miAleatorio = new Random();
        int numero = miAleatorio.nextInt(100);
        if (numero < 10) {
            sb.append("0");
            sb.append(numero);
        } else {
            sb.append(numero);
        }
        unir = sb.toString().toUpperCase();
        return unir;
    }

    public DefaultListModel getModeloLista() {
        return modeloLista;
    }

}

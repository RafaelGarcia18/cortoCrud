package corto2;

import java.util.ArrayList;
import java.util.Random;
import javax.annotation.PostConstruct;
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
        alumSelect = new Alumno();
        modeloLista(alumnoList);
    }

    public void init() {
        modeloLista(alumnoList);
    }

    public void modeloLista(ArrayList<Alumno> lista) {
        modeloLista.removeAllElements();
        for (Alumno alumno : lista) {
            modeloLista.addElement(alumno.nombre + " " + alumno.apellido + " " + alumno.grado + " " + alumno.carnet + " " + alumno.ingreso);
        }
    }

    public Alumno buscar(String carnet) {
        for (Alumno alumno : alumnoList) {
            if (alumno.carnet.equals(carnet.toUpperCase())) {
                return alumno;
            }
        }
        return null;
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

    void modeloLista(Alumno busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

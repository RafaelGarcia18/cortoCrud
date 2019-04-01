package corto2;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Control {

    ArrayList<Alumno> lumnoList;
    Alumno alumSelect = new Alumno();

    private void Agregar(String nombre, String Apellido, String carnet) {
        alumSelect.setNombre(nombre);
        alumSelect.setApellido(Apellido);
        alumSelect.setCarnet(carnet);
    }

    public String generadorCarne(String nombre, String apellido) {
        String unir;
        StringBuilder sb = new StringBuilder();
        char nom = nombre.charAt(0);
        char ape = apellido.charAt(0);
        sb.append(nom);
        sb.append(ape);
        String anio = JOptionPane.showInputDialog(null, "Ingrese el año de ingreso ");
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
        unir = sb.toString();
        System.out.println("uni " + unir);
        return unir;

    }
}

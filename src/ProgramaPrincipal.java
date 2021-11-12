/*
Desarrolla, utilizando CardLayout como base y el resto de layouts como accesorios, un simulador de registro que incluya 5 pestañas (piensa en el típico interfaz de instalación de un programa de Windows para diseñarlo), a saber:

1.- Pestaña de bienvenida con las instrucciones para rellenar el formulario
2.- Pestaña para introducir nombre, email (que debe comprobar que es válido) y contraseña (entre 8 y 16 caracteres,
al menos un dígito, al menos una mayúscula, al menos una minúscula y al menos un caracter que no sea letra ni número)
3.- Pestaña con selector de 2 países (España y EEUU) y provincias/estados que se deben cargar de un fichero txt
previamente incorporado al proyecto
4.- Pestaña con el resultado final con todos los datos, un JCheckbox que permita volcar los datos a un archivo de texto
después de seleccionar la ruta (con JFileChooser) y el botón de finalizar
5.- Pestaña de registro completado, resultado de la grabación del fichero y botón de salir
6.- El formulario debe incluir un logo y un degradado personalizado.
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramaPrincipal extends JFrame implements ActionListener {

    public ProgramaPrincipal(){

        initPantalla();
        initBorderLayout();
        initTarjeta1();
        initTarjeta2();
        initTarjeta3();
        initTarjeta4();
        initTarjeta5();

    }

    //Método inicial para definir como se verá la pantalla (tamaño, diseño,...)
    private void initPantalla() {

        setLayout(null);
        setTitle("Práctica Layouts");
        setSize(1750, 825);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void initBorderLayout() {

    }

    private void initTarjeta1() {

    }

    private void initTarjeta2() {

    }

    private void initTarjeta3() {

    }

    private void initTarjeta4() {

    }

    private void initTarjeta5() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ProgramaPrincipal();
    }

}
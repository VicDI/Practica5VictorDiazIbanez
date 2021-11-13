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
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class ProgramaPrincipal extends JFrame implements ActionListener {

    //Atributos
    BorderLayout borderl;
    JPanel panel1, panel2, panel3, panel4, panel5;
    JButton botonatras, botonsiguiente, botoncancelar, comprobar;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    CardLayout carta = new CardLayout();
    JTextField nombre, correo, contrasena;

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

    //Método que proporciona un esquema más complejo de colocación de los componentes en un panel
    private void initBorderLayout() {

        // creo y coloco los botones
        borderl = new BorderLayout(3,3);
        setLayout(borderl);
        panel1 = new JPanel();
        add(panel1, WEST);
        panel1.setBackground(Color.white);
        ImageIcon imagenFondo = new ImageIcon(new ImageIcon("src/imagenFondo.jpg").getImage().getScaledInstance(130,120,Image.SCALE_DEFAULT));
        JLabel label = new JLabel("", imagenFondo, JLabel.CENTER);
        panel1.add(label,WEST);

        panel2 = new JPanel(new GridLayout(1,2));
        botonatras = new JButton("atras");
        botonatras.setFont(new Font("a",Font.ROMAN_BASELINE,30));
        botonatras.setBorder(new LineBorder(Color.black));
        add(panel2, SOUTH);
        panel2.add(botonatras);

        botonsiguiente = new JButton("siguiente");
        botonsiguiente.setFont(new Font("a",Font.ROMAN_BASELINE,30));
        botonsiguiente.setBorder(new LineBorder(Color.black));
        panel2.add(botonsiguiente);

        botoncancelar = new JButton("cancelar");
        botoncancelar.setFont(new Font("a",Font.ROMAN_BASELINE,30));
        botoncancelar.setBorder(new LineBorder(Color.black));
        panel2.add(botoncancelar);

        botonsiguiente.addActionListener(this);
        botonatras.addActionListener(this);
        botoncancelar.addActionListener(this);

        setVisible(true);
        validate();

    }

    //Método para crear los textos de la ventana o tarjeta 1
    private void initTarjeta1() {

        panel3 = new JPanel(carta);
        panel4 = new JPanel(null);
        panel4.setBackground(Color.CYAN);
        panel3.add(panel4);
        carta.show(panel3,"");
        add(panel3, CENTER);
        label1 = new JLabel("Bienvenido al formulario.");
        label1.setBounds(70, 100,400,100);
        label1.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel4.add(label1);
        label2 = new JLabel("Siga las siguientes instrucciones.");
        label2.setBounds(70, 150,550,100);
        label2.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel4.add(label2);
        label3 = new JLabel("La contraseña debe tener: 8-16 caracteres.");
        label3.setBounds(70, 200,550,100);
        label3.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel4.add(label3);
        label4 = new JLabel("La contraseña debe tener: Al menos una mayúscula y una minúscula.");
        label4.setBounds(70, 250,850,100);
        label4.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel4.add(label4);
        label5 = new JLabel("La contraseña debe tener: Al menos un caracter que no sea letra ni número.");
        label5.setBounds(70, 300,900,100);
        label5.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel4.add(label5);
        label6 = new JLabel("El correo debe ser válido.");
        label6.setBounds(70, 350,750,100);
        label6.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel4.add(label6);

    }

    //Método para crear los textos de la ventana o tarjeta 1
    private void initTarjeta2() {

        panel5 = new JPanel(null);
        panel5.setBackground(Color.CYAN);
        panel3.add(panel5);
        add(panel3, CENTER);

        label7 = new JLabel("NOMBRE:");
        label7.setBounds(70, 110,900,100);
        label7.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel5.add(label7);
        label8 = new JLabel("CORREO:");
        label8.setBounds(70, 190,900,100);
        label8.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel5.add(label8);
        label9 = new JLabel("CONTRASEÑA:");
        label9.setBounds(70, 270,900,100);
        label9.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel5.add(label9);

        nombre = new JTextField();
        nombre.setBounds(220, 120,450,60);
        nombre.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel5.add(nombre);

        correo = new JTextField();
        correo.setBounds(220, 200,450,60);
        correo.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel5.add(correo);

        contrasena = new JTextField();
        contrasena.setBounds(275, 280,450,60);
        contrasena.setFont(new Font("", Font.ROMAN_BASELINE,26));
        panel5.add(contrasena);

        comprobar = new JButton("Comprobar");
        comprobar.setBounds(100, 400, 180, 60);
        comprobar.setFont(new Font("a",Font.ROMAN_BASELINE,30));
        comprobar.setBorder(new LineBorder(Color.black));
        comprobar.addActionListener(this);
        panel5.add(comprobar);


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
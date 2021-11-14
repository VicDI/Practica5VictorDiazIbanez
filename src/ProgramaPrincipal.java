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
import java.io.*;

import static java.awt.BorderLayout.*;

public class ProgramaPrincipal extends JFrame implements ActionListener {

    //Atributos
    BorderLayout borderl;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
    JButton botonatras, botonsiguiente, botoncancelar, comprobar, generar, botonfinalizar;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
    CardLayout carta = new CardLayout();
    JTextField nombre, correo, contrasena;
    JComboBox pais, provincias;
    JTextArea resultado;
    JCheckBox guardar;
    File x;
    String texto;
    boolean email = false;
    boolean nombr = false;

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
        ImageIcon imagenFondo = new ImageIcon(new ImageIcon("src/amazon.jpg").getImage().getScaledInstance(130,120,Image.SCALE_DEFAULT));
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

    //Método para crear los textos de la ventana o tarjeta 2
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

    //Método para crear los textos de la ventana o tarjeta 3
    private void initTarjeta3() {

        //Creación los combobox de la tarjeta o ventana 3
        panel6 = new JPanel(null);
        panel6.setBackground(Color.CYAN);
        panel3.add(panel6);
        add(panel3, CENTER);

        pais = new JComboBox<>();
        pais.setBounds(70,315,180,60);
        pais.setFont(new Font("",Font.ROMAN_BASELINE,26));
        pais.addItem("España");
        pais.addItem("EEUU");
        panel6.add(pais);
        pais.addActionListener(this);
        pais.setSelectedItem(null);
        provincias = new JComboBox<>();
        provincias.setBounds(70,455,180,60);
        provincias.setFont(new Font("",Font.ROMAN_BASELINE,26));
        panel6.add(provincias);

        generar = new JButton("Generar");
        generar.setBounds(400, 315, 180, 60);
        generar.setFont(new Font("a",Font.ROMAN_BASELINE,30));
        generar.setBorder(new LineBorder(Color.black));
        generar.addActionListener(this);
        panel6.add(generar);

    }

    //Método para crear los textos de la ventana o tarjeta 4
    private void initTarjeta4() {

        //me muestra la informacion y me permite guardarla en mi dispositivo
        panel7 = new JPanel(null);
        panel7.setBackground(Color.CYAN);
        panel3.add(panel7);
        add(panel3, CENTER);
        resultado = new JTextArea();
        resultado.setBounds(65,225,1130,600);
        resultado.setBorder(new LineBorder(Color.black));
        panel7.add(resultado);
        label10 = new JLabel("Datos recogidos");


        guardar =  new JCheckBox("Guardar");
        guardar.setBounds(65,40,100,50);
        guardar.addActionListener(this);
        panel7.add(guardar);

    }

    //Método para crear los textos de la ventana o tarjeta 4
    private void initTarjeta5() {

        //Dos label para indicar que has acabado y las instrucciones para salir
        panel8 = new JPanel(null);
        panel8.setBackground(Color.CYAN);

        panel3.add(panel8);
        add(panel3, CENTER);

        label11 = new JLabel("Has finalizado el formulario.");
        label11.setBounds(70, 350,750,100);
        label11.setFont(new Font("", Font.ROMAN_BASELINE,45));
        panel8.add(label11);
        label12 = new JLabel("Dale a finalizar para salir");
        label12.setBounds(70, 550,750,100);
        label12.setFont(new Font("", Font.ROMAN_BASELINE,45));
        panel8.add(label12);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==botonsiguiente){
            //cambio de ventana o de tarjeta si pulsa siguiente
            carta.next(panel3);

            if(panel8.isShowing()){
                panel2.remove(botonsiguiente);
                botonfinalizar = new JButton("finalizar");
                botonfinalizar.setFont(new Font("a",Font.ROMAN_BASELINE,18));
                botonfinalizar.setBorder(new LineBorder(Color.black));
                botonfinalizar.addActionListener(this);
                panel2.add(botonfinalizar);
            }

        }
        else if(e.getSource()==botonatras){
            carta.previous(panel3);
        }
        //hago que salga si pulsa cancelar
        else if(e.getSource()==botoncancelar){
            System.exit(0);
        }
        //hago que salga si pulsa finalizar
        else if(e.getSource()==botonfinalizar){
            System.exit(0);
        }
        if(e.getSource()==pais){
            //si pincho en españa que salgan las provincias del .txt y si es en eeuu que salga sus estados de su .txt
            if (pais.getSelectedItem()=="España"){
                provincias.removeAllItems();//para que no se concatenen
                try{
                    File archivo1 = new File("src/espana.txt");
                    FileReader leer = new FileReader(archivo1);
                    BufferedReader leer1 = new BufferedReader(leer);
                    String linea = leer1.readLine();
                    while (linea!=null){
                        provincias.addItem(linea);
                        linea= leer1.readLine();
                    }
                }catch(Exception es){
                    System.out.println("error");
                }


            }
            else if(e.getSource()==pais) {
                if (pais.getSelectedItem() == "EEUU") {
                    provincias.removeAllItems();//para que no se concatenen
                    try {
                        File archivo1 = new File("src/EEUU.txt");
                        FileReader leer = new FileReader(archivo1);
                        BufferedReader leer1 = new BufferedReader(leer);
                        String linea = leer1.readLine();
                        while (linea != null) {
                            provincias.addItem(linea);
                            linea = leer1.readLine();
                        }
                    } catch (Exception es) {
                        System.out.println("error");
                    }


                }
            }

        }

        if (e.getSource() == guardar){
            //guardo el resultado
            x = null;

            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int resultado1 = fc.showOpenDialog( null);

            if (resultado1 == JFileChooser.APPROVE_OPTION){
                x = fc.getSelectedFile();

            }
            File fichero = new File(x, "Datos.txt");

            try (FileWriter fw = new FileWriter(fichero)) {
                fw.write(texto);
                fw.flush();

            } catch (IOException ioException) {
                ioException.printStackTrace();

            }
        }

        if (e.getSource()== comprobar){
            String textoc = contrasena.getText();
            int longitud = 0;
            int contador = 0;
            int contadorm = 0;
            int simbolos = 0;
            int contmy = 0;
            if (!nombre.getText().equals("")){
                nombr = true;
            }else{
                JOptionPane.showMessageDialog(null, "El nombre debe tener al menos un caracter");
            }
            if(!correo.getText().equals("")){
                if(correo.getText().contains("@")){
                    email = true;
                }

            }else{
                JOptionPane.showMessageDialog(null, "El correo debe tenr un @");
            }if(!contrasena.getText().equals("")){
                for (int i = 0; i < contrasena.getText().length(); i++){ //Fuente: https://es.stackoverflow.com/questions/309558/c%c3%b3mo-validar-caracteres-especiales-en-java

                    if ((textoc.charAt(i) >= 47 && textoc.charAt(i) <= 58)//numeros
                            || (textoc.charAt(i) >= 64 && textoc.charAt(i) <= 91)//mayusculas
                            || (textoc.charAt(i) >= 32 && textoc.charAt(i) <= 44)//signos
                            || (textoc.charAt(i) >= 97 && textoc.charAt(i) <= 122) ){//minusculas

                    }

                    if (textoc.charAt(i) >= 47 && textoc.charAt(i) <= 58){// Cuenta la cantidad de numeros
                        contador++;
                    }

                    if ((textoc.charAt(i) > 32 && textoc.charAt(i) < 44)) { // Cuenta la cantidad signos
                        simbolos++;
                    }

                    if (textoc.charAt(i) >= 64 && textoc.charAt(i) <= 91){// Cuenta la cantidad de mayusculas
                        contmy++;
                    }
                    if (textoc.charAt(i) >= 97 && textoc.charAt(i) <= 122){// Cuenta la cantidad de minusculas
                        contadorm++;
                    }

                    longitud = (i + 1);// Cuenta la longitud del password

                }
                if (contador < 1 || contmy < 1 || (longitud < 8 || longitud >16) || contadorm < 1 || simbolos < 1 ){

                    contrasena.setBorder(new LineBorder(Color.RED));
                    if (contador < 1){// Revisa que el password contenga minimo 1 numero
                        JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos un numero");

                    }
                    if (contmy < 1){// Revisa que el password contenga minimo 1 mayuscula
                        JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos una mayúscula");

                    }
                    if (longitud < 8 || longitud >16){//Revisa que la contraseña tenga entre 8 y 16 caracteres
                        JOptionPane.showMessageDialog(null, "La contraseña debe tener entre 8 y 16 caracteres");

                    }
                    if (contadorm < 1){// Revisa que el password contenga minimo 1 minuscula
                        JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos una minuscula");

                    }

                    if (simbolos < 1){// Revisa que el password contenga minimo 1 signo
                        JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos uno de estos caracteres especiales: ( ! # $ % & ' ( ) + - )");

                    }


                }
            }
        }

        if (e.getSource() == generar){
            if (pais.getSelectedItem() == null || provincias.getSelectedItem() == null){
                JOptionPane.showMessageDialog(null, "Uno o mas campos estan sin rellenar");
            }else{
                carta.next(panel3);
                texto = "";
                texto += "Nombre: " + nombre.getText();
                texto+= System.lineSeparator() + "Contraseña: " + contrasena.getText();
                texto+= System.lineSeparator() + "Email: " + correo.getText();
                texto+= System.lineSeparator() + "Pais : " + pais.getSelectedItem();
                texto+= System.lineSeparator() + "Estado/Provincia : " + provincias.getSelectedItem();

                resultado.setText(texto);

            }
        }

    }

    public static void main(String[] args) {
        new ProgramaPrincipal();
    }

}
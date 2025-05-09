import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CalculadoraGUI extends JFrame {
    private JTextField pantalla;
    private double numeroActual = 0;
    private String operacionPendiente = "";
    private boolean iniciarNuevoNumero = true;
    private ArrayList<Double> valoresMultiples = new ArrayList<>();

    public CalculadoraGUI() {
        setTitle("Calculadora Científica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // Panel de pantalla
        pantalla = new JTextField("0");
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        add(pantalla, BorderLayout.NORTH);

        // Panel principal de botones
        JPanel panelBotones = new JPanel(new GridLayout(7, 4, 2, 2));
        String[] botones = {
            "%", "CE", "C", "⌫",
            "xⁿ", "x²", "x³", "÷",
            "ⁿ√x", "²√x", "³√x", "×",
            "n!",
            "7", "8", "9", "-",
            "4", "5", "6", "+",
            "1", "2", "3", "=",
            "±", "0", ".", "="
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 14));
            if (texto.matches("[0-9.]")) {
                boton.setBackground(Color.WHITE);
            } else if (texto.equals("=")) {
                boton.setBackground(new Color(255, 149, 117));
                boton.setForeground(Color.WHITE);
            } else {
                boton.setBackground(new Color(240, 240, 240));
            }
            boton.addActionListener(new BotonClickListener());
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER);

        // Configuración de la ventana
        setSize(320, 500);
        setLocationRelativeTo(null);
    }

    private class BotonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            
            try {
                if (comando.matches("[0-9.]")) {
                    if (iniciarNuevoNumero) {
                        pantalla.setText(comando);
                        iniciarNuevoNumero = false;
                    } else {
                        pantalla.setText(pantalla.getText() + comando);
                    }
                } else {
                    procesarOperacion(comando);
                }
            } catch (Exception ex) {
                pantalla.setText("Error");
                iniciarNuevoNumero = true;
            }
        }
    }

    private void procesarOperacion(String operacion) {
        try {
            double valor;
            double resultado;
            
            switch (operacion) {
                case "C":
                    pantalla.setText("0");
                    iniciarNuevoNumero = true;
                    operacionPendiente = "";
                    valoresMultiples.clear();
                    break;
                    
                case "CE":
                    pantalla.setText("0");
                    iniciarNuevoNumero = true;
                    break;
                    
                case "⌫":
                    String texto = pantalla.getText();
                    if (texto.length() > 1) {
                        pantalla.setText(texto.substring(0, texto.length() - 1));
                    } else {
                        pantalla.setText("0");
                        iniciarNuevoNumero = true;
                    }
                    break;
                    
                case "±":
                    valor = Double.parseDouble(pantalla.getText());
                    pantalla.setText(String.valueOf(-valor));
                    break;
                    
                case "x²":
                    valor = Double.parseDouble(pantalla.getText());
                    resultado = OperacionesCalculadora.potencia(valor, 2);
                    pantalla.setText(String.valueOf(resultado));
                    iniciarNuevoNumero = true;
                    break;
                    
                case "x³":
                    valor = Double.parseDouble(pantalla.getText());
                    resultado = OperacionesCalculadora.potencia(valor, 3);
                    pantalla.setText(String.valueOf(resultado));
                    iniciarNuevoNumero = true;
                    break;
                    
                case "xⁿ":
                    numeroActual = Double.parseDouble(pantalla.getText());
                    operacionPendiente = "potencia";
                    iniciarNuevoNumero = true;
                    break;
                    
                case "²√x":
                    valor = Double.parseDouble(pantalla.getText());
                    resultado = OperacionesCalculadora.raizCuadrada(valor);
                    pantalla.setText(String.valueOf(resultado));
                    iniciarNuevoNumero = true;
                    break;
                    
                case "³√x":
                    valor = Double.parseDouble(pantalla.getText());
                    resultado = Math.cbrt(valor);
                    pantalla.setText(String.valueOf(resultado));
                    iniciarNuevoNumero = true;
                    break;
                    
                case "ⁿ√x":
                    numeroActual = Double.parseDouble(pantalla.getText());
                    operacionPendiente = "raiz";
                    iniciarNuevoNumero = true;
                    break;
                    
                case "+":
                case "-":
                case "×":
                case "÷":
                    calcularOperacionPendiente();
                    numeroActual = Double.parseDouble(pantalla.getText());
                    operacionPendiente = operacion;
                    iniciarNuevoNumero = true;
                    break;
                case "n!":
                    try {
                     int numero = Integer.parseInt(pantalla.getText());
                     int resultado = factorial(numero);
                      pantalla.setText(String.valueOf(resultado));
                   } catch (NumberFormatException e) {
                  pantalla.setText("Error: Ingrese entero");
                 } catch (ArithmeticException e) {
                 pantalla.setText("Error: " + e.getMessage());
                 }
                 iniciarNuevoNumero = true;
                 break;
                 
                case "=":
                    calcularOperacionPendiente();
                    operacionPendiente = "";
                    iniciarNuevoNumero = true;
                    break;
            }
        } catch (ArithmeticException ex) {
            pantalla.setText("Error: " + ex.getMessage());
            iniciarNuevoNumero = true;
        } catch (Exception ex) {
            pantalla.setText("Error");
            iniciarNuevoNumero = true;
        }
    }

    private void calcularOperacionPendiente() {
        if (!operacionPendiente.isEmpty()) {
            double segundoNumero = Double.parseDouble(pantalla.getText());
            double resultado = 0;
            
            switch (operacionPendiente) {
                case "+":
                    ArrayList<Double> sumandos = new ArrayList<>();
                    sumandos.add(numeroActual);
                    sumandos.add(segundoNumero);
                    resultado = OperacionesCalculadora.suma(sumandos);
                    break;
                case "-":
                    ArrayList<Double> restandos = new ArrayList<>();
                    restandos.add(numeroActual);
                    restandos.add(segundoNumero);
                    resultado = OperacionesCalculadora.resta(restandos);
                    break;
                case "×":
                    ArrayList<Double> factores = new ArrayList<>();
                    factores.add(numeroActual);
                    factores.add(segundoNumero);
                    resultado = OperacionesCalculadora.multiplicacion(factores);
                    break;
                case "÷":
                    resultado = OperacionesCalculadora.division(numeroActual, segundoNumero);
                    break;
                case "potencia":
                    resultado = OperacionesCalculadora.potencia(numeroActual, segundoNumero);
                    break;
                case "raiz":
                    resultado = Math.pow(numeroActual, 1.0/segundoNumero);
                    break;
            }
            
            pantalla.setText(String.valueOf(resultado));
            numeroActual = resultado;
        }
    }
}
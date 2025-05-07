import java.util.Scanner;
import java.util.ArrayList;

public class CalculadoraF
{
    
    /**
     * metodo args inicia todo 
     * llama el meno y usa todos los metodos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch(opcion) {
                case 1: // Suma múltiple
                    operacionMultiple("suma");
                    break;

                case 2: // Resta múltiple
                    operacionMultiple("resta");
                    break;

                case 3: // Multiplicación múltiple
                    operacionMultiple("multiplicacion");
                    break;

                case 4: // División (solo 2 valores)
                    System.out.println("Ingrese dos números (dividendo y divisor):");
                    double num1 = scanner.nextDouble();
                    double num2 = scanner.nextDouble();
                    double resultado = division(num1, num2);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 5: // Potencia (2 valores)
                    System.out.println("Ingrese base y exponente:");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    resultado = potencia(num1, num2);
                    System.out.println("Resultado: " + resultado);
                    break;
                case 6: // Raíz cuadrada (1 valor)
                    System.out.println("Ingrese un número:");
                    num1 = scanner.nextDouble();
                    resultado = raizCuadrada(num1);
                    System.out.println("Resultado: " + resultado);
                    break;

            }
        } while(opcion != 0);
        scanner.close();
    }

    /**
     * Menu de calculadora 
     * para aumentar funciones hay que añadir el
     * case de switch,el nombre de la funion en el menu y el metodo
     */

    public static void mostrarMenu() {
        System.out.println("\nCALCULADORA CIENTÍFICA AVANZADA");
        System.out.println("1. Suma (múltiples valores)");
        System.out.println("2. Resta (múltiples valores)");
        System.out.println("3. Multiplicación (múltiples valores)");
        System.out.println("4. División (2 valores)");
        System.out.println("5. Potencia (2 valores)");
        System.out.println("6. Raíz cuadrada (1 valor)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
   /**
    * funcion para sumar, restar , multiplicar varios calores
    * se cambio el tipo de varias funciones para mas felxibilidad con la
    * libreria math
    */
    public static void operacionMultiple(String tipo) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> valores = new ArrayList<>();

        System.out.println("Ingrese los valores (escriba 'fin' para terminar):");

        while(true) {
            System.out.print("Valor " + (valores.size() + 1) + ": ");
            if(sc.hasNextDouble()) {
                valores.add(sc.nextDouble());
            } else {
                String input = sc.next();
                if(input.equalsIgnoreCase("fin")) {
                    break;
                } else {
                    System.out.println("Entrada no válida. Ingrese un número o 'fin' para terminar.");
                }
            }
        }

        if(valores.size() < 1) {
            System.out.println("No se ingresaron valores válidos.");
            return;
        }

        double resultado = 0;

        switch(tipo) {
            case "suma":
                resultado = suma(valores);
                System.out.println("Suma total: " + resultado);
                break;

            case "resta":
                resultado = resta(valores);
                System.out.println("Resta total: " + resultado);
                break;

            case "multiplicacion":
                resultado = multiplicacion(valores);
                System.out.println("Producto total: " + resultado);
                break;

        }
    }

    public static double suma(ArrayList<Double> valores) {
        double suma = 0;
        for(double valor : valores) {
            suma += valor;
        }
        return suma;
    }

    public static double resta(ArrayList<Double> valores) {
        if(valores.size() == 0) return 0;
        double resta = valores.get(0);
        for(int i = 1; i < valores.size(); i++) {
            resta -= valores.get(i);
        }
        return resta;
    }

    public static double multiplicacion(ArrayList<Double> valores) {
        if(valores.size() == 0) return 0;
        double producto = 1;
        for(double valor : valores) {
            producto *= valor;
        }
        return producto;
    }

    public static double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;
    }

    public static double potencia(double a, double b) {
        return (int) Math.pow(a, b);
    }

    public static double raizCuadrada(double a) {
        if (a < 0) {
            throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
        }
        return (int) Math.sqrt(a);
    }
}

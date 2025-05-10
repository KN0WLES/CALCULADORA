import java.util.Scanner;
import java.util.ArrayList;

public class CalculadoraF
{
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

                case 4: // División
                    System.out.println("Ingrese dos números (dividendo y divisor):");
                    double num1 = scanner.nextDouble();
                    double num2 = scanner.nextDouble();
                    double resultado = division(num1, num2);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 5: // Potencia
                    System.out.println("Ingrese base y exponente:");
                    num1 = scanner.nextDouble();
                    num2 = scanner.nextDouble();
                    resultado = potencia(num1, num2);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 6: // Raíz cuadrada
                    System.out.println("Ingrese un número:");
                    num1 = scanner.nextDouble();
                    resultado = raizCuadrada(num1);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 7: // Derivación
                    scanner.nextLine(); // Consumir salto de línea
                    System.out.println("Ingrese una función polinómica (ej: 3x^2 + 2x + 1):");
                    String funcion = scanner.nextLine();
                    String derivada = derivarFuncion(funcion);
                    System.out.println("Derivada: " + derivada);
                    break;

                case 8: // Fórmulas Físicas
                    mostrarFormulasFisicas();
                    break;
            }
        } while(opcion != 0);
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nCALCULADORA CIENTÍFICA AVANZADA");
        System.out.println("1. Suma (múltiples valores)");
        System.out.println("2. Resta (múltiples valores)");
        System.out.println("3. Multiplicación (múltiples valores)");
        System.out.println("4. División (2 valores)");
        System.out.println("5. Potencia (2 valores)");
        System.out.println("6. Raíz cuadrada (1 valor)");
        System.out.println("7. Derivar función polinómica (ej: 3x^2 + 2x + 1)");
        System.out.println("8. Fórmulas Físicas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

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

    public static String derivarFuncion(String funcion) {
        String[] terminos = funcion.replaceAll("-", "+-").split("\\+");
        StringBuilder derivada = new StringBuilder();

        for (String termino : terminos) {
            termino = termino.trim();
            if (termino.isEmpty()) continue;

            if (termino.contains("x^")) {
                String[] partes = termino.split("x\\^");
                double coef = partes[0].isEmpty() || partes[0].equals("+") ? 1 :
                              partes[0].equals("-") ? -1 : Double.parseDouble(partes[0]);
                int exponente = Integer.parseInt(partes[1]);
                double nuevoCoef = coef * exponente;
                int nuevoExponente = exponente - 1;

                derivada.append((nuevoCoef >= 0 && derivada.length() > 0 ? "+" : ""))
                        .append(nuevoCoef);
                if (nuevoExponente > 1)
                    derivada.append("x^").append(nuevoExponente);
                else if (nuevoExponente == 1)
                    derivada.append("x");

            } else if (termino.contains("x")) {
                String coefStr = termino.replace("x", "");
                double coef = coefStr.isEmpty() || coefStr.equals("+") ? 1 :
                              coefStr.equals("-") ? -1 : Double.parseDouble(coefStr);
                derivada.append((coef >= 0 && derivada.length() > 0 ? "+" : "")).append(coef);
            }
        }

        return derivada.length() == 0 ? "0" : derivada.toString();
    }

    public static void mostrarFormulasFisicas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFORMULAS FÍSICAS:");
        System.out.println("1. Movimiento Rectilíneo Uniforme (MRU)");

        System.out.print("Seleccione una fórmula para ver: ");
        int seleccion = scanner.nextInt();

        switch(seleccion) {
            case 1:
                System.out.println("Fórmula del MRU (Movimiento Rectilíneo Uniforme):");
                System.out.println("v = d / t");
                System.out.println("d = v * t");
                System.out.println("t = d / v");
                System.out.println("Donde:");
                System.out.println("v = velocidad (m/s)");
                System.out.println("d = distancia (m)");
                System.out.println("t = tiempo (s)");
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
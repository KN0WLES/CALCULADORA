import java.util.ArrayList;

public class OperacionesCalculadora {
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

    public static double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public static double raizCuadrada(double numero) {
        if (numero < 0) {
            throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
        }
        return Math.sqrt(numero);
    }
}
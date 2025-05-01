public class CALCULADORA {
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 5;
        int b = 3;
        int suma = a + b;
        System.out.println("La suma de " + a + " y " + b + " es: " + suma);
    }
    public static int suma(int a, int b) {
        return a + b;
    }
    public static int resta(int a, int b) {
        return a - b;
    }
    public static int multiplicacion(int a, int b) {
        return a * b;
    }
    public static int division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;
    }
    public static int potencia(int a, int b) {
        return (int) Math.pow(a, b);
    }
    public static int raizCuadrada(int a) {
        if (a < 0) {
            throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
        }
        return (int) Math.sqrt(a);
    }
}

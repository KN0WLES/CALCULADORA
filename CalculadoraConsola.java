import java.util.Scanner;
import java.util.ArrayList;

public class CalculadoraConsola {
    private Scanner scanner;

    public CalculadoraConsola() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            procesarOpcion(opcion);
        } while(opcion != 0);
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\nCALCULADORA CIENTÍFICA AVANZADA");
        System.out.println("1. Suma (múltiples valores)");
        System.out.println("2. Resta (múltiples valores)");
        System.out.println("3. Multiplicación (múltiples valores)");
        System.out.println("4. División (2 valores)");
        System.out.println("5. Potencia (2 valores)");
        System.out.println("6. Raíz cuadrada (1 valor)");
        System.out.println("7. Factorial (n!)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void procesarOpcion(int opcion) {
        try {
            switch(opcion) {
                case 1: operacionMultiple("suma"); break;
                case 2: operacionMultiple("resta"); break;
                case 3: operacionMultiple("multiplicacion"); break;
                case 4: operacionDivision(); break;
                case 5: operacionPotencia(); break;
                case 6: operacionRaiz(); break;
                case 7: operacionFactorial(); break;
                case 0: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida");
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void operacionMultiple(String tipo) {
        ArrayList<Double> valores = new ArrayList<>();
        System.out.println("Ingrese los valores (escriba 'fin' para terminar):");

        while(true) {
            System.out.print("Valor " + (valores.size() + 1) + ": ");
            if(scanner.hasNextDouble()) {
                valores.add(scanner.nextDouble());
            } else {
                String input = scanner.next();
                if(input.equalsIgnoreCase("fin")) break;
                System.out.println("Entrada no válida. Ingrese un número o 'fin' para terminar.");
            }
        }

        if(valores.size() < 1) {
            System.out.println("No se ingresaron valores válidos.");
            return;
        }

        double resultado = 0;
        switch(tipo) {
            case "suma":
                resultado = OperacionesCalculadora.suma(valores);
                System.out.println("Suma total: " + resultado);
                break;
            case "resta":
                resultado = OperacionesCalculadora.resta(valores);
                System.out.println("Resta total: " + resultado);
                break;
            case "multiplicacion":
                resultado = OperacionesCalculadora.multiplicacion(valores);
                System.out.println("Producto total: " + resultado);
                break;
        }
    }

    private void operacionDivision() {
        System.out.println("Ingrese dos números (dividendo y divisor):");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double resultado = OperacionesCalculadora.division(num1, num2);
        System.out.println("Resultado: " + resultado);
    }

    private void operacionPotencia() {
        System.out.println("Ingrese base y exponente:");
        double base = scanner.nextDouble();
        double exponente = scanner.nextDouble();
        double resultado = OperacionesCalculadora.potencia(base, exponente);
        System.out.println("Resultado: " + resultado);
    }

    private void operacionRaiz() {
        System.out.println("Ingrese un número:");
        double numero = scanner.nextDouble();
        double resultado = OperacionesCalculadora.raizCuadrada(numero);
        System.out.println("Resultado: " + resultado);

    }
    private void operacionFactorial(){
       System.out.println("ingrese un numero");
       int numero= scanner.nextInt();
        int resultado = factorial(numero);
        System.out.println("Resultado:"+resultado);

    }
    private int factorial(int n){
      int res;
      if (n==0)
          res=0;
      else
        res=n+factorial(n-1);  
     return res ;
    }
    

    
    
}
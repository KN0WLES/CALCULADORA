public class Main {
    public static void main(String[] args) {
        // Si se pasa el argumento "consola", inicia la versión de consola
        if (args.length > 0 && args[0].equals("consola")) {
            new CalculadoraConsola().iniciar();
        } else {
            // Por defecto, inicia la versión GUI
            javax.swing.SwingUtilities.invokeLater(() -> {
                new CalculadoraGUI().setVisible(true);
            });
        }
    }
}
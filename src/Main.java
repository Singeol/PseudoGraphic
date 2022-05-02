import java.util.Scanner;

public class Main {
    public void drawSymbolPlot(Calculator calculator, double bottomEdge, double topEdge, int stringCount) {
        double step = (topEdge - bottomEdge) / stringCount;
        double origin = 0;
        double[] ordinate = new double[stringCount + 1];
        for (int i = 0; i <= stringCount; ++i){
            double x = bottomEdge + i * step;
            double f = calculator.func(x);
            origin = Math.min(f, origin);
            ordinate[i] = (int) f;
        }
        for (double el: ordinate){
            for (int i = 0; i < el - origin; i++){
                System.out.print(' ');
            }
            System.out.println('*');
        }
    }


    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Main symbol = new Main();
        Scanner scanner = new Scanner(System.in);
        double bottomEdge = scanner.nextDouble();
        double topEdge = scanner.nextDouble();
        int stringCount = scanner.nextInt();
        symbol.drawSymbolPlot(calculator, bottomEdge, topEdge, stringCount);
    }
}

import java.util.Scanner;

public class Main {
    // Метод для рисования графика функции на экране
    // calculator - объект класса Calculator, содержащий функцию для вычисления значений
    // bottomEdge - нижняя граница графика
    // topEdge - верхняя граница графика
    // stringCount - количество строк для отображения графика
    public void drawSymbolPlot(Calculator calculator, double bottomEdge, double topEdge, int stringCount) {
        double step = (topEdge - bottomEdge) / stringCount; // вычисляем шаг между значениями аргумента функции
        double origin = 0; // начало координат графика
        double[] ordinate = new double[stringCount + 1]; // массив значений функции для каждого значения аргумента
        for (int i = 0; i <= stringCount; ++i){
            double x = bottomEdge + i * step; // вычисляем значение аргумента функции
            double f = calculator.func(x); // вычисляем значение функции для данного аргумента
            origin = Math.min(f, origin); // обновляем начало координат графика, если значение функции меньше текущего начала координат
            ordinate[i] = (int) f; // сохраняем значение функции в массив
        }
        for (double el: ordinate){ // проходим по массиву значений функции
            for (int i = 0; i < el - origin; i++){ // выводим пробелы для выравнивания графика по вертикали
                System.out.print(' ');
            }
            System.out.println('*'); // выводим символ * для обозначения точки на графике
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); // создаем объект класса Calculator, содержащий функцию для вычисления значений
        Main symbol = new Main(); // создаем объект класса Main, содержащий метод для рисования графика
        Scanner scanner = new Scanner(System.in); // создаем объект класса Scanner для считывания входных параметров
        double bottomEdge = scanner.nextDouble(); // считываем нижнюю границу графика
        double topEdge = scanner.nextDouble(); // считываем верхнюю границу графика
        int stringCount = scanner.nextInt(); // считываем количество строк для отображения графика
        symbol.drawSymbolPlot(calculator, bottomEdge, topEdge, stringCount); // вызываем метод для рисования графика
    }
}
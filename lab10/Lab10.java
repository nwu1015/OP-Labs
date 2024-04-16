@FunctionalInterface
interface MyFunction {
    double calculate(double a, double b, double c, double d);
}
public class Lab10 {
    public static void main(String[] args) {
        MyFunction task1 = (a, b, c, d) -> 3 * (Math.log(Math.abs(a / b)) + Math.sqrt(Math.cos(c) + Math.pow(Math.E, d)));
        calculateAndPrint(1, -2.54, 1.23, -2.14, -0.23, task1);

        MyFunction task2 = (a, b, c, d) -> 6 * (Math.pow(Math.sin(Math.abs(2 * a)), Math.log(b))) + Math.sqrt(c * Math.cosh(-d));
        calculateAndPrint(2, 1.478, 9.26, 0.68, 2.24, task2);

        MyFunction task3 = (a, b, c, d) -> Math.pow(2 * Math.sin(a) + Math.cos(b * Math.sqrt(c)), d);
        calculateAndPrint(3, 1.234, -3.12, 5.45, 2.0, task3);
    }

    public static void calculateAndPrint(int taskNumber, double a, double b, double c, double d, MyFunction function) {
        double result = function.calculate(a, b, c, d);
        System.out.println("Параметри: а = " + a + " b = " + b + " c = " + c + " d = " + d);
        System.out.println("Результат " + taskNumber + "-го завдання: " + result);
        System.out.println("\t\t\t Готово");
    }
}
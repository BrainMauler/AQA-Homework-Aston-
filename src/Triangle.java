public class Triangle implements Figure {
    private double side1;
    private double side2;
    private double side3;
    private String fillCol;
    private String bordCol;
    public Triangle(double side1, double side2, double side3, String fillCol, String bordCol) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillCol = fillCol;
        this.bordCol = bordCol;
    }
    @Override
    public  double per() {
        return side3 + side2 + side1;
    }
    @Override
    public double area() {
        double p = per() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
    public void info() {
        System.out.println("\nПериметр треугольника: " + per() + "\nПлощадь треугольника: " + area() +
                           "\nЦвет заливки: " + fillCol + "\nЦвет границы: " + bordCol);
    }
}

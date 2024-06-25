public class Circle implements Figure {
    private double rad;
    private String fillCol;
    private String bordCol;
    public Circle(double rad, String fillCol, String bordCol) {
        this.rad = rad;
        this.fillCol = fillCol;
        this.bordCol = bordCol;
    }
    @Override
    public double per() {
        return 2 * Math.PI * rad;
    }
    @Override
    public double area() {
        return Math.PI * rad * rad;
    }
    public void info() {
        System.out.println("\nПериметр круга: " + per() + "\nПлощадь круга: " + area() +
                           "\nЦвет заливки: " + fillCol + "\nЦвет границы: " + bordCol);
    }
}

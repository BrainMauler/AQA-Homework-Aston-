public class Rectrangle implements Figure {
    private double len;
    private double wid;
    private String fillCol;
    private String  bordCol;
    public Rectrangle(double len, double wid, String fillCol, String bordCol) {
        this.len = len;
        this.wid = wid;
        this.fillCol = fillCol;
        this.bordCol = bordCol;
    }
    @Override
    public double per() {
        return 2 * (len + wid);
    }
    @Override
    public double area() {
        return len * wid;
    }
    public void info() {
        System.out.println("\nПериметр прямоугольника: " + per() + "\nПлощадь прямоугольника: " + area() +
                           "\nЦвет заливки: " + fillCol + "\nЦвет границы: " + bordCol);
    }
}

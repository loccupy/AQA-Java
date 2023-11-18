package repoInterface;

public class Circle implements Interface{

    private String fillCol, outCol;
    private int radius;

    public Circle(int radius, String fillCol, String outCol) {
        this.radius = radius;
        this.fillCol = fillCol;
        this.outCol = outCol;
    }

    @Override
    public String getSize() {
        return ("радиус " + radius);
    }

    @Override
    public String getFillCol() {
        return fillCol;
    }

    @Override
    public void setFillCol(String fillCol){
        this.fillCol = fillCol;
    }

    @Override
    public String getOutCol() {
        return outCol;  
    }

    @Override
    public void setOutCol(String outCol){
        this.outCol = outCol;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public float perimeter() {
        return (float) Math.PI * 2 * radius;
    }
}

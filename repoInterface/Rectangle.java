package repoInterface;

public class Rectangle implements Interface{

    private String fillCol, outCol;
    private int firstSide, secondSide;

    public Rectangle(int firstSide, int secondSide, String fillCol, String outCol) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.fillCol = fillCol;
        this.outCol = outCol;
    }

    @Override
    public String getSize() {
        return (firstSide + " * " + secondSide);
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
        return firstSide*secondSide;
    }

    @Override
    public float  perimeter() {
         return 2 * (firstSide + secondSide);
    }
}

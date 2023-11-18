package repoInterface;

public class Triangle implements Interface{

    private String fillCol, outCol;
    private int firstSide, secondSide, thirdSide;

    public Triangle(int a, int b, int c,
        String fillCol, String outCol) {
        if((a + b > c && b + c > a && a + c > b) == false) {
            System.out.println("\n       Предупреждение!!!");
            System.out.println("Такого треугольника не существует!!!\n");
        }
        this.firstSide = a;
        this.secondSide = b;
        this.thirdSide = c;
        this.fillCol = fillCol;
        this.outCol = outCol;
    }

    @Override
    public String getSize() {
        return (firstSide + " * " + secondSide +
             " * " + thirdSide);
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
        double p = (firstSide + secondSide + thirdSide) / 2.0;
        return Math.sqrt(p* (p - firstSide) * 
            (p - secondSide) * (p - thirdSide));
    }

    @Override
    public float perimeter () {
       return (firstSide + secondSide + thirdSide);
   }
    
}

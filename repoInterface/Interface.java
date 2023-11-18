package repoInterface;

public interface Interface {

    String getFillCol();

    void setFillCol(String a);

    String getOutCol();

    void setOutCol(String a);

    String getSize ();

    double area ();

    float perimeter ();

    default float  perimeter(int a, int b) {
        return 2 * (a + b);
   }
}

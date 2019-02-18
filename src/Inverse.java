import java.util.Scanner;

public class Inverse
{
    public static int DIM = 2;

    public static void main(String args[])
    {
        int i, j,count=1;
        double determinant, temp;
        double rowOne[]= new double[DIM];
        double rowTwo[]= new double[DIM];
        double matrix[][] = new double[DIM][DIM];

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            for (i = 0; i < 2; ++i)
                rowOne[i] = sc.nextDouble();

            for (j = 0; j < 2; ++j)
                rowTwo[j] = sc.nextDouble();

            matrix[0][0] = rowOne[0];
            matrix[0][1] = rowOne[1];
            matrix[1][0] = rowTwo[0];
            matrix[1][1] = rowTwo[1];


            determinant = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);

            temp = matrix[0][0];
            matrix[0][0] = matrix[1][1];
            matrix[1][1] = temp;

            matrix[0][1] = -matrix[0][1];
            matrix[1][0] = -matrix[1][0];

            System.out.printf("Case %d: \n", count);
            count++;
            for (i = 0; i < 2; ++i) {
                for (j = 0; j < 2; ++j) {
                    double value = (matrix[i][j] / determinant);
                    int positionValue = (int) value;
                    System.out.print(positionValue + " ");
                }

                System.out.print("\n");
            }
        }
    }
}

public class LinearSystem
{
    public static void solve() throws Exception
    {
        Iteration gaussSeidel = new GaussSeidel();
        Iteration jacobi = new Jacobi();

        double[][] tmpA = {{-4, 1, 1, 0, 0, 0},
                           {1, -4, 0, 1, 0, 0},
                           {1, 0, -4, 1, 1, 0},
                           {0, 1, 1, -4, 0, 1},
                           {0, 0, 2, 0, -4, 1},
                           {0, 0, 0, 2, 1, -4}};

        SquareMatrix A = new SquareMatrix(tmpA);

        double[] tmpB = {2, -4, 5, -28, -2, -116};
        Vector B = new Vector(tmpB);

        Vector gaussSeidelX = gaussSeidel.solve(A, B);
        Vector jacobiX = jacobi.solve(A, B);

        gaussSeidelX.print();
        jacobiX.print();
    }
}

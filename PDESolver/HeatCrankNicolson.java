public class HeatCrankNicolson
{
    public static void solve() throws Exception
    {
        double h = 0.2;
        double k = 0.04;
        int timeNum = 5;

        double r = k / h / h;
        if(Math.abs(Math.floor(1 / h) - (1 / h)) > 1e-5) throw new Exception("Wrong h value");
        int num = (int)Math.floor(1 / h);

        double[] ans = new double[num + 1];
        System.out.println("t = 0.0");
        for(int i = 0; i <= num; i++)
        {
            if(i != 0 && i != num) ans[i] = Function.f(i * h);
            else ans[i] = 0.0;
            System.out.printf("x = %.2f: %.4f | ", i * h, ans[i]);
        }
        System.out.println("\n");

        for(int t = 1; t <= timeNum; t++)
        {
            System.out.printf("t = %.2f\n", t * k);

            double[][] A = new double[num - 1][num - 1];
            for(int i = 0; i < num - 1; i++)
                for(int j = 0; j < num - 1; j++)
                    A[i][j] = 0.0;

            for(int i = 1; i < num; i++)
            {
                if(i - 1 > 0) A[i - 1][i - 2] = -r;
                A[i - 1][i - 1] = 2 + 2 * r;
                if(i + 1 < num) A[i - 1][i] = -r;
            }

            double[] B = new double[num - 1];
            for(int i = 1; i < num; i++)
            {
                B[i - 1] = (2 - 2 * r) * ans[i] + r * (ans[i - 1] + ans[i + 1]);
            }

            Iteration gaussSeidel = new GaussSeidel();
            Vector X = gaussSeidel.solve(new SquareMatrix(A), new Vector(B));
            for(int i = 1; i < num; i++) ans[i] = X.get(i - 1);

            for(int i = 0; i <= num; i++)
            {
                System.out.printf("x = %.2f: %.4f | ", i * h, ans[i]);
            }
            System.out.println("\n");
        }
    }
}

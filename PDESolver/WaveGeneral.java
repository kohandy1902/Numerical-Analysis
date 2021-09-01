public class WaveGeneral
{
    public static void solve() throws Exception
    {
        double h = 0.2;
        double k = 0.2;
        int timeNum = 5;

        double r = k * k / h / h;
        if(Math.abs(Math.floor(1 / h) - (1 / h)) > 1e-5) throw new Exception("Wrong h value");
        int num = (int)Math.floor(1 / h);

        double[] ans1 = new double[num + 1];
        double[] ans2 = new double[num + 1];
        System.out.println("t = 0.0");
        for(int i = 0; i <= num; i++)
        {
            if(i != 0 && i != num) ans1[i] = Function.f(i * h);
            else ans1[i] = 0.0;
            System.out.printf("x = %.2f: %.4f | ", i * h, ans1[i]);
        }
        System.out.println("\n");

        System.out.printf("t = %.2f\n", k);
        for(int i = 0; i <= num; i++)
        {
            if(i != 0 && i != num) ans2[i] = 0.5 * (ans1[i - 1] + ans1[i + 1]) + k * Function.g(i * h);
            else ans2[i] = 0.0;
            System.out.printf("x = %.2f: %.4f | ", i * h, ans2[i]);
        }
        System.out.println("\n");

        for(int t = 2; t <= timeNum; t++)
        {
            System.out.printf("t = %.2f\n", t * k);

            double[] tmp = new double[num + 1];
            tmp[0] = tmp[num] = 0.0;

            for(int i = 1; i < num; i++)
            {
                tmp[i] = r * (ans2[i - 1] + ans2[i + 1]) + (2 - 2 * r) * ans2[i] - ans1[i];
            }

            ans1 = ans2;
            ans2 = tmp;
            for(int i = 0; i <= num; i++)
            {
                System.out.printf("x = %.2f: %.4f | ", i * h, ans2[i]);
            }
            System.out.println("\n");
        }
    }
}

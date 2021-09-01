public class HeatGeneral
{
    public static void solve() throws Exception
    {
        double h = 0.2;
        double k = 0.02;
        int timeNum = 5;

        double r = k / h / h;
        if(Math.abs(Math.floor(1 / h) - (1 / h)) > 1e-5) throw new Exception("Wrong h value");
        if(r > 0.5) throw new Exception("Invalid Ratio (Don't Converge)");
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
            double[] tmp = new double[num + 1];
            tmp[0] = tmp[num] = 0.0;

            for(int i = 1; i < num; i++)
            {
                tmp[i] = (1 - 2 * r) * ans[i] + r * (ans[i - 1] + ans[i + 1]);
            }

            ans = tmp;
            for(int i = 0; i <= num; i++)
            {
                System.out.printf("x = %.2f: %.4f | ", i * h, ans[i]);
            }
            System.out.println("\n");
        }
    }
}

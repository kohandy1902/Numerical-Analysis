public class SecantMethod
{
    public static void solve(double x0, double x1, int num)
    {
        double x01 = x0;
        double x02 = x1;

        System.out.println("--------Secant Method--------");
        System.out.println("x0 = " + x0);
        System.out.println("x1 = " + x1);
        for(int i = 1; i <= num; i++)
        {
            double tmp = x02 - Function.f(x02) * (x02 - x01) / (Function.f(x02) - Function.f(x01));
            x01 = x02;
            x02 = tmp;
            System.out.printf("x%d = %.4f\n", i + 1, x02);
        }
        System.out.println("--------End Method--------\n\n");
    }
}

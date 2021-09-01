public class NewtonMethod
{
    public static void solve(double x0, int num)
    {
        System.out.println("--------Newton Method--------");
        double x = x0;
        System.out.println("x0 = " + x0);
        for(int i = 1; i <= num; i++)
        {
            x = x - Function.f(x) / Function.fprime(x);
            System.out.printf("x%d = %.4f\n", i, x);
        }
        System.out.println("--------End Method--------\n\n");
    }
}

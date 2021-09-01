public class ImprovedEuler extends ODESolver
{
    public void solve(double x0, double y0, double step, int num, Function func)
    {
        double[] y = new double[num + 1];
        y[0] = y0;
        for(int i = 1; i <= num; i++)
        {
            double k1 = step * func.f(x0 + (i - 1) * step, y[i - 1]);
            double k2 = step * func.f(x0 + i * step, y[i - 1] + k1);
            y[i] = y[i - 1] + 0.5 * (k1 + k2);
        }
        System.out.println("----------Improved Euler----------");
        print(x0, y0, x0 + num * step, y[num], step);
    }
}

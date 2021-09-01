public class ClassicalRK extends ODESolver
{
    public void solve(double x0, double y0, double step, int num, Function func)
    {
        double[] y = new double[num + 1];
        y[0] = y0;
        for(int i = 1; i <= num; i++)
        {
            double k1 = step * func.f(x0 + (i - 1) * step, y[i - 1]);
            double k2 = step * func.f(x0 + (i - 0.5) * step, y[i - 1] + 0.5 * k1);
            double k3 = step * func.f(x0 + (i - 0.5) * step, y[i - 1] + 0.5 * k2);
            double k4 = step * func.f(x0 + i * step, y[i - 1] + k3);
            y[i] = y[i - 1] + 1.0 / 6.0 * (k1 + 2 * k2 + 2 * k3 + k4);
        }
        System.out.println("----------Classical RK----------");
        print(x0, y0, x0 + num * step, y[num], step);
    }
}

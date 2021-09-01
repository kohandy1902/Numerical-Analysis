public class RKF_fourth extends ODESolver
{
    public void solve(double x0, double y0, double step, int num, Function func)
    {
        double[] y = new double[num + 1];
        y[0] = y0;
        for(int i = 1; i <= num; i++)
        {
            double k1 = step * func.f(x0 + (i - 1) * step, y[i - 1]);
            double k2 = step * func.f(x0 + (i - 1 + 0.25) * step, y[i - 1] + 0.25 * k1);
            double k3 = step * func.f(x0 + (i - 1 + 3.0 / 8.0) * step, y[i - 1] + 3.0 / 32.0 * k1 + 9.0 / 32.0 * k2);
            double k4 = step * func.f(x0 + (i - 1 + 12.0 / 13.0) * step,
                    y[i - 1] + 1932.0 / 2197.0 * k1 - 7200.0 / 2197.0 * k2 + 7296.0 / 2197.0 * k3);
            double k5 = step * func.f(x0 + i * step,
                    y[i - 1] + 439.0 / 216.0 * k1 - 8 * k2 + 3680.0 / 513.0 * k3 - 845.0 / 4104.0 * k4);
            y[i] = y[i - 1] + 25.0 / 216.0 * k1 + 1408.0 / 2565.0 * k3 + 2197.0 / 4104.0 * k4 - 0.2 * k5;
        }
        System.out.println("----------RKF_fourth----------");
        print(x0, y0, x0 + num * step, y[num], step);
    }
}

public class RKF_fifth extends ODESolver
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
            double k6 = step * func.f(x0 + (i - 0.5) * step,
                    y[i - 1] - 8.0 / 27.0 * k1 + 2 * k2 - 3544.0 / 2565.0 * k3 + 1859.0 / 4104.0 * k4 - 11.0 / 40.0 * k5);
            y[i] = y[i - 1] + 16.0 / 135.0 * k1 + 6656.0 / 12825.0 * k3 + 28561.0 / 56430.0 * k4 - 0.18 * k5 + 2.0 / 55.0 * k6;
        }
        System.out.println("----------RKF_fifth----------");
        print(x0, y0, x0 + num * step, y[num], step);
    }
}

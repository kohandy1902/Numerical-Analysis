public class Euler extends ODESolver
{
    public void solve(double x0, double y0, double step, int num, Function func)
    {
        double[] y = new double[num + 1];
        y[0] = y0;
        for(int i = 1; i <= num; i++)
        {
            y[i] = y[i - 1] + step * func.f(x0 + (i - 1) * step, y[i - 1]);
        }
        System.out.println("----------Euler----------");
        print(x0, y0, x0 + num * step, y[num], step);
    }
}

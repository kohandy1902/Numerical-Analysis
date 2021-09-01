public abstract class ODESolver
{
    abstract public void solve(double x0, double y0, double step, int num, Function func);
    public void solve(double x0, double y0, double xn, double step, Function func)
    {
        solve(x0, y0, step, (int)Math.ceil((xn - x0) / step), func);
    }

    public void print(double x0, double y0, double xn, double yn, double step)
    {
        System.out.println("----------Solve Result----------");
        System.out.println("x0: " + x0 + ", y0: " + y0);
        System.out.println("Step: " + step);
        System.out.println("xn: " + xn + ", yn: " + yn);
        System.out.println("--------------END--------------");
        System.out.println();
        System.out.println();
    }
}

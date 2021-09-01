public class ODECalculator
{
    public static void main(String[] args)
    {
        Function func = new Function();
        ODESolver euler = new Euler();
        ODESolver improvedEuler = new ImprovedEuler();
        ODESolver classicalRK = new ClassicalRK();
        ODESolver rkf_Fourth = new RKF_fourth();
        ODESolver rkf_Fifth = new RKF_fifth();

        double x0, y0, step;
        int num;

        x0 = 0.0;
        y0 = 0.0;
        step = 0.1;
        num = 10;

        euler.solve(x0, y0, step, num, func);
        improvedEuler.solve(x0, y0, step, num, func);
        classicalRK.solve(x0, y0, step, num, func);
        rkf_Fourth.solve(x0, y0, step, num, func);
        rkf_Fifth.solve(x0, y0, step, num, func);
    }
}

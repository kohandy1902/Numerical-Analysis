public class Function
{
    private static final double PI = Math.PI;
    public static double f(double x)
    {
        return x - 2 * sin(x); //Solving Function
    }

    public static double fprime(double x)
    {
        return 1 - 2 * cos(x);
    }

    public static double pow(double x, double y)
    {
        return Math.pow(x, y);
    }

    public static double exp(double x)
    {
        return Math.exp(x);
    }

    public static double sin(double x){return Math.sin(x);}

    public static double cos(double x){return Math.cos(x);}
}

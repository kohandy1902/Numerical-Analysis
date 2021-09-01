public class Vector extends Matrix
{
    public Vector(double[] M) throws Exception
    {
        super(M);
    }

    public double get(int x) throws Exception
    {
        return get(x, 0);
    }

    public void set(int x, double y) throws Exception
    {
        set(x, 0, y);
    }
}
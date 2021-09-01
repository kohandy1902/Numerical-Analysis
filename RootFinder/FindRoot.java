public class FindRoot
{
    public static void main(String[] args)
    {
        NewtonMethod.solve(1.0, 5);
        SecantMethod.solve(2.0, 1.901, 5);
    }
}
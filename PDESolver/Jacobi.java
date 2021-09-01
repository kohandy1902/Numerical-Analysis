public class Jacobi implements Iteration
{
    public Vector solve(SquareMatrix A, Vector B) throws Exception
    {
        if(A.n != B.n) throw new Exception("Size Unmatched");

        double[] tmp = new double [B.n];
        for(int i = 0; i < tmp.length; i++) tmp[i] = 0.0;
        Vector X = new Vector(tmp);

        for(int tr = 0; tr < MX; tr++)
        {
            for (int i = 0; i < X.n; i++)
            {
                tmp[i] = B.get(i);
                for (int j = 0; j < X.n; j++)
                {
                    if (i == j) continue;
                    tmp[i] -= A.get(i, j) * X.get(j);
                }
                tmp[i] /= A.get(i, i);
            }
            X = new Vector(tmp);
        }
        return X;
    }
}

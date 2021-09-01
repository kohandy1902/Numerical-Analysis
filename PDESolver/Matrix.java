public class Matrix
{
    int n;
    int m;
    double[][] M;

    public Matrix(double[][] M) throws Exception
    {
        if(M.length == 0 || M[0].length == 0) throw new Exception("Wrong Matrix");
        n = M.length;
        m = M[0].length;
        this.M = M;
    }

    public Matrix(double[] M) throws Exception
    {
        n = M.length;
        m = 1;
        this.M = new double[M.length][1];
        for(int i = 0; i < M.length; i++) this.M[i][0] = M[i];
    }

    public double get(int x, int y) throws Exception
    {
        if(x < 0 || x >= n || y < 0 || y >= m) throw new Exception("Invalid Index");
        return M[x][y];
    }

    public void set(int x, int y, double z) throws Exception
    {
        if(x < 0 || x >= n || y < 0 || y >= m) throw new Exception("Invalid Index");
        M[x][y] = z;
    }

    public void print()
    {
        System.out.println("--------Printing Matrix--------");
        for(double[] i : M)
        {
            for(double j : i) System.out.print(j + " ");
            System.out.println();
        }
        System.out.println("----------End Printing----------");
        System.out.println();
    }
}
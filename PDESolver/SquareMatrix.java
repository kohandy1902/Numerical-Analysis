public class SquareMatrix extends Matrix
{
    SquareMatrix(double[][] M) throws Exception
    {
        super(M);
        if(M.length != M[0].length) throw new Exception("Wrong Matrix");
    }
}
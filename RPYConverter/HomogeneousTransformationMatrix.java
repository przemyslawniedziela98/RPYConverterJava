package RPYConverter;

import java.lang.Math;

import javax.lang.model.util.ElementScanner14;

public class HomogeneousTransformationMatrix 
{
    private double[] N = new double[3];
    private double[] O = new double[3];
    private double[] A = new double[3];
    private double[] P = new double[3];

    public HomogeneousTransformationMatrix(double[] N,  double[] O, double[] A, double[] P)
    {
       this.N = N;
       this.O = O;
       this.A = A;
       this.P = P;
    }

    public HomogeneousTransformationMatrix(double[][] matrix)
    {
        this.N = new double[] {matrix[0][0], matrix[1][0], matrix[2][0]};
        this.O = new double[] {matrix[0][1], matrix[1][1], matrix[2][1]};
        this.A = new double[] {matrix[0][2], matrix[1][2], matrix[2][2]};
        this.P = new double[] {matrix[0][3], matrix[1][3], matrix[2][3]};
    }

    public double getRoll()
    {   
        if (getRoundedPitchException() == 90 && N[0] == 0 && A[2] != 0) 
        {
            return Math.toDegrees(Math.atan2(O[2],A[2])-Math.atan2(O[0],O[1]));
        }
        else if (getRoundedPitchException() == -90 && N[0] == 0 && A[2] != 0) 
        {
            return Math.toDegrees(Math.atan2(-O[0],O[1])-Math.atan2(O[2],A[2]));
        }
        else return Math.toDegrees(Math.atan2(N[1],N[0]));
    }

    public double getPitch()
    {
        return  Math.toDegrees(Math.atan((-N[2])/Math.sqrt(1-Math.pow(N[2],2))));
    }

    public double getYaw()
    {
        if (getRoundedPitchException() == 90 && N[0] != 0 && A[2] == 0) 
        {
            return  Math.toDegrees(Math.atan2(O[0],O[1])+Math.atan2(N[1],N[0]));
        }
        else if (getRoundedPitchException() == -90 && N[0] != 0 && A[2] == 0)
        {
            return Math.toDegrees(Math.atan2(-O[0],O[1])-Math.atan2(O[2],A[2]));
        }
        else return Math.toDegrees(Math.atan2(O[2],A[2]));
    }

    private double getRoundedPitchException()
    {
        return Math.round(Math.toDegrees(Math.atan((-N[2])/Math.sqrt(1-Math.pow(N[2],2)))));
    }

    public String toString()
    {
        String matrixArray = "";
        for (int i =0; i <= 2; i ++)
        {
            matrixArray += String.format("%.2f, %.2f, %.2f, %.2f \n",N[i],O[i],A[i],P[i]);
        }
        matrixArray += "0,    0,    0,    1\n";
        return "Homogeneous Transformation Matrix:\n" + matrixArray;
    }
}
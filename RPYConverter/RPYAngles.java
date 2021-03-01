package RPYConverter;

import java.lang.Math;

public class RPYAngles 
{
    private double R=0;
    private double P=0;
    private double Y=0;

    public RPYAngles(double R,  double P, double Y)
    {
        this.R = Math.toRadians(R);
        this.P = Math.toRadians(P);
        this.Y = Math.toRadians(Y);
    }

    public RPYAngles(double[] angles)
    {
        this.R = Math.toRadians(angles[0]);
        this.P = Math.toRadians(angles[1]);
        this.Y = Math.toRadians(angles[2]);
    }

    public double[][] getHomogeneousTransformationMatrix()
    {
        double[][] matrix = {{C(R)*C(P), -S(R)*C(Y)+C(R)*S(P)*S(Y), S(R)*S(Y)+C(R)*S(P)*C(Y),0},
                             {S(R)*C(P), C(P)*C(Y)+S(R)*S(P)*S(Y), -C(R)*S(Y)+S(R)*S(P)*C(Y),0},
                             {-S(P), C(P)*S(Y), C(P)*C(Y),0},
                             {0,0,0,1}};
        if (P == 90)
        {
            matrix[0][1] = S(Y-P);
            matrix[1][1] = C(Y-P);
        }
        else if (P == -90)
        {
            matrix[0][1] = -S(Y+P);
            matrix[1][1] = C(Y+P);
        }
        return matrix;
    } 

    private double S(double angle)
    {
        return Math.sin(angle);
    }

    private double C(double angle)
    {
        return Math.cos(angle);
    }

    public double getRoll()
    {
        return R;
    }

    public double getPitch()
    {
        return P;
    }

    public double getYaw()
    {
        return Y;
    }
    
    public String toString()
    {
        return "RPYAngles [Roll= "+R+", Pitch = " + P +", Yaw = "+Y;
    }
}
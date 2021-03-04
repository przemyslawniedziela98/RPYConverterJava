package RPYConverter;

import java.lang.Math;

public class Quaternion {
    private double q0;
    private double q1;
    private double q2;
    private double q3;

    public Quaternion(double q0, double q1, double q2, double q3)
    {
        this.q0 = q0;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    public Quaternion(double[] quaterions)
    {
        q0 = quaterions[0];
        q1 = quaterions[1];
        q2 = quaterions[2];
        q3 = quaterions[3];
    }

    public double[][] getHomogeneousTransformationMatrix()
    {
        double[][] homogeneousTransformationMatrix = {{1-2*(q2*q2+q3*q3), 2*(q1*q2-q0*q3), 2*(q0*q2+q1*q3)},
                                                      {2*(q1*q2+q0*q3), 1-2*(q1*q1+q3*q3), 2*(q2*q3-q0*q1)},
                                                      {2*(q1*q3-q0*q2), 2*(q0*q1+q2*q3), 1-2*(q1*q1+q2*q2)}};
        return homogeneousTransformationMatrix;
    }

    public double getRoll()
    {
        return Math.atan2(2*(q0*q1 + q2*q3), 1-2*(q1*q1 + q2*q2));
    }

    public double getPitch()
    {
        return Math.asin(2*(q0*q2 - q3*q1));
    }

    public double getYaw()
    {
        return Math.atan2(2*(q0*q3 + q1*q2), 1-2*(q2*q2 + q3*q3));
    }

    public String toString()
    {
        return "Quaternion Matrix: ["+ q0 + ", " + q1 + ", " + q2 + ", " + q3 + "]\n" ;
    }
}

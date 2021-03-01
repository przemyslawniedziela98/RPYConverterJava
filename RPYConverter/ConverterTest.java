package RPYConverter;

import java.lang.Math;

import RPYConverter.RPYAngles;

public class ConverterTest
{
    public static void main(String[] args)
    {
        double[][] testMatrix = {{-Math.sqrt(3)/2, 0, 0.5, 0},
                                 {-0.5, 0, -Math.sqrt(3)/2, 0},
                                 {0, -1,0,0},
                                 {0,0,0,1}};
        HomogeneousTransformationMatrix matrixValues = new HomogeneousTransformationMatrix(testMatrix);
        System.out.println("Roll = " + matrixValues.getRoll());
        System.out.println("Pitch =" + matrixValues.getPitch());
        System.out.println("Yaw =" + matrixValues.getYaw());
        System.out.println(matrixValues.toString());

        RPYAngles anglesValues = new RPYAngles(-150, 0, -90);
        double[][] testAngleMatrix = anglesValues.getHomogeneousTransformationMatrix();

        String matrixArray = "";
        for (int i =0; i <= 3; i ++)
        {
            matrixArray += String.format("%.2f, %.2f, %.2f, %.2f \n",testAngleMatrix[i][0],testAngleMatrix[i][1],testAngleMatrix[i][2],testAngleMatrix[i][3]);
        }

        System.out.println(matrixArray);
    }
}
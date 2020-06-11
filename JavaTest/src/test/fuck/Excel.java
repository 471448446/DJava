package test.fuck;

import common.Utils;

public class Excel {

    public static void main(String[] args) {
        float fp1 = 27.956942f;
        double x = Math.pow(fp1, 1.5) / 18.0;
        Utils.log(x, transformFPSToScore(fp1));
    }

    private static double transformFPSToScore(float fps) {
        fps = fps > 60 ? 60 : fps;
        fps = Math.max(fps, 1);
        return Math.pow(fps, 1.5) / 18.0;
    }

}

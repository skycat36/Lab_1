package com.vsu.data.wave;

public class DoG implements Wave {

    @Override
    public double funcWeve(double x, int i, int j) {

        double result = Math.exp(-(Math.pow(i, 2.0) + Math.pow(j, 2.0))/2.0) - 0.5 * Math.exp(-(Math.pow(i, 2.0) + Math.pow(j, 2.0))/8.0);

        return result;
    }
}

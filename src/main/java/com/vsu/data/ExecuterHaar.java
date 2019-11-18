package com.vsu.data;

import com.vsu.data.wave.Func;
import com.vsu.data.wave.Haar;
import com.vsu.data.wave.PointWave;
import com.vsu.data.wave.Wave;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;

public class ExecuterHaar extends AbstractExecuter{

    public ExecuterHaar(Func func, double a, double b, int m, int accuracy) {
        super(new Haar(), func, a, b, m, accuracy);
    }

    @Override
    public void calculeteWave() {
        this.resultList = new ArrayList<PointWave>();

        this.resultList.add(new PointWave(0, 0, this.calcIntegralA0()));


        for (int i = 1; i <= this.m; i++){
            int n = (int)Math.pow(2.0, i);

            for (int j=1; j <= n; j++) {
                this.resultList.add(
                        new PointWave(
                                i, j,
                                Precision.round(
                                        calcIntegralCTwoDimensional(i, j),
                                        this.accuracy
                                )
                        )
                );
            }

        }
    }
}

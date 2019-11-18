package com.vsu.app;

import com.vsu.data.AbstractExecuter;
import com.vsu.data.ExecuterDoG;
import com.vsu.data.ExecuterHaar;
import com.vsu.data.wave.DoG;
import com.vsu.data.wave.Func;
import com.vsu.data.wave.PointWave;

import java.util.List;

public class App {
    private final static double PI = Math.PI; //число Пи

    private static int accuracy = 6; // точность

    private static int N = 10; // количество точек

    private static double a = -92.70999999999862, b = +92.70999999999862, m = 2, n = 3;


    public static void main(String[] args){


//Вычисление вейвлета Хоара
//        Func func = (x)-> Math.exp(-15.0 * Math.abs(x - 0.3)) + Math.pow(x, 2.0);

//        ExecuterHaar haarExecuterHaar = new ExecuterHaar(func, a, b, m, accuracy);
//
//        haarExecuterHaar.calculeteWave();


        Func func = (x)-> -28.0 * Math.sin(4.0 / (19.0 * PI) * x - 1) + 6.0 * Math.cos(1.0 / (40.0 * Math.sqrt(PI)) * x);

        ExecuterDoG executer = new ExecuterDoG(func, a, b, m, n, accuracy);

        //System.out.println(" Optimize = " + executer.searchOptimizeInterval());

        executer.calculeteWave();

        List<PointWave> res = executer.getResultList();


        System.out.printf("Точки: %2sX| Y%-5s | Значение: %7s%n", "", "", "");
        for (PointWave pointWave : res){
            System.out.printf("%8s%2d| %-6d |  %-8f%n", "", pointWave.getPointX(), pointWave.getPointY(), pointWave.getValue());
        }

        System.out.println("Prove: " + executer.prove());
    }
}

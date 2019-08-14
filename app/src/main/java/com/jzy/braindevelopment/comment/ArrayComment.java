package com.jzy.braindevelopment.comment;

import android.util.Log;

public class ArrayComment {

    public Integer[] FigureArray(int ArratLength, int max, int min) {

        // max - 期望的最大值
// min - 期望的最小值
//        parseInt(Math.random()*(max-min+1)+min,10);

        Integer ran[] = new Integer[ArratLength];
        for (int i = 0; i < ran.length; i++) {
            int index = (int) (Math.random()*(max-min+1)+min);
            ran[i] = index;
            Log.d("ArratLength", i + "-----FigureArray---" + ArratLength);
            System.out.println("***" + index);
            for (int j = 0; j < i; j++) {
                if (ran[j] == ran[i]) {
                    i--;
                    break;
                }
            }
        }
        return ran;
    }
}


package com.hackerrank;

import com.google.common.collect.Lists;

import java.util.List;

public class Pontuation {

    public int[] pontuate(List<Integer> points) {
        int[] pontuation = {0, 0};
        List<Integer> alicePontuation = Lists.partition(points, 3).get(0);
        List<Integer> bobPontuation = Lists.partition(points, 3).get(1);

        for (int i = 0; i < 3; i++) {
           if (alicePontuation.get(i) > bobPontuation.get(i)) {
                pontuation[0]+= 1;
           } else if (alicePontuation.get(i) < bobPontuation.get(i)) {
                pontuation[1]+= 1;
           }
        }

        return pontuation;
    }
}

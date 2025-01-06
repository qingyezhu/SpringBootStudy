package com.wangzhu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangzhu on 2024/12/8 22:59.
 **/
public class MyThree {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + calcPath(i));
        }
    }

    static List<List<Integer>> calcPath(int n) {
        if (n == 0) {
            List<Integer> list = new ArrayList<>();
            return Arrays.asList(list);
        }
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return Arrays.asList(list);
        }
        List<List<Integer>> ret = new ArrayList<>();
        List<List<Integer>> list1 = calcPath(n - 1);
        List<List<Integer>> list2 = calcPath(n - 2);

        addForEach(list1, ret, 1);
        addForEach(list2, ret, 2);

        return ret;
    }

    static void addForEach(List<List<Integer>> from, List<List<Integer>> to, int n) {
        for (List<Integer> list : from) {
            list.add(n);
            to.add(list);
        }
    }
}

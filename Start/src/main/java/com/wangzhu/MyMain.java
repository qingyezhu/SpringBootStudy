package com.wangzhu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhu on 2024/11/11 18:43.
 **/
public class MyMain {

    // 1
    // 1,1
    // 2,1
    // 1,2,1,1
    // 1,1,1,2,2,1
    // 3,1,2,2,1,1
    public static void main(String[] args) {
        fun(1, 6);
    }

    static void fun(int a, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                list.add(a);
                System.out.println(a);
                continue;
            }
            List<Integer> newList = new ArrayList<>();
            for (int j = 0, size = list.size(); j < size; j++) {
                if(j == 0){
                    newList.add(1);
                    newList.add(list.get(j));
                    continue;
                }
                if(list.get(j - 1).equals(list.get(j))){
                    int k = newList.size() - 2;
                    newList.set(k, newList.get(k) + 1);
                }else{
                    newList.add(1);
                    newList.add(list.get(j));
                }

            }
            System.out.println(newList);
            list = newList;
        }
    }
}

package com.wangzhu;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangzhu on 2024/12/16 15:14.
 **/
public class MyNewOne {

    public static void main(String[] args) {
        calc(new int[]{1,11,3,0,15,5,2,4,10,7,12,6});
        // [0,7]
        calc(new int[]{100,99,1,2,3,4});
        // [1,4]

    }

    static void calc(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxStart = -1, maxLen = -1;
        for(int num : nums){
            if(set.contains(num - 1)){
                continue;
            }
            // 有序序列的启示元素
            int start = num, len = 0;
            while(set.contains(start + len)){
                len++;
            }
            if(len > maxLen){
                maxLen = len - 1;
                maxStart = start;
            }
        }

        final int left = maxStart, right = left + maxLen;
        System.out.printf("[%d, %d]%n", left, right);
    }
}

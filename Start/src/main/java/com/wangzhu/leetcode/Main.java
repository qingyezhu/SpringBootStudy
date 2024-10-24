package com.wangzhu.leetcode;

import java.util.LinkedList;

/**
 * Created by wangzhu on 2024/10/22 17:01.
 **/
public class Main {

    public static void main(String[] args) {

    }

    static int handle(int[] nums, int n) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int sum = 0;// 假设和在int范围内
        int ret = Integer.MAX_VALUE;
        for (int num : nums) {
            linkedList.addLast(num);
            sum += num;
            while (sum >= n) {
                ret = Math.min(ret, linkedList.size());
                sum -= linkedList.removeFirst();
            }
        }
        return ret;
    }
}

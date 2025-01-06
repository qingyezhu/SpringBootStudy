package com.wangzhu;

import java.util.Arrays;

/**
 * Created by wangzhu on 2024/12/10 15:55.
 **/
public class MyFour {


    public static void main(String[] args) {
        calc(new int[]{10,9,2,5,3,7,101,18});
        calc(new int[]{0,1,0,3,2,3});
        calc(new int[]{7,7,7,7,7,7,7});
    }

    static void calc(int[] nums) {
        // 数组存在有元素
        final int len = nums.length;
        final int[] dp = new int[len];

        for(int i = 0;i < len;i ++){
            int max = 0;
            for(int j = i;j >= 0;j --){
                if(nums[i] > nums[j]){
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }
        System.out.println(Arrays.toString(dp));

        int maxLen = 0;
        for(int i = 0;i < len;i ++){
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(maxLen);
    }
}

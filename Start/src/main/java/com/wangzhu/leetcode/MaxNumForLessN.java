package com.wangzhu.leetcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by wangzhu on 2024/10/21 16:59.
 **/
public class MaxNumForLessN {

    /**
     * 题目描述：数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n的最大数。例如A={1, 2, 4, 9}，x=2533，返回2499<br/>
     *
     * @param args
     */

    public static void main(String[] args) {
        print(2533, new int[]{1, 2, 4, 9}, 2499);
        print(988822, new int[]{4, 2, 9, 8}, 988499);
        print(9, new int[]{9, 8}, 8);
        print(56449, new int[]{9, 6, 3, 5}, 56399);
        print(268, new int[]{2, 6, 8}, 266);
        print(2369, new int[]{2, 6, 8}, 2288);
        print(288, new int[]{2, 6, 8}, 286);
        print(1111, new int[]{2, 6, 8}, 888);
        print(4699, new int[]{4, 6, 8}, 4688);
        print(4369, new int[]{4, 6, 8}, 888);
        print(4369, new int[]{5, 6, 8}, 888);
        print(2533, new int[]{1, 2, 4, 9}, 2499);
        print(2033, new int[]{1, 2, 4, 9}, 1999);
        print(1033, new int[]{1, 2, 4, 9}, 999);
        print(222202222, new int[]{1, 2, 4, 9}, 222199999);
        print(433211, new int[]{9,4,3,2}, 432999);
    }

    static void print(int n, int[] nums, int expect) {
        int maxNum = maxNumForLessN(n, nums);
        System.out.println(Arrays.toString(nums) + " n=" + n + " maxNum=" + maxNum + " expect=" + expect + " " + (maxNum == expect));
        System.out.println();
    }

    static int maxNumForLessN(final int n, final int[] nums) {
        Arrays.sort(nums);
        final LinkedList<Integer> linkedList = new LinkedList<>();
        boolean less = false;
        final String str = "" + n;
        Integer targetIndex = null;
        for (int i = 0, len = str.length(); i < len; ) {
            if (less) {
                linkedList.addLast(nums.length - 1);
                i++;
                continue;
            }
            final int curr = str.charAt(i) - '0';
            int idx = -1;
            if (targetIndex != null) {
                // 回溯时，直接使用回溯索引的前一个位置即可，之后判断调整后的索引是否有效，即可
                idx = targetIndex - 1;
                targetIndex = null;
            } else {
                idx = findIndexForLessAndEq(nums, curr);
            }
            if (idx == -1) {
                // 没有找到符合条件的，需要回溯
                if (linkedList.isEmpty()) {
                    // 若无法回溯，则说明数字第一位是0，之后都是数组中的最大值
                    i++;
                    less = true;
                } else {
                    // 由于此时该位置还没有填充，故直接使用前一个位置进行回溯
                    targetIndex = linkedList.removeLast();
                    i--;
                }
                continue;
            }

            if (nums[idx] == curr) {
                linkedList.addLast(idx);
            } else {
                linkedList.addLast(idx);
                // 添加的是比curr小，则之后直接使用nums数组中最大的值去填充
                less = true;
            }
            if (i == len - 1) {
                final int ret = toNum(linkedList, nums);
                final boolean eq = str.equals(ret + "");
                if (eq) {
                    // 一样大，则最后一个位置，需要回溯，直接使用当前位置的索引进行回溯
                    targetIndex = linkedList.removeLast();
                    continue;
                }
            }
            i++;
        }
        return toNum(linkedList, nums);
    }

    static int toNum(LinkedList<Integer> linkedList, int[] nums) {
        int ret = 0;
        for (Integer idx : linkedList) {
            ret = ret * 10 + nums[idx];
        }
        return ret;
    }

    static int findIndexForLessAndEq(int[] nums, int target) {
        // 从数组中找到最后一个小于等于target的索引，若不存在，则返回-1
        // 使用的方式是target插入数组中的位置
        final int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == len) {
            // target比数组中的元素都大，故数组中最后一个元素的索引才是所求
            return len - 1;
        }
        if (target == nums[left]) {
            // 相等
            return left;
        }
        // 接下来说明就是不相等
        // 若索引位置是0，则说明target比数组中的元素都小，此时不存在，则返回-1
        return left == 0 ? -1 : left - 1;
    }
}

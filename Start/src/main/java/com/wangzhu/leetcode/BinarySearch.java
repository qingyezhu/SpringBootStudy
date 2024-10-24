package com.wangzhu.leetcode;

/**
 * 二分查找前提是数组是有序的<br/>
 * 以下写的代码，要求nums数组是升序的<br/>
 * Created by wangzhu on 2024/10/23 23:09.
 **/
public class BinarySearch {

    int[] searchRange0(int[] nums, int target) {
        final int firstIdx = binarySearchForFirstIdx(nums, target);
        if (firstIdx == -1) {
            return new int[]{-1, -1};
        }
        final int lastIdx = binarySearchForLastIdx(nums, target);
        return new int[]{firstIdx, lastIdx};
    }

    int[] searchRange1(int[] nums, int target) {
        final int firstIdx = binarySearch(nums, target);
        if (firstIdx == nums.length || target != nums[firstIdx]) {
            return new int[]{-1, -1};
        }
        // 当存在时，找比target大一点的数的位置index，那么target的最右边的索引必然是index-1
        final int lastIdx = binarySearch(nums, target + 1) - 1;
        return new int[]{firstIdx, lastIdx};
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            final int mid = (left + right) >>> 1; // 防止数据溢出 或者 left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 若没有找到，则left是target插入nums中的位置；若target大于nums中所有元素，此时left=nums.length
        return left;
    }

    /**
     * 查找target在nums数组中<font color=red>第一次</font>出现的位置<br/>
     *
     * @param nums
     * @param target
     * @return
     */
    int binarySearchForFirstIdx(int[] nums, int target) {
        final int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            final int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == len || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 查找target在nums数组中<font color=red>最后一次</font>出现的位置<br/>
     *
     * @param nums
     * @param target
     * @return
     */
    int binarySearchForLastIdx(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            final int mid = (left + right) >>> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right == -1 || nums[right] != target) {
            return -1;
        }
        return right;
    }


}

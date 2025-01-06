package com.wangzhu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wangzhu on 2024/12/5 12:50.
 **/
public class MyTwo {

    public static void main(String[] args) {
        print(handle(5, 5));
        print(handle(5, 6));
        print(handle(6, 6));
    }

    static int[][] handle(int row, int column) {
        final int[][] arr = new int[row][column];
        int left = 0, right = column - 1, top = 0, bottom = row - 1;
        int k = 1;

        while (left <= right && top <= bottom) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                arr[top][i] = k++;
            }
            top++;
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = k++;
            }
            right--;

            if (top <= bottom) {
                // 从右到左
                for (int i = right; i >= left; i--) {
                    arr[bottom][i] = k++;
                }
                bottom--;
            }

            if (left <= right) {
                // 从下到上
                for (int i = bottom; i >= top; i--) {
                    arr[i][left] = k++;
                }
                left++;
            }

        }

        return arr;
    }

    static void print(int[][] arr) {
        for (int i = 0, iLen = arr.length; i < iLen; i++) {
            for (int j = 0, jLen = arr[i].length; j < jLen; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.printf("%2d", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("----");
    }
}

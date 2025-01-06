package com.wangzhu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzhu on 2024/12/4 11:13.
 **/
public class My {

    public static void main(String[] args) {
        System.out.println(191037%65536);
        System.out.println(821697800%65536);
        System.out.println(Integer.toHexString(191037));
        System.out.println(Integer.toHexString(821697800));
        //System.out.println(reverse("hello world"));
//        System.out.println(reverseV2("hello world"));
//        System.out.println(findSub("abcdefcd", "cd"));
    }

    static String reverse(String str) {
        char[] ches = str.toCharArray();
        final int len = ches.length;
        char[] newches = new char[len];
        for (int i = 0; i < len; i++) {
            newches[i] = ches[len - i - 1];
        }
        return new String(newches);
    }

    static String reverseV2(String str) {
        final char[] ches = str.toCharArray();
        int left = 0, right = ches.length - 1;
        while (left < right) {
            swap(ches, left, right);
            left++;
            right--;
        }
        return new String(ches);
    }

    static void swap(char[] ches, int i, int j) {
        char tmp = ches[i];
        ches[i] = ches[j];
        ches[j] = tmp;
    }

    //abcdefcd cd

    static List<Integer> findSub(String parentStr, String subStr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0, pLen = parentStr.length(); i < pLen; i++) {

            int j = i, k = 0;
            while (j < pLen && k < subStr.length() && parentStr.charAt(j) == subStr.charAt(k)) {
                j++;
                k++;
            }
            if (k == subStr.length()) {
                list.add(i);
            }
        }
        return list;
    }
}

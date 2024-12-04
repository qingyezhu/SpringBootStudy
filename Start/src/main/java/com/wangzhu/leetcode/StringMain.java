package com.wangzhu.leetcode;


/**
 * Created by wangzhu on 2024/12/4 16:09.
 **/
public class StringMain {

    public static void main(String[] args) {
        System.out.println(reverse("hello world"));

        System.out.println(reverse("abcd", 2));
        System.out.println(reverse("abcdefgh", 2));
        System.out.println(reverse("abcdefg", 2));
        System.out.println(reverse("abcde", 2));
        System.out.println(reverse("abcdefg", 3));

        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("Mr Ding"));

        System.out.println(reverseWordsV1("the sky is blue"));
        System.out.println(reverseWordsV1("  hello world  "));
        System.out.println(reverseWordsV1("a good   example"));
    }


    static String reverse(String str) {
        // https://leetcode.cn/problems/reverse-string/description/
        // 反转字符串
        final char[] value = str.toCharArray();
        reverse(value, 0, value.length - 1);
        return new String(value);
    }

    static void reverse(char[] value, int start, int end) {
        while (start < end) {
            swap(value, start, end);
            start++;
            end--;
        }
    }

    static void swap(char[] value, int i, int j) {
        char tmp = value[i];
        value[i] = value[j];
        value[j] = tmp;
    }

    static String reverse(String str, int k) {
        // https://leetcode.cn/problems/reverse-string-ii/
        // 每2k字符对前k个进行反转
        // 若剩下不够2k个，则超过k个，则只对前k个进行反转
        // 若剩下不够k个，则全部反转

        final char[] value = str.toCharArray();
        final int len = value.length;

        final int step = k << 1;
        for (int i = 0; i < len; i += step) {
            reverse(value, i, Math.min(i + k, len) - 1);
        }
        return new String(value);
    }

    static String reverseWords(String str) {
        // https://leetcode.cn/problems/reverse-words-in-a-string-iii/
        // 反转句子中每个单词，整个句子不能反转
        // 至少包含一个单词，开头与结尾没有空格，所有单词用一个空格隔开
        return reverseWords(str.toCharArray());
    }

    static String reverseWords(char[] value) {
        final int len = value.length;
        int start = 0, end = 0;
        while (start < len) {
            while (end < len && !isBlank(value[end])) {
                end++;
            }
            reverse(value, start, end - 1);
            end++;
            start = end;
        }
        return new String(value);
    }

    static boolean isBlank(char ch) {
        return ch == ' ';
    }

    static String reverseWordsV1(String str) {
        // https://leetcode.cn/problems/reverse-words-in-a-string/description/
        // 整个句子反转，但是单个单词不能反转
        // 句子前后中间都可能有多个空格，并且句子中至少有一个单词
        final String tmpStr = trim(str);
        final char[] value = tmpStr.toCharArray();
        reverse(value, 0, value.length - 1);
        return reverseWords(value);
    }

    static String trim(String str) {
        final char[] value = str.toCharArray();
        int left = 0, right = value.length - 1;
        while (left < right && isBlank(value[left])) {
            left++;
        }
        while (left < right && isBlank(value[right])) {
            right--;
        }
        StringBuilder accum = new StringBuilder();
        for (int i = left; i <= right; i++) {
            char ch = value[i];
            if (!isBlank(ch) || !isBlank(accum.charAt(accum.length() - 1))) {
                accum.append(ch);
            }
        }
        return accum.toString();
    }
}

package com.wangzhu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangzhu on 2024/12/12 15:07.
 **/
public class MyFive {

    public static void main(String[] args) {
        handle("3[a]2[bc]");
        handle("3[a2[c]]");
        handle("2[abc]3[cd]ef");
        handle("abc3[cd]xyz");
    }

    static void handle(String str) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0, len = str.length(); i < len;) {
            char ch = str.charAt(i);

            if(isDigit(ch)){
                StringBuilder accum = new StringBuilder();
                while(i < len && isDigit(str.charAt(i))){
                    accum.append(ch);
                    i++;
                }
                linkedList.addLast(accum.toString());
                continue;
            }
            if(ch == ']'){
                List<String> list = new ArrayList<>();
                while(!linkedList.isEmpty() && !"[".equals(linkedList.getLast())){
                    list.add(linkedList.removeLast());
                }
                // [
                linkedList.removeLast();
                // 数字
                final int repeatNum = Integer.parseInt(linkedList.removeLast());

                StringBuilder accum = new StringBuilder();
                for(int j = 0, size = list.size();j < size;j ++){
                    accum.append(list.get(size - j  - 1));
                }
                final String repeatStr = accum.toString();

                StringBuilder newAccum = new StringBuilder();
                for(int j = 0; j < repeatNum;j ++){
                    newAccum.append(repeatStr);
                }
                linkedList.addLast(newAccum.toString());

                i++;
                continue;
            }
            linkedList.addLast(ch + "");
            i++;
        }
       // System.out.println(linkedList);

        StringBuilder accum = new StringBuilder();
        while(!linkedList.isEmpty()){
            accum.append(linkedList.removeFirst());
        }
        System.out.println(accum.toString());

    }

    static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    static boolean isLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}

package com.wangzhu.bitmap;

import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;

/**
 * Created by wangzhu on 2024/12/10 11:28.
 **/
public class RoaringBitmapTest {

    @Test
    public void testArrayContainer(){
        RoaringBitmap bitmap = buildArrayContainer();
        System.out.println(bitmap);
        for(int i = 0;i < 50;i ++){
            System.out.println(i + " " + bitmap.contains(i));
        }
    }

    RoaringBitmap buildArrayContainer(){
        return RoaringBitmap.bitmapOf(1,2,3,4,5,6,10,11,12,20,30,31,32,40);
    }

    @Test
    public void testRunContainer(){
        RoaringBitmap bitmap = buildRunContainer(10, 30);
        System.out.println(bitmap);
    }

    RoaringBitmap buildRunContainer(int min, int max){
        return RoaringBitmap.bitmapOfRange(min, max);
    }

    @Test
    public void testAnd(){
        RoaringBitmap aa = RoaringBitmap.bitmapOf();

        RoaringBitmap a = buildArrayContainer();
        RoaringBitmap b = buildRunContainer(20, 40);
        RoaringBitmap c = buildRunContainer(100, 110);
        System.out.println(a);
        System.out.println(b);

        //aa.or(a);
        aa.or(c);
        aa.or(b);

        System.out.println(aa);

        for(int i = 45;i < 50;i ++){
            aa.checkedAdd(i);
        }

        aa.checkedAdd(80);
        System.out.println(aa);
    }

}

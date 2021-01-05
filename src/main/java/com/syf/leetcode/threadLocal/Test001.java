package com.syf.leetcode.threadLocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName
 * @Author syf
 * @Date 2020/12/15
 * @Version
 */
public class Test001 {
    public static void main(String[] args) {
         ThreadLocal local = new ThreadLocal ();
        Random random = new Random ();
        IntStream.range ( 0,5 ).forEach ( a->new Thread (()->{
            local.set ( a+" "+random.nextInt (10) );
            System.out.println (local.get ());
            try {
                TimeUnit.SECONDS.sleep ( 1 );
            }catch (Exception e){
                e.printStackTrace ();
            }
        }).start ());
    }
}

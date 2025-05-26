package ru.jafix.ct;

public class Calculator {

    public static int plus(Integer a,Integer b){
        if(a==null || b==null){
            throw new IllegalArgumentException();
        }
        return a+b;
    }
    public static int minus(Integer a,Integer b){
        if(a==null || b==null){
            throw new IllegalArgumentException();
        }
        return a-b;
    }
    public static int multi(Integer a,Integer b){
        if(a==null || b==null){
            throw new IllegalArgumentException();
        }
        return a*b;
    }
    public static int devide(Integer a,Integer b){
        if(a==null || b==null){
            throw new IllegalArgumentException();
        }
        if(b==0){
            throw new ArithmeticException("На ноль делить нельзя");
        }
        return a/b;
    }
}

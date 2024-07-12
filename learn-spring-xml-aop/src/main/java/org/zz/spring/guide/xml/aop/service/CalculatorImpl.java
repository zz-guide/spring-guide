package org.zz.spring.guide.xml.aop.service;

public class CalculatorImpl implements Calculator {

    public CalculatorImpl(){
        System.out.println("=== CalculatorImpl 无参构造 ===");
    }

    @Override
    public int add(int i, int j) {
        int result = i+j;
        System.out.println("add result =" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i-j;
        System.out.println("add result =" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i*j;
        System.out.println("add result =" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i/j;
        System.out.println("add result =" + result);
        return result;
    }
}

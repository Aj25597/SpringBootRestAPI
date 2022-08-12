package com.example.springbootrestapi.models;

public class SumResponse {
    //3 props: Value1,Value2,Sum
    private int value1;
    private int value2;
    private int sum;

    public void setValue1(int value) {
        this.value1 = value;
    }

    public int getValue1() {
        return this.value1;

    }

    public void setValue2(int value) {
        this.value2 = value;   
    }

    public int getValue2() {
        return this.value2;
    }

    public void calculateSum() {
        this.sum = this.value1 + this.value2;
    }

    public int getSum() {
        return this.sum;
    }






}

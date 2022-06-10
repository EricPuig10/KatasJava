package katas;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private double total = 0.0;


    public double getTotal() {
        return this.total;
    }

    public void sum(double num) {
        total += num;
    }

    public void rest(double num) {
        total -= num;
    }

    public void mult(double num) {
        total *= num;
    }

    public void div(double num) {
        if (num == 0) {
            return;
        }
        total /= num;
    }

    public void residu(double num) {
        total %= num;
    }


    public boolean isPar(double num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }

    }

    public double older(double num, double num2) {
        if (num > num2) {
            return num;
        } else {
            return num2;
        }
    }

    public void sumArr(double[] Arr){
        double result = 0.0;
        for(double num : Arr) {
            result+=num;
        }
        total=result;
    }

    public List<Integer> returnEqualsOrGreaterThan5(List<Integer> list){
        List <Integer> resList = new ArrayList<>();
        for(int num : list){
            if(num >= 5.0){
                resList.add(num);
            }
        }
        return resList;
    }




}

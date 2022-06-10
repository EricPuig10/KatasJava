package katas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FizzBuzz {

    public String Fizz(double num) {
        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        }
        if (num % 5 == 0) {
            return "Buzz";
        }
        if (num % 3 == 0) {
            return "Fizz";
        } else return String.valueOf(num);
    }


    /*
    public List<String> Divisible(int [] numList, int num){
        int [] filteredArray = Arrays.stream(numList).filter( int x -> x.getNum(x%2==0)).collect(Collectors.toList());
        return filteredArray;
    }*/
/*
    public List<String> Divisible2(int [] numList, int num){
        Stream<String> divisible = Arrays.stream(numList).filter(f-> f.(f%2==0));
        List<String> listDivided = divisible.collect(Collectors.toList());
        return listDivided;
    }*/

    public List<Integer> Divisible(int[] numList, int num) {
        List<Integer> divList = new ArrayList<>();

        for (int i : numList) {
            if (i % num == 0) {
                divList.add(i);
            }
        }
        return divList;

    }


    public List<Users> OlderThan18(Users[] Users) {
        List<Users> older18 = new ArrayList<>();

        for (Users user : Users) {
            if (user.age >= 18) {
                older18.add(user);
            }
        }
        return older18;
    }


}






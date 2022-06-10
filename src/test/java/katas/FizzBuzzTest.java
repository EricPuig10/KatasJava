package katas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    public void returnsFizzOrBuzzOrFizzBuzz(){
    FizzBuzz fizzBuzz = new FizzBuzz();
    String result = fizzBuzz.Fizz(3);

        assertEquals("Fizz", result);
    }

    @Test
    public void returnsArrayWithAllNumsDividedForTheNumInTheParam(){
        FizzBuzz fizzBuzz = new FizzBuzz();

        int [] numList = {1,2,3,4,5,6,7,8,9,10};
        int num = 2;

        List <Integer> result = fizzBuzz.Divisible(numList, num);
        List <Integer> divList = new ArrayList<Integer>();

        divList.add(2);
        divList.add(4);
        divList.add(6);
        divList.add(8);
        divList.add(10);

        assertEquals(divList, result);
    }


    @Test
    public void receivesAnArrayOfUsersWithAgeAndNameAndReturnsUsersGreaterOrEqual18years(){
        FizzBuzz fizzBuzz = new FizzBuzz();

        Users [] user = new Users[3];

        user[0] = new Users(21,"Eric");
        user[1] = new Users(19,"Ari");
        user[2] = new Users(8,"Nuke");


        List<Users> result = fizzBuzz.OlderThan18(user);
        List<Users> older18 = new ArrayList<Users>();

        older18.add(user[0]);
        older18.add(user[1]);

        assertEquals(older18,result);



    }


}
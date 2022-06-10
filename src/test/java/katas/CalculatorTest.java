package katas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void calculatorStartsZero() {
        //GIVEN
        Calculator calculator = new Calculator();
        //WHEN
        double result = calculator.getTotal();
        //THEN
        assertEquals(0.0, result);
    }


    @Test
    public void calculatorSumsNumToTotal() {
        Calculator calculator = new Calculator();

        calculator.sum(5.0);

        double result = calculator.getTotal();

        assertEquals(5.0, result);

    }

    @Test
    public void calculatorRestsNumToTotal() {
        Calculator calculator = new Calculator();

        calculator.rest(1.0);

        double result = calculator.getTotal();

        assertEquals(-1.0, result);

    }

    @Test
    public void calculatorMultNumToTotal() {
        Calculator calculator = new Calculator();

        calculator.mult(2.0);

        double result = calculator.getTotal();

        assertEquals(0.0, result);

    }

    @Test
    public void calculatorDivNumToTotal() {
        Calculator calculator = new Calculator();


        calculator.sum(4.0);
        calculator.div(2.0);

        double result = calculator.getTotal();

        assertEquals(2.0, result);

    }

    @Test
    public void calculatorResidu() {
        Calculator calculator = new Calculator();


        calculator.sum(4.0);
        calculator.residu(3);

        double result = calculator.getTotal();
        assertEquals(1.0, result);

    }

    @Test
    public void calculatorIsPar() {
        Calculator calculator = new Calculator();


        boolean result = calculator.isPar(4.0);

        assertEquals(true, result);

    }

    @Test
    public void calculatorIsNumOlderThanNum2() {
        Calculator calculator = new Calculator();


        double result = calculator.older(4.0, 8.0);

        assertEquals(8.0, result);

    }

    @Test
    public void calculatorReturnsSumArr(){
        Calculator calculator = new Calculator();
        double[] doubleArr = new double [] {1,2,3,4};
        calculator.sumArr(doubleArr);
        double result = calculator.getTotal();
        assertEquals(10,result);
    }

    @Test
    public void calculatorReturnsNumbersGreaterOrEqualThan5ofList(){
        Calculator calculator = new Calculator();

        List<Integer> list = new ArrayList<Integer>();

        int [] listValues = {1,3,5,7,9,12};
        for(int value : listValues){
            list.add(value);
        }

        List <Integer> result = calculator.returnEqualsOrGreaterThan5(list);
        List <Integer> resList = new ArrayList<Integer>();
        resList.add(5);
        resList.add(7);
        resList.add(9);
        resList.add(12);

        assertEquals(resList,result);
    }





}
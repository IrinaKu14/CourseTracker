package ru.jafix.ct.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.jafix.ct.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    public void testPlusCorrect(){
        //Arenge
        Integer a = 10;
        Integer b = 15;
        Integer expected = 25;

        //Act
       Integer actual = Calculator.plus(a,b);

       //Assert
        assertEquals(expected, actual);

    }
    @Test
    public void testPlusANullException(){
        //Arenge
        Integer a = null;
        Integer b = 15;


        //Act
        Executable e = () -> Calculator.plus(a,b);

        //Assert
        assertThrows(IllegalArgumentException.class, e);

    }
}

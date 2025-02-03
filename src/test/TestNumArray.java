package src.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import src.main.NumArray;

import java.io.*;

public class TestNumArray {
  private int[] test1 = {5, 2, -1, 7, 9};
  private int[] test2 = {7, 6, 5, 4, -88};
  private int[] testNull = {};
  private int[] testNil = {};

   @Test
   public void testSumUp()
   {
     // action
    int test = NumArray.sumUp(test1);
     // assertion
     assertEquals(22, test);


   }

   @Test
   public void testUnderTen()
   {
     // action
     out = NumArray.underTen(null);

     // assertion
     assertEquals("Hello world!\n", bos.toString());

   }

   @Test
   public void testPrintArray()
   {
     PrintStream originalOut = System.out;
     ByteArrayOutputStream bos = new ByteArrayOutputStream();
     System.setOut(new PrintStream(bos));

     // action
     NumArray.sumUp(null);

     // assertion
     assertEquals("Hello world!\n", bos.toString());

     // undo the binding in System
     System.setOut(originalOut);
   }

}
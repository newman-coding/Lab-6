package src.test;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import src.main.NumArray;

import java.io.*;

@TestMethodOrder(MethodOrder.OrderAnnotation.class)
public class NumArrayTest {
  private int[] testArr = {5, 2, 1, 7, 9};
  //private int[] testNull = null;
  private int[] testNil = {0, 0, 0};
  private int[] testOne = {5};

  @Test
  @Order(0)
  @DisplayName("Test sumUp correctness") 
  public void testSumUp(){
    int[] t1 = {5, 2, 1, 7, 9};
    int[] t2 = {7, 6, -5, 4, -8};
    // action
    int test = NumArray.sumUp(t1);
    // assertion
    assertEquals(24, test);

    // action
    test = NumArray.sumUp(t2);
    // assertion
    assertEquals(4, test);

    // action
    test = NumArray.sumUp(testNil);
    // assertion
    assertEquals(0, test);

    // action
    test = NumArray.sumUp(testOne);
    // assertion
    assertEquals(5, test);

  }

  @Test
  @Order(1)
  @DisplayName("Test underTen correctness") 
  public void testUnderTen() {
    double[] t1 = {5.5, 2.0, 11.9, 10.1, 9.9};
    double[] t2 = {7.0, 6.0, -5.0, 4.0, -8.0};
    double[] t3 = {17.0, 62.3, 9.2, 10.0, -88.8, 1.0};
    double[] t4 = {10.5, 10.6, 10.7};
    // action
    int test = NumArray.underTen(t1);
    // assertion
    assertEquals(3, test);

    // action
    test = NumArray.underTen(t2);
    // assertion
    assertEquals(5, test);

    // action
    test = NumArray.underTen(t3);
    // assertion
    assertEquals(3, test);

    // action
    test = NumArray.underTen(t4);
    // assertion
    assertEquals(0, test);

  }

  @Test
  @Order(2)
  @DisplayName("Test scalarMult correctness") 
  public void testScalarMult(){
    int[] t1 = {5, 2, 1, 7, 9};
    int[] t2 = {7, 6, -5, 4, -8};

    // action
    int[] test = NumArray.scalarMult(t1, 1);
    int[] r1 = {5, 2, 1, 7, 9};
    // assertion
    assertArrayEquals(r1, test);

    // action
    test = NumArray.scalarMult(t1, 2);
    int[] r2 = {10, 4, 2, 14, 18};
    // assertion
    assertArrayEquals(r2, test);

    // action
    test = NumArray.scalarMult(t2, 3);
    int[] r3 = {21, 18, -15, 12, -24};
    // assertion
    assertArrayEquals(r3, test);

    // action
    test = NumArray.scalarMult(testOne, 5);
    int[] r4 = {25};
    // assertion
    assertArrayEquals(r4, test);

    // action
    test = NumArray.scalarMult(testNil, 5);
    int[] r5 = {0, 0, 0};
    // assertion
    assertArrayEquals(r5, test);

   }

  @Test
  @Order(3)
  @DisplayName("Test vectorAdd correctness") 
  public void testVectorAdd(){
    int[] t1 = {3, 4, 5};
    int[] t2 = {6, 3, 0};
    // action
    int[] test = NumArray.vectorAdd(t1, t2);
    int[] r1 = {9, 7, 5};
    // assertion
    assertArrayEquals(r1, test);

    // action
    test = NumArray.vectorAdd(t2, t1);
    // assertion
    assertArrayEquals(r1, test);

    // EDGE CASE: set output binding
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // action
    test = NumArray.vectorAdd(t1, testArr);
    int[] r2 = {0};
    // assertion
    assertNotNull(bos.toString());
    assertArrayEquals(r2, test);

    // UNDO output binding in System
    System.setOut(originalOut);

    // action
    test = NumArray.vectorAdd(testOne, testOne);
    int[] r3 = {10};
    // assertion
    assertArrayEquals(r3, test);

    // action
    test = NumArray.vectorAdd(testNil, t2);
    int[] r4 = {6, 3, 0};
    // assertion
    assertArrayEquals(r4, test);
  }

  @Test
  @Order(4)
  @DisplayName("Test dotProduct correctness") 
  public void testDotProduct(){
    int[] t1 = {2, 3, 5};
    int[] t2 = {6, 4, 1};
    int[] t3 = {2, 2, 2};
    int[] t4 = {-1, 1, 0};
    // action
    int test = NumArray.dotProduct(t1, t2);
    // assertion
    assertEquals(29, test);

    // action
    test = NumArray.dotProduct(t2, t1);
    // assertion
    assertEquals(29, test);

    // action
    test = NumArray.dotProduct(t1, t3);
    // assertion
    assertEquals(20, test);

    // action
    test = NumArray.dotProduct(t4, t3);
    // assertion
    assertEquals(0, test);

    // EDGE CASE: set output binding
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // action
    test = NumArray.dotProduct(testArr, t1);
    // assertion
    assertNotNull(bos.toString());
    assertEquals(Integer.MIN_VALUE, test);

    // UNDO output binding in System
    System.setOut(originalOut);

    // action
    test = NumArray.dotProduct(testOne, testOne);
    // assertion
    assertEquals(25, test);

    // action
    test = NumArray.dotProduct(testNil, t2);
    // assertion
    assertEquals(0, test);

   }
   @Test
   @Order(5)
  @DisplayName("Test minArray correctness") 
   public void testMinArray()
   {
    int[] t1 = {2, 3, 5};
    int[] t2 = {6, 4, 1};
    int[] t3 = {2, 2, 2};
    int[] t4 = {-1, 1, 0};
    // action
    int test = NumArray.minArray(t1);
    // assertion
    assertEquals(2, test);

    // action
    test = NumArray.minArray(t2);
    // assertion
    assertEquals(1, test);

    // action
    test = NumArray.minArray(t3);
    // assertion
    assertEquals(2, test);

    // action
    test = NumArray.minArray(t4);
    // assertion
    assertEquals(-1, test);

    // action
    test = NumArray.minArray(testOne);
    // assertion
    assertEquals(5, test);

    // action
    test = NumArray.minArray(testNil);
    // assertion
    assertEquals(0, test);

  }

  @Test
  @Order(6)
  @DisplayName("Test maxArray correctness") 
  public void testMaxArray(){
    int[] t1 = {2, 3, 5};
    int[] t2 = {6, 4, 1};
    int[] t3 = {2, 2, 2};
    int[] t4 = {-1, 1, 0};
    // action
    int test = NumArray.maxArray(t1);
    // assertion
    assertEquals(5, test);

    // action
    test = NumArray.maxArray(t2);
    // assertion
    assertEquals(6, test);

    // action
    test = NumArray.maxArray(t3);
    // assertion
    assertEquals(2, test);

    // action
    test = NumArray.maxArray(t4);
    // assertion
    assertEquals(1, test);

    // action
    test = NumArray.maxArray(testOne);
    // assertion
    assertEquals(5, test);

    // action
    test = NumArray.maxArray(testNil);
    // assertion
    assertEquals(0, test);
  }
   
  @Test
  @Order(7)
  @DisplayName("Test sumUp correctness") 
  public void testRandomEntry(){

  }

  @Test
  @Order(8)
  @DisplayName("Test sumUp correctness") 
  public void testSubArray(){
    int[] t1 = {2, 3, 5, 7, 9};
    int[] t2 = {0, 1, 1, 2, 3, 5, 8};
    int[] t3 = {2, 2, 2, 2, 2};
    int[] t4 = {-1, 1, 0, 2, 4, 6};
    // action
    int[] test = NumArray.subArray(t1, 0, 3);
    int[] r1 = {2, 3, 5};
    // assertion
    assertArrayEquals(r1, test);

    // action
    test = NumArray.subArray(t2, 2, t.length - 1);
    int[] r2 = {1, 2, 3, 5, 8};
    // assertion
    assertEquals(r2, test);

    // action
    test = NumArray.subArray(t2, 2, 5);
    int[] r3 = {1, 2, 3};
    // assertion
    assertEquals(r3, test);

    // action
    test = NumArray.subArray(t1, 0, 1);
    int[] r4 = {2};
    // assertion
    assertEquals(r4, test);

  }

}
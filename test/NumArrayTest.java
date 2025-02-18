import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    assertThat(test).isEqualTo(24);

    // action
    test = NumArray.sumUp(t2);
    // assertion
    assertThat(test == 4).isTrue();

    // action
    test = NumArray.sumUp(testNil);
    // assertion
    assertThat(test == 0).isTrue();;

    // action
    test = NumArray.sumUp(testOne);
    // assertion
    assertThat(test == 5).isTrue();;

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
    assertThat(test == 3).isTrue();

    // action
    test = NumArray.underTen(t2);
    // assertion
    assertThat(test == 5).isTrue();

    // action
    test = NumArray.underTen(t3);
    // assertion
    assertThat(test == 3).isTrue();

    // action
    test = NumArray.underTen(t4);
    // assertion
    assertThat(test == 0).isTrue();

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
    assertThat(check(r1, test)).isTrue();

    // action
    test = NumArray.scalarMult(t1, 2);
    int[] r2 = {10, 4, 2, 14, 18};
    // assertion
    assertThat(check(r2, test)).isTrue();

    // action
    test = NumArray.scalarMult(t2, 3);
    int[] r3 = {21, 18, -15, 12, -24};
    // assertion
    assertThat(check(r3, test)).isTrue();

    // action
    test = NumArray.scalarMult(testOne, 5);
    int[] r4 = {25};
    // assertion
    assertThat(check(r4, test)).isTrue();

    // action
    test = NumArray.scalarMult(testNil, 5);
    int[] r5 = {0, 0, 0};
    // assertion
    assertThat(check(test, r5)).isTrue();

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
    assertThat(check(r1, test)).isTrue();

    // action
    test = NumArray.vectorAdd(t2, t1);
    // assertion
    assertThat(check(r1, test)).isTrue();

    // EDGE CASE: set output binding
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // action
    test = NumArray.vectorAdd(t1, testArr);
    int[] r2 = {0};
    // assertion
    assertThat(bos.toString()).isNotNull();
    assertThat(check(r2, test)).isTrue();


    // UNDO output binding in System
    System.setOut(originalOut);

    // action
    test = NumArray.vectorAdd(testOne, testOne);
    int[] r3 = {10};
    // assertion
    assertThat(check(r3, test)).isTrue();

    // action
    test = NumArray.vectorAdd(testNil, t2);
    int[] r4 = {6, 3, 0};
    // assertion
    assertThat(check(r4, test)).isTrue();
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
    assertThat(test == 29).isTrue();

    // action
    test = NumArray.dotProduct(t2, t1);
    // assertion
    assertThat(test == 29).isTrue();

    // action
    test = NumArray.dotProduct(t1, t3);
    // assertion
    assertThat(test == 20).isTrue();

    // action
    test = NumArray.dotProduct(t4, t3);
    // assertion
    assertThat(test == 0).isTrue();

    // EDGE CASE: set output binding
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // action
    test = NumArray.dotProduct(testArr, t1);
    // assertion
    assertThat(bos.toString()).isNotNull();
    assertThat(test).isEqualTo(Integer.MIN_VALUE);

    // UNDO output binding in System
    System.setOut(originalOut);

    // action
    test = NumArray.dotProduct(testOne, testOne);
    // assertion
    assertThat(test == 25).isTrue();

    // action
    test = NumArray.dotProduct(testNil, t2);
    // assertion
    assertThat(test == 0).isTrue();

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
    assertThat(test == 2).isTrue();

    // action
    test = NumArray.minArray(t2);
    // assertion
    assertThat(test == 1).isTrue();

    // action
    test = NumArray.minArray(t3);
    // assertion
    assertThat(test == 2).isTrue();

    // action
    test = NumArray.minArray(t4);
    // assertion
    assertThat(test == -1).isTrue();

    // action
    test = NumArray.minArray(testOne);
    // assertion
    assertThat(test == 5).isTrue();

    // action
    test = NumArray.minArray(testNil);
    // assertion
    assertThat(test == 0).isTrue();

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
    assertThat(test == 5).isTrue();

    // action
    test = NumArray.maxArray(t2);
    // assertion
    assertThat(test == 6).isTrue();

    // action
    test = NumArray.maxArray(t3);
    // assertion
    assertThat(test == 2).isTrue();

    // action
    test = NumArray.maxArray(t4);
    // assertion
    assertThat(test == 1).isTrue();

    // action
    test = NumArray.maxArray(testOne);
    // assertion
    assertThat(test == 5).isTrue();

    // action
    test = NumArray.maxArray(testNil);
    // assertion
    assertThat(test == 0).isTrue();
  }
   
  @Test
  @Order(7)
  @DisplayName("Test randomEntry correctness") 
  public void testRandomEntry(){

  }

  @Test
  @Order(8)
  @DisplayName("Test subArray correctness") 
  public void testSubArray(){
    int[] t1 = {2, 3, 5, 7, 9};
    int[] t2 = {0, 1, 1, 2, 3, 5, 8};

    // action
    int[] test = NumArray.subArray(t1, 0, 3);
    int[] r1 = {2, 3, 5};
    // assertion
    assertThat(check(r1, test)).isTrue();

    // action
    test = NumArray.subArray(t2, 2, t2.length);
    int[] r2 = {1, 2, 3, 5, 8};
    // assertion
    assertThat(check(r2, test)).isTrue();

    // action
    test = NumArray.subArray(t2, 2, 5);
    int[] r3 = {1, 2, 3};
    // assertion
    assertThat(check(r3, test)).isTrue();

    // action
    test = NumArray.subArray(t1, 0, 1);
    int[] r4 = {2};
    // assertion
    assertThat(check(r4, test)).isTrue();

  }

  public static boolean check(int[] expected, int[] actual) {
    if(actual == null) {
        System.out.format("Your \"actual\" array is null. Have you implemented the method you are testing?\n\n");
        return false;
    }
    if (expected.length != actual.length) {
        System.out.format("Array length did not match expected length:\n"
                + "      Expected: %d\n"
                + "      Got: %d\n",
                expected.length, actual.length);
        return false;
    }
    for (int k = 0; k < expected.length; k++) {
        if (expected[k] != actual[k]) {
            System.out.format("Array contents different at index %d:\n"
                    + "    Expected: %d\n"
                    + "    Got: %d\n",
                    k, expected[k], actual[k]);
            return false;
        }
    }
    return true;
  }

}
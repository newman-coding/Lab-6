import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringArrayTest {

    @Test
    @Order(0)
    @DisplayName("Test capsLock correctness")
    public void testCapsLock() {
        String[] s1 = {"hello", "world", "It's me!", "Mario"};
        String[] r1 = {"HELLO", "WORLD", "IT'S ME!", "MARIO"};
        // action
        String[] test = StringArray.capsLock(s1);
        // assertion
        assertThat(test).isNotNull();
        assertThat(test.length).isEqualTo(4);
        assertThat(check(r1, test)).isTrue();
    }

    @Test
    @Order(1)
    @DisplayName("Test allEqual correctness")
    public void testAllEqual() //in: two str arrays, same shape; out: bool, if all elements String.equal, catch: diff shape - return false
    {
        String[] s1 = {"hello", "world", "It's me!", "Mario"};
        String[] s4 = {"hello", "world", "It's me!", "Mario"};
        String[] s2 = {"hello", "world", "It's me!", "Luigi"};
        String[] s3 = {"Bahahahaha!", "It's Wario!!!"};
        //action / assertion
        assertThat(StringArray.allEqual(s1, s4)).isTrue();
        assertThat(StringArray.allEqual(s1, s3)).isFalse();
        assertThat(StringArray.allEqual(s1, s2)).isFalse();

    }

    @Test
    @Order(2)
    @DisplayName("Test swap correctness")
    public void testSwap() //in: str array, i1, i2; out: str array w/ new[i1] = str[12]; new[i2] = str[i1]
    {
        String[] s1 = {"hello", "world", "It's me!", "Mario"};
        String[] r1 = {"hello", "Mario", "It's me!", "world"};

        //action
        String[] test = StringArray.swap(s1, 1, 3);
        //assertion
        assertThat(check(r1, test)).isTrue();

        //action
        test = StringArray.swap(s1, 3, 1);
        //assertion
        assertThat(check(r1, test)).isTrue();

        String[] s2 = {"hello", "world"};
        String[] r2 = {"hello", "world"};
        String[] r3 = {"world", "hello"};

        //action
        test = StringArray.swap(s1, 1, 1);
        //assertion
        assertThat(check(r2, test)).isTrue();

        //action
        test = StringArray.swap(s1, 0, 1);
        //assertion
        assertThat(check(r3, test)).isTrue();

    }

    @Test
    @Order(3)
    @DisplayName("Test reverse correctness")
    public void testReverse() //in: str array; out: str array w/ order reversed
    {
        String[] s1 = {"hello", "world", "It's me!", "Mario"};
        String[] r1 = {"Mario", "It's me!", "world", "hello"};

        //action
        String[] test = StringArray.reverse(s1);
        //assertion
        assertThat(check(r1, test)).isTrue();

        String[] s2 = {"It's me!", "Luigi"};
        String[] r2 = {"Luigi", "It's me!"};

        //action
        test = StringArray.reverse(s2);
        //assertion
        assertThat(check(r2, test)).isTrue();

        String[] s3 = {"edge case"};
        String[] r3 = {"edge case"};

        //action
        test = StringArray.reverse(s3);
        //assertion
        assertThat(check(r3, test)).isTrue();

    }

    @Test
    @Order(4)
    @DisplayName("Test combineAll correctness")
    public void testCombineAll() //in: str array; out: str concat of all elements
    {
        String[] s1 = {"hello", "world", "It's me!", "Mario"};
        String r1 = "helloworldIt's me!Mario";

        //action
        String test = StringArray.combineAll(s1);
        //assertion
        assertThat(test).isEqualTo(r1);

        String[] s2 = {"good", "bye"};
        String r2 = "goodbye";

        //action
        test = StringArray.combineAll(s2);
        //assertion
        assertThat(test).isEqualTo(r2);

        String[] s3 = {"good"};
        String r3 = "good";

        //action
        test = StringArray.combineAll(s3);
        //assertion
        assertThat(test).isEqualTo(r3);

    }
    
    @Test
    @Order(5)
    @DisplayName("Test searchString correctness")
    public void testSearchString() //in: str array, str; out: prints all elements w/ str as substring and returns num results
    {
        // set output binding
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        String[] s1 = {"while", "actress", "silken", "triple", "track", "ill", "bobble"};

        // action
        int test = StringArray.searchString(s1, "il");
        
        // assertion
        assertThat(bos.toString()).isEqualTo("while\nsilken\nill\n");
        assertThat(test).equals(3);

        // clear output stream
        bos.reset();

        // action
        test = StringArray.searchString(s1, "tr");
        
        // assertion
        assertThat(bos.toString()).isEqualTo("actress\ntriple\ntrack\n");
        assertThat(test).equals(3);
        
        // clear output stream
        bos.reset();

        // action
        test = StringArray.searchString(s1, "zzz");
        
        // assertion
        assertThat(test).equals(0);

        // UNDO output binding in System
        System.setOut(originalOut);

    }
    
    @Test
    @Order(6)
    @DisplayName("Test longest correctness")
    public void testLongest() //in: str array; out: longest str
    {
        String[] names = {"annie oakley", "creola katherine johnson", "david lynch"};
        //action
        String test = StringArray.longest(names);
        //assertion
        assertThat(test).isEqualTo("creola katherine johnson");

        String[] str2 = {"kid,", "mother", "father"};
        test = StringArray.longest(str2);
        assertThat(test).isEqualTo("mother");
    }

    public static boolean check(String[] expected, String[] actual) {
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
            if (!expected[k].equals(actual[k])) {
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

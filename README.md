# Lab-6

Use the starter code provided to complete the following Java classes and their methods. ALL of the following methods should be **NON-DESTRUCTIVE** unless otherwise noted.

## Part One - NumArray: 
This class will have a set of methods dealing with arrays of numbers--ints and doubles. Please write the following methods:

1. int sumUp(int[] arr) – this method should take an array of ints (int[]) and return an int. The return value represents the sum of all of the elements in the array.
  ```java
  int[] a = {2,3,5};
  sumUp(a); // should return 10.
  ```
2. int underTen(double[] arr) - this method should take an array of doubles and return an int. The returned int represents how many doubles there are that are less than 10.
  ```java
  double[] b = {4.2, 11.12, -23.0, 60.0};
  underTen(b) // should return 2, because 4.2 and -23.0 are the only 2 elements less than 10.
  ```
3. int[] scalarMult(int[] arr, int scalar) – this function should take an array of ints and an int (in that order), and then multiply each element in the array by the int and return that array of ints. In terms of vectors, this is called scalar multiplication.
  ```java
  int[] c = {2,3,5};
  scalarMult(c,3) // should return {6,9,15}, because 2*3=6, 3*3=9, 5*3=15 <p>
  scalarMult(c,2) // should return {4,6,10}
  ```
4. int[] vectorAdd(int[] arr1, int[] arr2) – this function should input 2 arrays of ints (int[]), and then add the values  together and return their sum (another array of ints). To add two vectors of the same length, add the individual elements at each index together, so {2,3,4} + {-4,5,0} = {-2,8,4}. If the two vectors have **DIFFERENT** lengths, your function should print a mean message to the user, then create and return an array of length 1 where the only element has a value of 0 (_without_ causing a runtime error).
  ```java
  int[] d1 = {1,2,3}; 
  int[] d2 = {4,-1,6};
  vectorAdd(d1, d2) // should return {5, 1, 9}
  ```
5. int dotProduct(int[] arr1, int[] arr2) – this function should input two arrays of ints, and return an int that represents the dot product of the arrays. The dot product is calculated like so: **multiply** the individual elements at each index together, _then_ **add** all the products together. So {3,2,0} (dot) {4,-1,-1} = 3*4 + 2*-1 + 0*-1 = 10. If the two vectors have **DIFFERENT lengths** (in which case it is impossible to take the dot product), your function should print a mean message then **return Integer.MIN_VALUE**.
  ```java
  int[] d1 = {1,2,3}; 
  int[] d2 = {4,-1,6}; 
  // 1*4 + 2*(-1) + 3*6 = 11 
  dotProduct(d1, d2) // should return 11
  ```
6. int minArray(int[] arr) – this function should input an array of integers and return an integer which represents the SMALLEST value in the array.
  ```java
  int[] e = {3,2,4};
  minArray(e) // should return 2.
  ```
7. int maxArray(int[] arr) - this function should input an array of integers and return an integer which represents the LARGEST value in the array.
  ```java
  int[] e = {3,2,4};
  minArray(e) //should return 4.
  ```
8. int randomEntry(int[] arr) - this method will input an array of ints and return a random int from that array. It should be different each time. So if the input is {4,66,23,-43} this method should randomly choose one of the array's indices and return 4, 66, 23, or -43. Make sure to test this code several times to make sure that it returns different values and never causes an out of bounds error! <p>
  Hint: Math.random()

9. int[] subArray(int[] nums, int start, int end) - this method is like substring, but for arrays. It should return an array of ints. You should create and return a smaller array consisting of all the elements of the array nums between start (inclusive) and end (exclusive).
```java
int[] nums = {6,2,3,45,-1,0};
subArray(nums,2,5) // should return {3,45,-1}.
```
  Hint: as you iterate through, you will need separate variables for the indices in your new array.

Optional Extra Credit: <p>
10. int[] negEntries(int[] arr) – this function should input an array of integers and return an integer array of just the negative integers in the same order. For instance, if the input is {4,6,-3,-4,0,9,4,-2} and it should return the array {-3,-4,-2}. <p>

 (Hint: first try to determine the size of the array you will return)



## Part Two - StringArray:
This class will have a bunch of methods dealing with arrays of Strings. Please write the following methods:

1. String[] capsLock(String[] a) – this method should input an array of Strings, and return an array of Strings consisting of the same strings, only in uppercase. Hint: .toUpperCase(). So if you send {"happy", "sad", "Bob"}, it should return {"HAPPY", "SAD", "BOB"}.


2. boolean allEqual(String[] b1, String[] b2) – this function should input two arrays of Strings and return a boolean that is true if the two arrays have exactly identical entries (in the same order), and false if not. If the arrays have different sizes, this should automatically return false and not cause a runtime error. Remember to use .equals() to compare Strings.


3. String[] swap(String[] words, int spot1, int spot2) - this method inputs an array of Strings and 2 ints (in that order), then switches the elements in spot1 and spot2 and returns an array of Strings. It should not change any other elements. Remember, this method should be NON-DESTRUCTIVE.
So if you call swap({"bob","jim","al", "joe","sam"},1,3), it swaps the elements in spot 1 and spot 3 and returns the array {"bob","joe","al", "jim","sam"}. I should get the same result if I switch the order of 1 and 3 and called swap({"bob","jim","al", "joe","sam"},3,1). 


4. String[] reverse(String[] d) – this method should input an array of Strings, and return an array of Strings that is identical to the input, only in reverse order. Remember, this method should be NON-DESTRUCTIVE.
 For instance, if you send {"happy", "sad", "bored"}, the method should return {"bored","sad","happy"}.

  Hint: make 2 int variables to keep track of where you are in each array


5. String combineAll(String[] e) - this method should input an array of Strings and return a String. The string it returns should be the concatenation of all the Strings in the input. So if I call combineAll( {"yes", "hello there", "class"}) your method should return the String "yeshello thereclass"


6. int searchString(String[] terms, String search) – this method should input an array of Strings and a string, and it should return an int. The method should print out each string from the array which contains the second String as a substring, and then return the number of Strings which contain the substring (so the inputs are a String[] and a String, and it outputs an int). For instance if you send the function the array {"happy", "ap computer science", "bop"} and the String "ap", your program should print out:
```java
happy
ap computer science

//Then it should return 2, since there were 2 results found
```
  Hint: String method .indexOf( ).


7. String longest(String[] g) - this method should input an array of Strings and then return the String with the longest length (in case of a tie, you should return the first one). So if I call longest({"annie oakley", "creola katherine johnson", "david lynch"}), this method should return "creola katherine johnson".

  Hint: it may be useful to find the location of the longest String first. 


Optional Extra Credit:
8. countLetter(String[] h) – this method should input an array of Strings and a String (which you can assume will just be one letter), and then return an integer which counts how many times total the letter appears in all of the Strings. For example, if you send countLetter {"happy", "ap computer science", "bop"} and the letter "p", this should return 5 since there are 5 p’s in all of the strings.

(Hint: you may need a helper method or a nested for loop here.)


When you're happy with your code, commit with the message "Lab 6 Submission" and push to GitHub.

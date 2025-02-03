# Lab-6
FOR SUBMITTING THIS WEEK: Once I have graded your method labs, make sure all previous labs are removed from your named folder in google drive (including your old files, save those elsewhere). The only files in your named folder should be NumArray.java and StringArray.java.

ANOTHER WARNING: If you have any typos in method/class names or wrong inputs/outputs or your program does not compile for any reason, you may get a zero. Please follow my directions carefully!

Video version of this lesson can be seen here: https://www.youtube.com/watch?v=_MZscIwB5Iw and https://www.youtube.com/watch?v=fg53t7NISpE 

All labs are due on Monday, October 2 by 12pm (noon). 

 

1. Create a class named NumArray (as always please make sure to spell this and any method names exactly the same as I have done, including capitalization). This class will have a bunch of methods dealing with arrays of numbers. Please write the following methods (MAKE ALL METHODS STATIC):


(fun fact: an array of integers/doubles is basically the same thing as a vector, broken down into components. Some of this lab will deal with operations on these vectors.)

a. sumUp – this function (another word for a method) should input an array of ints (int[]) and return an integer that is the sum of all of the elements in the array. So if a is the array representing {2,3,5}, sumUp(a) should return 10.


b. underTen - this method should input an array of doubles and return an int. That int represents how many doubles there are that are less than 10. So if you send this method the array {4.2, 11.12, -23, 60}, this method should return 2 as there are two numbers less than 10 in that array.


c. scalarMult – this function should input an array of ints and an int (in that order), and then multiply each element in the array by the int and return that array of ints. So for example, scalarMult({2,3,5},3) will multiply each element by 3 and return {6,9,15}. In terms of vectors, this is called scalar multiplication.


d. vectorAdd – this function should input 2 arrays of ints (int[]), and then add them together and return their sum (another array of ints). To add two vectors of the same length, add the individual components, so {2,3,4} + {-4,5,0} = {-2,8,4}. If the two vectors have DIFFERENT lengths, your function should print a mean message then create and return an array of length 1 where the only element has a value of 0 (without causing a runtime error).

 

e. vectorSubtract [note that there is only one s in the word 'subtract'] - this function should input 2 arrays of ints (int[]), and then subtract them and return the difference (another array of ints). To subtract two vectors of the same length, subtract the individual components, so {2,3,4} - {-4,5,0} = {6,-2,4}. If the two vectors have DIFFERENT lengths, your function should print a mean message then create and return an array of length 1 where the only element has a value of 0.

 

f. dotProduct – this function should input two arrays of ints, and return an int that represents the dot product of the arrays. The dot product is calculated like so: multiply the first entries, multiply the second entries, multiply the third, etc., then add all the products together. So {3,2,0} (dot) {4,-1,-1} = 3*4 + 2*-1 + 0*-1 = 10. If the two vectors have DIFFERENT lengths (in which case it is impossible to take the dot product), your function should print a mean message then return Integer.MIN_VALUE.

 

g. minArray – this function should input an array of integers and return an integer which represents the SMALLEST value in the array. Take a look back at ForMaxMin if you forgot how to do this. So minArray({3,2,4}) should return 2.

 

h. maxArray - this function should input an array of integers and return an integer which represents the LARGEST value in the array. So maxArray({3,2,4}) should return 4.


i. printArray – this void function should input an array of integers and print out the array (as you may recall, printing a whole array prints out the memory location. This method provides a way to print it out in a more useful way). Using System.out.print() statements on the individual elements of the array, you may do this however you want.  (you can use the + command to concatenate) For example, you may have it print out in the normal {2,3,4,5} format or anything else you like. This function is void so it shouldn’t return anything.


j. randomEntry - this method will input an array of ints and return a random int from that array. It should be different each time. So if the input is {4,66,23,-43} this method should randomly choose one of these spots and return 4,66,23, or -43. This is very similar to how you picked a random character from a String. Make sure to test this code several times to make sure that it returns different values and never causes an out of bounds error!


k. subArray(int[] nums, int start, int end) - this method, which returns an array of ints, is like substring but for arrays. It should return an array of ints. You should create and then return a smaller array consisting of all the elements of the array nums between start and end, NOT including end. So, if you have nums = {6,2,3,45,-1,0} and you call subArray(nums,2,5) it should return an array containing elements 2 through 4, in this case, the array {3,45,-1}. 

HINT: as you go through, you will need separate variables for the locations in your new array as well as nums since the numbers are in different locations.

Dont worry if start and/or end will lead to an out of bounds error, I will not test this case.

 

(DOOZIE ALERT)

L. negEntries – this function should input an array of integers and return an integer array of just the negative integers in the same order. For instance, if the input is {4,6,-3,-4,0,9,4,-2} and it should return the array {-3,-4,-2}.


 (hint - first try to determine the size of the array you will return then make a new array to return)




2. Create a class named StringArray (as always please make sure to spell this and any method names exactly the same as I have done). This class will have a bunch of methods dealing with arrays of Strings. Please write the following methods:


a. capsLock – this method should input an array of Strings, and return an array of Strings consisting of the same strings, only in uppercase. Remember .toUpperCase(). So if you send {"happy", "sad", "bob"}, it should return {"HAPPY", 'SAD", "BOB"}.


b. allEqual – this function should input two arrays of Strings and return a boolean that is true if the two arrays have exactly identical entries (in the same order) and false if not. If the arrays have different sizes, this should automatically return false and not cause a runtime error. Remember to use .equals() to compare Strings


c. swap(String[] words, int spot1, int spot2) - this method inputs an array of Strings and 2 ints (in that order), then switches the elements in spot1 and spot2 (do this carefully) and returns an array of Strings. It should not change any other elements. So if you call swap({"bob","jim","al", "joe","sam"},1,3), it swaps the elements in spot 1 and spot 3 and returns the array {"bob","joe","al", "jim","sam"}. I should get the same result if I switch the order of 1 and 3 and called swap({"bob","jim","al", "joe","sam"},3,1). Dont worry if spot1 and/or spot2 will lead to an out of bounds error, I will not test this.


d. reverse – this method should input an array of Strings, and return an array of Strings that is identical to the input, only in reverse order. For instance, if you send {"happy", "sad", "bob"}, the method should return {"bob","sad","happy"}.

 

(hint: make 2 int variables which will each keep track of where you are in both arrays)


e. comboAll - this method should input an array of Strings and return a String. The string it returns should be the concatenation (use plus) of all the Strings in the input. So if I call comboAll( {"yes", "hello there", "class"}) your method should return the String "yeshello thereclass"


f. searchString(String[] terms, String search) – this method should input an array of Strings and a string, and it should return an int. The method should println out each string from the array which contains the second String as a substring, and then return the number of Strings which contain the substring (so the inputs are a String[] and a String, and it outputs an int). For instance if you send the function the array {"happy", "ap computer science", "bop"} and the String "ap", your program should print out:

happy

ap computer science

[and then it should return 2 since there were 2 results found.]

You probably want to use .indexOf( ).


[This almost sounds like how a search engine works…]


g. longest - this method should input an array of Strings and then return the String with the longest length (in case of a tie, you can return either one). So if I call longest({"seahawks", "richard sherman", "lynch"}), this method should return "richard sherman".

Hint: it may be useful to find the location of the longest String first... 


h. countLetter – this method should input an array of Strings and a String (which you can assume will just be one letter), and then return an integer which counts how many times total the letter appears in all of the Strings. For example, if you send countLetter {"happy", "ap computer science", "bop"} and the letter "p", this should return 5 since there are 5 p’s in all of the strings.

 

(you may need a nested for loop here. You could also write a second method and call that. Or you could do something else, there are lots of possible solutions)


Submit NumArray.java and StringArray.java



EXTRA CREDIT: Done early? Try these on codingbat.com

->go to the array-3 subsection on java

->Try exercises: linearIn and/or fix34

As always, email me (and share with me under preferences) if you do some/all of the extra credit.

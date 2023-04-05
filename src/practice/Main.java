package practice;

// An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

// Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

// Example 1:
// Input: low = 100, high = 300
// Output: [123,234]
// Example 2:
// Input: low = 1000, high = 13000
// Output: [1234,2345,3456,4567,5678,6789,12345]

// Constraints:
// 10 <= low <= high <= 10^9

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int low = 100, high = 13000;
        List<Integer> list = sequentialDigits(low, high);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> result = new ArrayList<>();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int i = lowLen; i <= highLen; i++) {
            for (int j = 0; j < 10 - i; j++) {
                int num = Integer.parseInt(digits.substring(j, j + i));
                if (num >= low && num <= high) result.add(num);
            }
        }
        return result;
    }
}

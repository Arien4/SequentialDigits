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
        List<Integer> result = new ArrayList<>();
        int i = low;
        while (i <= high) {

            int prevRest = i % 10;
            while (prevRest == 0 || prevRest < (int) (Math.log10(prevRest) + 1)) {i++; break;}
            int temp = i / 10;

            int rest;
            boolean seqI = true;
            while (temp > 0) {
                rest = temp % 10;

                if (prevRest - rest != 1) {
                    seqI = false;
                    break;
                }
                temp = temp / 10;
                prevRest = rest;

            }
            if (seqI) result.add(i);
            i++;
        }
        return result;
    }
}

package SlidingWinfows;

//Longest Substring Without Repeating Characters
//Given a string s, find the length of the longest substring without duplicate characters.
//
//A substring is a contiguous sequence of characters within a string.

//Input: s = "zxyzxyz"
//
//Output: 3


//Input: s = "xxxx"
//
//Output: 1


import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicatedChars {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;
        for(int end=0;end<s.length();end++)
        {
            var currChar = s.charAt(end);
            while(set.contains(currChar))
            {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(currChar);
            max= Math.max(max, end-start+1);
        }
        return max;
    }

}

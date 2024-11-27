package ArraysHashing;


//Group Anagrams
//Solved
//Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
//
//An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

//Input: strs = ["act","pots","tops","cat","stop","hat"]
//
//Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Caka string kada je srotiran daje nagram u ulazu u mapi
// Genijalna fora !

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        // GO threw Strings
        // Make a hash map for individual string
        HashMap<String, List<String>> mapOfSortedStr = new HashMap<>();
        for(String str:strs)
        {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            mapOfSortedStr.computeIfAbsent(sortedString, k-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(mapOfSortedStr.values());
    }
}

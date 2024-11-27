package ArraysHashing;

//Valid Anagram
//Solved
//Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
//
//An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.


import java.util.HashMap;
import java.util.Map;

// comptueIfAbsent :
//Map<String, Integer> map = new HashMap<>();
//
//// Add a value only if "apple" is not in the map
//map.computeIfAbsent("apple", key -> 1);
//
//        System.out.println(map); // Output: {apple=1}
//
//// Since "apple" already exists, computeIfAbsent does nothing
//map.computeIfAbsent("apple", key -> 100);
//
//        System.out.println(map); // Output: {apple=1}

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length();i++)
        {
            // Ako ne postoji
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(Integer val: map.values())
        {
            if(val!=0)return false;
        }
        return true;
    }
}

// Resenje :
// prolazis kroz jedamn string, ubacujes u mapu : Mapa <Character, Integer>, gde je Integer broj ponavljanja
// Onda prolazis kroz drugi niz i smanjujes broj ponavljanja, kada dodje do nule, to znaci da drugi string ima isti broj ponavljanja tog slova
// Ako je doslo do toga onda ga izbacis iz mape
// Na kraju samo proveris da li je mapa prazna ako jeste znaci da su svi elementi tu
// koristiti metodu map.compute

package ArraysHashing;

//Encode and Decode Strings
//Solved
//Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
//
//Please implement encode and decode

//Input: ["neet","code","love","you"]
//
//Output:["neet","code","love","you"]


import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder resultedString = new StringBuilder();
        for (String str : strs) {
            int numbOfLetters = str.length();
            resultedString.append(numbOfLetters).append("."); // Append the length followed by a delimiter
            resultedString.append(str); // Append the actual string
        }
        return resultedString.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // Find the position of the next delimiter (.)
            int j = i;
            while (j < str.length() && str.charAt(j) != '.') {
                j++;
            }

            // Get the length of the next string
            int wordSize = Integer.parseInt(str.substring(i, j));
            i = j + 1; // Move past the delimiter

            // Get the actual string of length `wordSize`
            String s = str.substring(i, i + wordSize);
            res.add(s);
            i += wordSize; // Move past the current string
        }

        return res;
    }
}

package TwoPointers;
//Given a string s, return true if it is a palindrome, otherwise return false.
//
//A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
//
//Example 1:
//
//Input: s = "Was it a car or a cat I saw?"
//
//Output: true
//Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
//
//Example 2:
//
//Input: s = "tab a cat"
//
//Output: false
//Explanation: "tabacat" is not a palindrome.
//
//Constraints:
//
//        1 <= s.length <= 1000
//s is made up of only printable ASCII characters.
public class Valid_Palindrom {
    public static boolean isPalindrome(String s) {
    int i=0;
    int j=s.length()-1;
        while(i<=j)
        {
            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(s.charAt(j));
            if(!isAlphaNumeric(c1))
            {
                i++;
                continue;
            }
            if(!isAlphaNumeric(c2))
            {
                j--;
                continue;
            }
            if(c1!=c2)return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean  isAlphaNumeric(Character c)
    {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}

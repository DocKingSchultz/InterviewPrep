package ArraysHashing;

import java.util.HashMap;
import java.util.Map;


// Use of puIfAbsent method
// very usefull
public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int  num:nums)
        {
            if(map.putIfAbsent(num, true)!=null)return true;
        }
        return false;
    }
}



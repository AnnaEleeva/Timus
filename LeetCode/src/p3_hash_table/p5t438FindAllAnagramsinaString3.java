package p3_hash_table;
//хорошее, более понятное решение
import java.util.ArrayList;
import java.util.List;

/*
// Method2: HashTable
1. Two pointers with range of p.length(). O(n)
2. Use counter to count the character apperance in s and p.
3. For s, when moving the pointer, always -- on past index, and ++ on new index
4. Compare countS, countP => O(26)
*/
class p5t438FindAllAnagramsinaString3 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) return rst;

        int n = s.length(), m = p.length();

        // prep the count and window
        int[] window = new int[26], countP = new int[26];
        for (int i = 0; i < m; i++) {
            window[s.charAt(i) - 'a']++;
            countP[p.charAt(i) - 'a']++;
        }

        // compare at index = 0
        if (compare(window, countP)) rst.add(0);

        for (int i = m; i < n; i++) {
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - m) - 'a']--;
            if (compare(window, countP)) rst.add(i - m + 1);
        }

        return rst;
    }

    private boolean compare(int[] window, int[] countP) {
        for (int i = 0; i < 26; i++) {
            if (window[i] != countP[i]) return false;
        }
        return true;
    }
}
package p3_hash_table;

import java.util.Arrays;

public class p4t242ValidAnagram {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        char[] sC=s.toCharArray();
        Arrays.sort(sC);

        char[] tC=t.toCharArray();
        Arrays.sort(tC);

       return String.valueOf(sC).equals(String.valueOf(tC));

    }
}

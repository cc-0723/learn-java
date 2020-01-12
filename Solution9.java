package 寒假作业;

public class Solution9 {
    //赎金信，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ints = new int[26];
        for (char c:magazine.toCharArray()) {
            ints[c-'a']++;
        }
        for (char c:ransomNote.toCharArray()) {
            ints[c-'a']--;
            if(ints[c-'a'] < 0)
                return false;
        }
        return true;
    }
}

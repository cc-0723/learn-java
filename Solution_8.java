package 寒假练习;

public class Solution_8 {
    //比较版本号
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < nums1.length || j < nums2.length) {
            String num1 = i < nums1.length ? nums1[i] : "0";
            String num2 = j < nums2.length ? nums2[j] : "0";
            int res = compare(num1, num2);
            if(res == 0) {
                i++;
                j++;
            }else {
                return res;
            }
        }
        return 0;
    }

    private int compare(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if(n1 > n2) {
            return 1;
        } else if(n1 < n2) {
            return -1;
        } else {
            return 0;
        }
    }
}

package org.example.addBinary;

public class Solution {
    public String addBinary(String a, String b) {
        int sign = 0;

        int index = 1;

        StringBuilder sb = new StringBuilder();

        while(index <= a.length() || index <= b.length()){
            int x = a.length() - index >= 0 ? (int)a.charAt(a.length() - index) - '0' : 0;
            int y = b.length() - index >= 0 ? (int)b.charAt(b.length() - index) - '0' : 0;

            int z = x + y + sign;

            sb.append(String.valueOf(z % 2));

            sign = z / 2;

            index++;
        }

        if(sign == 1){
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11","10"));
    }
}

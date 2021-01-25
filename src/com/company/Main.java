package com.company;

import java.util.HashMap;

public class Main {

    public static void task_2(int[][] arr1, int [][] arr2){

        boolean check;

        for (int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++){
                check = true;
                for (int i_1=0; i_1<arr2.length; i_1++ ){
                    if (!check) break;
                    for (int j_1=0; j_1<arr2[i_1].length; j_1++){
                        if (!check) break;
                        if (arr1[i][j]==arr2[i_1][j_1]) {System.out.println("Common element is: " + arr1[i][j]);
                            check = false;
                        }
                    }
                }
            }
        }
    }



    public static String task_14(String line){

        StringBuilder line1 = new StringBuilder(line.length());

        for(int i=0; i<line.length()-1; i++) {
            boolean check = false;
            for (int j=i+1; j<line.length(); j++){
                    if (Character.toUpperCase(line.charAt(i))==Character.toUpperCase(line.charAt(j))){
                        if ((Character.isUpperCase(line.charAt(i)) && Character.isLowerCase(line.charAt(j)))
                                || (Character.isUpperCase(line.charAt(j)) && Character.isLowerCase(line.charAt(i)))){
                            if (!check) line1.append(line.charAt(i));
                            line1.append(line.charAt(j));
                            check=true;
                        }
                    }
                }
            }

        line = line1.toString();
        return line;
    }

    public static String task_17(String str){
        StringBuilder strNew = new StringBuilder(str.length());
        for (int i=0; i<str.length(); i++){
            if (Character.isLowerCase(str.charAt(i)))
                strNew.append(Character.toUpperCase(str.charAt(i)));
            else {
                strNew.append(Character.toLowerCase(str.charAt(i)));
                }
        }
        str = strNew.toString();
        return str;
    }

    public static int task_18(String word1, String word2){
        if (word1.length()>word2.length()) return 0;
        else {
            HashMap<Character, Integer> letters_list = new HashMap<>();
            for (int i=0; i<word1.length(); i++){
                if (!letters_list.containsKey(word1.charAt(i))) letters_list.put(word1.charAt(i), 1);
                else {
                    int el = letters_list.get(word1.charAt(i));
                    letters_list.put(word1.charAt(i), ++el);
                }
            }
            int end=0;
            for (int i=0; i<word1.length(); i++){
                int start = 0;
                for (int j=0; j<word2.length(); j++){
                    if (word1.charAt(i)==word2.charAt(j)) start++;
                }
                start/=letters_list.get(word1.charAt(i));
                if ((i==0) || ((start <= end)&&(start!=0))) end=start;
            }
            return end;
        }
    }

    public static int task_22_1(int number){
        int result=1;
        for (int i=1; i<=number; i++){
            result*=i;
        }
        return result;
    }

    public static int task_22_2(int number){
        int result=1;
        if (number == 1) return result;
        if (number == 0) return 0;
        result = number * task_22_2(number - 1);
        return result;
    }

    public static void main(String[] args) {

        System.out.println("Task #2. The method displays the common elements of two 2D arrays.");

        int [][] arr1 = {{1, 2, 3}, {2}, {0, 9}};
        int [][] arr2 = {{5, 8, 1}, {2, 0}, {9}};
        task_2(arr2, arr1);

        System.out.println("Task #18. The method returns how many times the first word can be formed with the letters of the second word.");
        String str1 = "воно";
        String str2 = "ннноооооввввукег";
        String str3 = "j";
        System.out.println("From the letters of the second word, the first can be composed " + task_18(str1, str2));
        System.out.println("From the letters of the second word, the first can be composed " + task_18(str1, str3));

        System.out.println("Task #22. The method calculates the factorial of a number. Regular and recursive versions.");
        System.out.println("Result: " + task_22_1(5));
        System.out.println("Result recurse: " + task_22_2(6));

        System.out.println("Task #14. The method returns the most balanced substring from the string it receives.");
        System.out.println(task_14("HOooGDdgH"));

        System.out.println("Task #17. The method changes the case of the letters of the string to the opposite and returns a new string.");
        System.out.println(task_17("hELLO wORLD!"));
        System.out.println(task_17("hElLo WorLd!"));

    }
}

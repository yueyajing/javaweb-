package com.example.jkapi.test;

import org.junit.Test;

public class licoTEST {

    int[] a = {1,2,3,4,5,6,7};

    @Test
    public void tt(){
        int count = 0 ;
        int sp = 0;
        for(int i = 0;i<a.length;i++){

            count = count + a[i];
        }

        for(int i = 0;i<a.length;i++){

            sp =a[i]*a.length;
            if (count==sp){
                System.out.println(i);
                System.out.println(sp);
            }
        }
return ;

    }


    public static void main(String[] args) {
        String s1 = "abcdedcba";
        String s2 = "erfsfbnj";
        if (pali(s1)){
            System.out.println("s1为回");
        } else{
            System.out.println("s1不为回");
        }

        if (pali(s2)){
            System.out.println("s2为回");
        } else{
            System.out.println("s2不为回");
        }
    }
    static boolean pali(String s){
        int i,j;
        j=s.length()-1;
        for (i=0;i<=j;i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
            if (i>j){
                return true;
            }
            else {
                return false;
            }
    }
}

package com.maps.test;

import java.util.Arrays;

public class PrintSquareWaste {
    /*
Write code for print all possible right angle triangle in given m*n matrixes
Input : i=0,j=0
1 2 3                    1 2 3 4 5
4 5 6                    4 5 6 7 8
7 8 9                    9 1 2 3 4
 */
    public static void main(String[] args) {
        int a[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2}
        };

        /*
        0,0
        1,0 1,1

        0,0
        1,0 1,1
        2,0 2,1 2,2

        0,1
        1,1 1,2

        0,1
        1,1 1,2
        2,1 2,2 2,3
         */

//        int i = 0, j = 0;
       /* for (int i = 0; i < a.length -1; i++) {
            String leftToRight = getRow(a[i],i,i+1 );
            for (int j = 1; j < a[i].length-1; j++) {
                String leftToRight="";
                leftToRight +=getRow(a[i+j],j)

            }
        }*/
        /*
         {1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 0, 1, 2}
        */
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a[i].length - 1; j++) {
                for (int k = j + 1; i + k < a.length && k < a[i].length; k++) {
                    String square = "";
                    for (int l = j; l <= k; l++) {
                        square += getRow(a[i + l], j, i + k) + "\n";
                    }
                    System.out.println(square);
                }
            }
        }
    }

    static String getRow(int[] ar, int i, int j) {
        String line = "";
        for (int k = i; k <= j; k++) {
            line += ar[k] + " ";
        }
        return line;
    }

    private static void printRightToLeft(String rightToLeft) {
        String[] strings = rightToLeft.split("\n");
        for (int i = strings.length - 1, k = 0; i >= 0; i--, k++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }

            System.out.println(strings[k]);
        }
        System.out.println("\n");
    }
}

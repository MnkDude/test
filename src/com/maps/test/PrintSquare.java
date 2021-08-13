package com.maps.test;


public class PrintSquare {
    /*
Write code for print all possible square in given m*n matrixes
Input : i=0,j=0
1 2 3                    1 2 3 4 5
4 5 6                    4 5 6 7 8
7 8 9                    9 1 2 3 4
 */
    public static void main(String[] args) {
        int a[][] = {
                {1, 2,3,4,5},
                {3,4,6,7,8},
                {4,5,1,2,3}
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

        int i = 0, j = 0;
        if (a.length <= 1 || a[i].length <= 1) return;
        while (i < a.length - 1) {
            for (int k = 1; i + k < a.length && j + k < a[i].length; k++) {
                String square = "";
                for (int l = 0; l <= k; l++) {
                    square += getRow(a[i + l], j, j + k) + "\n";
                }
                System.out.println(square);
            }
            j++;
            if (j == a[i].length - 1) {
                i++;
                j = 0;
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
}
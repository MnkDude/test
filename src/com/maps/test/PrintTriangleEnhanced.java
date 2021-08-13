package com.maps.test;

import java.util.Arrays;

public class PrintTriangleEnhanced {
    /*
Write code for print all possible right angle triangle in given m*n matrixes
Input : i=0,j=0
1 2 3                    1 2 3 4 5
4 5 6                    4 5 6 7 8
7 8 9                    9 1 2 3 4
 */
    public static void main(String[] args) {
        int a[][] = {
                {1},
                {7},
                {1},
                {7}
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
        int j1 = a[0].length - 1;
        while (i < a.length - 1) {
            if (a.length <= 1 || a[i].length <= 1) break;
            String leftToRight = a[i][j] + "\n";
            String rightToLeft = a[i][j1] + "\n";
            StringBuilder temp = new StringBuilder();
            temp.setLength(a.length - 1);
            rightToLeft = temp.toString().replaceAll("\u0000", "  ") + rightToLeft;
            for (int k = 1; i + k < a.length && j + k < a[i].length; k++) {
                leftToRight += getRow(a[i + k], j, j + k) + "\n";
                temp.setLength(a.length - k - 1);
                rightToLeft += temp.toString().replaceAll("\u0000", "  ") + getRow(a[i + k], j1 - k, j1) + "\n";
                System.out.println(leftToRight);
                System.out.println(rightToLeft);
//                printRightToLeft(rightToLeft);
            }
            j++;
            j1--;
            if (j == a[i].length - 1 && j1 == 0) {
                i++;
                j = 0;
                j1 = a[i].length - 1;
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

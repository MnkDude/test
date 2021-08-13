package com.maps.test;

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
                {1, 2},
                {8, 6},
                {4, 5}
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

        String result = "";
        String revResult = "";
        int i = 0, j = 0;
        int j1 = a[0].length - 1;
        while (i < a.length - 1) {
            result = a[i][j] + "\n";
            revResult = a[i][j1] + "\n";
            for (int k = 1; i + k < a.length && j + k < a[i].length; k++) {
                result += getRow(a[i + k], j, j + k);
                revResult += getRow(a[i + k], j1 - k, j1);
                if (i + k < a.length - 1 && j + k < a[i].length - 1) {
                    result += "\n\n" + result + "\n";
                    revResult += "\n\n" + revResult + "\n";
                }
            }
            result += "\n";
            revResult += "\n";
            System.out.println(result);
            System.out.println(revResult);
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
}
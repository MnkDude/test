package com.maps.test;

import java.util.Scanner;

public class PrintTriangle {
    /*
    Write code for print all possible right angle triangle in given m*n matrixes
Input : i=0,j=0
1 2 3                    1 2 3 4 5
4 5 6                    4 5 6 7 8
7 8 9                    9 1 2 3 4



     */
    public static void main(String[] args) {
        int a[][] = {
                {1, 2, 3, 9},
                {8, 6, 6, 2},
                {4, 5, 8, 1},
                {7, 8, 2, 3}
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

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a[i].length - 1; j++) {
                for (int k = 1; k < a.length; k++) {
                    if (i + k < a.length && j + k < a[i].length)
                        printTriangle(a, i, j, i + k, j + k);
                }
            }
        }

        for (int i = 0; i < a.length -1; i++) {
            for (int j = a[i].length - 1; j > 0; j--) {
                for (int k = 1; k < a.length; k++) {
                    if (i + k < a.length && j - k >= 0)
                        printTriangle(a, i, j, i + k, j - k);
                }
            }
        }
    }

    static void printTriangle(int[][] matrix, int i1, int j1, int i2, int j2) {
        if (i1 < i2 && j1 < j2) {
            for (int i = i1, k = 0; i <= i2; i++, k++) {
                for (int j = j1, l = 0; j <= j2; j++, l++) {
                    System.out.print(" " + matrix[i][j]);
                    if (k == l) {
                        break;
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = i1, k = 0; i <= i2; i++, k++) {
                for (int j = j1, l = 0; j >= j2; j--, l++) {
                    System.out.print(matrix[i][j] + " ");
                    if (l == k) {
                        break;
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
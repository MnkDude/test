package com.maps.test;

import java.util.Scanner;

public class MinimumNoOfPages {
    //TODO Senthil test
    public static void main(String[] args) {
        int bookCount, studentCount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no of books :");
        bookCount = scanner.nextInt();
        int[] bookPagesCount = new int[bookCount];
        System.out.println("Enter no of pages in each books :");
        for (int i = 0; i < bookCount; i++) {
            bookPagesCount[i] = scanner.nextInt();
        }
        System.out.println("Enter no of students :");
        studentCount = scanner.nextInt();
        System.out.println("Minimum no. of pages for Maximum assigned for one student : " + solveMinimumNoOfPages(bookPagesCount, bookCount, studentCount));

    }

    private static int solveMinimumNoOfPages(int[] bookPagesCount, int bookCount, int studentCount) {
        int minOfMaxPageCount = Integer.MAX_VALUE;
        if(studentCount>bookCount) {
            return -1;
        }
        if(studentCount == bookCount) {
            return greatestInArrayAndSum(bookPagesCount,0,-1,-1);
        }
        for (int i = 0; i <  studentCount; i++) {
            int sum = sumOfArrayInRange(bookPagesCount, i, i + bookCount - studentCount);
            minOfMaxPageCount = Math.min(greatestInArrayAndSum(bookPagesCount, sum, i, i + studentCount),minOfMaxPageCount);
        }
        return minOfMaxPageCount;
    }

    private static int sumOfArrayInRange(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static int greatestInArrayAndSum(int[] array, int sumValue, int start, int end) {
        int max = sumValue;
        for (int i = 0; i < array.length; i++) {
            if (!(i >= start && i <= end)) {
                max = Math.max(array[i], max);
            }
        }
        return max;
    }
}

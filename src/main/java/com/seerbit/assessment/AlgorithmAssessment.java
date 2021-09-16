package com.seerbit.assessment;

public class AlgorithmAssessment {
    //Given an array of integers and a value, determine if there are any two integers in the
    // array whose sum is equal to the given value.
    private boolean sumsToTarget(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    //Given a sorted array of integers, return the low and high index of the given key.
    //Return  -1 if not found. The array length can be in the millions with many duplicates.
    public static void findFirstAndLast(int arr[], int num) {
        int n = arr.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if (num != arr[i])
                continue;
            if (first == -1) {
                first = i;
            } else {
                last = i;
            }
        }
        if (first != -1) {
            System.out.println("First Occurrence = " + first);
            System.out.println("Last Occurrence = " + last);
        } else {
            System.out.println("Not Found");
        }
    }
}

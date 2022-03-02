package activities;

import java.util.Arrays;

public class Activity4 {
    public static void main(String args[]) {
        int a[] = {10, 77, 60, 54, 11, 30};
        System.out.println("initial array: " + Arrays.toString(a));
        result(a);
    }
    static void result(int[] a) {
        int i;
        int n = a.length;
        for (i = 0; i < n; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && temp < a[j]) {
                a[j + 1] = a[j];
                --j;
            }
            a[j + 1] = temp;
        }
        System.out.println("sorted array: " + Arrays.toString(a));
    }
}

package activities;

public class Activity2 {
   public static void main(String[] args) {
        int a[] = {10, 77, 10, 54, -11, 10};
        int num = 10;
        int total = 30;
        System.out.println("Result: " + result(a, num, total));
        }
public static boolean result(int[] numbers, int num, int total) {
        int temp = 0;
        for (int number : numbers) {
        if (number == num)
        temp += num;
        if (temp > total)
        break;
        }
        return temp == total;
   }
}
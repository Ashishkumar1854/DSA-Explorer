// Creation if arrays
// public class arraySysntax {
// public static void main(String[] args) {
// int marks[] = new int[10];
// int numbers [] = {1,3,5};
// int morenumbers [] = {6,7,8};
// String fruits [] = {"apple","mango", "banana"};
// }
// }

// // Input an array
// import java.util.Scanner;

// public class arraySysntax {
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int number;
// System.out.print("enter number:");
// number = sc.nextInt();
// System.out.print(number);
// }
// }

// Updation

// import java.util.Arrays;

// public class arraySysntax {
// public static void main(String[] args) {
// int number[] = { 1, 2, 3, 4, 5 }; // ✅ correct array syntax
// System.out.println(Arrays.toString(number)); // ✅ prints array
// // Update value at index 2 to 99
// updateArray(number, 2, 99);

// System.out.println("Updated Array: " + Arrays.toString(number));
// }
// }

// for operation (create,input,update,output) explain in below example
// Also example of - by reference
public class arraySysntax {

  public static void updateMark(int marks[]) {
    for (int i = 0; i < marks.length; i++) {
      marks[i] = marks[i] + 1;
    }
  }

  public static void main(String[] args) {
    int marks[] = { 79, 89, 99 };
    updateMark(marks);
    // print marks
    for (int i = 0; i < marks.length; i++) {
      System.out.print(marks[i] + " ");
    }
  }
}
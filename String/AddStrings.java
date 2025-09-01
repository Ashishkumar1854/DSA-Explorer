// public class AddStrings {
// public static void main(String[] args) {
// String num1 = "356";
// String num2 = "77";
// System.out.println(addStrings(num1, num2));
// }

// public static String addStrings(String num1, String num2) {
// int i = num1.length() - 1;
// int j = num2.length() - 1;
// int carry = 0;
// StringBuilder sb = new StringBuilder();

// while (i >= 0 || j >= 0 || carry != 0) {
// int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
// int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

// int sum = digit1 + digit2 + carry;
// carry = sum / 10;

// sb.append(sum % 10);
// i--;
// j--;
// }
// return sb.reverse().toString();

// }
// }

// option 1) if you dont want to here static . public String addStrings(String
// num1, String num2) {
// then you cannot call here public String addStrings(String num1, String num2)
// {
// answer = static baanao like public static String addString(String num1,
// String num2) mtlb abebe vala tarika .

// option2) you want to solve this problem without static jaise leaatcode me h
// then tum object bana kr run kr skte ho like below code check .these all two
// method for vs code format leetcode ke liye kuchh nhi krna direct solve krna h

// public class AddStrings {
// public static void main(String[] args) {
// String num1 = "356";
// String num2 = "77";

// // Object create karke call karna
// AddStrings obj = new AddStrings();
// System.out.println("Input: " + num1 + " + " + num2);
// System.out.println("Output: " + obj.addStrings(num1, num2));
// }

// public String addStrings(String num1, String num2) {
// int i = num1.length() - 1;
// int j = num2.length() - 1;
// int carry = 0;
// StringBuilder sb = new StringBuilder();

// while (i >= 0 || j >= 0 || carry != 0) {
// int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
// int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

// int sum = digit1 + digit2 + carry;
// carry = sum / 10;

// sb.append(sum % 10);
// i--;
// j--;
// }
// return sb.reverse().toString();
// }
// }

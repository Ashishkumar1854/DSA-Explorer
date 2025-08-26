public class IpAddress {

  // Function to defang IP address
  public String defangIPaddr(String address) {
    StringBuilder ans = new StringBuilder(); // efficient string building
    int index = 0;

    while (index < address.length()) {
      if (address.charAt(index) == '.') {
        ans.append("[.]");
      } else {
        ans.append(address.charAt(index));
      }
      index++; // always increment
    }

    return ans.toString();
  }

  // Main method for testing
  public static void main(String[] args) {
    IpAddress sol = new IpAddress(); // ✅ fixed class name

    String input1 = "1.1.1.1";
    String input2 = "255.100.50.0";

    System.out.println("Input: " + input1);
    System.out.println("Output: " + sol.defangIPaddr(input1));

    System.out.println("Input: " + input2);
    System.out.println("Output: " + sol.defangIPaddr(input2));
  }
}

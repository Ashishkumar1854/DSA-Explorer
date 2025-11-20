public class AccessModifier {

  public static void main(String args[]) {
    BankAccount myAcc = new BankAccount();
    myAcc.username = "ashishyadav";
    myAcc.setPassword("Ashish@2004");
  }

  class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
      password = pwd;
    }
  }

}

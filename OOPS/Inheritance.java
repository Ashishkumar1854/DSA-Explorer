// syntax or single level inheritance
public class Inheritance {
  public static void main(String args[]) {
    Fish shark = new Fish();
    shark.eat();
  }
}

// Base class
class Animal {
  String color;

  void eat() {
    System.out.println("eating..");
  }

  void breathe() {
    System.out.println("breatheing...");
  }
}

// derived class or subclass
class Fish extends Animal {
  int fins;

  void swim() {
    System.out.println("swimming...");
  }
}

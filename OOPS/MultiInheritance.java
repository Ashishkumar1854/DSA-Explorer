public class MultiInheritance {
  public static void main(String args[]) {
    Dog tommy = new Dog();
    tommy.eat();
    tommy.legs = 4;
    System.out.println(tommy.legs);
  }
}

// base class
class Animal {
  String color;

  void eat() {
    System.out.println("eating ..");
  }

  void breathe() {
    System.out.println("breatheing ..");
  }
}

// derived class 1
class mammal extends Animal {
  int legs;
}

class Dog extends mammal {
  String breed;
}
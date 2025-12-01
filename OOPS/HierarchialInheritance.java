public class HierarchialInheritance {
  public static void main(String args[]) {
    mammal dog = new mammal();
    dog.eat();
  }
}

class Animal {
  String color;

  void eat() {
    System.out.println("eats");
  }

  void breathe() {
    System.out.println("breating..");
  }
}

class mammal extends Animal {
  void walk() {
    System.out.println("walk");
  }
}

class Fish extends Animal {
  void swim() {
    System.out.println("swim");
  }
}

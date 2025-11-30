// public class Constructor {
//   public static void main(String args[]) {
//     Student s1 = new Student("Ashish");
//     System.out.println(s1.name);
//   }
// }

// class Student {
//   String name;
//   // int roll;

//   Student(String name) {
//     this.name = name;
//   }
// }

//............types os constructors......
// 1) non -paramaterized constructor
// public class Constructor {
//   public static void main(String args[]) {
//     Student s1 = new Student();
//   }
// }

// class Student {
//   String name;

//   Student() {
//     System.out.println("constructor is called..");
//   }
// }

//2) parameterized cosntuctor
// public class Constructor {
//   public static void main(String args[]) {
//     Student s1 = new Student();
//     Student s2 = new Student("Ashish");
//     Student s3 = new Student(123);

//   }
// }

// class Student {
//   String name;
//   int roll;

//   Student() {
//     System.out.println("construction is called..");
//   }

//   Student(String name) {
//     this.name = name;
//   }

//   Student(int roll) {
//     this.roll = roll;
//   }
// }
// // here issue of that constuctor not understand automatically which constructore
// // print ,so solve this problem used constuctor overloading

//3) ..........copy constructor ......
public class Constructor {
  public static void main(String args[]) {
    Student s1 = new Student();
    s1.name = "Ashish";
    s1.roll = 123;
    s1.password = "abcd";
    s1.marks[0] = 100;
    s1.marks[1] = 90;
    s1.marks[2] = 80;

    Student s2 = new Student(s1);
    s2.password = "xyz";
    s1.marks[2] = 100;

    for (int i = 0; i < 3; i++) {
      System.out.println(s2.marks[i]);
    }
  }
}

class Student {
  String name;
  int roll;
  String password;
  int marks[];

  // copy constructor
  Student(Student s1) {
    marks = new int[3];
    this.name = s1.name;
    this.roll = s1.roll;
    this.marks = s1.marks;
  }

  Student() {
    marks = new int[3];
    System.out.println("construction is called..");
  }

  Student(String name) {
    marks = new int[3];
    this.name = name;
  }

  Student(int roll) {
    marks = new int[3];
    this.roll = roll;
  }
}
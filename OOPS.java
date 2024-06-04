package alpha;

public class OOPS {
    public static void main(String[] args) {
        // Pen p1=new Pen();    //created a pen object with name p1
        // p1.setColor("blue");
        // p1.setTip(5);
        // System.out.println(p1.getcolor());
        // System.out.println(p1.getTip());
        

        // Bankaccount myacc=new Bankaccount();
        // myacc.username="Rachit Goyal";
        // myacc.setpassword("12345678");

        //cannot access password variable dircetly 
        //we can just change the password
        //but we cannot access what the password is



        Student s1=new Student();
        s1.name="Rachit Goyal";
        s1.roll=22104084;
        s1.password="12345678";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=99;

        Student s2=new Student(s1);
        s2.password="abcd";
        s1.marks[0]=90;
        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        }

    }
    
}

// class Bankaccount{
//     public String username;
//     private String password;
//     public void setpassword(String pwd){
//         password=pwd;
//     }
// }

// class Pen{
//     //properties and functions
//     private String color;
//     private int tip;

//     //setter functions
//     void setColor(String newcolor){
//         color = newcolor;
//     }
//     void setTip(int newtip){
//         tip = newtip;
//     }


//     //getter functions
//     String getcolor(){
//         return this.color;
//     }

//     int getTip(){
//         return this.tip;
//     }

// }

//comstructor methods
class Student{
    String name;
    int roll;
    String password;
    int marks[];

    //non parameterized constructor
    Student(){
        marks = new int[3];
    }

    //parameterized constructor
    Student(String name){
        //constructor is called
        this.name = name;
        marks = new int[3];
    }

    //shallow copy constructor
    // Student(Student s1){
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     marks = new int[3];
    //     this.marks = s1.marks;
    // }

    //deep copy constructor
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        for (int i = 0; i < 3; i++) {
            this.marks[i] =s1.marks[i]; 
        }
    }
}

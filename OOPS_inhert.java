package alpha;

public class OOPS_inhert {
    public static void main(String[] args) {
        // Fish shark=new Fish();
        // shark.eats();

        // Dog dobby=new Dog();
        // dobby.eats();
        // dobby.legs=4;
        // System.out.println(dobby.legs);
        
    }
}

class Animal{
    void color(){
    }

    void breathe(){
        System.out.println("breathe");
    }
    void eats(){
        System.out.println("eats");
    }
}


//single level inheritance
        //derived or child class
        // class Fish extends Animal{
        //     int fins;

        //     void swim(){
        //         System.out.println("swims");
        //     }
        // }



//multilevel inheritance
        // class Mammals extends Animal{
        //     int legs;
        // }

        // class Dog extends Mammals{
        //     String breed;

        // }



//hierarchical inheritance
        // class Mammals extends Animal{
        //     void walks(){
        //         System.out.println("walks");
        //     }
        // }

        // class Fish extends Animal{
        //     void swims(){
        //         System.out.println("swims");
        //     }
        // }

        // class bird extends Animal{
        //     void flies(){
        //         System.out.println("flies");
        //     }
        // }


//hybrid inheritance


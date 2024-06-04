package alpha;

public class OOPS_abstract {
    public static void main(String[] args) {
        Horse h=new Horse();
        h.walks();
        h.eats();

        Chicken c=new Chicken();
        c.eats();
        c.walks();
        
    }
}

abstract class Animals{
    void eats(){
        System.out.println("eats");
    }
    String colors;
    Animals(){
        colors="brown";   
    }

    abstract void walks();
}

class Horse extends Animals{
    void walks() {
        System.out.println("walks on 4 legs");    
    }

    void changecolr(){
        colors="dark brown";
    }
}

class Chicken extends Animals{
    void walks() {
        System.out.println("walks on 2 legs");
    }

    void changecolr(){
        colors="white";
    }
}
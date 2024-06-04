package alpha;

public class OOPS_interface {
    public static void main(String[] args) {
        Queen q=new Queen();
        q.moves();
        Bear b=new Bear();
        b.eats();
    }
}

interface chessPlayer{
    void moves();
}

class Queen implements chessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal in all directions");
    }
}

class Rook implements chessPlayer{
    public void moves(){
        System.out.println("up down left right");
    }
}

class King implements chessPlayer{
    public void moves(){
        System.out.println("only one step");
    }
}


interface herbivore{
    void eats();
}

interface carnivore{
    void eats();
}

class Bear implements herbivore, carnivore{
    public void eats(){
        System.out.println("eat both meat and grass ");
    }
}
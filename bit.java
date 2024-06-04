package alpha;


public class bit {


    //CHECK IF NUMBER IS EVEN OR ODD
    public static void isevenodd(int n) {
        int bitmask=1;
        if((n & bitmask)==0) {
            System.out.println("NUMBER IS EVEN");
        }
        else{
            System.out.println("NUMBER IS ODD");
        }
    }


    //TO GET THE BIT OF ITH INDEX
    public static void getithbit(int n,int i) {
        int bitmask=1<<i;
        if((n & bitmask)==0) {
            System.out.print("iTH BIT IS ZERO");
        }
        else{
            System.out.println("iTH BIT IS ONE");
        }
        
    }


    //TO SET THE ITH INDEX TO 1 OF A GIVEN NUMBER
    public static void setithbit(int n,int i) {
        int bitmask=1<<i;
        n= (n | bitmask);
        System.out.println(n);
    }


    //TO CLEAR THE ITH INDEX TO 0 OF A GIVEN NUMBER
    public static int clearithbit(int n,int i) {
        int bitmask=~(1<<i);
        n= (n & bitmask);
        System.out.println(n);
        return n;
    }

    //TO UPDATE THE ITH INDEX TO NEW BIT 
    public static int updateithbit(int n,int i,int newbit) {
        // if(newbit==0){
        //     clearithbit(n,i);
        // }else{
        //     setithbit(n,i);
        // }


        n=clearithbit(n, i);
        int bitmask=newbit<<i;
        return n|bitmask;

    }

    public static int clearlastibits(int n,int i) {
        int bitmask=(~0)<<i;
        return n & bitmask;
        
    }



    public static int clearbitsinrange(int n,int i,int j) {
        int a,b;
        a=(~0)<<(j+1);
        b=(int)Math.pow(2, i)-1;    //or (1<<i)-1
        int bitmask=a|b;
        return n & bitmask;
    }



     public static boolean ispowerof2(int n) {
         if((n & (n-1)) ==0)
         return true;
         else
         return false;
     }



     //GOOGLE AND AMAZON 
     public static void checksetbits(int n) {
        int count=0;
        int bitmask=1;
        while(n!=0){
            int lsb=n&bitmask;
            if(lsb==1){
                count++;
            }
            n=n>>1;
        }
        System.out.println(count);
     }



    public static int fastexponent(int a,int n){
        int ans=1;
        while(n>0){
            if((n&1) !=0){
            ans*=a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }


    public static void swapwithoutthird(int a,int b) {
        // System.out.println(a+" "+b);
        // a=a+b;
        // b=a-b;
        // a=a-b;
        // System.out.println(a+" "+b);


        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a+" "+b);
    }


    public static int add1(int n) {
        // int bitmask=(~0)&((~0)<<1);
        // return n + ~bitmask;

                //OR
                
                
        return -~n;
        
    }

    public static void main(String[] args) {
        // isevenodd(10);
        // isevenodd(11);
        // isevenodd(7);

        // getithbit(10, 3);

        // setithbit(10, 1);

        // clearithbit(10, 1);

        // System.out.println(updateithbit(10, 2, 1));

        // int n=clearlastibits(15, 2);

        // int n=clearbitsinrange(10, 2, 4); 
        // System.out.println(n);

        // System.out.println(ispowerof2(15));

        // checksetbits(16);

        // System.out.println(fastexponent(3,5));

        swapwithoutthird(10,5);

        System.out.println(add1(4));
        
    }
}

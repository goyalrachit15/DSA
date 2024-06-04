package alpha;

import java.util.Arrays;
import java.util.Scanner;

public class string {

    public static void printletter(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i)+" ");
        }
        System.out.println();
    }

    public static boolean palindrome(String str) {
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }


    public static double shortest_path(String str) {
        int x=0,y=0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='N'){
                y++;
            }
            else if(str.charAt(i)=='S'){
                y--;
            }
            else if(str.charAt(i)=='E'){
                x++;
            }
            else{
                x--;
            }
        }
        return Math.sqrt((x*x)+(y*y));
    }

    public static boolean isequals(String str,String str2) {
        if(str.equals(str2)){
            return true;
        }
        else
        return false;
    }
   
    public static void substring(String str,int si,int ei) {
        //starting index is included
        //ending index is not included 
        //substring function treturns part od string from starting index ti ending index-1
        String sub=str.substring(si,ei);
        System.out.println(sub);
        
    }
    
    public static void largest(String str,String str1) {
        /*comapareTo() function is used to comapre two strings
         * it returns 0 if equals
         * -ve if str<str1
         * +ve if str>str1
         * 
         * lower case and upper case character are different 
         * to avoid case differences we use compareToIgnoreFunction()
         */
        if(str.compareTo(str1)>0){
            System.out.println(str);
        }
        else if(str.compareTo(str1)<0){
            System.out.println(str1);
        }
        else
        System.out.println("both are same");
    }
    
    /*
     * Q) why string are immutable??
     * 
     * answer
     * 
     * string str=tony;                      1
     * string str1=tony;                     2
     * string str=new string("tony");        3
     * 
     * 1 and 2 are same beacuse
     * 
     * in memory there are two tyoe if memory allocation
     * stack memory and heap memory
     * 
     * when str=tony is created 
     * in stack str variable is created pointing toward "tony " in heap memory 
     * 
     * when str is created 
     * in stack str1 variable is created pointing toward existing  "tony " in heap memory
     * 
     * this is also know as interning 
     * str1 and str does not contain string but points towards it.
     * 
     * 
     * 
     * when str2 is created and intialized with new keyword
     * it does not matter whether tony is present in heap or not 
     * it will create a new tony in heap memory with differnet address
     * 
     * 
     * due to this interning phenomenon strings get immutable
     */


     //stringbuilder are used because they can be changed and easily modified
     public static void stringbulider() {

        StringBuilder sb=new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
            //append function add the changes to existing strings
        }
        System.out.println(sb);
     }

     public static void uppercase(String str) {
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)==' ' && i < str.length()-1){
                sb.append(' ');
                ch=Character.toUpperCase(str.charAt(i+1));
                sb.append(ch);
                i++;
            }
            else{
                ch=str.charAt(i);
                sb.append(ch);
            }
        }
        System.out.println(sb);
     }
    
     public static void stringcompression(String str) {
        StringBuilder sb=new StringBuilder("");
        for(int i=0; i<str.length();i++){
            char ch=str.charAt(i);
            int count=1;
            sb.append(ch);
            while( i<str.length()-1 && ch==str.charAt(i+1)){
                count++;
                i++;
            }
            if(count!=1)
            sb.append(count);
        }
        System.out.println(sb);

     }
   
   
     public static void anagram(String str,String str1) {
        int l=str.length();
        int l1=str.length();
        if(l==l1){
            str=str.toLowerCase();
            str1=str1.toLowerCase();
            
            char ch[]=str.toCharArray();
            char ch1[]=str1.toCharArray();

            Arrays.sort(ch);
            Arrays.sort(ch1);

            boolean result=Arrays.equals(ch , ch1);
            if(result==true){
                System.out.println("ANAGRAMS");
            }
            else{
                System.out.println("NOT ANAGRAMS");
            }
        }

        
     }
     public static void main(String[] args) {
        Scanner br=new Scanner(System.in);
        // String name="tony stark";
        // String f_name="rachit";
        // String l_name="Goyal";
        // String fullname=f_name+" "+l_name;
        // int length=name.length();
        // System.out.println(fullname);
        // System.out.println(fullname.charAt(4));

        String name,name1;
        name=br.nextLine();
        name1=br.nextLine();
        // int si=br.nextInt();
        // int ei=br.nextInt();
        // printletter(name);
        // boolean res=palindrome(name);
        // System.out.println(res);
        // System.out.println(shortest_path(name));
        // System.out.println(isequals(name, name1));
        // substring(name,si,ei);
        // largest(name, name1);

        // stringbulider();

        // uppercase(name);

        // stringcompression(name);

        anagram(name, name1);
        br.close();
    }
}

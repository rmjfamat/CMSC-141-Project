import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        System.out.println("Turing Machine Menu\n\t1. Power\n\t2. Even b's\n\nEnter 1 to to check if string is a^n.\nEnter 2 to check of string has even b's.");
        Scanner sc = new Scanner(System.in);
        int generate;
        do{
            generate = sc.nextInt();
        }while(!(generate == 1 || generate == 2));
        String string = "";
        switch(generate){
            case 1:
                System.out.println("Enter string. (alphabet = {a,b})");
                string = sc.next();
                Power pow = new Power();
                pow.check(string);
                break;
            case 2:
                System.out.println("Enter string. (alphabet = {a,b})");
                string = sc.next();
                Evenbs pal= new Evenbs();
                pal.check(string);
                break;
        }

    }
}

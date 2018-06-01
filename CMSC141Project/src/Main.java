import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int generate;
        while (true) {
            do {
                System.out.println("Turing Machine Menu\n\t1. Power\n\t2. Even B's\n\t3. Exit\n\nEnter 1 to to check if string is x^y.\nEnter 2 to check of string has even b's.\nEnter 3 to exit program.");
                try {
                    generate = sc.nextInt();
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    generate = 0;
                }
                if (generate == 3) {
                    return;
                }
            } while (!(generate == 1 || generate == 2));
            String string;
            boolean error;
            switch (generate) {
                case 1:
                    int x = 0, y = 0;
                    do {
                        error = false;
                        System.out.print("Enter number x (x^y): ");
                        try {
                            x = sc.nextInt();
                            if (x <= 0) {
                                error = true;
                            }
                        } catch (InputMismatchException e) {
                            error = true;
                            sc.nextLine();
                        }
                    } while (error);
                    do {
                        error = false;
                        System.out.print("Enter number y (x^y): ");
                        try {
                            y = sc.nextInt();
                            if (y <= 0) {
                                error = true;
                            }
                        } catch (InputMismatchException e) {
                            error = true;
                            sc.nextLine();
                        }
                    } while (error);
                    Power pow = new Power(x, y);
                    pow.check();
                    break;
                case 2:
                    do {
                        error = false;
                        System.out.println("Enter string. (alphabet = {a,b})");
                        string = sc.next();
                        for (char c : string.toCharArray()) {
                            if (c != 'a' && c != 'b') {
                                error = true;
                            }
                        }
                    } while (error);
                    Evenbs pal = new Evenbs();
                    pal.check(string);
                    break;
            }
        }
    }
}

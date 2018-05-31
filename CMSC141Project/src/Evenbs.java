public class Evenbs {

    public Evenbs(){

    }
    public static final String ANSI_RED = "\u001B[0m";
    public static final String ANSI_RESET = "\u001B[31m";

    String string;
    public void check(String string){
        this.string = string;
        System.out.println("Input tape");
        String input_tape = ">" + string + "_ _ _ _";
        System.out.println(input_tape);
        if(string == null) {
            System.out.println("valid");
        }
        int halting_state = 0;
        int accept_state = 3;
        int reject_state = 4;

        String read_string;
        int R = 2;

        int previous_state = 0;
        int current_state = 0;


        while(halting_state == 0){
            read_string = input_tape.substring(0, R);
            try {
                //sleep 5 seconds
                Thread.sleep(1800);

                System.out.println(input_tape.substring(0, R-1) + ANSI_RESET + input_tape.charAt(R-1) + ANSI_RED + input_tape.substring(R, input_tape.length()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int length = read_string.length();
            char read_char = read_string.charAt(length-1);

            if(read_char == 'a'){
                System.out.println("a ; a, R");
                R++; //move right, access next char
            }
            else if(read_char == 'b') {
                System.out.println("b ; b, R");
                if(previous_state == 0 && current_state == 0){
                    previous_state = 0;
                    current_state = 1;
                }
                else if (previous_state == 0 && current_state == 1) {
                    previous_state = 1;
                    current_state = 0;
                }
                else if (previous_state == 1 && current_state == 0) {
                    previous_state = 0;
                    current_state = 1;
                }
                R++; //move right, access next char
            }
            else if(read_char == '_'){
                System.out.println("s ; s, R");
                if(previous_state == 1 && current_state == 0){
                    halting_state = accept_state;
                }else if(previous_state == 0 && current_state == 1){
                    halting_state = reject_state;
                }
            }


        }
        if(halting_state == accept_state){
            System.out.println("String accepted.");
        }else{
            System.out.println("String rejected.");
        }
    }


}

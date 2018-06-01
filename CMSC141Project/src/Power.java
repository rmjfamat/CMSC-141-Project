public class Power {
    private static final int TAPE_LENGTH = 1000;
    private static final int DYNAMIC_INCREASE = 25;
    private char[] inputTape = new char[TAPE_LENGTH];
    private int displayTape = 50;

    Power(int n, int m){
        int i = 0;
        inputTape[i++] = '>';
        for (; n > 0; n--) {
            inputTape[i++] = '1';
        }
        inputTape[i++] = '#';
        for (; m > 0; m--) {
            inputTape[i++] = '1';
        }
        inputTape[i++] = '$';
        for (; i < TAPE_LENGTH; i++) {
            inputTape[i] = 'b';
        }

        for (int j = 0; j < displayTape; j++) {
            System.out.print(inputTape[j] + " ");
        }
        System.out.println();
    }

    void check() {
        int head = 0;
        int state = 1;
        boolean right = true;
        while (true) {
            char c = inputTape[head];
            char origC = c;
            int origState = state;
            int origHead = head;
            switch (state) {
                case 0:
                    if (c == 'P') {
                        c = '1';
                    } else if (c == 'b') {
                        return;
                    }
                    right = true;
                case 1:
                    if (c == '>') {
                        // write none
                        right = true;
                        state = 2;
                    }
                    break;
                case 2:
                    if (c == '1') {
                        c = 'Y';
                        right = true;
                        state = 3;
                    } else if (c == '#') {
                        // write none
                        state = 13;
                        right = false;
                    }
                    break;
                case 3:
                    if (c == 'b') {
                        c = '1';
                        right = false;
                        state = 4;
                    } else {
                        right = true;
                    }
                    break;
                case 4:
                    if (c == 'Y') {
                        right = true;
                        state = 2;
                    } else {
                        right = false;
                    }
                    break;
                case 5:
                    if (c == 'Y') {
                        c = '1';
                        right = false;
                    } else if (c == '>') {
                        right = true;
                        state = 6;
                    }
                    break;
                case 6:
                    if (c == '1') {
                        c = '>';
                        state = 9;
                    }
                    break;
                case 7:
                    if (c == '1') {
                        c = 'X';
                        state = 8;
                        right = true;
                    }
                    break;
                case 8:
                    if (c == '1') {
                        c = 'X';
                        state = 12;
                        right = false;
                    } else if (c == '$') {
                        state = 0;
                    }
                    break;
                case 9:
                    if (c == '1') {
                        right = true;
                    } else if (c == '#') {
                        right = true;
                        state = 7;
                    }
                    break;
                case 12:
                    if (c == '>') {
                        right = true;
                        state = 16;
                    }
                    break;
                case 13:
                    if (c == 'b') {
                        right = false;
                        state = 14;
                    } else {
                        right = true;
                    }
                    break;
                case 14:
                    if (c == '1') {
                        c = 'P';
                        right = false;
                        state = 15;
                    } else {
                        right = false;
                    }
                    break;
                case 15:
                    if (c == '#') {
                        state = 5;
                        right = false;
                    } else {
                        right = false;
                    }
                    break;
                case 16:
                    if (c == '1') {
                        c = 'Y';
                        state = 17;
                        right = true;
                    } else if (c == 'Y') {
                        right = true;
                    } else if (c == '#') {
                        state = 23;
                        right = true;
                    }
                    break;
                case 17:
                    if (c == '$') {
                        right = true;
                        state = 18;
                    } else {
                        right = true;
                    }
                    break;
                case 18:
                    if (c == '1') {
                        c = 'Z';
                        right = true;
                        state = 19;
                    } else if (c == 'P') {
                        right = true;
                        state = 21;
                    } else if (c == 'Z') {
                        right = true;
                    }
                    break;
                case 19:
                    if (c == 'b') {
                        c = '1';
                        right = false;
                        state = 20;
                    } else {
                        right = true;
                    }
                    break;
                case 20:
                    if (c == 'Z') {
                        right = true;
                        state = 18;
                    } else {
                        right = false;
                    }
                    break;
                case 21:
                    if (c == 'b') {
                        c = '1';
                        right = false;
                        state = 22;
                    } else if (c == '1') {
                        right = true;
                    }
                    break;
                case 22:
                    if (c == 'Y') {
                        right = true;
                        state = 16;
                    } else if (c == 'Z') {
                        c = '1';
                        right = false;
                    } else {
                        right = false;
                    }
                    break;
                case 23:
                    if (c == 'P') {
                        c = '1';
                        right = true;
                        state = 27;
                    } else {
                        right = true;
                    }
                    break;
                case 24:
                    if (c == '#') {
                        state = 25;
                        right = true;
                    } else {
                        right = true;
                    }
                    break;
                case 25:
                    if (c == '1') {
                        c = 'X';
                        right = false;
                        state = 12;
                    } else if (c == 'X') {
                        right = true;
                    } else if (c == '$') {
                        state = 0;
                    }
                    break;
                case 27:
                    if (c == 'b') {
                        state = 28;
                        right = false;
                    } else {
                        right = true;
                    }
                    break;
                case 28:
                    if (c == '1') {
                        c = 'P';
                        state = 29;
                        right = false;
                    }
                    break;
                case 29:
                    if (c == 'Y') {
                        c = '1';
                        right = false;
                    } else if (c == '>') {
                        right = true;
                        state = 24;
                    } else {
                        right = false;
                    }
                    break;
            }
            inputTape[head] = c;
            if (right) {
                head++;
                if (displayTape <= head && displayTape <= TAPE_LENGTH - DYNAMIC_INCREASE) {
                    displayTape += DYNAMIC_INCREASE;
                }
            } else {
                head--;
            }

            for (int i = 0; i < displayTape; i++) {
                if (!right && i + 1 == origHead) {
                    System.out.print(inputTape[i] + "<");
                } else if (right && i == origHead) {
                    System.out.print(inputTape[i] + ">");
                } else {
                    System.out.print(inputTape[i] + " ");
                }
            }
            System.out.print("Current State: " + origState + " | Next State: " + state + " | " + origC + " ; " + c + ", ");
            if (right) {
                System.out.println("R");
            } else {
                System.out.println("L");
            }
        }
    }
}

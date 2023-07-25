import java.util.Scanner;
import java.util.Arrays;

public class Calculator {
    public static void main(String[] args) {
        String enter, num1, num2;
        int result=0;
        String [] romeNumbers = new String[10];

        romeNumbers[0] = "I";
        romeNumbers[1] = "II";
        romeNumbers[2] = "III";
        romeNumbers[3] = "IV";
        romeNumbers[4] = "V";
        romeNumbers[5] = "VI";
        romeNumbers[6] = "VII";
        romeNumbers[7] = "VIII";
        romeNumbers[8] = "IX";
        romeNumbers[9] = "X";

        Scanner in = new Scanner(System.in);

        System.out.println("Введите арифметическую операцию:");
        //ввод данных
        enter = in.nextLine();
        enter = enter.toUpperCase();
        System.out.println("Вы написали: " + enter);
        String[] strings = enter.split(" ");
        int a, b;
        num1 = strings[0];
        num2 = strings[2];
        char x=strings[1].charAt(0);

        if (Arrays.asList(romeNumbers).contains(num1) && Arrays.asList(romeNumbers).contains(num2)){
            String num = num1;
            a = toArab(num);
            num = num2;
            b = toArab(num);
            switch (x) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
                default:
                    result = 0;
                    System.out.println("Ошибка");
            }
            if (result<=0){
                System.out.println("Ошибка");
            }

        }
        else {
            a = Integer.parseInt(strings[0]);
            b = Integer.parseInt(strings[2]);
            if (a>0 && a<11 && b>0 && b<11) {
                switch (x) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    default:
                        result = 0;
                        System.out.println("Ошибка");
                }
            }
            else {
                System.out.println("Ошибка");
            }
        }
        System.out.println("Результат: "+ result);
    }

    private static int toArab(String num) {
        switch (num) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
        }
        return 0;
    }
//    private static int toArab2(String num2) {
//        switch (num2) {
//            case "I":
//                return 1;
//            case "II":
//                return 2;
//            case "III":
//                return 3;
//            case "IV":
//                return 4;
//            case "V":
//                return 5;
//            case "VI":
//                return 6;
//            case "VII":
//                return 7;
//            case "VIII":
//                return 8;
//            case "IX":
//                return 9;
//            case "X":
//                return 10;
//        }
//        return 0;
//    }
}
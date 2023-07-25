import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        System.out.println("Введите строку для расчета:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toUpperCase();
        try {
            String result = calc(input);
            System.out.println(result);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {

        String num1, num2;
        int a, b;
        int result = 0;
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

        System.out.println("Вы написали: " + input);
        String[] strings = input.trim().split(" ");
        if (strings.length != 3)
            throw new Exception("throws Exception //т.к. неверное количество операндов");

        num1 = strings[0];
        num2 = strings[2];
        char x = strings[1].charAt(0);

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
                    throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    //System.out.println("Ошибка");
            }
            if (result<=0){
                throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
                //System.out.println("Ошибка");
            }
            return roman(result);

        }
        else {
            try {
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[2]);
            } catch (Exception e) {
                throw new Exception("throws Exception //т.к. некорректный тип данных");
            }

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
                        throw new Exception("Некорректный знак математической операции");
                        //System.out.println("Ошибка");
                }
            }
            else {
                throw new Exception("Операнд вне области допустимых значений");
                //System.out.println("Ошибка");
            }
            return String.valueOf(result);
        }

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

    public static String roman(int n) throws Exception{

        if( n <= 0) {
            throw new Exception("Отрицательное римское число");
        }

        StringBuilder buf = new StringBuilder();

        final Numeral[] values = Numeral.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (n >= values[i].weight) {
                buf.append(values[i]);
                n -= values[i].weight;
            }
        }
        return buf.toString();
    }

}
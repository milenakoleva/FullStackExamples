package examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class Controllers {

    @RequestMapping(method = RequestMethod.GET, value = "/api/zad1")
    @ResponseBody
    public String zad1(@RequestParam Map<String, String> request) {

        System.out.print("DEBUG: zad1: " + request);


        int counterP1 = 0;
        int counterP2 = 0;
        int counterP3 = 0;
        int counterP4 = 0;
        int counterP5 = 0;
        for (String input : request.values()) {
            int i = Integer.parseInt(input);

            if (i < 200) {
                counterP1++;
            } else if (i < 400) {
                counterP2++;
            } else if (i < 600) {
                counterP3++;
            } else if (i < 800) {
                counterP4++;
            } else {
                counterP5++;
            }
        }

        String result = "Числата между 0 и 200 са: " + counterP1
                + "\nЧислата между 200 и 400 са: " + counterP2
                + "\nЧислата между 400 и 600 са: " + counterP3
                + "\nЧислата между 600 и 800 са: " + counterP4
                + "\nЧислата между 800 и 1000 са: " + counterP1;

        System.out.print(result);

        return result;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/api/zadlili")
    @ResponseBody
    public String zadLili(@RequestParam Map<String, String> request) {

        System.out.print("DEBUG: zadlili: " + request);

        int age = Integer.parseInt(request.get("age"));
        int washingMachinePrice = Integer.parseInt(request.get("wmp"));
        int toyPrice = Integer.parseInt(request.get("tp"));

        int sum = 0;

        for (int i = 0; i <= age; i++) {
            if (i % 2 == 1) {
                sum += toyPrice;
            } else {
                int presentMoney = (i * 5) - 1;
                sum += presentMoney;
            }
        }

        String result = "Лили разполага с " + sum + " лева \n" +
                "Лили " + (sum > washingMachinePrice ? "" : "не") + " може да си купи пералня";

        System.out.println(result);

        return result;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/api/returntopast")
    @ResponseBody
    public String zadReturnToPast(@RequestParam Map<String, String> request) {

        System.out.print("DEBUG: zadReturnToPast: " + request);

        int money = Integer.parseInt(request.get("money"));
        int year = Integer.parseInt(request.get("year"));

        int totalSpent = 0;

        for (int i = 1800; i <= year; i++) {
            int spent = 12000;
            if (i % 2 != 0) {
                int ageOfIvancho = 18 + (i - 1800);
                spent += (50 * ageOfIvancho);
            }
            totalSpent += spent;
        }

        boolean survive = money > totalSpent;

        String result = survive ? ("Иванчо ще оцелее и ще му останат "+(money - totalSpent)+" лева")
                : ("Иванчо няма да оцелее, няма да му достигнат "+(money - totalSpent)+" лева");

        System.out.println(result);

        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/zadbreaking")
    @ResponseBody
    public String zadbreaking(@RequestParam Map<String, String> request) {

        System.out.print("DEBUG: zadbreaking: " + request);

        int M = Integer.parseInt(request.get("M"));
        int N = Integer.parseInt(request.get("N"));
        int S = Integer.parseInt(request.get("S"));

        int sum = 0;

        StringBuilder Sb= new StringBuilder();


        for (int i = M; i >= N; i--) {
            if (i % 6 == 0) {
                if (S == i) {
                        break;
                }
                Sb.append(i);
                Sb.append(" ");
            }

        }

        String result = Sb.toString();

        System.out.println(result);

        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/zadLogistic")
    @ResponseBody
    public String zadLogistic(@RequestParam Map<String, String> request) {

        System.out.print("DEBUG: zadLogistic: " + request);


        int countMiktobus = 0;
        int countKamion = 0;
        int countVlak = 0;

        int totalWeight = 0;

        for (String t:request.values()) {
           int tovar= Integer.parseInt(t);
            if (tovar < 3) {
                countMiktobus += tovar;
            } else if (tovar < 11) {
                countKamion += tovar;
            } else {
                countVlak += tovar;
            }

            totalWeight += tovar;

        }

        String result = "Процент с микробус" + (countMiktobus * 100f / totalWeight)
                + "\nПроцент с камион" + (countKamion * 100f / totalWeight)
                + "\nпроцент  с влак" + (countVlak * 100f / totalWeight);

        System.out.print(result);

        return result;
    }

}

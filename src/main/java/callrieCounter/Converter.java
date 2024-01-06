package callrieCounter;

public class Converter {
    double stepsToKm = 0;
    double spentCcalories = 0;
    public void convert(int sum){
        stepsToKm = sum * 0.00075; //учитывая что 1 шаг 75см
        spentCcalories = sum * 0.05; //1 шаг 50 калорий
        System.out.println("Пройденная дистанция (в км): " + stepsToKm);
        System.out.println("Количество сожжённых килокалорий: " + spentCcalories);
    }
}

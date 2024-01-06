package callrieCounter;
import java.util.HashMap;

public class StepTrecker {
    int goalStep = 10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();

    Converter converter = new Converter();
    public StepTrecker(){

        MonthData monthData = new MonthData();
        for (int i = 1; i < 13; i++){
            monthToData.put(i, new MonthData());
        }

    }
    public void saveSteps(int month, int day, int stepsPerDay){
        if (stepsPerDay > 0 && day > 0 && day < 31 && month > 0 && month < 12){
            monthToData.get(month).steps[day - 1] = stepsPerDay;
            System.out.println("Ваши шаги сохранены.");
        }
        else{
            System.out.println("Ошибка! Количество шагов не должно быть отрицательным числом, а даты от 1 до 30.");
        }

    }
    public void getStatistics(int month) {
        if (monthToData.containsKey(month)){
            int sum = 0;
            int maxSteps = 0;
            int currentSeries = 0;
            int theBestSeries = 0;

            for (int i = 0; i < monthToData.get(month).steps.length; i++) {
                System.out.println((i + 1) + " день: " + monthToData.get(month).steps[i] + ",");
                sum += monthToData.get(month).steps[i];

                if (monthToData.get(month).steps[i] > maxSteps) {
                    maxSteps = monthToData.get(month).steps[i];
                }
            }
            for (int stepsDay : monthToData.get(month).steps) {
                if (stepsDay > goalStep) {
                    currentSeries++;
                }
                else {
                    if (currentSeries > theBestSeries) {
                        theBestSeries = currentSeries;
                    }
                    currentSeries = 0;
                }
            }

            if (currentSeries > theBestSeries) {
                theBestSeries = currentSeries;
            }

            System.out.println("Общее количество шагов за месяц: " + sum);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
            System.out.println("Среднее количество шагов за месяц: " + sum / monthToData.get(month).steps.length);
            converter.convert(sum);
            System.out.println("Лучшая серия за месяц: " + theBestSeries);
        }
        else{
            System.out.println("Введите номер существующего месяца.");
        }
    }
    public void setNewGoal(int newGoal){
        goalStep = newGoal;
        System.out.println("Ваша новая цель " + goalStep + " шагов.");
    }

    public String MonthName(){
        HashMap<Integer, String> monthName = new HashMap<>();
        int monthNumber = 0;
        monthName.put(1, "январь");
        monthName.put(2, "февраль");
        monthName.put(3, "март");
        monthName.put(4, "апрель");
        monthName.put(5, "май");
        monthName.put(6, "июнь");
        monthName.put(7, "июль");
        monthName.put(8, "август");
        monthName.put(9, "сентябрь");
        monthName.put(10, "октябрь");
        monthName.put(11, "ноябрь");
        monthName.put(12, "декабрь");
        System.out.println(monthName);
        return monthName.get(monthNumber);
    }

    static class MonthData{
        int steps[];
        MonthData(){
            steps = new int[30];
        }

    }
}

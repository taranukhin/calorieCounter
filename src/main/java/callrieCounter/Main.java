package callrieCounter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTrecker stepTrecker = new StepTrecker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0){
            if (userInput > 3 || userInput < 0){
                System.out.println("Неверная команда, выберите команду из пунктов меню.");
            }
            if (userInput == 1){
                System.out.println("Пункт меню №1");
                inputData(scanner,stepTrecker);
            } else if (userInput == 2) {
                System.out.println("Пункт меню №2");
                printStatistics(scanner,stepTrecker);

            } else if (userInput == 3) {
                System.out.println("Пункт меню №3");
                changeStep(scanner, stepTrecker);
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завешена");
    }
    private static void printMenu(){
        System.out.println("______________________МЕНЮ______________________");
        System.out.println("1. Ввести количество шагов за определенный день.");
        System.out.println("2. Напечатать статистику за определенный месяц.");
        System.out.println("3. Изменить цель по количеству шагов в день.");
        System.out.println("0. Выйти из приложения.");
    }
    private static void inputData(Scanner scanner, StepTrecker stepTrecker){
        System.out.println("Укажите месяц: ");
        stepTrecker.MonthName();
        int month = scanner.nextInt();
        System.out.println("Укажите день: ");
        int day = scanner.nextInt();
        System.out.println("Количество пройденных шагов: ");
        int stepsPerDay = scanner.nextInt();
        stepTrecker.saveSteps(month, day, stepsPerDay);

    }
    private static void printStatistics(Scanner scanner, StepTrecker stepTrecker){
        System.out.println("Укажите за какой месяц отобразить статистику: ");
        stepTrecker.MonthName();
        int month = scanner.nextInt();
        stepTrecker.getStatistics(month);
    }
    private static void changeStep(Scanner scanner, StepTrecker stepTrecker){
        System.out.println("Текущая цель : " + stepTrecker.goalStep + " шагов в день");
        System.out.println("Введите новую цель :");
        int steps = scanner.nextInt();
        stepTrecker.setNewGoal(steps);

    }
}

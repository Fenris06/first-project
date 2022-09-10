import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();


        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Введите номер месяц: 0-январь, 1-февраль, 2-март, 3-апрель, 4-май, 5-июнь, 6-июль," +
                        "7-август, 8-сентябрь, 9-октябрь, 10-ноябрь, 11-декабрь.");
                int month = scanner.nextInt();
                System.out.println("Введите день: от 1 до 30");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов в день");
                int stepDay = scanner.nextInt();

                stepTracker.safeDayStep(month, day, stepDay);


            } else if (command == 2) {
                System.out.println("Введите номер месяц: 0-январь, 1-февраль, 2-март, 3-апрель, 4-май, 5-июнь, 6-июль," +
                        "7-август, 8-сентябрь, 9-октябрь, 10-ноябрь, 11-декабрь.");
                int month = scanner.nextInt();
                stepTracker.printAllStepMouth(month);
                System.out.println("Общее количество шагов за месяц: " + stepTracker.sumAllStepMonth(month));
                System.out.println("Максимальное пройденое количество шагов в месяце: " + stepTracker.maxDayStepMonth(month));
                System.out.println("Средние количество шагов: " + stepTracker.middleSumDayStepMouth(month));
                System.out.println("Пройдиная дистанция: " + converter.distanceConvert * stepTracker.sumAllStepMonth(month) + " километров");
                System.out.println("Количество килокалорий: " + (converter.calories * stepTracker.sumAllStepMonth(month)) * converter.kilocalories + " килокалорий");
                System.out.println("Лучшая серия шагов: " + stepTracker.bestSeriesOfStep(month));

            } else if (command == 3) {
                System.out.println("Текущая цель по количеству шагов в день: " + stepTracker.recommendDayStep);
                System.out.println("Введите новое значение.");
                int newRecommendDayStep = scanner.nextInt();
                stepTracker.changeRecommendDayStep(newRecommendDayStep);


            } else if (command == 0) {
                return;

            } else {
                System.out.println("Команда не поддерживается. Введите другую команду.");

            }

        }
    }

    public static void printMenu() {
        System.out.println("Выберите номер команды.");
        System.out.println("1 - Ввести количество шагов за день.");
        System.out.println("2 - Напечатать статистику за месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выйти из приложения.");

    }
}

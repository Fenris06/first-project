public class StepTracker {
    MonthData[] monthToData;
    int recommendDayStep;


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        recommendDayStep = 10000;

    }

    int safeDayStep(int month, int day, int stepADay) {
        if (stepADay >= 0) {
            monthToData[month].daysToMonth[day - 1] = stepADay;
            System.out.println("Данные сохранены.");
        } else {
            System.out.println("Введите положительное количесво шагов.");
        }
        return monthToData[month].daysToMonth[day - 1];


    }

    void printAllStepMouth(int month) {
        int[] day = monthToData[month].daysToMonth;


        for (int i = 0; i < day.length; i++) {
            System.out.print((i + 1) + " День: " + day[i] + ", ");
        }
        System.out.println();
    }

    int sumAllStepMonth(int month) {
        int sum = 0;
        int[] day = monthToData[month].daysToMonth;
        for (int i = 0; i < day.length; i++) {
            sum = sum + day[i];
        }
        return sum;
    }

    int maxDayStepMonth(int month) {
        int maxDayStepMonth = 0;
        int[] day = monthToData[month].daysToMonth;
        for (int i = 0; i < day.length; i++) {
            if (day[i] > maxDayStepMonth) {
                maxDayStepMonth = day[i];
            }
        }
        return maxDayStepMonth;
    }

    int middleSumDayStepMouth(int month) {
        int middleSum = 0;
        int[] day = monthToData[month].daysToMonth;
        for (int i = 0; i < day.length; i++) {
            middleSum = middleSum + day[i] / 30;
        }
        return middleSum;
    }

    void changeRecommendDayStep(int newRecommendDayStep) {
        if (newRecommendDayStep >= 0) {
            recommendDayStep = newRecommendDayStep;
            System.out.println("Новое значение сохранено.");
        } else {
            System.out.println("Введите положительное значение шагов.");
        }
    }

    int bestSeriesOfStep(int month) {
        int[] day = monthToData[month].daysToMonth;
        int maxSeriesStep = 0;
        int bestStepDay = 0;
        for (int i = 0; i < day.length; i++) {
            if (day[i] < recommendDayStep) {
                bestStepDay = 0;
            } else {
                bestStepDay++;
            }
            if (bestStepDay > maxSeriesStep) {
                maxSeriesStep = bestStepDay;
            }
        }
        return maxSeriesStep;
    }


    class MonthData {
        int[] daysToMonth;

        MonthData() {
            daysToMonth = new int[30];
        }

    }
}
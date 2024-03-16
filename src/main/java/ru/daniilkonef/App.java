package ru.daniilkonef;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int totalSimulations = 1000000;
        int switchWins = 0;
        int stayWins = 0;

        Random random = new Random();

        for (int i = 0; i < totalSimulations; i++) {
            // Генерируем случайный выбор двери, за которой находится приз
            int prizeDoor = random.nextInt(3);

            // Участник делает свой первоначальный выбор
            int initialChoice = random.nextInt(3);

            // Ведущий открывает одну из дверей, за которой нет приза
            int openedDoor;
            do {
                openedDoor = random.nextInt(3);
            } while (openedDoor == prizeDoor || openedDoor == initialChoice);

            // Проверяем, выиграл ли участник, сохраняя свой первоначальный выбор
            if (initialChoice == prizeDoor) {
                stayWins++;
            }

            // Проверяем, выиграл ли участник, изменив свой выбор
            int finalChoice;
            do {
                finalChoice = random.nextInt(3);
            } while (finalChoice == openedDoor || finalChoice == initialChoice);

            if (finalChoice == prizeDoor) {
                switchWins++;
            }
        }

        double switchWinPercentage = (double) switchWins / totalSimulations * 100;
        double stayWinPercentage = (double) stayWins / totalSimulations * 100;

        System.out.println("При изменении выбора: " + switchWinPercentage + "% выигрышей.");
        System.out.println("При сохранении исходного выбора: " + stayWinPercentage + "% выигрышей.");
    }
    }


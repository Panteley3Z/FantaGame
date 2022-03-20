import java.util.Scanner;

public class Seller {

    public static void giveGoods() {
        System.out.println("Приветствую тебя, странник! Что выбираешь?\n1. Лечение\n2. Ограбить кассу");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                int apteka = 20;
                int patientHealth = WorldG.gamer.getHealth() + apteka;
                WorldG.gamer.setHealth(patientHealth);
                System.out.printf("Здоровье поднято до %s процентов%n", WorldG.gamer.getHealth());
            }
            case 2 -> {
                WorldG.gamer.setGold(10_000);
                System.out.printf("Ты ограбил кассу! Теперь у тебя %s $%n", WorldG.gamer.getGold());
            }
            case 3 -> System.out.println("Nothing... Goodbye!");
        }
    }

}

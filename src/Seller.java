public class Seller {

    public static void giveGoods(String choice) {
        System.out.println("Приветствую тебя, странник! Что выбираешь?\n1. Лечение\n2. Ограбить кассу");
        switch (choice) {
            case "1" -> {
                int apt = 20;
                int patientHealth = WorldG.gamer.getHealth() + apt;
                WorldG.gamer.setHealth(patientHealth);
                System.out.printf("Здоровье поднято до %s единиц", WorldG.gamer.getHealth());
            }
            case "2" -> {
                WorldG.gamer.setGold(10_000);
                System.out.printf("Ты ограбил кассу! Теперь у тебя %s $ ", WorldG.gamer.getGold());
            }
            case "3" -> System.out.println("Ничего так ничего!");
        }
    }

}

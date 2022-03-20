import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorldG {

    private static BufferedReader bufRead;
    static Creature gamer = null;
    private static Battle battle = null;

    public static void main(String[] args) {
        bufRead = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.print("- Назовитесь, о благородный рыцарь! \n- Имя моё ");
        try {
            gameOptions(bufRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gameOptions(String m) throws IOException {
        System.out.println("_________________________________________________");
        if (gamer == null) {
            gamer = new Knight (m, 100, 20, 20, 0, 0);
            System.out.printf("- Ну что ж, %s, Ты вызвался спасти эту землю от страшного врага! Да прибудет с тобой сила!%n", gamer.getName());
            gameNavigation();
        }

        switch (m) {
            case "1" -> {
                System.out.println("\nИдем в магазин!");
                takeGoods();
            }
            case "2" -> {
                commitFight();
                System.out.println("    Удачи!");
            }
            case "3" -> System.exit(1);
            case "да" -> gameOptions("2");
            case "нет" -> {
                gameNavigation();
                gameOptions(bufRead.readLine());
            }
        }
        gameOptions(bufRead.readLine());
    }

    private static void takeGoods() {
        Seller.giveGoods();
        System.out.println("\nДальше в боевой поход? (да/нет)");
        try {
            gameOptions(bufRead.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gameNavigation() {
        System.out.println("\nКуда пойдешь?\n1. К Торговцу\n2. Биться, конечно!\n3. Че-то ссыкотно. Пожалуй дома посижу. Да и нога болит...");
    }

    private static void commitFight() {
        battle.fight(gamer, createOpponent(), new FightResult() {
            @Override
            public void fightWin() {
                System.out.printf("      * * *\nВеликий воин %s, Ты победил! Теперь у тебя:\n    (%d) опыта;\n    (%d) золота;  \nЗдоровья осталось %d единиц.%n", gamer.getName(), gamer.getXp(), gamer.getGold(), gamer.getHealth() );
                System.out.println("\nДальше в боевой поход? (да/нет)");
                try {
                    gameOptions(bufRead.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void fightLost() {
                System.out.printf("\n    ГАЗЕТА БОЙ\n  Хроника боевого сражения.\nСегодня доблестный воин %s был сражен в битве с неравным врагом...%n", gamer.getName());
                System.exit(1);
            }
        } );
    }

    private static Creature createOpponent() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) {
            return new Monster ("Монстрище", 50, 20, 20, 100, 20);
        } else {
            return new Skeleton ("Чудик", 25, 10, 10, 50, 10
            );
        }
    }
}
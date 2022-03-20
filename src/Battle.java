public class Battle {

    public void fight(Creature gamer, Creature opponent, FightResult fightResult) {
        Runnable runnable = () -> {
            int gameStep = 1;
            boolean isFightEnded = false;
            System.out.printf("\n  Ты идешь по дремучему лесу, и внезапно из кустов вылезает %s!\nНо ты был готов к этому! Начинается кровавый бой!%n", opponent.getName());
            while (!isFightEnded) {
                System.out.println("\n- - - Удар " + gameStep + " - - -");
                if (gameStep++ % 2 != 0) {
                    isFightEnded = makeHit(opponent, gamer, fightResult);
                } else {
                    isFightEnded = makeHit(gamer, opponent, fightResult);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(Creature defender, Creature attacker, FightResult fightResult) {
        int hit = attacker.attack();
        int defenderHealth = defender.getHealth() - hit;
        if (defenderHealth < 0) {
            defenderHealth = 0;
        }
        if (hit != 0) {
            if (defender instanceof Knight) {
                System.out.printf("%s Нанес тебе удар в %d единиц!%n", attacker.getName(), hit);
                if (defenderHealth == 0) {
                    System.out.println("У тебя совсем не осталось здоровья...");
                } else {
                    System.out.printf("У тебя осталось %d единиц здоровья...%n", defenderHealth);
                }
            } else {
                System.out.printf("Ты Нанес удар в %d единиц!%n", hit);
                if (defenderHealth == 0) {
                    System.out.printf("У %s совсем не осталось здоровья, чудище погибает!%n", defender.getName() );
                } else {
                    System.out.printf("У %s осталось %d единиц здоровья...%n", defender.getName(), defenderHealth);
                }
            }
        } else {
            System.out.println("Трах!-Бах!\nПыль-грязь...");
        }
        if (defenderHealth <= 0 && defender instanceof Knight) {
            System.out.println("Печальная весть...");
            fightResult.fightLost();
            return true;
        } else if(defenderHealth <= 0) {
            System.out.printf("\nВраг повержен! Ты получил:\n    (%d) опыта и (%d) золота!%n", defender.getXp(), defender.getGold());
            attacker.setXp(attacker.getXp() + defender.getXp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            fightResult.fightWin();
            return true;
        } else {
            defender.setHealth(defenderHealth);
            return false;
        }
    }
}
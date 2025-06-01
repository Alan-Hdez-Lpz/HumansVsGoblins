import java.util.Scanner;

public class HumansVsGoblins {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean validationStartGameAnswer;
        String startGameAnswer;
        Goblin goblin = new Goblin();
        Human human = new Human();
        Land land = new Land();

        System.out.println("Humans VS Goblins");
        do{
            System.out.println("Do you want to start? (Y/N)");
            startGameAnswer = input.next();
            if (startGameAnswer.equalsIgnoreCase("y")) {
                validationStartGameAnswer = true;
            } else if (startGameAnswer.equalsIgnoreCase("n")) {
                validationStartGameAnswer = true;
            } else {
                System.out.println("Invalid input");
                validationStartGameAnswer = false;
            }
        }while(!validationStartGameAnswer);

        if(startGameAnswer.equalsIgnoreCase("y")){
            human.setHumanInitialPosition();

            do{
                goblin.setGoblinInitialPosition();
            } while (human.getPositionX() == goblin.getPositionX() && human.getPositionY() == goblin.getPositionY());

            land.createLand(human,goblin);

            boolean combatValidation;
            do{
                String humanMovement;
                boolean validationHumanMovement;
                do{
                    System.out.println("Human turn (insert n/s/e/w):");
                    humanMovement = input.next();
                    if (humanMovement.equalsIgnoreCase("n")) {
                        validationHumanMovement = true;
                        if((human.getPositionX()-1) >= 0){
                            human.setPositionX(human.getPositionX()-1);
                        } else {
                            System.out.println("It's not possible to make that movement, enter another cardinal point");
                            validationHumanMovement = false;
                        }
                    } else if (humanMovement.equalsIgnoreCase("s")) {
                        validationHumanMovement = true;
                        if((human.getPositionX()+1) < land.getLand().length){
                            human.setPositionX(human.getPositionX()+1);
                        } else {
                            System.out.println("It's not possible to make that movement, enter another cardinal point");
                            validationHumanMovement = false;
                        }
                    } else if (humanMovement.equalsIgnoreCase("e")) {
                        validationHumanMovement = true;
                        if((human.getPositionY()+1) < land.getLand().length){
                            human.setPositionY(human.getPositionY()+1);
                        } else {
                            System.out.println("It's not possible to make that movement, enter another cardinal point");
                            validationHumanMovement = false;
                        }
                    } else if (humanMovement.equalsIgnoreCase("w")) {
                        validationHumanMovement = true;
                        if((human.getPositionY()-1) >= 0){
                            human.setPositionY(human.getPositionY()-1);
                        } else {
                            System.out.println("It's not possible to make that movement, enter another cardinal point");
                            validationHumanMovement = false;
                        }
                    } else{
                        System.out.println("Invalid input");
                        validationHumanMovement = false;
                    }
                }while(!validationHumanMovement);

                if(human.getPositionX() == goblin.getPositionX() && human.getPositionY() == goblin.getPositionY()){
                    combatValidation = true;
                    human.calculateCombatValue();
                    goblin.calculateCombatValue();
                    land.combat(human,goblin);
                } else {
                    land.createLand(human,goblin);
                    String goblinMovement;
                    boolean validationGoblinMovement;
                    do{
                        System.out.println("Goblin turn (insert n/s/e/w):");
                        goblinMovement = input.next();
                        if (goblinMovement.equalsIgnoreCase("n")) {
                            validationGoblinMovement = true;
                            if((goblin.getPositionX()-1) >= 0){
                                goblin.setPositionX(goblin.getPositionX()-1);
                            } else {
                                System.out.println("It's not possible to make that movement, enter another cardinal point");
                                validationGoblinMovement = false;
                            }
                        } else if (goblinMovement.equalsIgnoreCase("s")) {
                            validationGoblinMovement = true;
                            if((goblin.getPositionX()+1) < land.getLand().length){
                                goblin.setPositionX(goblin.getPositionX()+1);
                            } else {
                                System.out.println("It's not possible to make that movement, enter another cardinal point");
                                validationGoblinMovement = false;
                            }
                        } else if (goblinMovement.equalsIgnoreCase("e")) {
                            validationGoblinMovement = true;
                            if((goblin.getPositionY()+1) < land.getLand().length){
                                goblin.setPositionY(goblin.getPositionY()+1);
                            } else {
                                System.out.println("It's not possible to make that movement, enter another cardinal point");
                                validationGoblinMovement = false;
                            }
                        } else if (goblinMovement.equalsIgnoreCase("w")) {
                            validationGoblinMovement = true;
                            if((goblin.getPositionY()-1) >= 0){
                                goblin.setPositionY(goblin.getPositionY()-1);
                            } else {
                                System.out.println("It's not possible to make that movement, enter another cardinal point");
                                validationGoblinMovement = false;
                            }
                        } else{
                            System.out.println("Invalid input");
                            validationGoblinMovement = false;
                        }
                    }while(!validationGoblinMovement);

                    if(human.getPositionX() == goblin.getPositionX() && human.getPositionY() == goblin.getPositionY()){
                        combatValidation = true;
                        human.calculateCombatValue();
                        goblin.calculateCombatValue();
                        land.combat(human,goblin);
                    } else {
                        land.createLand(human,goblin);
                        combatValidation = false;
                    }
                }
            }while (!combatValidation);
        }
    }
}

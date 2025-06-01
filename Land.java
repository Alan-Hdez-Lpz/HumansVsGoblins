public class Land {
    private String[][] land = new String[10][10];

    public String[][] getLand() {
        return land;
    }

    public void setLand(String[][] land) {
        this.land = land;
    }

    public void createLand() {
        String[][] newLand = getLand();
        for (int i=0; i<newLand.length;i++){
            for (int j=0;j<newLand[i].length;j++){
                newLand[i][j] = this.toString();
            }
        }
        setLand(newLand);
    }

    public void createLand(Human human, Goblin goblin) {
        String[][] updatedLand = getLand();
        createLand();
        updatedLand[human.getPositionX()][human.getPositionY()] = human.toString();
        updatedLand[goblin.getPositionX()][goblin.getPositionY()] = goblin.toString();
        drawLand();
    }

    public void drawLand(){
        String[][] landToDraw = getLand();
        for (String[] rows : landToDraw) {
            for (String columns : rows) {
                System.out.print(columns);
            }
            System.out.println();
        }
    }

    public void combat(Human human, Goblin goblin) {
        float humanValue;
        float goblinValue;

        System.out.println("Combat started.....");
        createLand();
        String[][] existingLand = getLand();
        existingLand[human.getPositionX()][human.getPositionY()] = "\uD83E\uDD4A";
        drawLand();

        do{
            humanValue = human.getCombatValue();
            goblinValue = goblin.getCombatValue();
        } while (humanValue == goblinValue);
        if(humanValue > goblinValue){
            System.out.println("Human WON the combat \uD83C\uDFC6");
        } else {
            System.out.println("Goblin WON the combat \uD83C\uDFC6");
        }
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }
}

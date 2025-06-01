import java.util.Random;

public class Human {
    private int positionX;
    private int positionY;
    private float combatValue;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public float getCombatValue(){
        return combatValue;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setCombatValue(float combatValue) {
        this.combatValue = combatValue;
    }

    public void setHumanInitialPosition(){
        Random random = new Random();
        setPositionX(random.nextInt(9));
        setPositionY(random.nextInt(9));
    }

    public void calculateCombatValue(){
        Random random = new Random();
        setCombatValue((random.nextFloat(100) + random.nextFloat(100)) / 2);
    }

    @Override
    public String toString() {
        return "\uD83D\uDE00";
    }
}

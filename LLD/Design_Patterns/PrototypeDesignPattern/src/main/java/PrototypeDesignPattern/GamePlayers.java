package PrototypeDesignPattern;

public class GamePlayers implements Clonable{
    private String name;
    private int health;
    private int power;
    private int defensePower;

    public GamePlayers(String name, int health, int power, int defensePower){
        // Here we are connecting with database on cloud which is very expensive.
        this.name = name;
        this.health = health;
        this.power = power;
        this.defensePower = defensePower;
    }
    private GamePlayers(GamePlayers player){
        // using this copy constructor we can create new objects without expensive tasks

        this.name = player.name;
        this.defensePower = player.defensePower;
        this.power = player.power;
        this.health = player.health;
    }
    public Clonable clone(){
        return new GamePlayers(this);
    }

    public void describe(){
        System.out.println("Name: "+this.getName());
        System.out.println("Power: "+this.getPower());
        System.out.println("DefensePower: "+this.getDefensePower());
        System.out.println("Health: "+this.getHealth());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}

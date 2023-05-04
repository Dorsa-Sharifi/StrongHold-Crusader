package model.Building;

import model.Empire;
import model.GroundType;

import java.util.HashMap;

public class StoneGateWay extends Building implements BuildingConstantFunctions {
    public StoneGateWay(Empire government) {
        super(government);

    }

    private static Names name;
    private int capacity;
    private static Names direction;
    private boolean isGateOpen;
    private boolean isGateConquered;
    private int maxCapacity;

    private int currentCapacity;

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public static Names getNames() {
        return name;
    }

    public void setNames(Names names) {
        name = names;
    }

    private int hp;
    private int maxHP;
    private String groundType = GroundType.DEFAULT.getGroundType();

    public String getGroundType() {
        return groundType;
    }

    public void setGroundType(String groundType) {
        this.groundType = groundType;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isGateOpen() {
        return isGateOpen;
    }

    public boolean isGateConquered() {
        return isGateConquered;
    }
    //    public HashMap<String, Integer> cost = new HashMap<>();

    //TODO: call createBuildingCost before usage
    public void createBuildingCost(int wood, int stone, int gold, int iron, int oil) {
        cost.put("wood", wood);
        cost.put("stone", stone);
        cost.put("gold", gold);
        cost.put("iron", iron);
        cost.put("oil", oil);
    }

    public HashMap<String, Integer> workersNeeded = new HashMap<>();

    public void createBuildingWorkersNeeded(int engineer, int worker) {
        workersNeeded.put("engineer", engineer);
        workersNeeded.put("worker", worker);

    }

    //TODO make a condition in the Building menu to see whether we have Gateway or not if we don't make an error
    //TODO TAX FUNCTION IN GOVERNMENT MENU FOR GATES
    public void smallGateWay(Names directionOfGate) {
        hp = 500;
        maxHP = 500;
        name = Names.SMALL_STONE_GATE_HOUSE;
        direction = directionOfGate;
        capacity = 8;
        createBuildingCost(0, 0, 0, 0, 0);
        createBuildingWorkersNeeded(0, 0);
    }

    public void bigGateWay(Names directionOfGate) {
        hp = 700;
        maxHP = 700;
        name = Names.BIG_STONE_GATE_HOUSE;
        direction = directionOfGate;
        capacity = 10;
        createBuildingWorkersNeeded(0, 0);
        createBuildingCost(0, 20, 0, 0, 0);
    }

    @Override
    public int maxHp() {
        return maxHP;
    }

    @Override
    public int hp() {
        return hp;
    }

    @Override
    public String groundType() {
        return groundType;
    }

    @Override
    public String showBuildingName() {
        return name.getName();
    }
}
package model.Building;

import model.Empire;

import java.util.HashMap;

public class PrepareLaboursAndFighters extends Building implements BuildingConstantFunctions {
    public PrepareLaboursAndFighters(Empire government) {
        super(government);
    }

    private int costOfBarracks;
    private int costOfMercenary;
    private int costOfLadderMan;
    private int costOfEngineer;
    private int costOfTunneler;
    private Names name;

    public Names getName() {
        return name;
    }

    public void setName(Names name) {
        this.name = name;
    }

    public int getCostOfBarracks() {
        return costOfBarracks;
    }

    public void setCostOfBarracks(int costOfBarracks) {
        this.costOfBarracks = costOfBarracks;
    }

    public int getCostOfMercenary() {
        return costOfMercenary;
    }

    public void setCostOfMercenary(int costOfMercenary) {
        this.costOfMercenary = costOfMercenary;
    }

    public int getCostOfLadderMan() {
        return costOfLadderMan;
    }

    public void setCostOfLadderMan(int costOfLadderMan) {
        this.costOfLadderMan = costOfLadderMan;
    }

    public int getCostOfEngineer() {
        return costOfEngineer;
    }

    public void setCostOfEngineer(int costOfEngineer) {
        this.costOfEngineer = costOfEngineer;
    }

    public int getCostOfTunneler() {
        return costOfTunneler;
    }

    public void setCostOfTunneler(int costOfTunneler) {
        this.costOfTunneler = costOfTunneler;
    }

    public HashMap<String, Integer> cost = new HashMap<>();

    //TODO call createBuildingCost before usage
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

    public void barracks() {
        costOfBarracks=50;
        name = Names.BARRACK;
        createBuildingCost(0, 15, 0, 0, 0);
        createBuildingWorkersNeeded(0 , 0);
    }

    public void mercenary() {
        costOfMercenary=30;
        name = Names.MERCENARY_POST;
        createBuildingCost(10, 0, 0, 0, 0);
        createBuildingWorkersNeeded(0 , 0);
    }

    public void engineerGuild() {
        //TODO : ADD ENGINEERS AND LADDERMAN TO THE ARRAYLIST OF SPECIALIZED BUILDING
        costOfEngineer=40;
        costOfLadderMan=20;
        name = Names.ENGINEER_GUILD;
        createBuildingCost(10, 0, 100, 0, 0);
        createBuildingWorkersNeeded(0 , 0);
    }

    public void tunnelerGuild() {
        name = Names.TUNNELER;
        createBuildingCost(10, 0, 100, 0, 0);
        createBuildingWorkersNeeded(0 , 0);
    }

    @Override
    public int maxHp() {
        return 0;
    }

    @Override
    public int hp() {
        return 0;
    }

    @Override
    public String groundType() {
        return null;
    }

    @Override
    public String showBuildingName() {
        return name.getName();
    }
}

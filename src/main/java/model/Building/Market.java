package model.Building;

import model.Empire;

import java.util.HashMap;

public class Market extends Building implements BuildingHPAndGroundType {

    Market(Empire government) {
        super(government);
    }

    private Names names;

    public Names getNames() {
        return names;
    }

    //TODO add WORKER
    public HashMap<String, Integer> cost = new HashMap<>();

    //TODO call createBuildingCost before usage
    public void createBuildingCost(int wood, int stone, int gold, int iron, int oil) {
        cost.put("wood", wood);
        cost.put("stone", stone);
        cost.put("gold", gold);
        cost.put("iron", iron);
        cost.put("oil", oil);
    }

    public void market() {
        names = Names.MARKET;
        createBuildingCost(5, 0, 0, 0, 0);
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
}
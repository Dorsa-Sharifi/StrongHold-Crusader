import controller.JsonController;
import controller.PathFindingController;
import model.*;
import model.Building.*;
import model.Human.Troop.ArchersAndThrowers;
import model.Obstacle.Obstacle;
import model.Obstacle.ObstacleName;
import model.Obstacle.WaterSources;
import view.BuildingMenu;
import view.GameMenu;
import view.LoginMenu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.Math.floor;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        User newUser = new User("user6", "aa", "ali", "a", "1", "1", 1);
        User newUser1 = new User("user6", "aa", "dorsa", "a", "1", "1", 1);
        Empire empire = new Empire();
        Empire empire1 = new Empire();
        Manage.setCurrentEmpire(empire);
        Map.CreateMap(200);
        empire.setUser(newUser);
        empire1.setUser(newUser1);
        empire.setEngineerCount(60000000);
        empire.setWorkerCount(500000);
        empire.setWoodCount(20000000);
        empire.setStoneCount(300000);
        empire.setGoldCount(1000000);
        empire.setOilAmount(1000000);
        empire.setIronCount(10000000);
        empire.setEuropeArcherCount(4);
        ArchersAndThrowers archerEnemy = new ArchersAndThrowers(empire1);
        archerEnemy.archer(2,3);
        ArchersAndThrowers archers1 = new ArchersAndThrowers(empire);
        archers1.archer(2,3);
        System.out.println("Army : "+archers1+" owner: "+archers1.getOwner().getName());
        ArchersAndThrowers archers2 = new ArchersAndThrowers(empire);
        archers2.archer(2,3);
        System.out.println("Army : "+archers2+" owner: "+archers2.getOwner().getName());
        ArchersAndThrowers archers3 = new ArchersAndThrowers(empire);
        archers3.archer(2,3);
        System.out.println("Army : "+archers3+" owner: "+archers3.getOwner().getName());
        ArchersAndThrowers archers4 = new ArchersAndThrowers(empire);
        archers4.archer(2,3);
        System.out.println("Army : "+archers4+" owner: "+archers4.getOwner().getName());
        Map.getTroopMap()[2][3].add(archers1);
        Map.getTroopMap()[2][3].add(archers2);
        Map.getTroopMap()[2][3].add(archers3);
        Map.getTroopMap()[2][3].add(archers4);
        empire.empireArmy.add(archers1);
        empire.empireArmy.add(archers2);
        empire.empireArmy.add(archers3);
        empire.empireArmy.add(archers4);
        Map.notPassable[2][3] = false;
        GameMenu gameMenu = new GameMenu();
        gameMenu.run(scanner);
    }
}
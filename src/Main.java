import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // PHASE 1 - U1.
        // return all items create from the Item Object.
        HashMap<Integer, Item> u1Phase1ItemList = Simulation.loadItems("phase-1.txt");
        // load items and return all fully loaded U1s
        ArrayList<Rocket> phase1U1s = Simulation.loadU1(u1Phase1ItemList);
        double phase1U1Budget = Simulation.runSimulation(phase1U1s); // $400.0m
        System.out.println("$" + phase1U1Budget + "m");


        // Phase-2 U1.
        HashMap<Integer, Item> u1Phase2ItemList = Simulation.loadItems("phase-2.txt");
        ArrayList<Rocket> phase2U1s = Simulation.loadU1(u1Phase2ItemList);
        double phase2U1Budget = Simulation.runSimulation(phase2U1s); // $600.0m
        System.out.println("$" + phase2U1Budget + "m");

        // Phase-1 U2.
        HashMap<Integer, Item> u2Phase1ItemList = Simulation.loadItems("phase-1.txt");
        ArrayList<Rocket> phase1U2s = Simulation.loadU2(u2Phase1ItemList);
        double phase1U2Budget = Simulation.runSimulation(phase1U2s); // $960.0m
        System.out.println("$" + phase1U2Budget + "m");

        // Phase-2 U2.
        HashMap<Integer, Item> u2Phase2ItemList = Simulation.loadItems("phase-2.txt");
        ArrayList<Rocket> phase2U2s = Simulation.loadU1(u2Phase2ItemList);
        double phase2U2Budget = Simulation.runSimulation(phase2U2s); // $1160.0m
        System.out.println("$" + phase2U2Budget + "m");

    }
}

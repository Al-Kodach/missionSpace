import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Simulation {
    static double budget;

    public Simulation() {
        budget = 0;
    }

    static  double runSimulation(ArrayList<Rocket> list) {
//        int num = 0; //failed trials of launch/land
//        int indexSuccess = 1;
//        for (Rocket r : list) {
//
//            while (!r.launch()) {
//                r.launch();
//                num++;
//                System.out.println("Extra trials: " + num);
//            }
//            System.out.println("No." + indexSuccess + " rocket launched");
//
//            while (!r.land()) {
//                r.land();
//                num++;
//                System.out.println("Extra trials: " + num);
//            }
//            System.out.println("No." + indexSuccess + " rocket landed\n");
//            indexSuccess++;
//        }
//        int budget = list.get(0).cost * (list.size() + num);
//        System.out.println(list.size() + " rockets and " + num + " extra trials = "
//                + (list.size() + num) + " in total");

        for (Rocket rocket: list) {
            if (rocket.launch()) {
                System.out.println("rocket launch successful");

                if (rocket.land()) {
                    System.out.println("rocket land successful");
                } else {
                    // increase budget
                    // build new
                    budget+= rocket.cost;
                }
            } else {
                budget += rocket.cost;
            }
        }

        return budget;
    }

    static HashMap<Integer, Item> loadItems(String doc) {
        // store all instance of Item Object.
        HashMap<Integer, Item>  allItems = new HashMap<>();
        int counter = 0;

        // copy data from the file provided.
        try {
            // create a new file with the passed in file
            File file = new File(doc);
            // scan data in the files.
            Scanner scanner = new Scanner(file);
            // iterate through the info.
            // loop will continue if there is data at next line.
            while (scanner.hasNextLine()) {
                // convert string into an array of two element.
                String[] arr = scanner.nextLine().split("=");
                // create item from the Item class.
                Item item = new Item(arr[0], Integer.parseInt(arr[1]));
                // add item
                allItems.put(counter, item);
                counter++;
            }
            // throw error if file not found
        } catch (FileNotFoundException e) {
           System.out.println("No file found");
        }

        // return the array containing all the items instances from the file
        return allItems;
    }

    static ArrayList<Rocket> loadU1(HashMap<Integer, Item> itemsArray) {
        ArrayList<Rocket> allU1s = new ArrayList<>();

        int size = itemsArray.size();
        U1 newU1 = new U1(100, 10, 18);

        while (size > 0) {
            Item item = itemsArray.get(size - 1);

            if (newU1.canCarry(item.weight)) {
                newU1.carry(item);
            } else {
                allU1s.add(newU1);
                budget += newU1.cost;
                // create new U1
                newU1 = new U1(100, 10, 18);
            }

            size--;
        }
        // return all U1s
        return allU1s;
    }

    static ArrayList<Rocket> loadU2(HashMap<Integer, Item> items) {
        ArrayList<Rocket> allU2s = new ArrayList<>();
        int size = items.size();
        U2 u2 = new U2(120, 18, 29);

        while (size > 0) {
            Item item = items.get(size - 1);

            if (u2.canCarry(item.weight)) {
                u2.carry(item);
            } else {
                allU2s.add(u2);
                budget += u2.cost;
                // create new U1
                u2 = new U2(120, 18, 29);
            }
            size--;
        }

       return allU2s;
    }
}

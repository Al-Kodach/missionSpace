public class Rocket implements SpaceShip {
    int cost;
    int weight;
    int maxWeight;

    public Rocket(int cost, int weight, int maxWeight) {
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    public final boolean canCarry(int weight) {
        return ( this.weight + weight / 1000 ) <= maxWeight;
    }

    public final void carry(Item item) {
        // convert from kg to tons
        weight += (item.weight / 1000);
    }

    public boolean land() {
        return true;
    }

    public boolean launch() {
        return true;
    }
}

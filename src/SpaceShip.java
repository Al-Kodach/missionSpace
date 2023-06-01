public interface SpaceShip {
    boolean  canCarry(int weight);
    void carry(Item item);
    boolean land();
    boolean launch();
}

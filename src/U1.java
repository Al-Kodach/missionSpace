public  class U1 extends Rocket {
    double launchExplosion;
    double landingCrash;
    double currentWeight;

    public U1(int cost, int weight, int maxWeight) {
        super(cost, weight, maxWeight);
        launchExplosion = 0.0;
        landingCrash = 0.0;
        this.currentWeight = weight;
    }

    public boolean launch() {
        int random = (int)(Math.random() * 100 + 1);
        this.launchExplosion = 5.0 * (this.currentWeight - this.weight) / (this.maxWeight - this.weight);

        return this.launchExplosion <= random;
    }

    public boolean land() {
        int random = (int)(Math.random() * 100 + 1);
        this.landingCrash = (this.currentWeight - this.weight) / (this.maxWeight - this.weight);

        return this.landingCrash <= random;
    }
}

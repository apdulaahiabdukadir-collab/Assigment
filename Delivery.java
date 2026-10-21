abstract class Delivery {

    protected int distance;
    protected int weight;

    Delivery() {
        distance = 0;
        weight = 0;
    }

    Delivery(int distance, int weight) {
        this();
        this.distance = distance;
        this.weight = weight;
    }

    public abstract long calculateFee();
}
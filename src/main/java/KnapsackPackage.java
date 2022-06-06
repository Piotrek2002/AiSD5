public class KnapsackPackage {

    private double weight;
    private double value;
    private Double cost;
    private int id;

    public KnapsackPackage(double weight, double value, int id) {
        super();

        this.weight = weight;
        this.value = value;
        this.cost = value / weight;
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public Double getCost() {
        return cost;
    }
    public int getId(){
        return id;
    }

}

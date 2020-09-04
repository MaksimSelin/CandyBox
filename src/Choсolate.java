public class Choсolate extends Sweetness {

    private String type;

    public Choсolate(String name, int weight, int price, String type) {
        super(name, weight, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Candy{" + super.toString() +
                ", type='" + type +
                '}';
    }
}

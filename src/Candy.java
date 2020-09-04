public class Candy extends Sweetness {

    private String manufacturer;


    public Candy(String name, int weight, int price, String manufacturer) {
        super(name, weight, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Candy{" + super.toString() +
                ", manufacturer='" + manufacturer +
                "'}";
    }
}

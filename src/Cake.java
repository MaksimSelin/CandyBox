public class Cake extends Sweetness {

    private String form;

    public Cake(String name, int weight, int price, String form) {
        super(name, weight, price);
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Candy{" + super.toString() +
                ", form='" + form +
                '}';
    }
}

public class Runner {
    public static void main(String[] args) {
        Candy candy1 = new Candy("candy1", 100, 50, "1");
        Candy candy2 = new Candy("candy2", 200, 20, "2");
        Choсolate choсolate = new Choсolate("chocolate", 9, 80, "chocolate");
        Cake cake = new Cake("cake", 78, 90, "cake");
        BoxImpl box = new BoxImpl(10);
        box.addLast(candy1);
        box.addByIndex(11, candy2);
        box.addLast(cake);
        box.addByIndex(9,candy2);
        box.addLast(choсolate);
        box.deleteByIndex(15);
        box.deleteByIndex(8);
//        box.deleteByIndex(9);
 //       box.deleteLast();
        System.out.println("WightBox = " + box.weight());
        System.out.println("PriceBox = " + box.price());
        box.info();
//        box.optimizedByWeight(305);
//        box.info();
        box.optimizedByPrice(150);
        box.info();
    }
}

public class BoxImpl implements Box{

    private int size;
    private Sweetness[] candyBox;
    private int maxIndex;
    private int numberOfSweetness = 0;

    @Override
    public void addByIndex(int index, Sweetness sweetness) {
        if (numberOfSweetness < size) {
            if (index < size) {
                if (candyBox[index] == null) {
                    candyBox[index] = sweetness;
                    numberOfSweetness++;
                    if (maxIndex < index) maxIndex = index;
                    System.out.println("position " + index + " filled");
                } else System.out.println("position " + index + " already filled");
            } else System.out.println("Index is out of range");
        }
        else System.out.println("overflow");
    }

    @Override
    public void addLast(Sweetness sweetness) {
        if (numberOfSweetness==0) maxIndex = -1;
        if (numberOfSweetness < size) {
            if (maxIndex < size - 1) {
                candyBox[maxIndex + 1] = sweetness;
                maxIndex++;
                numberOfSweetness++;
                System.out.println("position " + maxIndex + " filled");
            } else System.out.println("overflow");
        }
        else System.out.println("overflow");
    }

    @Override
    public void deleteByIndex(int index) {
        if (numberOfSweetness != 0) {
            if (index < size) {
                if (candyBox[index] != null) {
                    candyBox[index] = null;
                    System.out.println("sweetness by index: " + index + " deleted");
                    numberOfSweetness--;
                    if (numberOfSweetness == 0) return;
                    if (index == maxIndex) {
                        for (int i = maxIndex - 1; i >= 0; i--) {
                            if (candyBox[i] != null) {
                                maxIndex = i;
                                break;
                            }
                        }
                    }
                } else System.out.println("Index is empty");
            } else System.out.println("Index is out of range");
        } else System.out.println("Box is empty");
    }

    @Override
    public void deleteLast(){
        if (numberOfSweetness!=0){
            candyBox[maxIndex] = null;
            numberOfSweetness--;
            System.out.println("sweetness by index: " + maxIndex + " deleted");
            if (numberOfSweetness==0) return;
            else for (int i = maxIndex - 1; i >= 0; i--) {
                if (candyBox[i] != null) {
                    maxIndex = i;
                    break;
                }
            }

        }
        else System.out.println("Box is empty");
    }

    @Override
    public int weight() {
        int weightBox = 0;
        if (numberOfSweetness !=0) {
            for (int i = 0; i <= maxIndex; i++){
                if (candyBox[i]!= null)
                    weightBox = weightBox + candyBox[i].getWeight();
            }
            return weightBox;
        }else return weightBox;
    }

    @Override
    public int price() {
        int priceBox = 0;
        if (numberOfSweetness !=0){
            for (int i = 0; i <= maxIndex; i++){
                if (candyBox[i]!=null)
                    priceBox = priceBox + candyBox[i].getPrice();
            }
            return priceBox;
        }else return priceBox;
    }

    @Override
    public void info() {
        if (numberOfSweetness !=0){
            System.out.println("=================================");
            for (int i = 0; i < size; i++){
                if (candyBox[i]!=null) System.out.println("position " + i + " " + candyBox[i]);
                else System.out.println("position "+ i +" is empty");
            }
            System.out.println("=================================");
        }
        else System.out.println("box is empty");
    }

    public BoxImpl(int size) {
        this.size = size;
        candyBox = new Sweetness[size];
    }

    public void optimizedByWeight(int weight){
        if (weight()>=weight){
            deleteByIndex(minIndexWeight());
            optimizedByWeight(weight);
        }
        else System.out.println("Box does not need optimization");
    }

    public int minIndexWeight(){
        int index = 0;
        int min = 0;
        for (int i = 0; i <= maxIndex; i++){
            if (candyBox[i]!= null){
                index = i;
                min = candyBox[i].getWeight();
                break;
            }
        }
        if(index < maxIndex) {
            for (int i = index + 1; i <= maxIndex; i++) {
                if (candyBox[i] != null) {
                    if (candyBox[i].getWeight() < min) {
                        min = candyBox[i].getWeight();
                        index = i;
                    }
                }
            }
        }
        return index;
    }

    public void optimizedByPrice(int price){
        if (price()>=price){
            deleteByIndex(minIndexPrice());
            optimizedByPrice(price);
        }
        else System.out.println("Box does not need optimization");
    }

    public int minIndexPrice(){
        int index = 0;
        int min = 0;
        for (int i = 0; i <= maxIndex; i++){
            if (candyBox[i]!= null){
                index = i;
                min = candyBox[i].getPrice();
                break;
            }
        }
        if(index < maxIndex) {
            for (int i = index + 1; i <= maxIndex; i++) {
                if (candyBox[i] != null) {
                    if (candyBox[i].getPrice() < min) {
                        min = candyBox[i].getPrice();
                        index = i;
                    }
                }
            }
        }
        return index;
    }

}

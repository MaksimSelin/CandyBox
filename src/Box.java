public interface Box {

    void addByIndex(int index, Sweetness sweetness);
    void addLast(Sweetness sweetness);
    void deleteByIndex(int index);
    void deleteLast();
    int weight();
    int price();
    void info();
}

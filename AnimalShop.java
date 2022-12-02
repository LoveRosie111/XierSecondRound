package XierOnline;

/**
 接口
 */
public interface AnimalShop {
    public default void purchaseAnimal(){
        System.out.println("买入新动物");
    }
    public default void open(){
        System.out.println("欢迎光临");
    }
    public default void close(){
        System.out.println("歇业中");
    }
}

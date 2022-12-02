package XierOnline;

public class Customer {
    private String name;
    private int times;
    private static LocalDate date;

    public Customer(String name, int times, String tempTime) {
        this.name = name;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public static LocalDate getDate() {
        return date;
    }

    public static void setDate(LocalDate date) {
        Customer.date = date;
    }

    //这里怎么重写没搞懂呜呜呜
    //TODO
    public String toString() {
        System.out.println(
                "name:" + getName() +
                " times" + getTimes() +
                " date" + getDate());
        return toString();
    }
}

package XierOnline;

import java.util.ArrayList;
import java.util.Scanner;

public class MyAnimalShop implements AnimalShop{
    private String name;
    private static double remain;
    private boolean isWorking ;
    Scanner sc=new Scanner(System.in);
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Customer> MemoryCustomers = new ArrayList<>();
    /**
     顾客买动物
     */
    public void buyAnimal(){
        switch (inputInt("需要买什么宠物？猫（1），狗（2），兔（3）")) {
            case 1:
                buyDogView(sc);
                break;
            case 2:
                buyCatView(sc);
                break;
            case 3:
                buyRabbitView(sc);
            default:
                break;
        }

    }

    private void buyCatView(Scanner sc) {
        System.out.println("它的名字是：");
        int flag=0;
        String temp=sc.next();
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i).getName()==temp){
                animals.get(i).toString();
                remain+=animals.get(i).getPrice();
                animals.remove(temp);
                System.out.println("恭喜你收获甜心一枚，你要好好爱他噢");
                flag=1;
            }
        }
        try {
            checkhaveAnimal(flag);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void buyRabbitView(Scanner sc) {
        System.out.println("它的名字是：");
        int flag=0;
        String temp=sc.next();
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i).getName()==temp){
                animals.get(i).toString();
                remain+=animals.get(i).getPrice();
                animals.remove(temp);
                System.out.println("恭喜你收获甜心一枚，你要好好爱他噢");
                flag=1;
            }
        }
        try {
            checkhaveAnimal(flag);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void buyDogView(Scanner sc) {
        System.out.println("它的名字是：");
        int flag=0;
        String temp=sc.next();
        for (int i = 0; i < animals.size(); i++) {
            if(animals.get(i).getName()==temp){
                animals.get(i).toString();
                remain+=animals.get(i).getPrice();
                animals.remove(temp);
                System.out.println("恭喜你收获甜心一枚，你要好好爱他噢");
                flag=1;
            }
        }
        try {
            checkhaveAnimal(flag);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void checkhaveAnimal(int flag) throws AnimalNotFoundException{
        if(flag!=1){
            throw new AnimalNotFoundException("他不在这里捏，或者说他还没来我们店呢");
        }else{
            System.out.println("找到啦");
        }
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
    /**
        买入动物
     */
    public void purchaseAnimal() {
        int choice = inputInt("你的宠物是？狗（1），猫（2），兔子（3）");
        switch (choice) {
            case 1:
                purchaseDogView();
                break;
            case 2:
                purchaseCatView();
                break;
            case 3:
                purchaseRabbitView();
                break;
            default:
                break;
        }
    }
    // 添加动物 private boolean addPet(Pet pet);
    private static boolean addAnimal(ArrayList<Animal> animals, Animal animal) {
        try {
            checkRemain(remain,animal);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        animals.add(animal);
        return true;
    }
    public static void checkRemain(double remain,Animal animal) throws InsufficientBalanceException{
        if(animal.price>MyAnimalShop.remain) {
            throw new InsufficientBalanceException("没钱了呜呜呜");
        }else {
            System.out.println("钱还在够的哈哈哈");
        }
    }
    // 买入动物 ,在该方法调用 addAnimal，方法。
    public boolean purchasePet(Animal animal) {
        return this.addAnimal(animals,animal);
    }

    private void purchaseRabbitView() {
        String name = inputStr("兔兔叫什么名字？");
        String sex = inputStr("是什么性别的兔子？");
        int age = inputInt("兔子年龄多大？");
        double price = inputDouble("您卖多少钱呢？");
        Rabbit rabbit= new Rabbit(name, age, sex, price);
        boolean purchasePet = MyAnimalShop.addAnimal(animals,rabbit);
        System.out.println(purchasePet ? "收购成功！" : "收购失败！");
    }

    private void purchaseCatView() {
        String name = inputStr("猫猫叫什么名字？");
        String sex = inputStr("是什么性别的猫？");
        int age = inputInt("猫年龄多大？");
        double price = inputDouble("您卖多少钱呢？");
        Cat cat = new Cat(name, age, sex, price);
        boolean purchasePet = MyAnimalShop.addAnimal(animals,cat);
        System.out.println(purchasePet ? "收购成功！" : "收购失败！");
    }

    private void purchaseDogView() {
        String name = inputStr("狗狗叫什么名字？");
        String sex = inputStr("是什么性别的狗？");
        int age = inputInt("狗年龄多大？");
        double price = inputDouble("您卖多少钱呢？");
        Dog dog = new Dog(name, age, sex, price);
        boolean purchasePet = MyAnimalShop.addAnimal(animals,dog);
        System.out.println(purchasePet ? "收购成功！" : "收购失败！");
    }

    // 输入int方法
    public int inputInt(String tip) {
        System.out.println(tip);
        return sc.nextInt();
    }

    public double inputDouble(String tip) {
        System.out.println(tip);
        return sc.nextDouble();
    }

    // 输入String方法
    public String inputStr(String tip) {
        System.out.println(tip);
        return sc.next();
    }



    public void showPets() {
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).getName()+
                    " "+ animals.get(i).getAge()+" "+ animals.get(i).getSex()+
                    " "+ animals.get(i).getPrice());
        }
    }
}

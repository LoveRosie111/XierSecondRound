package XierOnline;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        //空的顾客列表
        ArrayList<Customer> Customers = new ArrayList<>();
        MyAnimalShop Shop=new MyAnimalShop();
        //初始化动物
        Shop.setName("RosiePetShop");
        System.out.println(Shop.getName());

        Shop.animals.add(new Cat("莉莉", 4, "母", 200));
        Shop.animals.add(new Dog("小黑", 2, "公", 100));
        Shop.animals.add(new Rabbit("cute", 4, "母", 200));
        Shop.animals.add(new Cat("xx", 4, "母", 200));
        Shop.animals.add(new Cat("yy", 4, "母", 200));
        Shop.animals.add(new Dog("zz", 4, "母", 100));
        Shop.animals.add(new Rabbit("qq", 4, "母", 200));
        //初始化余额
        Shop.setRemain(500000);
        //招待客户
        while (true) {
            System.out.println("先生/女士 ，您好，由于疫情防控需要，请你扫码登记信息,时间格式为hh:mm");
            String tempName= sc.next();
            String tempTime = sc.next();
            int flag=0;
            for (int i = 0; i < Shop.MemoryCustomers.size(); i++) {
                if(tempName==Shop.MemoryCustomers.get(i).getName()){
                    Shop.MemoryCustomers.get(i).setTimes(Shop.MemoryCustomers.get(i).getTimes()+1);
                    flag=1;
                }
            }
            if(flag==0)Shop.MemoryCustomers.add(new Customer(tempName,1,tempTime));
            System.out.println("您好，请问你是要买宠物（1）？还是要出售宠物（2）？查看所有宠物（3）？还是随便看看然后离开（0）？");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Shop.buyAnimal();
                    break;
                case 2:
                    Shop.purchaseAnimal();
                    break;
                case 3:
                    Shop.showPets();
                    break;
                default:
                    System.out.println("再见...");
                    return;
            }
            if(tempTime.compareTo("17:30")>0){
                System.out.println("下班啦！");
                Shop.setWorking(false);
                break;
            }else Shop.setWorking(true);
        }
        if(Shop.isWorking()==false){
            for (int i = 0; i < Shop.MemoryCustomers.size(); i++) {
                System.out.println(Shop.MemoryCustomers.get(i).getName()+
                        " "+Shop.MemoryCustomers.get(i).getTimes());
            }
            System.out.println(Shop.getRemain());
        }
    }
}

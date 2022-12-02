package XierOnline;

import java.util.Enumeration;

public class Dog extends Animal{
    //成员变量
    private boolean isVaccinelnjected() {
        return true;
    }
    public Dog(String name, int age, String sex, double price) {
        super(name, age, sex, 100);
    }

    @Override
    public String toString() {
        return "name:"+getName()+
                " age:"+getAge()+
                " sex:"+getSex()+
                " price"+getPrice()+
                " 疫苗注射情况"+isVaccinelnjected();
    }


}

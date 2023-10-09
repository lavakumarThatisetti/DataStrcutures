package Temp;

import java.util.EnumMap;

public class EnumMain {
    enum MyFruits{
        Apple, Mango, Banana, StraBerry
    }

    public static void main(String[] args) {
        EnumMap<MyFruits,String> obj=new EnumMap<MyFruits, String>(MyFruits.class);
        obj.put(MyFruits.Apple,"Red");
        obj.put(MyFruits.Mango,"Green");
        System.out.println("Set1 "+obj);
        EnumMap<MyFruits,String> obj2=new EnumMap<MyFruits, String>(MyFruits.class);
        obj2.putAll(obj);
        obj2.put(MyFruits.Banana,"Yelllow");
        System.out.println("Set1 2"+obj2);
    }
}

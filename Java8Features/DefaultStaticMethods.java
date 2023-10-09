package Java8Features;

/**
 * Inside functional Interface Default and static methods
 * also allowed
 *
 * Interface contains only one abstract function then called Fucntional Interface
 * restriction only for Abstract Method
 * Not for Default and  static methods
 * @FunctionalInterface To Specify the interface explicitly its a Functional Interface
 */

@FunctionalInterface
interface A{

    void m1();
    default void m2(){
        System.out.println("Default is allowed in FI");
    }
    static void m3(){
        System.out.println("This is Static");
    }

}

@FunctionalInterface
interface B extends A{
    void m1(); // Valid as Function name is same from parent
    //void childMethod(); // Invalid extra functions
}

@FunctionalInterface
interface Interf {
    void add(int a , int b); // Valid as parent has only one function
}


class Demo implements A{


    public void m3(){
        System.out.println("helelo");
    }

    @Override
    public void m1() {
        System.out.println("Demo");
    }

}



public class DefaultStaticMethods {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.m1();
        d.m2();
        A i = new Demo();
        i.m1();
        A le = ()-> System.out.println("Helo");
        le.m1();
        Interf  interf = (a,b)-> System.out.println(a+b);
        interf.add(10,20);


    }
}


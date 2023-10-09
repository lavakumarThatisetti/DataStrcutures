package Temp;

import java.util.HashMap;
import java.util.Map;

interface ifDemo{
    void print();
}

abstract class absDemo{
    abstract void print();
    public absDemo(){
        System.out.println("abstract Constructor");
    }
}

class ImplInterface implements ifDemo{

    @Override
    public void print() {
        System.out.println("Impl Interface");
    }
    void subMethod(){
        System.out.println("Sub method");
    }
}

class ExtendAbstract extends absDemo{

    @Override
    void print() {
        System.out.println("extend Abstract");
    }
}

interface A{

}

class One{
    void print(){
        System.out.println("One");
    }
}
class Two extends One{
    void twoPrint(){
        System.out.println("two print");
    }
}

public class Inhertiance_absrtact {
    public static void main(String[] args) {
        // Map is Abstract Cannot be instantiated
        // Map<String,String> map = new Map<>();  --> Error

        ImplInterface implInterface =  new ImplInterface();
        implInterface.print();
        ExtendAbstract extendAbstract = new ExtendAbstract();
        extendAbstract.print();

//        ImplInterface implInterface1  = new ifDemo();
//        ImplInterface implInterface2  = new absDemo();
          ifDemo demo = new ifDemo() {
              @Override
              public void print() {
                  System.out.println("lava");
              }
          };
        demo.print();

        ifDemo a  = new ImplInterface();
        a.print();   // Only interface methods can only access

        absDemo absDemo = new ExtendAbstract();
        absDemo.print();

        Map<String,String> map = new HashMap<>();

        //ImplInterface implInterface2  = new absDemo();

        /*

        Interfaces and Abstracts cannot be instantiated
        In Interfaces we cannot create constructors as impl is not allowed
        In Abstract we can create constructors as we cannot implement functions
        Interface and Abstract can create objects but not instaniated
         */

        One one = new One();
        one.print();
   //     Two two = new One(); // Upcasting error parent instanation to child
     //   two.twoPrint();
        One one1 = new Two();
        one1.print(); // Only get parent functions visible




    }

}

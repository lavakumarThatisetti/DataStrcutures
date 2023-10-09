package Java8Features;

class Parent{
    static int x =5;
    void print(){
        System.out.println("In Parent");
    }
}

class Child1 extends Parent{
    void print(){
        System.out.println("In Child1");
    }
}

public class InheritancEUpcasting {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.x);
        Parent parent2 = new Parent();
        parent2.x =6;
        System.out.println(parent2.x);
        System.out.println(parent.x);

        Parent parent1 = new Child1();

        Child1 child1 = new Child1();

        parent1.print();

       // Child1 child2 = new Parent();
    }
}

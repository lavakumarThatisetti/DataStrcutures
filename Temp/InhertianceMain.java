package Temp;


class Test<T extends HackClass1>{
    private T myObj;
    public Test(T obj){
        this.myObj=obj;
    }
    public void hackFun(){
        this.myObj.hackFunc1();
    }
}
class HackClass1{
    public void hackFunc1(){
        System.out.println("st1");
    }
}
class HackClass2 extends HackClass1{
    public void hackFunc1(){
        System.out.println("st2");
    }
}
class HackClass3 extends HackClass1{
    public void hackFunc1(){
        System.out.println("st3");
    }
}
public class InhertianceMain {
    public static void main(String[] args) {
        Test<HackClass3> hackClass3Test = new Test<HackClass3>(new HackClass3());
        hackClass3Test.hackFun();
        Test<HackClass2> hackClass3Test1 = new Test<HackClass2>(new HackClass2());
        hackClass3Test1.hackFun();
        Test<HackClass1> hackClass3Test2 = new Test<HackClass1>(new HackClass1());
        hackClass3Test2.hackFun();
    }

}

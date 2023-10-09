package Temp;

class HackClass<T>{
    T hackOnj;
    HackClass(T hackOnj){
        this.hackOnj = hackOnj;
    }
    public T hackFunc(){
        return this.hackOnj;
    }
}
interface Java{
    void fc();
}
public class HackClassMain {
    public static void main(String[] args) {
        HackClass<Integer> hackobj= new HackClass<Integer>(15);
        System.out.println(hackobj.hackFunc());
        HackClass<String> hackobjStr= new HackClass<String>("Fuck");
        System.out.println(hackobjStr.hackFunc());

    }
}

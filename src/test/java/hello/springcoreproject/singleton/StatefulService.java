package hello.springcoreproject.singleton;

public class StatefulService {
//    private int price; // 상태를 유지하는 필드 10000-> 20000

    public int order(String name, int price) {
        System.out.println("name = " + name + "price = "+ price);
//        this.price = price;   // Here is the problem!!
        return price;

    }

//    public int getPrice() {
////        return price;
//    }
}

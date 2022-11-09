package hello.springcoreproject.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {          // 인스턴스의 참조를 꺼낼 수 있는 건 얘밖에 없음
        return instance;                                    // 생성할 수 있는 곳은 아무 곳도 없음
    }

    private SingletonService() {                          // 생성자를 private으로 막기
                                                            // 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막아야 한다.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

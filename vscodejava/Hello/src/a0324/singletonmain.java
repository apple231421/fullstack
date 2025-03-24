package a0324;

public class singletonmain {
    public static void main(String[] args) {

        singleton s1 = singleton.getinstance();
        singleton s2 = singleton.getinstance();
        singleton s3 = singleton.getinstance();

        // singleton s4 = new singleton();

        // 객체를 한번만 만들기 위해서

        // 싱글톤 패턴은 하나의 인스턴스만 유지하여 메모리 절약과
        // 성능 최적화
    }
}
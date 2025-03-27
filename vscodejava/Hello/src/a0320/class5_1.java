

public class class5_1 {
    public static void main(String[] args) {
    //person1이라는 객체는 만들고 생성자에 "홍길동" 31 넣어 출력하시오
    Person1 p1 = new Person1("홍길동",31);
    Person1 p2 = new Person1();

    p2.name = "이순신";
    p2.age = 25;    


    System.out.println("이름은 "+p1.name+ "이고 나이는 "+p1.age+"입니다.");
    System.out.println("이름은 "+p2.name+ "이고 나이는 "+p2.age+"입니다.");
        }
    }
        
    class Person1{
        String name;
        int age;
       
        public Person1(String n, int a) {
            name = n;
            age = a;
        }

        //  기본생성자+-
        public Person1(){

        }


        //자바프로그램이 알아서 기본생성자를 만들어 준다.
        // public Person1(){

        // }




    }

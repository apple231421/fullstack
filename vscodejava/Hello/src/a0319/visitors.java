package a0319;

public class visitors {
    public static void main(String[] args) {
        String[] a = {"서울","부산","인천","대전","대구"};
        int[] b = {599,51,46,43,27};

        for(int i=0;i<a.length;i++){
            
            System.out.printf("%s : %d 명\n", a[i], b[i]);
        }
    }

}

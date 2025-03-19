package a0319;


public class Score {
    public static void main(String[] args) {
        int[][] score = {{100,95,46},{20,20,20},{30,30,30},{40,40,40}};
        Score(score);
    }
    
    public static void Score(int[][] as){
        int sum = 0;
        int[] total = new int[as[0].length]; //합계
        double[]avg = new double[as.length]; //평균

        System.out.println("번호 국어 영어 수학 합계 평균");
        System.out.println("================================");
        
        for(int i = 0; i < as.length; i++){
            sum = 0;
            System.out.printf("%3d",i+1);
            for(int j = 0; j < as[i].length; j++){
                sum += as[i][j];
                total[j] += as[i][j];
                System.out.printf("%5d",as[i][j]);
            }
            avg[i] = (double)sum / as[i].length;
            System.out.printf("%5d %5.1f \n",sum ,avg[i]);
        }
        System.out.println("================================");
        System.out.print("총점:");
        for(int k = 0; k < as[0].length; k++){
            System.out.printf("%4d ", total[k]);
        }
    }
}

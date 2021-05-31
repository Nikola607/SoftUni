public class ClockTower {
    public static void main(String[] args) {

        for(int i = 0; i<=23; i++) {
            for (int j = 0; j <= 59; j++) {
                for (int h = 0; h <= 59; h++) {
                    System.out.printf("%d : %d : %d\n", i, j,h);
                }
            }
        }
    }
}

package Audit_Algorithm;

public class E267_find_total_2_number_in_array {
    public static void main(String[] args) {
        int[] arrayInt = {1,10,2,11,6,3};
        int sum = 9;
        int[] result = find(arrayInt,sum);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static int[] find(int[] arrayInt, int sum) {
        for (int i = 0; i < arrayInt.length - 1; i++) {
            if (i > sum){
                continue;
            }
            for (int j = i + 1; j <arrayInt.length ; j++) {
                if (arrayInt[i] + arrayInt[j] == sum) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }
}

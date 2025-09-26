import java.security.SecureRandom;

public class RollDice {
    public static void main(String[] args) {
        SecureRandom randomNumber = new SecureRandom();

        int[] frequency = new int[7]; // 使用索引1-6

        for (int roll = 0; roll < 60000000; roll++) {
            int face = 1 + randomNumber.nextInt(6); // 產生1到6的數字
            frequency[face]++;
        }

        System.out.printf("%s%10s%n", "面值", "出現次數");
        for (int face = 1; face < frequency.length; face++) {
            System.out.printf("%4d%10d%n", face, frequency[face]);
        }

    }
}
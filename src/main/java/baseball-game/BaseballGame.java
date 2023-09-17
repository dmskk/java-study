import java.util.*;

public class BaseballGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static int[] initNumbers() {
        Set<Integer> numbers = new HashSet<>(3);
        while (numbers.size() < 3) {
            numbers.add(1 + RANDOM.nextInt(9));
        }
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] stringToIntArray(String str) {
        int[] input = new int[3];
        int idx = 0;
        for (char c : str.toCharArray()) {
            input[idx++] = Character.getNumericValue(c);
        }
        return input;
    }

    private static boolean action(int[] guess, int[] input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == input[i]) {
                strike++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (guess[j] == input[i]) {
                        ball++;
                        break;
                    }
                }
            }
        }
        if (ball != 0) {
            System.out.println(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        return strike == 3;
    }

    public static void main(String[] args) {
        boolean flag = false;
        boolean turn = true;
        while (turn) {
            int[] guess = initNumbers();
            while (!flag) {
                System.out.print("숫자를 입력해 주세요 : ");
                String str = String.valueOf(SCANNER.nextInt());
                int[] input = stringToIntArray(str);
                flag = action(guess, input);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int num = SCANNER.nextInt();
            turn = num == 1;
            flag = false;
        }
    }
}

import java.util.*;

public class BaseballGame {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static List<Integer> initNumbers() {
        Set<Integer> numbers = new HashSet<>(3);
        while (numbers.size() < 3) {
            numbers.add(1 + RANDOM.nextInt(9));
        }
        return new ArrayList<>(numbers);
    }

    private static List<Integer> stringToIntArray(String str) {
        List<Integer> input = new ArrayList<>(3);
        for (char c : str.toCharArray()) {
            input.add(Character.getNumericValue(c));
        }
        return input;
    }

    private static boolean action(List<Integer> guess, List<Integer> input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(input.get(i))) {
                strike++;
            } else if (guess.contains(input.get(i))) {
                ball++;
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
            List<Integer> guess = initNumbers();
            while (!flag) {
                System.out.print("숫자를 입력해 주세요 : ");
                String str = String.valueOf(SCANNER.nextInt());
                List<Integer> input = stringToIntArray(str);
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

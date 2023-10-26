package main.java.level1;

// level 1-3
// 양의 정수를 입력받고 1부터 해당 입력값 사이의 모든 소수를 출력합니다.
// (조건: -1을 입력하면 프로그램을 종료하며, 소수 판별 함수에 메모이제이션 기법을 적용하여 최적화 합니다.)
public class Solution {

    private boolean[] isPrime;
    private StringBuilder sb;

    public void solution (int input) {
        if (input == -1) {
            System.exit(0);
        }

        sb = new StringBuilder();
        isPrime = new boolean[input + 1];
        isPrime[0] = true;

        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i + i; j <= input; j += i) {
                isPrime[j] = true;
            }
        }

        for (int i = 1; i < isPrime.length; i++) {
            if (!isPrime[i]) sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

}

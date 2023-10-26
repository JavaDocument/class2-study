package main.java.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private boolean[] isPrime;

    public void solution() {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("== 입력 ==\n숫자 입력 : ");
            int input = 0;

            try {
                input = Integer.parseInt(br.readLine());
                if (input == -1) {
                    break;
                }
            } catch (IOException e) {
                 System.out.println("정수를 입력해주세요");
                 continue;
            } catch (NumberFormatException e) {
                System.out.println("올바른 정수를 입력해주세요");
                continue;
            }

            isPrime = new boolean[input + 1];
            isPrime[0] = true;
            isPrime(input);

            sb.append("== 결과 ==\n");
            for (int i = 1; i < isPrime.length; i++) {
                if (!isPrime[i]) {
                    sb.append("- ").append(i).append(" \n");
                }
            }

            System.out.println(sb);
            sb.setLength(0);
        }

        System.out.println("== 종료 ==");
    }

    private void isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i + i; j <= num; j += i) {
                isPrime[j] = true;
            }
        }
    }
}

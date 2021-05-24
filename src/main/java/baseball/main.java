package baseball;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        int com[] = new int[3];

        for(int i = 0; i < com.length; i++) {
            com[i] = (int)(Math.random()*9 +1);
            if(i >= 1 && com[i-1] == com[i]) {
                i--;
                break;
            }
            System.out.println(com[i]);
        }// 난수 생성

        compareNum(com);

    }

    public static void compareNum(int com[]) {
        Scanner sc = new Scanner(System.in);
        int selNum;
        int InNum;
        int strike;
        int ball;
        int num[] = new int[3];
        while(true) {
            strike = 0;
            ball = 0;
            System.out.println("숫자를 입력해주세요: ");
            InNum = sc.nextInt();

            for(int i = num.length-1; i >= 0; i--) {
                num[i] = InNum % 10;
                InNum /= 10;
            }//입력값 받아 배열로 저장

            for(int i = 0; i < com.length; i++) {
                for(int j = 0; j  < num.length; j++) {
                    if(com[i] == num[j] && i == j) {
                        strike++;
                    }
                    else if(com[i] == num[j] && i != j) {
                        ball++;
                    }
                }
            }//배열로 비교

            if(strike == 0 && ball == 0) {
                System.out.println("낫싱");
            }
            else if(strike == 3) {
                System.out.println(strike + " 스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                selNum = sc.nextInt();
                if(selNum == 2)
                {
                    break;
                }

            }
            else if(ball == 0){
                System.out.println(strike + " 스트라이크 ");
            }
            else if(strike == 0) {
                System.out.println(ball + "볼");
            }
            else
            {
                System.out.println(strike + " 스트라이크 " + ball + "볼");
            }
        }
    }
}


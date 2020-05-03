package study.测试;

import java.util.Scanner;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/30 17:03
 */

public class Poker {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNextLine()){
            String str=scanner.nextLine();
            int [] cards=new int[str.length()];
            for (int i = 0; i <str.length() ; i++) {
                if (str.charAt(i) == 'A') {
                    cards[0]=cards[0]+1;
                }else {
                    int num=str.charAt(i);
                    cards[num]=cards[num]+1;
                }
            }
            System.out.println(Poker(cards));
        }
    }
    //打牌
    public static int Poker(int[] cards){
        return subPoker(cards,0);
    }

    private static int subPoker(int[] cards, int k){
        int ans = Integer.MAX_VALUE;
        if (k >= cards.length) {
            return 0;
        }
        //当前牌出完，出下一张
        else if (cards[k] == 0){
            return subPoker(cards,k+1);
        }
        //出连对
        if (k <= cards.length - 3 && cards[k] >= 2 && cards[k+1] >= 2 && cards[k+2] >=2){
            cards[k] -= 2;
            cards[k+1] -= 2;
            cards[k+2] -= 2;
            ans = Math.min(1+subPoker(cards,k),ans);
            cards[k] += 2;
            cards[k+1] += 2;
            cards[k+2] += 2;
        }
        //出顺子
        if (k <= cards.length - 5 && cards[k] >= 1 && cards[k+1] >= 1 && cards[k+2] >=1 && cards[k+3] >= 1 && cards[k+4] >= 1){
            cards[k] -= 1;
            cards[k+1] -= 1;
            cards[k+2] -= 1;
            cards[k+3] -= 1;
            cards[k+4] -= 1;
            ans = Math.min(1+subPoker(cards,k),ans);
            cards[k] += 1;
            cards[k+1] += 1;
            cards[k+2] += 1;
            cards[k+3] += 1;
            cards[k+4] += 1;
        }
        //出对子
        if (cards[k] >= 2){
            cards[k] -= 2;
            ans = Math.min(1+subPoker(cards,k),ans);
            cards[k] += 2;
        }
        //出单牌
        if (cards[k] >= 1){
            cards[k] -= 1;
            ans = Math.min(1+subPoker(cards,k),ans);
            cards[k] += 1;
        }

        return ans;

    }
}

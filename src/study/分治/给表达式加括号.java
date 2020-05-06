package study.分治;

import java.util.ArrayList;
import java.util.List;

public class 给表达式加括号 {
    public static void main(String[] args) {
        new 给表达式加括号().diffWaysToCompute("2-1-1");
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }

    public List<Integer> diffWaysToCompute1(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (res == null) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}

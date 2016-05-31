package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by ksk on 2016-04-14.
 */
class MyLinkedStack {
    private Node top;
    private Node list;
    private int size = 0;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        public String toString() {
            return String.valueOf(this.data);
        }
    }

    void push(Object input) {
        Node newNode = new Node(input);
        newNode.next = top;
        top = newNode;
        size++;
        if (top.next == null) {
            list = top;
        }
    }

    Object pop() {
        //삭제될 데이터를 추출하기 위해 temp를 사용
        Node temp = top;

        top = top.next;

        Object returnData = temp.data;
        temp = null;

        size--;
        return returnData;
    }

    boolean isEmpty() {
        return top == null;
    }

    Object getTop() {
        return top.data;
    }

    public String toString() {
        //노드가 없다면 []를 리턴합니다.
        if (top == null) {
            return "[]";
        }

        //탐색을 시작합니다.
        Node temp = top;
        String str = "[";
        //다음 노드가 없을 때까지 반복문을 실행합니다.
        //마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
        while (temp.next != null) {
            str += temp.data + ",";
            temp = temp.next;
        }

        //while문에서 빠진 마지막 노드를 포함시킵니다.
        str += temp.data;
        return str + "]";
    }
}

class Calculator {
    private final char LEFT_PARENTHESIS = '(';
    private final char RIGHT_PARENTHESIS = ')';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final char PLUS = '+';
    private final char MINUS = '-';

    private MyLinkedStack stack;

    public Calculator() {
        stack = new MyLinkedStack();
    }

    boolean isSymbol(char charValue) {
        switch (charValue) {
            case LEFT_PARENTHESIS:
            case RIGHT_PARENTHESIS:
            case MULTIPLY:
            case DIVIDE:
            case PLUS:
            case MINUS:
                return true;
        }

        return false;
    }

    int getPrior(char operator, boolean inStack) {
        int priority = -1;
        switch (operator) {
            case LEFT_PARENTHESIS:
                // 왼쪽 괄호의 경우 항상 예외로 스택에 넣어줘야 하기 때문에 0이어야 하는데
                //괄호 다음의 기호를 넣어줄 때는 영향을 받지 않기 위해 3이어야 하므로
                //밑에와 같이 구분을 지어준다.
                if (inStack)
                    priority = 3;
                else
                    priority = 0;
                break;
            case MULTIPLY:
            case DIVIDE:
                priority = 1;
                break;
            case PLUS:
            case MINUS:
                priority = 2;
                break;
        }
        return priority;
    }

    boolean isPrior(char token, char stack) {
        return getPrior(token, false) < getPrior(stack, true);
    }

    List<String> getToken(String inFixValue) {
        int position = 0;
        List<String> inFixTokenArry = new ArrayList<String>();
        for (int i = 0; i < inFixValue.length(); i++) {
            if (isSymbol(inFixValue.charAt(i))) {
                if (!inFixValue.substring(position, i).equals("")) {
                    inFixTokenArry.add(inFixValue.substring(position, i));
                }
                inFixTokenArry.add(inFixValue.substring(i, i + 1));
                position = i + 1;
            } else {
                if (i == inFixValue.length() - 1) {
                    inFixTokenArry.add(inFixValue.substring(position, i + 1));
                }
            }
        }
        return inFixTokenArry;
    }

    List<String> getPostFix(String input) {
        String poped;
        List<String> postFixArry = new ArrayList<String>();
        for (String token : getToken(input)) {
            if (Pattern.matches("^\\d*(\\.?\\d*)$", token)) {
                postFixArry.add(token);
            } else {
                if (token.charAt(0) == RIGHT_PARENTHESIS) {
                    while (!stack.isEmpty()) {
                        poped = (String) stack.pop();

                        if (poped.charAt(0) == LEFT_PARENTHESIS) {
                            break;
                        } else {
                            postFixArry.add(poped);
                        }
                    }
                } else {
                    while (!stack.isEmpty() && !isPrior(token.charAt(0), ((String) stack.getTop()).charAt(0))) {
                        poped = (String) stack.pop();
                        if (poped.charAt(0) != LEFT_PARENTHESIS) {
                            postFixArry.add(poped);
                        }
                    }
                    stack.push(token);
                }
            }
        }

        while (!stack.isEmpty()) {
            postFixArry.add((String) stack.pop());
        }

        return postFixArry;
    }

    double calculate(List<String> input) {
        double result = 0.0;
        double operand1, operand2;

        for(String token :input){
            if (Pattern.matches("^\\d*(\\.?\\d*)$", token)) {
                stack.push(String.valueOf(token));
            } else {
                operand1 = Double.parseDouble((String) stack.pop());
                operand2 = Double.parseDouble((String) stack.pop());

                switch (token.charAt(0)) {
                    case MULTIPLY:
                        result = operand1 * operand2;
                        break;
                    case DIVIDE:
                        result = operand2 / operand1;
                        break;
                    case PLUS:
                        result = operand1 + operand2;
                        break;
                    case MINUS:
                        result = operand2 - operand1;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }

        return result;
    }
}

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        double result = 0.0;

        String input = scanner.nextLine();

        List<String> postFix = calculator.getPostFix(input);
        result = calculator.calculate(postFix);
        System.out.println(result);
    }
}

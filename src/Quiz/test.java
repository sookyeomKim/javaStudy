package Quiz;

import java.util.List;

/**
 * Created by ksk on 2016-04-10.
 */
public class test {
    /*public static int Find_Max(int[] list, int length) {
        int tmp = list[0];
        for (int i = 0; i < length; i++) {
            if (tmp < list[i]) {
                tmp = list[i];
            }
        }
        return tmp;
    }*/

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

    public static int Factoral(int a) {
        if (a < 1) {
            return 1;
        }
        return a * Factoral(a - 1);
    }

    public static int Fibo(int n) {
        int i, tmp, right = 1, left = 0;
        if (n < 2) {
            return n;
        }
        for (i = 2; i <= n; i++) {
            tmp = right;
            right += left;
            left = tmp;
        }
        return right;
    }

    public static void Fibo2(int n) {
        int i, tmp, right = 1, left = 0;

        for (i = 0; i < n; i++) {
            System.out.println(right);
            tmp = right;
            right += left;
            left = tmp;
        }
    }

    public static int Power(int v, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * v;
        }
        return result;
    }

    public static int Power2(int v, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return Power2(v * v, n / 2);
        } else {
            return v * Power2(v * v, (n - 1) / 2);
        }
    }

    public static void Hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            System.out.println(from + "번 기둥에서" + to + "번 기둥으로 옮긴다.");
        } else {
            Hanoi(n - 1, from, to, by);
            System.out.println(from + "번 기둥에서" + to + "번 기둥으로 옮긴다.");
            Hanoi(n - 1, by, from, to);
        }
    }

    public static void main(String[] args) {
        /*int[] list = {90, 30, 20, 120, 60, 10, 3, 100};
        System.out.println(Find_Max(list, 5));*/
        //System.out.println(GCD(76, 120));
        //120,76
        //76,44
        //44,32
        //32,12
        //12,20
        //20,12
        //12,8
        //8,4

        //System.out.println(Factoral(32));
        //32부터 -2147483648
        //34부터 0
        //System.out.println(Fibo(12));
        //Fibo2(12);

        //System.out.println(Power(3, 6));
        //System.out.println(Power2(3, 6));
        Hanoi(3,1,2,3);
    }
}

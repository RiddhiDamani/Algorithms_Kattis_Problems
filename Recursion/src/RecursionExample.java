public class RecursionExample {
    static int stepCount = 0;
    public static void main(String args[]) {
        System.out.println(sum(5));

        System.out.println(pow(3, 1000));
        System.out.println("steps: " + stepCount);

        stepCount = 0;
        System.out.println(fastPow(3, 1000));
        System.out.println("steps: " + stepCount);
    }
    static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n-1);
    }

    static int pow(int a, int b) {
        stepCount++;
        if(b==0){
            return 1;
        }
        return a * pow(a, b-1);
    }

    static int fastPow(int a, int b) {
        stepCount++;
        if(b==0) {
            return 1;
        }
        if (b%2 == 0) {
            return fastPow(a*a, b/2);
        }
        return a * fastPow(a, b-1);
    }

}

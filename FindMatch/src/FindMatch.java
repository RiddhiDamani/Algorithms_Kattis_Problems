public class FindMatch {
    int[] A = {-10,-3,1,6,9};
    public static void main(String[] args) {

        int high = 5;
        int low = 1;
        FindMatch fm = new FindMatch();
        int a = fm.calculate(low, high);
        System.out.println(a);
    }

    private int calculate(int low, int high) {
        if(low > high) {
            return 0;
        }
        int mid = (low + high)/2;
        if(A[mid] == mid) {
            return mid;
        }
        else if(A[mid] < mid) {
            return calculate(mid+1, high);
        }
        else if(A[mid] > mid) {
            return calculate(low, mid-1);
        }
        return 9;
    }

//    private int calculate(int A[], int low, int high) {
//        while (low <= high) {
//            int mid = (low + high)/2;
//            System.out.println("Middle value" + mid);
//            System.out.println("Array Value" + A[mid]);
//            if(A[mid] == mid) {
//                System.out.println("Inside mid");
//                return mid;
//            }
//            else if(A[mid] < mid) {
//                low = mid + 1;
//            }
//            else {
//                high = mid - 1;
//            }
//        }
//        return 0;
//    }
}

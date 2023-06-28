public class MinStp_to_1 {
    public static int minStepsTo1(int n){
        if(n == 1){
            return 0;
        }
        int ans1 = minStepsTo1(n-1);
        int ans2 = Integer.MAX_VALUE;
        if ((n%2 == 0)) {
            ans2 = minStepsTo1(n/2);
        }
        int ans3 = Integer.MAX_VALUE;
        if ((n%2) == 0) {
            ans3 = minStepsTo1(n/3);
        }
        int myAns = Math.min(ans1,Math.min(ans2, ans3))+1;
        return myAns;
    }
    public static void main(String[] args) {
        int n = 10;
        int ans = minStepsTo1(n);
        System.out.println(ans);
    }
}

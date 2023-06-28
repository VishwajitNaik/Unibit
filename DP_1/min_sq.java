public class min_sq {
    /*
    public static int minSq(int n){
        if(n == 0){
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for (int i = 0; i*i <= n; i++) {
            int currAns = minSq(n-(i*i));
            if(minAns > currAns){
                minAns = currAns;
            }
        }
        int myAns = 1 + minAns;
        return myAns; 
    }
    */
    // public static int minSq(int n, int dp[]){
    //     if(n == 0){
    //         return 0;
    //     }
    //     int minAns = Integer.MAX_VALUE;
    //     for (int i = 0; i*i <= n; i++) {
    //         int currAns;
    //         if(dp[n-(i*i)] == -1){
    //             currAns = minSq(n-(i*i),dp);
    //         }else{
    //             currAns = dp[n-(i*i)];
    //         }
    //         if(minAns > currAns){
    //             minAns = currAns;
    //         }
    //     }
    //     int myAns = 1 + minAns;
    //     return myAns; 
    // }

    public static int minCount(int n) {
		//Your code goes here
        int dp[] = new int[n+1];
        for (int i=0;i<n+1;i++)
            dp[i]=-1;
        
        return minCountHelper(n,dp);
	}
    
    private static int minCountHelper(int n, int[] dp)
    {
        if (n==0)
            return 0;
        
        int minVal = Integer.MAX_VALUE;
        for (int i=1;i*i<=n;i++)
        {
            if (dp[n-(i*i)]==-1)
                dp[n-(i*i)]=minCountHelper(n-(i*i),dp);
            int currVal = dp[n-(i*i)];
            if (currVal<minVal)
                minVal=currVal;
        }
        
        return minVal+1;
    }
    public static void main(String[] args) {
        int n = 12;
        int dp[] = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        int ans = minCountHelper(n,dp);
        System.out.println(ans);
    }
}

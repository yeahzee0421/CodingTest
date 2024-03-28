import java.util.*;
import java.io.*;

class Solution {
    public int func(int n){
        int dp[] = new int[1000001];
        dp[0]=0; dp[1]=1;
        for(int i = 2; i <= n; i++)
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
        return dp[n]%1234567;
    }
    public int solution(int n) {
        return func(n);
    }
}
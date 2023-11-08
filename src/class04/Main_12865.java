package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
    private static int[] W;
    private static int[] V;
    private static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //물건 개수
        int K = Integer.parseInt(st.nextToken()); //최대 무게
        W = new int[N];
        V = new int[N];
        dp = new Integer[N][K+1];

        for (int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]); //물건 무게
            int v = Integer.parseInt(input[1]); //가치

            W[i] = w;
            V[i] = v;
        }
        //end input
        System.out.print(fillBag(N-1, K));
    }
    
    private static int fillBag(int i, int K){
        //탑다운으로 고민해보자
        if (i<0){
            return 0;
        }

        if (dp[i][K] == null){
            if (W[i]>K){
                dp[i][K] = fillBag(i-1, K);
            }
            else{
                dp[i][K] = Math.max(fillBag(i-1, K), fillBag(i-1, K-W[i])+V[i]);
            }
        }

        return dp[i][K];
    }
}//class

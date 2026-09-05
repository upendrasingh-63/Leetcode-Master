class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // made dp array from graph, store weight, and INF if node reachable 
        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][i]=0;
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            int weight=edge[2];

            dp[u][v]=weight;
            dp[v][u]=weight;
        }

        //Strandard dp floyed warshell algo use intermidiate k node between i and j
        // calculate min dis
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    if(dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE){
                        dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                    }
                }
            }
        }

        // count as required by question
        int min=Integer.MAX_VALUE;
        int answer=-1;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && dp[i][j]<=distanceThreshold){
                    count++;
                }
            }

            if(count<=min){
                min=count;
                answer=i;
            }
        }

        return answer;
    }
}
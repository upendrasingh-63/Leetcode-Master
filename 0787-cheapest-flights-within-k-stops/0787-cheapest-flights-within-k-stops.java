class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] dist=new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src]=0;


        // try k+1 time relaxation
        for(int i=0;i<k+1;i++){

            //copy from previous dist
            int[] temp=dist.clone();

            for(int[] flight:flights){
                int u=flight[0];
                int v=flight[1];
                int cost=flight[2];

                if(dist[u]!=Integer.MAX_VALUE){
                    temp[v]=Math.min(temp[v],dist[u]+cost);
                }
            }

            dist=temp;
        }

        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
        
    }
}
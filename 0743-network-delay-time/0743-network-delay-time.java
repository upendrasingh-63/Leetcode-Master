class Solution {

    //build pair to keep weight with node
    class Pair{
        int weight;
        int node;
        Pair(int node, int weight){
            this.weight=weight;
            this.node=node;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        //build graph
        List<List<Pair>> graph=new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:times){
            int u=edge[0];
            int v=edge[1];
            int weight=edge[2];

            graph.get(u).add(new Pair(v,weight));
        }


        //Dijkstra algo
        int[] dist=new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);

        dist[k]=0;

        pq.offer(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();

            int node=curr.node;
            int distance=curr.weight;

            //if distance of outdated node is greater than current node then do nothing
            //(2,5), (2,10) we will pass for later node 2
            if(distance>dist[node]){
                continue;
            }

            for(Pair key:graph.get(node)){
                int next=key.node;
                int weight=key.weight;

                if(dist[node]+weight<dist[next]){
                    dist[next]=dist[node]+weight;

                    pq.offer(new Pair(next,dist[next]));
                }
            }
        }

        //find max shortest distance
        int max=0;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        
        return max;
    }
}
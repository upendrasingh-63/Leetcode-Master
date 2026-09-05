class Solution {

    //make to keep node and weight
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        List<List<Pair>> graph=new ArrayList<>();

        int n=points.length;

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        // make graph from question requirement
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    int u=i;
                    int v=j;
                    int weight=Math.abs(points[i][0]-points[j][0])+
                                Math.abs(points[i][1]-points[j][1]);
                    
                    graph.get(u).add(new Pair(v,weight));
                }
            }
        }

        //total min weight of MST
        int total=0;

        //keep track of visited node for creating MST
        boolean[] visited=new boolean[n];

        // it will give min edge weight of neighbour node
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);

        pq.offer(new Pair(0,0));

        //standard prims algo
        while(!pq.isEmpty()){
            Pair curr=pq.poll();

            int node=curr.node;
            int weight=curr.weight;

            //not calculate if visited
            if(visited[node]){
                continue;
            }

            //mark visited and add its weight to answer
            visited[node]=true;

            total+=weight;

            for(Pair edge:graph.get(node)){
                int next=edge.node;
                int nextweight=edge.weight;
                
                //only add if not visited
                if(!visited[next]){
                    pq.add(new Pair(next, nextweight));
                }

            }
        }

        return total;
    }
}
class Solution {
     public boolean isBipartite(int[][] graph) {
         //Bipartite mein do color meon divide ho jaana chahiye graph aur components ho skte hai to baar baar check krk same color se dfs call kr rhe
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int u = 0; u < graph.length; u++){
            if(colors[u] == -1){
                if(!dfs(u, graph, colors, 1)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean dfs(int u, int[][]graph, int[]colors, int col){
        // if (colors[u] == 1- col){ //basically wo condition jisme required color se alg hai
        //     return false; 
        // } 

        if(colors[u] !=-1 && colors[u] != col)
        {
            return false;
        }
        if (colors[u] == col) { //the current vertices is already colored with required color
            return true; 
        }
        colors[u] = col;
        for (var neighbor: graph[u]) {
            if (!dfs(neighbor, graph, colors, 1 - col)) {
                return false;
            }
        }
        return true;
    }
}
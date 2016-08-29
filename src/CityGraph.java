import java.util.*;

/**
 * Created by mars_wang on 2016/8/18.
 * 将城市间的车次连接抽象成图，城市为图中的点，
 * 如果有直达的车次那么两个点之间有连接，否则没有连接，最后构成一个无向图。
 * 通过BFS查找两个城市之间的最短路径。
 *
 */
public class CityGraph {

    // 存储边信息（邻接矩阵），城市之间是否有直达车次
    private  int[][] arcs;

    // 图的节点数
    private int vexnum;

    // 记录节点是否已被遍历
    private boolean[] visited;

    //搜索过程路径
    private Map<Integer, Integer> searchPath = new HashMap<>();

    //有效路径
    private List<Integer>finalPath = new ArrayList<>();

    // 初始化
    public CityGraph(int n) {
        vexnum = n;
        arcs = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < vexnum; i++) {
            for (int j = 0; j < vexnum; j++) {
                arcs[i][j] = 0;
            }
        }

    }

    // 添加边(无向图)
    public void addEdge(int i, int j) {
        // 边的头尾不能为同一节点
        if (i == j)return;
        arcs[i][j] = 1;
        arcs[j][i] = 1;
    }

    // 设置节点访问标记
    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    // 图的深度优先遍历,起点是from, 终点是to
    public void BFSTraverse(int from, int to){
        if(from == to){
            searchPath.put(from,to);
            return;
        }
        // 初始化节点遍历标记
        for (int i = 0; i < vexnum; i++) {
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        // Stack<Integer> s = new Stack<>();
        queue.add(from);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(!visited[cur]){
                visited[cur] = true;
                if(cur == to){
                    break;
                }
                // 没遍历的子节点入队列
                for(int j = vexnum-1; j >= 0 ; j-- ){
                    if(arcs[cur][j] == 1 && !visited[j]){
                        //记录搜索过程路径
                        searchPath.put(j, cur);
                        queue.add(j);
                    }
                }

            }
        }

        //找出最短路径以倒序的方式放入finalPath中
        if(searchPath == null)
            return;
        finalPath.add(to);
        Integer k = to;
        while(true){
            k = searchPath.get(k);
            if(visited[k])
                finalPath.add(k);
            if(k == null || k == from)
                break;

        }
    }

    //将倒序的路径反转，得到正确路径顺序
    public List<Integer> getFinalPath(){
        Collections.reverse(finalPath);
        return finalPath;
    }


}

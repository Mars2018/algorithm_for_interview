import java.util.*;

/**
 * Created by mars_wang on 2016/8/18.
 */
public class Graph {
    // 图的起点
    private String firstVertax;

    //BFS
    private BFS bfs;

    // 邻接表
    private Map<String, List<String>> adj = new HashMap<>();

    /**
     * 得到从起点到vertex点的最短路径
     */
    public Stack<String> findPathTo(String vertex) {
        Stack<String> stack = new Stack<>();
        stack.add(vertex);

        Map<String, String> path = bfs.getPath();
        for (String location = path.get(vertex) ; !location.equals(firstVertax) ; location = path.get(location)) {
            stack.push(location);
        }
        stack.push(firstVertax);

        return stack;
    }

    /**
     * 添加一条边
     */
    public void addEdge(String fromVertex, String toVertex) {
        if (firstVertax == null) {
            firstVertax = fromVertex;
        }

        adj.get(fromVertex).add(toVertex);
        adj.get(toVertex).add(fromVertex);
    }

    /**
     * 添加一个顶点
     */
    public void addVertex(String vertex) {
        adj.put(vertex, new ArrayList<String>());
    }

    public Map<String, List<String>> getAdj() {
        return adj;
    }

    public String getFirstVertax() {
        return firstVertax;
    }

    public void setFirstVertax(String firstVertax) {
        this.firstVertax = firstVertax;
    }

    public BFS getBfs() {
        return bfs;
    }

    public void setBfs(BFS bfs) {
        this.bfs = bfs;
    }

    public void setAdj(Map<String, List<String>> adj) {
        this.adj = adj;
    }
}


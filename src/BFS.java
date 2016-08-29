import java.util.*;

/**
 * Created by mars_wang on 2016/8/18.
 */
public class BFS {
    // 保存已经访问过的地点
    private List<String> visitedVertex;
    // 保存最短路径
    private Map<String, String> path;


    public void perform(Graph g, String sourceVertex) {
        if (null == visitedVertex) {
            visitedVertex = new ArrayList<>();
        }
        if (null == path) {
            path = new HashMap<>();
        }

        BFS(g, sourceVertex);
    }

    public Map<String, String> getPath() {
        return path;
    }

    private void BFS(Graph g, String sourceVertex) {
        Queue<String> queue = new LinkedList<>();
        // 标记起点
        visitedVertex.add(sourceVertex);
        // 起点入列
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            String ver = queue.poll();

            List<String> toBeVisitedVertex = g.getAdj().get(ver);
            for (String v : toBeVisitedVertex) {
                if (!visitedVertex.contains(v)) {
                    visitedVertex.add(v);
                    path.put(v, ver);
                    queue.add(v);
                }
            }
        }
    }
}

import java.util.List;

/**
 * Created by mars_wang on 2016/8/18.
 */
public class Main {
    public static void main(String[] args) {
        CityGraph g = new CityGraph(9);
        char[] cities = {'A','B','C','D','E','F','G','H','I'};

        g.addEdge(0, 1);
        g.addEdge(0, 5);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(1, 8);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(3, 4);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(3, 8);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(7, 6);

        System.out.print("搜索结果：");
        g.BFSTraverse(0,3);
        List<Integer> path = g.getFinalPath();
        for(int i = 0; i < path.size(); ++i){
            System.out.print(cities[path.get(i)] + " ");
        }
    }
}

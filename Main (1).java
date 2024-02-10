import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> edges = Arrays.asList(
            "N_23, N_22",
            "N_15, N_10",
            "N_1, N_2",
            "N_12, N_7",
            "N_19, N_18",
            "N_10, N_15",
            "N_8, N_13",
            "N_17, N_22",
            "N_11, N_10",
            "N_2, N_1",
            "N_5, N_6",
            "N_10, N_5",
            "N_6, N_7",
            "N_13, N_14",
            "N_22, N_17",
            "N_24, N_19",
            "N_16, N_11",
            "N_9, N_8",
            "N_20, N_21",
            "N_6, N_1",
            "N_0, N_1",
            "N_14, N_13",
            "N_13, N_12",
            "N_2, N_3",
            "N_18, N_19",
            "N_15, N_20",
            "N_17, N_12",
            "N_4, N_9",
            "N_18, N_13",
            "N_13, N_18",
            "N_9, N_4",
            "N_7, N_6",
            "N_19, N_24",
            "N_10, N_11",
            "N_6, N_5",
            "N_13, N_8",
            "N_1, N_0",
            "N_21, N_20",
            "N_1, N_6",
            "N_20, N_15",
            "N_22, N_23",
            "N_7, N_12",
            "N_12, N_17",
            "N_11, N_16",
            "N_8, N_9",
            "N_5, N_10",
            "N_12, N_13",
            "N_3, N_2"
        );

        GraphSearch graphSearch = new GraphSearch(edges);

        //list of node pairs to test
        List<String[]> pairsToTest = Arrays.asList(
            new String[]{"N_0", "N_1"},
            new String[]{"N_0", "N_2"},
            new String[]{"N_0", "N_3"},
            new String[]{"N_0", "N_4"},
            new String[]{"N_0", "N_5"},
            new String[]{"N_0", "N_6"},
            new String[]{"N_0", "N_7"},
            new String[]{"N_0", "N_8"},
            new String[]{"N_0", "N_9"},
            new String[]{"N_0", "N_10"},
            new String[]{"N_0", "N_11"},
            new String[]{"N_0", "N_12"},
            new String[]{"N_0", "N_13"},
            new String[]{"N_0", "N_14"},
            new String[]{"N_0", "N_15"},
            new String[]{"N_0", "N_16"},
            new String[]{"N_0", "N_17"},
            new String[]{"N_0", "N_18"},
            new String[]{"N_0", "N_19"},
            new String[]{"N_0", "N_20"},
            new String[]{"N_0", "N_21"},
            new String[]{"N_0", "N_22"},
            new String[]{"N_0", "N_23"},
            new String[]{"N_0", "N_24"}
        );
       
 

        System.out.println("Node 1\tNode 2\tBFS Distance\tBFS Time (ns)\tDFS Distance\tDFS Time (ns)");
        for (String[] pair : pairsToTest) {
            GraphSearch.Result bfsResult = graphSearch.bfs(pair[0], pair[1]);
            GraphSearch.Result dfsResult = graphSearch.dfs(pair[0], pair[1]);

            // Only print the result if a path was found
            if (bfsResult.distance != -1 && dfsResult.distance != -1) {
                System.out.println(pair[0] + "\t" + pair[1] + "\t" +
                                   bfsResult.distance + "\t\t\t" + bfsResult.time + "\t\t\t" +
                                   dfsResult.distance + "\t\t\t" + dfsResult.time);
            }
        }
    }
}
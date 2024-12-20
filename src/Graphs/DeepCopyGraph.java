package Graphs;

import java.util.*;

public class DeepCopyGraph {
    Node deepCopy;
    Map<Integer, Node> mapValueNode = new HashMap<>();

    public Node cloneGraph(Node node) {
         return dfs(node);

    }

    Node dfs(Node node)
    {
        if(node==null)return null;
        if(mapValueNode.containsKey(node.val))return mapValueNode.get(node.val);
        Node deepCopy = new Node(node.val);
        mapValueNode.put(deepCopy.val, deepCopy);
        for(Node neigh:node.neighbors)
        {
            if(neigh==null)continue;
            if(mapValueNode.containsKey(neigh.val))
            {
                deepCopy.neighbors.add(mapValueNode.get(neigh.val));
            }
            else
            {
                deepCopy.neighbors.add(dfs(neigh));
            }
        }
        return deepCopy;
    }

}

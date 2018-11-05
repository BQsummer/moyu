package util;

import common.Contract;
import model.v2ex.Node;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {
    public static List<String> removeItem(List<String> oriList, String item) {
        oriList.removeIf(tmp -> tmp.equals(item));
        return oriList;
    }

    public static List<String> addItem(List<String> oriList, String item) {
        for (String tmp : oriList) {
            if (tmp.equals(item)) {
                return oriList;
            }
        }
        oriList.add(item);
        return oriList;
    }

    public static List<Node> searchNode(String key) {
        List<Node> matchedNodes = new ArrayList<>();
        if (Contract.getAllNode() != null) {
            for (Node node : Contract.getAllNode()) {
                if (node.getName().contains(key)) {
                    matchedNodes.add(node);
                }
            }
        }
        return matchedNodes;
    }
}

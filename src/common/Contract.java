package common;

import model.v2ex.Node;

import java.util.List;

public class Contract {

    public static final String V2EX_LATEST_API = "https://www.v2ex.com/api/topics/latest.json";

    public static final String V2EX_HOT_API = "https://www.v2ex.com/api/topics/hot.json";

    public static final String V2EX_TOPIC_API = "https://www.v2ex.com/api/topics/show.json";

    public static final String V2EX_REPLY_API = "https://www.v2ex.com/api/replies/show.json";

    public static final String V2EX_NODE_API = "https://www.v2ex.com/api/nodes/show.json";

    public static final String V2EX_ALLNODE_API = "https://www.v2ex.com/api/nodes/all.json";

    public static final String V2EX_NODE_ID = "node_id";

    public static final String V2EX_NODE_NAME = "node_name";

    public static final String V2EX_TOPIC_ID = "topic_id";

    public static List<Node> allNode;

    public static List<Node> getAllNode() {
        return allNode;
    }

    public static void setAllNode(List<Node> allNode) {
        Contract.allNode = allNode;
    }
}

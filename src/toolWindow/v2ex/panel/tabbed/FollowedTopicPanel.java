package toolWindow.v2ex.panel.tabbed;

import common.Contract;
import common.PersistentState;
import common.PluginConf;
import toolWindow.v2ex.panel.V2exPanel;

import java.util.HashMap;
import java.util.Map;

public class FollowedTopicPanel extends V2exPanel {

    public FollowedTopicPanel(String topicApi) {
        super(topicApi);
    }

    @Override
    public boolean isInit() {
        Object obj = PersistentState.getInstance().get(PluginConf.V2EX_FOLLOW_LIST);
        if (obj != null) {
            String[] followedTopicIdArr = (String[]) obj;
            if (followedTopicIdArr.length > 0) {
                Map<String, String> param = new HashMap<>();
                param.put(Contract.V2EX_NODE_ID, followedTopicIdArr[0]);
                this.setParams(param);
                return true;
            }
        }
        return false;
    }
}

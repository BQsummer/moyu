package toolWindow.v2ex.panel.tabbed;

import common.Contract;
import toolWindow.v2ex.panel.V2exPanel;
import util.TopicUtil;

import java.util.HashMap;
import java.util.Map;

public class FollowedTopicPanel extends V2exPanel {

    public FollowedTopicPanel(String topicApi) {
        super(topicApi);
    }

    /**
     * 判断followed topic是否需要加载数据
     *
     * @return true or false
     */
    @Override
    public boolean isInit() {
        String[] followedTopicArr = TopicUtil.getFollowedTopic();
        if (followedTopicArr != null) {
            if (followedTopicArr.length > 0) {
                Map<String, String> param = new HashMap<>();
                param.put(Contract.V2EX_NODE_NAME, followedTopicArr[0]);
                this.setParams(param);
                return true;
            }
        }
        return false;
    }

    /**
     * 更新当前topic，并重载数据
     *
     * @param topicName 需要重载的topic名称
     */
    public void freshTopic(String topicName) {
        if (topicName != null && topicName.length() > 0) {
            Map<String, String> param = new HashMap<>();
            param.put(Contract.V2EX_NODE_NAME, topicName);
            this.setParams(param);
            this.setCurrentPage(1);
            fresh();
        }
    }
}

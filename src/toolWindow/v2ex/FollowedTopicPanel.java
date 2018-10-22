package toolWindow.v2ex;

import com.intellij.openapi.diagnostic.Logger;
import common.Contract;
import model.v2ex.Topic;
import util.HttpUtil;
import util.PageHelper;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FollowedTopicPanel extends JPanel implements V2exPanel {

    private static final Logger log = Logger.getInstance("moyu");

    private Integer currentFollowedTopicId;

    public FollowedTopicPanel(FlowLayout flowLayout) {
        super(flowLayout);
        fresh();
    }

    @Override
    public void fresh() {
        if (currentFollowedTopicId != null) {
            Map<String, String> params = new HashMap<>();
            params.put("node_id", currentFollowedTopicId + "");
            List<Topic> topicList = HttpUtil.page(Contract.V2EX_TOPIC_API, null, Topic.class, new PageHelper(currentPage, 10));
            JList<String> listPanel = new JList<>();
            List<String> titles = topicList.stream().map(Topic::getTitle).collect(Collectors.toList());
            listPanel.setListData(titles.toArray(new String[titles.size()]));
            this.add(listPanel);
        }
    }

    public Integer getCurrentFollowedTopicId() {
        return currentFollowedTopicId;
    }

    public void setCurrentFollowedTopicId(Integer currentFollowedTopicId) {
        this.currentFollowedTopicId = currentFollowedTopicId;
    }
}

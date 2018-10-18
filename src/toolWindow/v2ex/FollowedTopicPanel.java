package toolWindow.v2ex;

import common.Contract;
import model.v2ex.Topic;
import util.HttpUtil;
import util.PageHelper;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class FollowedTopicPanel extends JPanel implements V2exPanel {


    public FollowedTopicPanel() {
        fresh();
    }

    @Override
    public void fresh() {
        List<Topic> topicList = HttpUtil.page(Contract.V2EX_TOPIC_API, null, Topic.class, new PageHelper(currentPage, 10));
        JList<String> listPanel = new JList<>();
        List<String> titles = topicList.stream().map(Topic::getTitle).collect(Collectors.toList());
        listPanel.setListData(titles.toArray(new String[titles.size()]));
        this.add(listPanel);
    }
}

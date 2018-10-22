package toolWindow.v2ex;

import common.Contract;
import model.v2ex.Reply;
import model.v2ex.Topic;
import toolWindow.v2ex.panel.V2exGridBagConstraints;
import toolWindow.v2ex.panel.V2exPanel;
import util.HttpUtil;
import util.PageHelper;
import util.TopicUtil;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LatestTopicPanel extends JPanel implements V2exPanel {

    private List<Topic> topicList = null;

    private List<Reply> replyList = null;

    private Topic selectedTopic = null;

    private JScrollPane scrollPane2 = null;

    private int currentPage = 1;

    private boolean isLast = false;

    public LatestTopicPanel(LayoutManager layoutManager) {
        super(layoutManager);
        this.init();
    }

    @Override
    public void init() {
        // topic list
        topicList = HttpUtil.page(Contract.V2EX_LATEST_API, null, Topic.class, new PageHelper(currentPage, 10));
        if (topicList == null || topicList.size() == 0) {
            isLast = true;
            currentPage--;
        }
        ListModel listModel = new AbstractListModel() {
            @Override
            public int getSize() {
                return topicList.size();
            }

            @Override
            public Object getElementAt(int index) {
                return TopicUtil.generateTitleInfo(topicList.get(index));
            }
        };
        JList<String> listPanel = new JList<>(listModel);
        listPanel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    selectedTopic = topicList.get(listPanel.getSelectedIndex());
                    Map<String, String> detailParams = new HashMap<>();
                    detailParams.put("topic_id", selectedTopic.getId() + "");
                    replyList = HttpUtil.page(Contract.V2EX_REPLY_API, detailParams, Reply.class, new PageHelper(1, Integer.MAX_VALUE));
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(listPanel);
        this.add(scrollPane, new V2exGridBagConstraints(0, 0, 30, 100));


        // topic detail
        if (listPanel.getSelectedIndex() == -1) {
            if (topicList != null && topicList.size() > 0) {
                selectedTopic = topicList.get(0);
            }
        } else {
            if (listPanel.getSelectedIndex() < topicList.size()) {
                selectedTopic = topicList.get(listPanel.getSelectedIndex());
            }
        }
        if (selectedTopic != null) {
            Map<String, String> detailParams = new HashMap<>();
            detailParams.put("topic_id", selectedTopic.getId() + "");
            replyList = HttpUtil.page(Contract.V2EX_REPLY_API, detailParams, Reply.class, new PageHelper(1, Integer.MAX_VALUE));
            ListModel detailModel = new AbstractListModel() {
                @Override
                public int getSize() {
                    return replyList.size() + 2;
                }

                @Override
                public Object getElementAt(int index) {
                    if (index == 0) {
                        return selectedTopic.getContent();
                    } else if (index == 1) {
                        return TopicUtil.generateTopicInfo(selectedTopic);
                    } else {
                        return TopicUtil.generateReplyInfo(replyList.get(index - 2));
                    }
                }
            };
            JList<String> detailPanel = new JList<>(detailModel);
            scrollPane2 = new JScrollPane(detailPanel);
            this.add(scrollPane2, new V2exGridBagConstraints(1, 0, 70, 100));
        }
    }

    @Override
    public void fresh() {

    }

    public void prevPage() {
        if (currentPage > 1) {
            currentPage--;
            init();
        }
    }

    public void nextPage() {
        if (!isLast) {
            currentPage++;
            init();
        }
    }
}

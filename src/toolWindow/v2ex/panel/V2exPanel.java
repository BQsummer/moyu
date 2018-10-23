package toolWindow.v2ex.panel;

import common.Contract;
import model.v2ex.Reply;
import model.v2ex.Topic;
import util.HttpUtil;
import util.PageHelper;
import util.TopicUtil;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class V2exPanel extends JPanel {

    /**
     * 当前页topic数据
     */
    private List<Topic> topicList = null;

    /**
     * 当前选择的topic 的回复数据，如果没有选择，就显示第一个
     */
    private List<Reply> replyList = null;

    /**
     * 当前选择的topic
     */
    private Topic selectedTopic = null;

    /**
     * jscrollpane, 左侧topic栏
     */
    private JScrollPane scrollPane = new JScrollPane();

    /**
     * jscrollpanel，右侧reply栏
     */
    private JScrollPane scrollPane2 = new JScrollPane();

    /**
     * 当前页数
     */
    private int currentPage = 1;

    /**
     * 是否是最后一页
     */
    private boolean isLast = false;

    /**
     * 左侧 topic 绑定数据
     */
    private JList<String> detailPanel = new JList<>();

    /**
     * 右侧 reply 绑定数据
     */
    private JList<String> listPanel = new JList<>();

    /**
     * 当前 panel 使用的 api
     */
    private String topicApi;

    /**
     * 使用 api 的参数
     */
    private Map<String, String> params;

    public V2exPanel(String topicApi) {
        super(new GridBagLayout());
        this.topicApi = topicApi;
        if (isInit()) {
            init();
        }
        this.add(scrollPane, new V2exGridBagConstraints(0, 0, 30, 100));
        this.add(scrollPane2, new V2exGridBagConstraints(1, 0, 70, 100));
    }

    /**
     * 初始化
     */
    public void init() {
        fresh();
        scrollPane = new JScrollPane(listPanel);
        scrollPane2 = new JScrollPane(detailPanel);
    }


    /**
     * 上一页
     */
    public void prevPage() {
        if (currentPage > 1) {
            currentPage--;
            fresh();
        }
    }

    /**
     * 下一页
     */
    public void nextPage() {
        if (!isLast) {
            currentPage++;
            fresh();
        }
    }

    /**
     * 是否需要初始化数据，因为followed topic的panel要根据用户配置判断
     *
     * @return
     */
    abstract public boolean isInit();

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    private void fresh() {
        // 获取topic数据
        topicList = HttpUtil.page(topicApi, params, Topic.class, new PageHelper(currentPage, 10));
        if (topicList == null || topicList.size() == 0) {
            isLast = true;
            currentPage--;
        }
        // 创建topic的listmodel
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
        listPanel.setModel(listModel);
        // set selectedTopic
        if (listPanel.getSelectedIndex() == -1) {
            if (topicList != null && topicList.size() > 0) {
                selectedTopic = topicList.get(0);
            }
        } else {
            if (listPanel.getSelectedIndex() < topicList.size()) {
                selectedTopic = topicList.get(listPanel.getSelectedIndex());
            }
        }
        // 创建reply 的listmodel
        if (topicList != null && topicList.size() > 0) {
            Map<String, String> detailParams = new HashMap<>();
            detailParams.put(Contract.V2EX_TOPIC_ID, selectedTopic.getId() + "");
            replyList = HttpUtil.page(Contract.V2EX_REPLY_API, detailParams, Reply.class, new PageHelper(1, Integer.MAX_VALUE));
        }
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
        detailPanel.setModel(detailModel);
        // topic监听事件
        listPanel.addListSelectionListener(arg0 -> {
            if (!arg0.getValueIsAdjusting()) {
                if (topicList != null && topicList.size() > 0) {
                    if (listPanel.getSelectedIndex() == -1) {
                        selectedTopic = topicList.get(0);
                    } else {
                        selectedTopic = topicList.get(listPanel.getSelectedIndex());
                    }
                    Map<String, String> detailParams = new HashMap<>();
                    detailParams.put(Contract.V2EX_TOPIC_ID, selectedTopic.getId() + "");
                    replyList = HttpUtil.page(Contract.V2EX_REPLY_API, detailParams, Reply.class, new PageHelper(1, Integer.MAX_VALUE));
                    detailPanel.setModel(detailModel);
                }
            }
        });
    }
}

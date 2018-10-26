package toolWindow.setting;

import com.intellij.icons.AllIcons;
import common.PersistentState;
import common.PluginConf;
import model.v2ex.Node;
import util.CollectionUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V2exConfigPanel {
    private JTextField usernameFiled;
    private JPasswordField passwordField;
    private JTextField input;
    private JButton button;
    private JPanel panel;
    private JScrollPane followedTopic;
    private JList followList;
    private JList searchList;
    private JButton removeButton;

    /**
     * 检索出的node列表
     */
    private List<Node> nodeList;
    /**
     * 已关注的node列表，增删后需要保存
     */
    private List<String> followedNodeList = new ArrayList<>();

    public V2exConfigPanel() {
        initFollowedPanel();
        addInputListener();
        addButtonListener();
        removeButtonListener();
    }

    /**
     * 显示已follow的topic
     */
    public void initFollowedPanel() {
        Object obj = PersistentState.getInstance().get(PluginConf.V2EX_FOLLOW_LIST);
        if (obj != null) {
            String[] followedTopic = (String[]) obj;
            followedNodeList.addAll(Arrays.asList(followedTopic));
            ListModel listModel = new AbstractListModel() {
                @Override
                public int getSize() {
                    return followedTopic.length;
                }

                @Override
                public Object getElementAt(int index) {
                    return followedTopic[index];
                }
            };
            followList.setModel(listModel);
            this.panel.updateUI();
        }
    }

    /**
     * 输入关键词后，显示查找到的topic
     */
    public void addInputListener() {
        input.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = input.getText();
                if (key != null && key.length() > 0) {
                    nodeList = CollectionUtil.searchNode(key);
                    if (nodeList != null && nodeList.size() > 0) {
                        ListModel detailModel = new AbstractListModel() {
                            @Override
                            public int getSize() {
                                return nodeList.size();
                            }

                            @Override
                            public Object getElementAt(int index) {
                                return nodeList.get(index);
                            }
                        };
                        searchList.setModel(detailModel);
                        //searchList.setCellRenderer(new NodeListCellRenderer());
                        searchList.updateUI();
                    }
                }
            }
        });
    }

    /**
     * 添加topic
     */
    public void addButtonListener() {
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchList.getSelectedIndex() != -1 && searchList.getSelectedIndex() < nodeList.size()) {
                    Node selected = nodeList.get(searchList.getSelectedIndex());
                    String selectedName = selected.getName();
                    followedNodeList = CollectionUtil.addItem(followedNodeList, selectedName);
                    refreshFollowedList();
                }
            }
        });
    }

    /**
     * 移除topic
     */
    public void removeButtonListener() {
        removeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (followList.getSelectedIndex() != -1 && followList.getSelectedIndex() < followedNodeList.size()) {
                    String selectedName = followedNodeList.get(followList.getSelectedIndex());
                    followedNodeList = CollectionUtil.removeItem(followedNodeList, selectedName);
                    refreshFollowedList();
                }
            }
        });
    }

    /**
     * setting面板的reset
     */
    public void reset() {
        refreshFollowedList();
    }

    /**
     * 刷新followed node list
     */
    private void refreshFollowedList() {
        ListModel listModel = new AbstractListModel() {
            @Override
            public int getSize() {
                return followedNodeList.size();
            }

            @Override
            public Object getElementAt(int index) {
                return followedNodeList.get(index);
            }
        };
        followList.setModel(listModel);
        this.panel.updateUI();
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public List<String> getFollowedNodeList() {
        return followedNodeList;
    }

    public void setFollowedNodeList(List<String> followedNodeList) {
        this.followedNodeList = followedNodeList;
    }

    /**
     * 废弃，icon添加listener太烦了，还是用按钮
     * 自定义带cancel icon 的label，放在已follow的topiclist
     */
    class NodeListCellRenderer extends DefaultListCellRenderer {

        private JLabel label;

        @Override
        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean selected,
                boolean expanded) {
            Icon icon = AllIcons.Actions.Cancel;
            label = new JLabel(icon, JLabel.RIGHT);
            String nodeName = (String) value;
            label.setText(nodeName);

//            if (selected) {
//                label.setBackground(backgroundSelectionColor);
//                label.setForeground(textSelectionColor);
//            } else {
//                label.setBackground(backgroundNonSelectionColor);
//                label.setForeground(textNonSelectionColor);
//            }
            return label;
        }
    }
}

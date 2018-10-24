package toolWindow.setting;

import common.PersistentState;
import common.PluginConf;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class V2exConfigPanel {
    private JTextField usernameFiled;
    private JPasswordField passwordField;
    private JTextField input;
    private JButton button;
    private JPanel panel;
    private JScrollPane followedTopic;
    private JList followList;
    private JList searchList;

    public V2exConfigPanel() {
        initFollowedPanel();
        addInputListener();
    }

    public void initFollowedPanel() {
        Object obj = PersistentState.getInstance().get(PluginConf.V2EX_FOLLOW_LIST);
        if (obj != null) {
            String[] followedTopic = (String[]) obj;
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
            JList<String> listPanel = new JList<>();
            listPanel.setModel(listModel);
            this.panel.updateUI();
        }
    }

    public void addInputListener() {
        input.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = input.getText();
                if (key != null && key.length() > 0) {
                    // TODO
                    //List<Node> nodeList =

                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }


}

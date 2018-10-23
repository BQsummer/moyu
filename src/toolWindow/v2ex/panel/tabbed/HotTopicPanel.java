package toolWindow.v2ex.panel.tabbed;

import toolWindow.v2ex.panel.V2exPanel;

public class HotTopicPanel extends V2exPanel {

    public HotTopicPanel(String topicApi) {
        super(topicApi);
    }

    @Override
    public boolean isInit() {
        return true;
    }
}

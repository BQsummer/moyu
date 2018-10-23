package toolWindow.v2ex.panel.tabbed;

import toolWindow.v2ex.panel.V2exPanel;

public class LatestTopicPanel extends V2exPanel {

    public LatestTopicPanel(String topicApi) {
        super(topicApi);
    }

    @Override
    public boolean isInit() {
        return true;
    }
}

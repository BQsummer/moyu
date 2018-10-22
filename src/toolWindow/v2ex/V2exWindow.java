package toolWindow.v2ex;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import common.PersistentState;
import common.PluginConf;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * v2ex的toolWindow
 */
public class V2exWindow implements ToolWindowFactory {

    private static final Logger log = Logger.getInstance("moyu");

    // ui component
    private ToolWindow toolWindow;
    private JTabbedPane tabbedPane1;
    private JPanel panelContent;
    private JToolBar toolBar;
    private LatestTopicPanel latestTopicPanel = new LatestTopicPanel(new FlowLayout(FlowLayout.LEFT));
    private HotTopicPanel hotTopicPanel = new HotTopicPanel(new FlowLayout(FlowLayout.LEFT));
    private FollowedTopicPanel followedTopicPanel = new FollowedTopicPanel(new FlowLayout(FlowLayout.LEFT));

    public V2exWindow() {
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // set toolWindow
        this.toolWindow = toolWindow;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(panelContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }

    @Override
    public void init(ToolWindow window) {
        initPanel();
    }

    @Override
    public boolean shouldBeAvailable(@NotNull Project project) {
        return false;
    }

    @Override
    public boolean isDoNotActivateOnStart() {
        return false;
    }


    /**
     * 初始化panel
     */
    private void initPanel() {
        initToolBar();
        initTabbedPanel();
    }

    /**
     * 初始化toolbar
     */
    private void initToolBar() {
        toolBar.setFloatable(true);
        toolBar.setOrientation(SwingConstants.VERTICAL);
        toolBar.add(new AbstractAction("refresh", AllIcons.Actions.Refresh) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        toolBar.add(new AbstractAction("back", AllIcons.Actions.Back) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        toolBar.add(new AbstractAction("forward", AllIcons.Actions.Forward) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
    }

    private void initTabbedPanel() {
        tabbedPane1.addTab("Latest Topic", latestTopicPanel);
        tabbedPane1.addTab("Hot Topic", hotTopicPanel);
        getFollowedTopic();
        tabbedPane1.addTab("Followed Topic", followedTopicPanel);
    }

    private void getFollowedTopic() {
        Object obj = PersistentState.getInstance().get(PluginConf.V2EX_FOLLOW_LIST);
        log.info("1. " + obj.toString());
        if (obj != null) {
            log.info("2. " + obj);
            String[] followedTopic = (String[]) obj;
            if (followedTopic.length > 0) {
                try {
                    followedTopicPanel.setCurrentFollowedTopicId(Integer.parseInt(followedTopic[0]));
                } catch (NumberFormatException e) {
                    log.error("format followed topic id failed", e);
                }
            }
        }
    }
}

package toolWindow.v2ex;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
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
    private LatestTopicPanel latestTopicPanel = new LatestTopicPanel(new GridBagLayout());
    private HotTopicPanel hotTopicPanel = new HotTopicPanel(new GridBagLayout());
    private FollowedTopicPanel followedTopicPanel = new FollowedTopicPanel(new GridBagLayout());

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
                if (tabbedPane1.getSelectedIndex() == 0) {
                    latestTopicPanel.prevPage();
                    return;
                }
                if (tabbedPane1.getSelectedIndex() == 1) {
                    hotTopicPanel.prevPage();
                    return;
                }
                if (tabbedPane1.getSelectedIndex() == 2) {
                    followedTopicPanel.prevPage();
                    return;
                }
            }
        });
        toolBar.add(new AbstractAction("forward", AllIcons.Actions.Forward) {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tabbedPane1.getSelectedIndex() == 0) {
                    latestTopicPanel.nextPage();
                    return;
                }
                if (tabbedPane1.getSelectedIndex() == 1) {
                    hotTopicPanel.nextPage();
                    return;
                }
                if (tabbedPane1.getSelectedIndex() == 2) {
                    followedTopicPanel.nextPage();
                    return;
                }
            }
        });
    }

    private void initTabbedPanel() {
        tabbedPane1.addTab("Latest Topic", latestTopicPanel);
        tabbedPane1.addTab("Hot Topic", hotTopicPanel);
        tabbedPane1.addTab("Followed Topic", followedTopicPanel);
    }

}

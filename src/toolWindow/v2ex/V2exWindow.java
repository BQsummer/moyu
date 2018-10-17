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
import java.awt.event.ActionEvent;

/**
 * v2ex的toolWindow
 */
public class V2exWindow implements ToolWindowFactory {

    private static final Logger log = Logger.getInstance("moyu");

    /**
     * 最新话题的页数
     */
    private int lastPanelPage;

    /**
     * 最热话题的页数
     */
    private int hotPanelPage;

    /**
     * 节点的名字
     */
    private String nodePanelName;

    // ui component
    private ToolWindow toolWindow;
    private JTabbedPane tabbedPane1;
    private JPanel latestPanel;
    private JPanel hotPanel;
    private JPanel nodePanel;
    private JPanel panelContent;
    private JToolBar toolBar;


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
        initParams();
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

    private void initParams() {
        lastPanelPage = 0;
        hotPanelPage = 0;
        nodePanelName = "";
        PersistentState.getInstance().set(PluginConf.V2EX_NAME, "bqsummer");
    }

    private void fresh(int selectedPanelIndex) {
        switch(selectedPanelIndex) {
            // latestPanel
            case 0 : {
                freshLatestPanel();
                break;
            }
            // hotPanel
            case 1: {
                freshHotPanel();
                break;
            }
            // nodePanel
            case 2 :  {
                freshNodePanel();
                break;
            }
        }
    }

    private void freshLatestPanel() {
        // TODO
    }

    private void freshHotPanel() {
        // TODO
    }

    private void freshNodePanel() {
        // TODO
    }

    private void initPanel() {
        initToolBar();
        initTabbedpanel();

    }

    private void initToolBar() {
        log.error(PersistentState.getInstance().get(PluginConf.V2EX_NAME));
        System.out.println(PersistentState.getInstance().get(PluginConf.V2EX_NAME));
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

    private void initTabbedpanel() {

    }
}

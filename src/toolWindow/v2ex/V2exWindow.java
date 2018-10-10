package toolWindow.v2ex;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBTabbedPane;
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
    private JButton button1;
    private JButton button2;
    private JPanel latestPanel;
    private JPanel hotPanel;
    private JPanel nodePanel;
    private JPanel panelContent;
    private JList list1;

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
        jToolBar = new JToolBar();
        jToolBar.setFloatable(true);
        jToolBar.setOrientation(SwingConstants.VERTICAL);
        jToolBar.add(new AbstractAction("refresh", AllIcons.Actions.Refresh) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        jToolBar.add(new AbstractAction("back", AllIcons.Actions.Back) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        jToolBar.add(new AbstractAction("forward", AllIcons.Actions.Forward) {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO
            }
        });
        toolWindowContent.add(jToolBar, BorderLayout.WEST);
    }

    private void initTabbedpanel() {
        tabbedPane = new JBTabbedPane();
        toolWindowContent.add(tabbedPane, BorderLayout.CENTER);
    }
}

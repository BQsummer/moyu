package toolWindow.v2ex;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import common.Contract;
import model.v2ex.Node;
import org.jetbrains.annotations.NotNull;
import toolWindow.v2ex.panel.V2exPanel;
import toolWindow.v2ex.panel.tabbed.FollowedTopicPanel;
import toolWindow.v2ex.panel.tabbed.HotTopicPanel;
import toolWindow.v2ex.panel.tabbed.LatestTopicPanel;
import util.HttpUtil;
import util.PageHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

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
    private LatestTopicPanel latestTopicPanel = new LatestTopicPanel(Contract.V2EX_LATEST_API);
    private HotTopicPanel hotTopicPanel = new HotTopicPanel(Contract.V2EX_HOT_API);
    private FollowedTopicPanel followedTopicPanel = new FollowedTopicPanel(Contract.V2EX_TOPIC_API);
    private List<V2exPanel> panelList = new ArrayList<>();

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
                panelList.get(tabbedPane1.getSelectedIndex()).prevPage();
            }
        });
        toolBar.add(new AbstractAction("forward", AllIcons.Actions.Forward) {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelList.get(tabbedPane1.getSelectedIndex()).nextPage();
            }
        });
    }

    /**
     * 初始化tabbed panel
     */
    private void initTabbedPanel() {
        tabbedPane1.addTab("Latest Topic", latestTopicPanel);
        tabbedPane1.addTab("Hot Topic", hotTopicPanel);
        tabbedPane1.addTab("Followed Topic", followedTopicPanel);
        panelList.addAll(new ArrayList<V2exPanel>() {{
            add(latestTopicPanel);
            add(hotTopicPanel);
            add(followedTopicPanel);
        }});
    }

    /**
     * 获取v2ex所有节点信息，给setting提供查询
     */
    private void initAllNode() {
        List<Node> allNode = HttpUtil.page(Contract.V2EX_ALLNODE_API, null, Node.class, new PageHelper(1, Integer.MAX_VALUE));
        Contract.setAllNode(allNode);
    }
}

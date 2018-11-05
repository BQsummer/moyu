package common;

import com.intellij.ide.ui.UINumericRange;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.wm.ToolWindowManager;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.PersistentState;
import toolWindow.setting.V2exConfigPanel;
import toolWindow.setting.WechatConfigPanel;
import toolWindow.v2ex.V2exWindow;
import util.TopicUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoyuSettingComponent implements SearchableConfigurable {

    private static boolean isCusModified = false;

    private JTabbedPane settingPanel = new JTabbedPane();

    private V2exConfigPanel v2exSettingPanel = new V2exConfigPanel();

    private WechatConfigPanel wechatSettingPanel = new WechatConfigPanel();

    @NotNull
    @Override
    public String getId() {
        return "moyu plugin";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String option) {
        return null;
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "moyu plugin";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Override
    public boolean isModified(@NotNull JTextField textField, @NotNull String value) {
        return false;
    }

    @Override
    public boolean isModified(@NotNull JTextField textField, int value, @NotNull UINumericRange range) {
        return false;
    }

    @Override
    public boolean isModified(@NotNull JToggleButton toggleButton, boolean value) {
        return false;
    }

    @Override
    public <T> boolean isModified(@NotNull ComboBox<T> comboBox, T value) {
        return false;
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        settingPanel.addTab("v2ex", v2exSettingPanel.getPanel());
        settingPanel.addTab("wechat", wechatSettingPanel.getPanel());
        return settingPanel;
    }

    /**
     * apply是否可用
     *
     * @return true or false
     */
    @Override
    public boolean isModified() {
        return isCusModify();
    }

    /**
     * 提交
     *
     * @throws ConfigurationException ConfigurationException
     */
    @Override
    public void apply() throws ConfigurationException {
        // save followed node list
        List<String> followedNodeList = v2exSettingPanel.getFollowedNodeList();
        PersistentState.getInstance().set(PluginConf.V2EX_FOLLOW_LIST, followedNodeList);

        // 更新topic下拉框
        V2exWindow toolWindow = (V2exWindow) ToolWindowManager.getInstance(V2exWindow.getInstance().getProject()).getToolWindow(V2exWindow.TOOL_WINDOW_ID);
        toolWindow.setComoBoxContent(followedNodeList.toArray(new String[followedNodeList.size()]));

        setCusModified(false);
    }

    /**
     * 重置
     */
    @Override
    public void reset() {
        // reset v2ex setting
        String[] followedTopicArr = TopicUtil.getFollowedTopic();
        if (followedTopicArr != null) {
            // List not support add() remove() method
            List<String> topicList = Arrays.asList(followedTopicArr);
            this.v2exSettingPanel.setFollowedNodeList(new ArrayList<>(topicList));
        }
        this.v2exSettingPanel.reset();
    }

    @Override
    public void disposeUIResources() {

    }

    private void initV2exSettingPanel() {

    }

    public static boolean isCusModify() {
        return isCusModified;
    }

    public static void setCusModified(boolean cusModified) {
        isCusModified = cusModified;
    }

}

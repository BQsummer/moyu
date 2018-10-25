package common;

import com.intellij.ide.ui.UINumericRange;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.ui.ComboBox;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import toolWindow.setting.V2exConfigPanel;
import toolWindow.setting.WechatConfigPanel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class MoyuSettingComponent implements SearchableConfigurable {

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
     * ok apply是否可用
     *
     * @return
     */
    @Override
    public boolean isModified() {
        return false;
    }

    /**
     * 提交
     *
     * @throws ConfigurationException
     */
    @Override
    public void apply() throws ConfigurationException {
        // save followed node list
        List<String> followedNodeList = v2exSettingPanel.getFollowedNodeList();
        PersistentState.getInstance().set(PluginConf.V2EX_FOLLOW_LIST, followedNodeList);
    }

    /**
     * 重置
     */
    @Override
    public void reset() {
        // reset v2ex setting
        Object obj = PersistentState.getInstance().get(PluginConf.V2EX_FOLLOW_LIST);
        if (obj != null) {
            String[] followed = (String[]) obj;
            this.v2exSettingPanel.setFollowedNodeList(Arrays.asList(followed));
        }
        this.v2exSettingPanel.reset();
    }

    @Override
    public void disposeUIResources() {

    }

    private void initV2exSettingPanel() {

    }
}

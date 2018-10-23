package common;

import com.intellij.ide.ui.UINumericRange;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.ui.ComboBox;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import toolWindow.setting.V2exSettingPanel;
import toolWindow.setting.WechatSettingPanel;

import javax.swing.*;

public class MoyuSettingComponent implements SearchableConfigurable {

    private JTabbedPane settingPanel = new JTabbedPane();

    private V2exSettingPanel v2exSettingPanel = new V2exSettingPanel();

    private WechatSettingPanel wechatSettingPanel = new WechatSettingPanel();


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
        settingPanel.addTab("v2ex", v2exSettingPanel);
        settingPanel.addTab("wechat", wechatSettingPanel);
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

    }

    /**
     * 重置
     */
    @Override
    public void reset() {

    }

    @Override
    public void disposeUIResources() {

    }

    private void initV2exSettingPanel() {

    }
}

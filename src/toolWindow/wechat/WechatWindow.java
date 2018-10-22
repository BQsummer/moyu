package toolWindow.wechat;

import cn.zhouyafeng.itchat4j.Wechat;
import cn.zhouyafeng.itchat4j.api.WechatTools;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;
import com.alibaba.fastjson.JSONObject;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import model.wechat.Friend;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HX
 * @description
 * @date 2018/10/20
 */
public class WechatWindow implements ToolWindowFactory {

    private ToolWindow toolWindow;

    private JList contactList;

    private JTextField textField;

    private JList dialogueList;

    private JToolBar toolBar;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        this.toolWindow = toolWindow;
    }

    @Override
    public void init(ToolWindow window) {
        ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
            public void run() {
                ApplicationManager.getApplication().runReadAction(new Runnable() {
                    public void run() {
                        startWechat();
                    }
                });
            }
        });

    }

    @Override
    public boolean shouldBeAvailable(@NotNull Project project) {
        return false;
    }

    @Override
    public boolean isDoNotActivateOnStart() {
        return false;
    }

    private void startWechat() {
        String qrPath = "D://itchat4j//login";
        IMsgHandlerFace msgHandler = new MsgHandle();
        Wechat wechat = new Wechat(msgHandler, qrPath);
        wechat.start();
        List<JSONObject> contactList = WechatTools.getContactList();
        List<Friend> friendList = contactList.stream().map(obj -> JSONObject.toJavaObject(obj, Friend.class)).collect(Collectors.toList());
        List<JSONObject> groupObjectList = WechatTools.getGroupList();
        List<Friend> groupList = contactList.stream().map(obj -> JSONObject.toJavaObject(obj, Friend.class)).collect(Collectors.toList());
    }
}

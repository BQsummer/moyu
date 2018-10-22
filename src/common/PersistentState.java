package common;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.diagnostic.Logger;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@State(name = "moyu", storages = {@Storage("moyuConfig.xml")})
public class PersistentState implements PersistentStateComponent<Element> {

    private static final Logger log = Logger.getInstance("moyu");

    private String VALUE_NAME = "value";

    private Element element;

    private PersistentState() {
    }

    public static PersistentState getInstance() {
        return ServiceManager.getService(PersistentState.class);
    }

    /**
     * called every time the settings are saved,the returned state is serialized in XML and stored
     *
     * @return
     */
    @Nullable
    @Override
    public Element getState() {
        if (element == null) {
            Element element = new Element("moyu");
        }
        return element;
    }

    /**
     * called when the component has been created, and after the XML file with the persisted state is changed externally
     *
     * @param element
     */
    @Override
    public void loadState(@NotNull Element element) {
        this.element = element.clone();
    }

    public Object get(PluginConf conf) {
        Class clz = conf.getType();
        Element specialEle = element.getChild(conf.getKey());
        log.info("4. ");
        if (specialEle == null) {
            log.info("5. ");
            if (conf.getDefaultVal() != null) {
                log.info("6. " + conf.getDefaultVal());
                return conf.getDefaultVal();
            }
            return null;
        }
        List<Element> contentList = specialEle.getChildren();
        if (contentList != null && contentList.size() > 0) {
            if (contentList.size() > 1) {
                Object[] arr = new Object[contentList.size()];
                for (int i = 0; i < contentList.size(); i++) {
                    Element element = contentList.get(i);
                    arr[i] = clz.cast(element.getText());
                }
                return arr;
            } else {
                Element element = contentList.get(0);
                return clz.cast(element.getText());
            }
        }
        return null;
    }

    public void set(PluginConf conf, Object value) {
        // 创建root
        if (this.element == null) {
            this.element = new Element("moyu");
        }
        // 删除原值
        this.element.removeChildren(conf.getKey());
        // 设值
        Element specialEle = new Element(conf.getKey());
        if (value instanceof List) {
            List<Object> list = (List<Object>) value;
            for (Object obj : list) {
                Element specialVal = new Element(VALUE_NAME);
                specialVal.setText(String.valueOf(obj));
                specialEle.addContent(specialVal);
            }
        } else {
            Element specialVal = new Element(VALUE_NAME);
            specialVal.setText(String.valueOf(value));
            specialEle.addContent(specialVal);
        }
        // 添加到root
        this.element.addContent(specialEle);
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}

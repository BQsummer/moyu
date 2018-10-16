package common;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "moyu")
public class PersistentState implements PersistentStateComponent<Element> {

    private PersistentState() {
    }

    public static PersistentState getInstance() {
        return ServiceManager.getService(PersistentState.class);
    }

    @Nullable
    @Override
    public Element getState() {
        Element element = new Element("moyu");
        // TODO
        //element.setAttr
        return element;
    }

    @Override
    public void loadState(@NotNull Element element) {
        //TODO
        // local attr
    }
}

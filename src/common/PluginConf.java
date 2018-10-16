package common;

import java.util.ArrayList;

/**
 * 全局设置
 */
public class PluginConf {

    private static PluginConf instance;

    private ArrayList<Integer> followedTopic;

    private PluginConf(){}

    public static synchronized PluginConf getInstance(){
        if(instance == null){
            instance = new PluginConf();
        }
        return instance;
    }

    public static void setInstance(PluginConf instance) {
        PluginConf.instance = instance;
    }
}

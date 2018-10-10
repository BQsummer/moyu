package common;

/**
 * 全局设置
 */
public class PluginConf {

    private static PluginConf instance;

    private PluginConf(){}

    public static synchronized PluginConf getInstance(){
        if(instance == null){
            instance = new PluginConf();
        }
        return instance;
    }

}

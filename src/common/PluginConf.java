package common;

/**
 * 全局设置
 */
public enum PluginConf {

    V2EX_NAME("v2ex_name", String.class),

    V2EX_FOLLOW_LIST("v2ex_follow_list", String[].class);

    String key;

    Class type;

    PluginConf() {
    }

    PluginConf(String key, Class type) {
        this.key = key;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }
}

package common;

/**
 * 全局设置
 */
public enum PluginConf {

    V2EX_NAME("v2ex_name", String.class, null),

    V2EX_FOLLOW_LIST("v2ex_follow_list", String[].class, new String[]{"java"});

    String key;

    Class type;

    Object defaultVal;

    PluginConf() {
    }

    PluginConf(String key, Class type, Object defaultVal) {
        this.key = key;
        this.type = type;
        this.defaultVal = defaultVal;
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

    public Object getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(Object defaultVal) {
        this.defaultVal = defaultVal;
    }
}

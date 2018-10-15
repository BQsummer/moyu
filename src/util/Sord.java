package util;

/**
 * 排序类型
 */
public enum Sord {
    ASC("asc"),

    DESC("desc");

    String type;

    private Sord(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

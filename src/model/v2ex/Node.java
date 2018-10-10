package model.v2ex;

import com.alibaba.fastjson.annotation.JSONField;

public class Node {
    private String avatar_large;

    private String name;

    @JSONField(name="avater_normal")
    private String avaterNormal;

    private String title;

    private String url;

    private String topis;

    private String footer;

    private String header;

    @JSONField(name="title_alternative")
    private String titleAlternative;

    @JSONField(name="avater_mini")
    private String avaterMini;

    private String stars;

    private String root;

    private Long id;

    @JSONField(name="parent_node_name")
    private String parentNodeName;

    public String getAvatar_large() {
        return avatar_large;
    }

    public void setAvatar_large(String avatar_large) {
        this.avatar_large = avatar_large;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopis() {
        return topis;
    }

    public void setTopis(String topis) {
        this.topis = topis;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvaterNormal() {
        return avaterNormal;
    }

    public void setAvaterNormal(String avaterNormal) {
        this.avaterNormal = avaterNormal;
    }

    public String getTitleAlternative() {
        return titleAlternative;
    }

    public void setTitleAlternative(String titleAlternative) {
        this.titleAlternative = titleAlternative;
    }

    public String getAvaterMini() {
        return avaterMini;
    }

    public void setAvaterMini(String avaterMini) {
        this.avaterMini = avaterMini;
    }

    public String getParentNodeName() {
        return parentNodeName;
    }

    public void setParentNodeName(String parentNodeName) {
        this.parentNodeName = parentNodeName;
    }
}

package model.v2ex;

import com.alibaba.fastjson.annotation.JSONField;
import model.AbsModel;

public class Topic extends AbsModel {

    private Node node;

    private Member member;

    @JSONField(name="last_reply_by")
    private String lastReplyBy;

    @JSONField(name="last_touched")
    private Long lastTouched;

    private String title;

    private String url;

    private Long created;

    private String content;

    @JSONField(name="content_rendered")
    private String contentRendered;

    @JSONField(name="last_modified")
    private Long lastModified;

    private Long replies;

    private Long id;

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getLastReplyBy() {
        return lastReplyBy;
    }

    public void setLastReplyBy(String lastReplyBy) {
        this.lastReplyBy = lastReplyBy;
    }

    public Long getLastTouched() {
        return lastTouched;
    }

    public void setLastTouched(Long lastTouched) {
        this.lastTouched = lastTouched;
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

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentRendered() {
        return contentRendered;
    }

    public void setContentRendered(String contentRendered) {
        this.contentRendered = contentRendered;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    public Long getReplies() {
        return replies;
    }

    public void setReplies(Long replies) {
        this.replies = replies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "node=" + node +
                ", member=" + member +
                ", lastReplyBy='" + lastReplyBy + '\'' +
                ", lastTouched=" + lastTouched +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", content='" + content + '\'' +
                ", contentRendered='" + contentRendered + '\'' +
                ", lastModified=" + lastModified +
                ", replies=" + replies +
                ", id=" + id +
                '}';
    }
}

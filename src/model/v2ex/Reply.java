package model.v2ex;

import com.alibaba.fastjson.annotation.JSONField;

public class Reply {
    private Member member;

    private Long created;

    @JSONField(name="topic_id")
    private Long topicId;

    private String content;

    @JSONField(name="content_rendered")
    private String contentRendered;

    @JSONField(name="last_modified")
    private Long lastModified;

    @JSONField(name="member_id")
    private Long memberId;

    private Long id;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

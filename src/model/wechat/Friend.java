package model.wechat;

import com.alibaba.fastjson.annotation.JSONField;
import model.AbsModel;

import java.util.List;

/**
 * @author HX
 * @description
 * @date 2018/10/22
 */
public class Friend extends AbsModel {
    @JSONField(name = "ChatRoomId")
    private Long chatRoomId;

    // 1男2女 0群
    @JSONField(name = "Sex")
    private Integer sex;

    @JSONField(name = "AttrStatus")
    private Long attrStatus;

    @JSONField(name = "Statues")
    private Long statues;

    @JSONField(name = "PYQuanPin")
    private String pYQuanPin;

    @JSONField(name = "EncryChatRoomId")
    private String encryChatRoomId;

    @JSONField(name = "DisplayName")
    private String displayName;

    @JSONField(name = "VerifyFlag")
    private Long verifyFlag;

    @JSONField(name = "UniFriend")
    private Integer uniFriend;

    @JSONField(name = "ContactFlag")
    private Integer contactFlag;

    @JSONField(name = "UserName")
    private String userName;

    @JSONField(name = "MemberList")
    private List<Member> memberList;

    @JSONField(name = "RemarkPYInitial")
    private String remarkPYInitial;

    @JSONField(name = "City")
    private String city;

    @JSONField(name = "NickName")
    private String nickName;

    @JSONField(name = "Province")
    private String province;

    @JSONField(name = "SnsFlag")
    private Long snsFlag;

    @JSONField(name = "Alias")
    private String alias;

    @JSONField(name = "KeyWord")
    private String keyWord;

    @JSONField(name = "HideInputBarFlag")
    private Long hideInputBarFlag;

    @JSONField(name = "Signature")
    private String signature;

    @JSONField(name = "RemarkName")
    private String remarkName;

    @JSONField(name = "RemarkPYQuanPin")
    private String remarkPYQuanPin;

    @JSONField(name = "Uin")
    private Long uin;

    @JSONField(name = "OwnerUin")
    private Long ownerUin;

    @JSONField(name = "IsOwner")
    private Long isOwner;

    @JSONField(name = "PYInitial")
    private String pYInitial;

    private int cardIndex;

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Long getAttrStatus() {
        return attrStatus;
    }

    public void setAttrStatus(Long attrStatus) {
        this.attrStatus = attrStatus;
    }

    public Long getStatues() {
        return statues;
    }

    public void setStatues(Long statues) {
        this.statues = statues;
    }

    public String getpYQuanPin() {
        return pYQuanPin;
    }

    public void setpYQuanPin(String pYQuanPin) {
        this.pYQuanPin = pYQuanPin;
    }

    public String getEncryChatRoomId() {
        return encryChatRoomId;
    }

    public void setEncryChatRoomId(String encryChatRoomId) {
        this.encryChatRoomId = encryChatRoomId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(Long verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public Integer getUniFriend() {
        return uniFriend;
    }

    public void setUniFriend(Integer uniFriend) {
        this.uniFriend = uniFriend;
    }

    public Integer getContactFlag() {
        return contactFlag;
    }

    public void setContactFlag(Integer contactFlag) {
        this.contactFlag = contactFlag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public String getRemarkPYInitial() {
        return remarkPYInitial;
    }

    public void setRemarkPYInitial(String remarkPYInitial) {
        this.remarkPYInitial = remarkPYInitial;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getSnsFlag() {
        return snsFlag;
    }

    public void setSnsFlag(Long snsFlag) {
        this.snsFlag = snsFlag;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Long getHideInputBarFlag() {
        return hideInputBarFlag;
    }

    public void setHideInputBarFlag(Long hideInputBarFlag) {
        this.hideInputBarFlag = hideInputBarFlag;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getRemarkPYQuanPin() {
        return remarkPYQuanPin;
    }

    public void setRemarkPYQuanPin(String remarkPYQuanPin) {
        this.remarkPYQuanPin = remarkPYQuanPin;
    }

    public Long getUin() {
        return uin;
    }

    public void setUin(Long uin) {
        this.uin = uin;
    }

    public Long getOwnerUin() {
        return ownerUin;
    }

    public void setOwnerUin(Long ownerUin) {
        this.ownerUin = ownerUin;
    }

    public Long getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Long isOwner) {
        this.isOwner = isOwner;
    }

    public String getpYInitial() {
        return pYInitial;
    }

    public void setpYInitial(String pYInitial) {
        this.pYInitial = pYInitial;
    }

    public int getCardIndex() {
        return cardIndex;
    }

    public void setCardIndex(int cardIndex) {
        this.cardIndex = cardIndex;
    }
}

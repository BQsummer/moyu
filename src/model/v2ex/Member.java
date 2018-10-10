package model.v2ex;

import com.alibaba.fastjson.annotation.JSONField;

public class Member {

    private String username;

    private String website;

    private String github;

    private String psn;

    @JSONField(name="avater_normal")
    private String avaterNormal;

    private String bio;

    private String url;

    private String tagline;

    private String twitter;

    private Long created;

    @JSONField(name="avater_lager")
    private String avaterLager;

    @JSONField(name="avater_mini")
    private String avaterMini;

    private String location;

    private String btc;

    private Long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBtc() {
        return btc;
    }

    public void setBtc(String btc) {
        this.btc = btc;
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

    public String getAvaterLager() {
        return avaterLager;
    }

    public void setAvaterLager(String avaterLager) {
        this.avaterLager = avaterLager;
    }

    public String getAvaterMini() {
        return avaterMini;
    }

    public void setAvaterMini(String avaterMini) {
        this.avaterMini = avaterMini;
    }
}

package com.datasource.model;

public class News {
    private int id;
    private String title;
    private String fenlei;
    private String content;
    private String addtime;
    private int visit;
    private String quanxian;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int visit) {
        this.visit = visit;
    }

    public String getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(String quanxian) {
        this.quanxian = quanxian;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fenlei='" + fenlei + '\'' +
                ", content='" + content + '\'' +
                ", addtime='" + addtime + '\'' +
                ", visit=" + visit +
                ", quanxian='" + quanxian + '\'' +
                '}';
    }
}

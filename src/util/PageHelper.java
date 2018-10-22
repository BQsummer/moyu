package util;

import java.util.List;

public class PageHelper {
    /**
     * 页数
     */
    private Integer page;

    /**
     * 每页数量
     */
    private Integer rows;

    /**
     * 排序字段
     */
    private String sidx;

    /**
     * 排序类型
     */
    private Sord sord;

    public <T> List<T> query(final List<T> list) {
        if (page == null || page < 1) {
            this.page = 1;
        }
        int startRow = (this.page - 1) * this.rows;
        if (startRow > list.size()) {
            startRow = list.size();
        }
        int endRow = this.page * this.rows;
        if (endRow > list.size()) {
            endRow = list.size();
        }
        return list.subList(startRow, endRow);
    }


    public PageHelper() {
    }

    public PageHelper(Integer page, Integer rows) {
        this.page = page;
        this.rows = rows;
    }

    public PageHelper(Integer page, Integer rows, String sidx, Sord sord) {
        this.page = page;
        this.rows = rows;
        this.sidx = sidx;
        this.sord = sord;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public Sord getSord() {
        return sord;
    }

    public void setSord(Sord sord) {
        this.sord = sord;
    }

}

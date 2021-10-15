package com.lianxing.pojo;

import java.util.List;

/**
 * @author lianxing
 * @description T分页中存储的对象
 * @create 2021-10-02 14:56
 */
public class Page<T> {
    public static final Integer PAGE_SIZE  = 4;

    private String url;

    //当前页码
    private Integer pageNo;
    //当前页数量
    private Integer pageSize = PAGE_SIZE;
    //总页码
    private Integer pageTotal;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //总记录数
    private Integer pageTotalCount;
    //当前页数据
    private List<T> items;

    @Override
    public String toString() {
        return "Page{" +
                "url='" + url + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //数据边界的有效检查
        if ( pageNo<1 ){
            pageNo = 1;
        }
        if ( pageNo>pageTotal ){
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

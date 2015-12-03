package com.moon.web.model;
public class GridData extends  ResultData {

    private Integer pageSize = 20; // 每页条数,数字, 分页时使用
    private Integer start = 0; // 从第几条开始显示,数字, 分页时使用
    private Integer totalCount = 0;// 总数据条数,数字,如果涉及到分页以及多条数据

    public static GridData newInstance(){
        return new GridData();
    }
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount){
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "GridData{" +
                "pageSize=" + pageSize +
                ", start=" + start +
                ", totalCount=" + totalCount +
                "} " + super.toString();
    }
}

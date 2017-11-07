package org.jypj.dev.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

public class Page extends RowBounds implements Serializable {
    private static final long serialVersionUID = 1L;
    protected List<?> result;
    protected int pageSize = 15;
    protected int currentPage = 1;
    protected int totalRows = 0;

    public Map<String, Object> condition; //查询条件

    public Page() {
    }

    public Page(int pageSize, String currentPage) {
        this.pageSize = pageSize;
        if (currentPage == null) {
            this.currentPage = 1;
        } else {
            this.currentPage = Integer.parseInt(currentPage);
        }

    }

    public Page(int currentPage) {
        this.currentPage = currentPage;
    }


    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * <p>
     * 每一页的条数，默认10条
     * <p/>
     *
     * @param pageSize
     * @author zhys
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        PageUtil.checkPage(this);
        return currentPage;
    }

    /**
     * <p>
     * 当前第几页，默认为1，从第一页开始
     * <p/>
     *
     * @author zhys
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    /**
     * <p>
     * 获取总页数
     * <p/>
     *
     * @return
     * @author zhys
     */
    public int getTotalPage() {
        return PageUtil.getTotalPage(this);
    }


    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }
}

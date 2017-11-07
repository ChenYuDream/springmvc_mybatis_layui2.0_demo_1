package org.jypj.dev.util;

import org.apache.log4j.Logger;

import javax.servlet.ServletRequest;

public class PageUtil {

    private static final Logger logger = Logger.getLogger(PageUtil.class);

    public static Page createPage(ServletRequest request) {
        Page page = createPage(request, null);
        return page;
    }

    public static Page createPage(ServletRequest request, String actionUrl, String... attrs) {
        Page page = new Page();
        String pageSize = request.getParameter("pageSize");
        String currentPage = request.getParameter("pageNo");

        if (RegularUtil.regularNumber(pageSize, 9)) {// 字符长度1-9位
            page.setPageSize(Integer.parseInt(pageSize));
        }
        if (RegularUtil.regularNumber(currentPage, 9)) {// 字符长度1-9位
            page.setCurrentPage(Integer.parseInt(currentPage));
        }
        return page;
    }

    public static void checkPage(Page page) {
        logger.debug("初始化总数" + page.totalRows);
        logger.debug("初始化页数" + page.currentPage);
        logger.debug(page.getTotalRows() / page.getPageSize());
        logger.debug(page.getPageSize());
        int countPage = getTotalPage(page);
        if (page.currentPage > countPage) {
            page.setCurrentPage(countPage - 1);
        } else if (page.currentPage < 1) {
            page.setCurrentPage(0);
        }
        logger.debug("页数" + page.currentPage);
    }

    /**
     * <p>
     * 获取总页数
     * <p/>
     *
     * @param page
     * @return
     * @author zhys
     */
    public static int getTotalPage(Page page) {
        int countPage = 0;
        if (page.getTotalRows() > 0) {
            if (page.getTotalRows() % page.getPageSize() == 0) {
                countPage = page.getTotalRows() / page.getPageSize();
            } else {
                countPage = page.getTotalRows() / page.getPageSize() + 1;
            }
        }
        return countPage;
    }
}

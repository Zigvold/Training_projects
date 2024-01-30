package ru.daniil.app.util;

import org.springframework.stereotype.Component;

@Component
public class RequestParam {
    private  Boolean paging;
    private Boolean sortByYear;
    private int booksPerPage;
    private int page;

    public RequestParam(Boolean paging, Boolean sortByYear, int booksPerPage, int page) {
        this.paging = paging;
        this.sortByYear = sortByYear;
        this.booksPerPage = booksPerPage;
        this.page = page;
    }

    public RequestParam() {}

    public Boolean getPaging() {
        return paging;
    }

    public void setPaging(Boolean paging) {
        this.paging = paging;
    }

    public Boolean getSortByYear() {
        return sortByYear;
    }

    public void setSortByYear(Boolean sortByYear) {
        this.sortByYear = sortByYear;
    }

    public int getBooksPerPage() {
        return booksPerPage;
    }

    public void setBooksPerPage(int booksPerPage) {
        this.booksPerPage = booksPerPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "RequestParam{" +
                "paging=" + paging +
                ", sortByYear=" + sortByYear +
                ", booksPerPage=" + booksPerPage +
                ", page=" + page +
                '}';
    }
}

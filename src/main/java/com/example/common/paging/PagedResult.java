package com.example.common.paging;

import java.util.List;

public class PagedResult<T> {
    private List<T> items;
    private long totalCount;

    public PagedResult() {
    }

    public PagedResult(List<T> items, long totalCount) {
        this.items = items;
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}

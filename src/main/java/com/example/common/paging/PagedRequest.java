package com.example.common.paging;

public class PagedRequest {

    // Số bản ghi tối đa mỗi trang client request
    private Integer maxResultCount;

    // Số bản ghi cần skip (offset)
    private Integer skipCount;

    public PagedRequest() {
    }

    public PagedRequest(Integer maxResultCount, Integer skipCount) {
        this.maxResultCount = maxResultCount;
        this.skipCount = skipCount;
    }

    public Integer getMaxResultCount() {
        return maxResultCount;
    }

    public void setMaxResultCount(Integer maxResultCount) {
        this.maxResultCount = maxResultCount;
    }

    public Integer getSkipCount() {
        return skipCount;
    }

    public void setSkipCount(Integer skipCount) {
        this.skipCount = skipCount;
    }
}

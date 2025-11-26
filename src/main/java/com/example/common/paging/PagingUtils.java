
package com.example.common.paging;

public final class PagingUtils {
    private static final int MAX_LIMIT = 100;

    private PagingUtils() {
    }

    public static void normalize(PagedRequest request) {
        if (request == null) {
            return;
        }

        Integer rawMax = request.getMaxResultCount();
        Integer rawSkip = request.getSkipCount();

        // maxResultCount
        int max = (rawMax == null) ? 0 : rawMax;
        if (max < 0) {
            max = 0;
        }
        if (max > MAX_LIMIT) {
            max = MAX_LIMIT;
        }

        // skipCount
        int skip = (rawSkip == null) ? 0 : rawSkip;
        if (skip < 0) {
            skip = 0;
        }

        request.setMaxResultCount(max);
        request.setSkipCount(skip);
    }
    public static int getOffset(PagedRequest request) {
        if (request == null || request.getSkipCount() == null) {
            return 0;
        }
        return Math.max(0, request.getSkipCount());
    }
    public static int getLimit(PagedRequest request) {
        if (request == null || request.getMaxResultCount() == null) {
            return 0;
        }
        int max = request.getMaxResultCount();
        return Math.max(0, max);
    }
}

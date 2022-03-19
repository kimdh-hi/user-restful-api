package com.devblog.mobileappws.service.dto.response;

import java.util.List;

public class PageUserResponseDto<T> {

    private List<UserResponseDto> content;

    private int size;
    private int page;
    private boolean isLastPage;
    private long totalElements;
    private int totalPages;

    public PageUserResponseDto() {
    }

    public PageUserResponseDto(List<UserResponseDto> content, int size, int page, boolean isLastPage, long totalElements, int totalPages) {
        this.content = content;
        this.size = size;
        this.page = page;
        this.isLastPage = isLastPage;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<UserResponseDto> getContent() {
        return content;
    }

    public void setContent(List<UserResponseDto> content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}

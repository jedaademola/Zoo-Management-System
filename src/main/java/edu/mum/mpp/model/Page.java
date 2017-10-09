package edu.mum.mpp.model;

import java.util.List;

/**
 * Created by Lukman.Arogundade on 4/30/2015.
 */
public class Page<T> {
    private Long count;
    private List<T> content;

    public Page(Long count, List<T> content) {
        this.count = count;
        this.content = content;
    }

    /**
     * @return the count
     */
    public Long getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * @return the content
     */
    public List<T> getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(List<T> content) {
        this.content = content;
    }
}
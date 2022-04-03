package ch.bbw.springproject.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Stats {
    private int views;

    public Stats() {
        this.views = 0;
    }

    public int getViews() {
        return views;
    }

    public void incrementViews() {
        views++;
    }
}

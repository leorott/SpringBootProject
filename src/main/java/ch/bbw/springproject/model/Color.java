package ch.bbw.springproject.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Color {
    private int r;
    private int g;
    private int b;

    public Color() {
        this.r = (int) (Math.random() * 127 + 128);
        this.g = (int) (Math.random() * 127 + 128);
        this.b = (int) (Math.random() * 127 + 128);
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}

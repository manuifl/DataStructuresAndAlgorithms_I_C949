package org.manuel.elements;

import javafx.util.Duration;

/**
 * @author Manuel Fuentes
 */
public enum DurationSpeeds {
    SLOW(Duration.millis(150.0)),
    NORMAL(Duration.millis(100.0)),
    FAST(Duration.millis(50.0));

    private final Duration duration;

    DurationSpeeds(Duration millis) {
        this.duration = millis;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public Duration getDuration() {
        return duration;
    }
}

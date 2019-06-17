package ru.kursio.application.model.entity.enumeration;

import java.util.Arrays;
import java.util.Optional;

public enum RankingStar {
    ONE_STAR(1),
    TWO_STARS(2),
    THREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);

    private final int value;

    RankingStar(int value) {
        this.value = value;
    }

    public static Optional<RankingStar> valueOf(int value) {
        return Arrays.stream(values())
                .filter(rankingStar -> rankingStar.value == value)
                .findFirst();
    }
}

package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.CharacterType;

public final class AppTheme {

    private AppTheme() {
    }

    // Warna utama aplikasi
    public static final Color BACKGROUND =
            new Color(25, 30, 45);

    public static final Color CARD_BACKGROUND =
            new Color(42, 49, 68);

    public static final Color TEXT =
            new Color(245, 245, 245);

    public static final Color MUTED_TEXT =
            new Color(180, 185, 200);

    public static final Color GOLD =
            new Color(255, 195, 60);

    public static final Color ACCENT =
            new Color(90, 150, 220);

    // Batas level untuk karakter spesial
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    // Font aplikasi
    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 24);

    public static final Font SUBTITLE_FONT =
            new Font("SansSerif", Font.BOLD, 15);

    public static final Font BODY_FONT =
            new Font("SansSerif", Font.PLAIN, 14);

    public static final Font SMALL_FONT =
            new Font("SansSerif", Font.PLAIN, 12);

    // Border aplikasi
    public static final Border WINDOW_BORDER =
            BorderFactory.createEmptyBorder(15, 15, 15, 15);

    public static Color colorFor(CharacterType type) {
        switch (type) {
            case WARRIOR:
                return new Color(190, 75, 75);

            case MAGE:
                return new Color(100, 90, 190);

            case ARCHER:
                return new Color(65, 145, 100);

            default:
                return ACCENT;
        }
    }

    public static Border borderFor(CharacterType type) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(colorFor(type), 2),
                BorderFactory.createEmptyBorder(10, 12, 10, 12)
        );
    }
}


package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;

import java.awt.Color;
import java.awt.Font;

public class AppTheme {

    public static final Color BACKGROUND =
        new Color(245, 247, 250);

    public static final Color PRIMARY =
        new Color(52, 73, 94);

    public static final Color TEXT =
        new Color(44, 62, 80);

    public static final Font TITLE_FONT =
        new Font("Arial", Font.BOLD, 22);

    public static final Font NORMAL_FONT =
        new Font("Arial", Font.PLAIN, 14);

    public static final Font CARD_FONT =
        new Font("Arial", Font.BOLD, 15);

    public static final int HIGH_LEVEL = 5;

    public static Color colorFor(CharacterType type) {

        switch (type) {
            case WARRIOR:
                return new Color(255, 220, 220);

            case MAGE:
                return new Color(220, 225, 255);

            case ARCHER:
                return new Color(220, 245, 220);

            default:
                return Color.WHITE;
        }
    }
}

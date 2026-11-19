
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CharacterManager manager = new CharacterManager();

            // Data awal
            manager.addCharacter(
                new Character("Regnar", CharacterType.WARRIOR, 10)
            );

            manager.addCharacter(
                new Character("Elara", CharacterType.MAGE, 15)
            );

            manager.addCharacter(
                new Character("Kael", CharacterType.ARCHER, 8)
            );

            manager.addCharacter(
                new Character("Freya", CharacterType.MAGE, 12)
            );

            manager.addCharacter(
                new Character("Arden", CharacterType.WARRIOR, 2)
            );

            MainWindow window = new MainWindow(manager);

            window.setVisible(true);
        });
    }
}


package com.unpri.charactermanager;

import javax.swing.SwingUtilities;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            CharacterManager manager = new CharacterManager();

            // Menambahkan 8 karakter

            manager.addCharacter(
                    new Character("Arka", 10, CharacterType.WARRIOR)
            );

            manager.addCharacter(
                    new Character("Luna", 15, CharacterType.MAGE)
            );

            manager.addCharacter(
                    new Character("Raka", 3, CharacterType.ARCHER)
            );

            manager.addCharacter(
                    new Character("Nara", 5, CharacterType.MAGE)
            );

            manager.addCharacter(
                    new Character("Kirana", 8, CharacterType.WARRIOR)
            );

            manager.addCharacter(
                    new Character("Bima", 2, CharacterType.ARCHER)
            );

            manager.addCharacter(
                    new Character("Maya", 7, CharacterType.MAGE)
            );

            manager.addCharacter(
                    new Character("Damar", 12, CharacterType.WARRIOR)
            );

            // Menampilkan GUI
            MainWindow window = new MainWindow(manager);

            window.setVisible(true);
        });
    }
}

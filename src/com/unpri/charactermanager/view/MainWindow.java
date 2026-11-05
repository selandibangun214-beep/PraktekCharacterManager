
package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private JPanel cardPanel;

    private JLabel totalLabel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager - Sprint #5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setLayout(
                new BorderLayout(12, 12)
        );

        getContentPane().setBackground(AppTheme.BACKGROUND);

        getRootPane().setBorder(
                AppTheme.WINDOW_BORDER
        );

        createHeader();
        createCharacterList();
        createLegend();
        createStatusBar();

        refreshCharacters();

        setMinimumSize(new Dimension(650, 450));
        setPreferredSize(new Dimension(1050, 650));

        pack();
        setLocationRelativeTo(null);
    }

    // =====================================
    // HEADER - NORTH
    // =====================================

    private void createHeader() {

        JPanel headerPanel = new JPanel(
                new BorderLayout(10, 10)
        );

        headerPanel.setBackground(AppTheme.BACKGROUND);

        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER"
        );

        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.GOLD);

        headerPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        // Panel statistik tambahan
        JPanel statisticsPanel = new JPanel(
                new GridLayout(2, 2, 10, 8)
        );

        statisticsPanel.setBackground(AppTheme.BACKGROUND);

        totalLabel = new JLabel("Total Karakter: 0");
        averageLabel = new JLabel("Rata-rata Level: 0.00");

        JLabel roleLabel = new JLabel("3 Jenis Role");
        JLabel versionLabel = new JLabel("Layout Version 0.5");

        JLabel[] statistics = {
            totalLabel,
            averageLabel,
            roleLabel,
            versionLabel
        };

        for (JLabel label : statistics) {

            label.setFont(AppTheme.BODY_FONT);
            label.setForeground(AppTheme.TEXT);
            label.setOpaque(true);
            label.setBackground(AppTheme.CARD_BACKGROUND);

            label.setBorder(
                    BorderFactory.createEmptyBorder(
                            8, 10, 8, 10
                    )
            );

            statisticsPanel.add(label);
        }

        headerPanel.add(
                statisticsPanel,
                BorderLayout.CENTER
        );

        getContentPane().add(
                headerPanel,
                BorderLayout.NORTH
        );
    }

    // =====================================
    // CHARACTER LIST - CENTER
    // =====================================

    private void createCharacterList() {

        // Panel pembungkus
        JPanel wrapperPanel = new JPanel(
                new BorderLayout()
        );

        wrapperPanel.setBackground(AppTheme.BACKGROUND);

        // Panel untuk menampung kartu karakter
        cardPanel = new JPanel(
                new GridLayout(0, 2, 12, 12)
        );

        cardPanel.setBackground(AppTheme.BACKGROUND);

        cardPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        5, 5, 5, 5
                )
        );

        // Kartu ditempatkan di NORTH
        wrapperPanel.add(
                cardPanel,
                BorderLayout.NORTH
        );

        // ScrollPane membungkus wrapperPanel
        JScrollPane scroll = new JScrollPane(wrapperPanel);

        scroll.setPreferredSize(
                new Dimension(700, 450)
        );

        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scroll.getViewport().setBackground(AppTheme.BACKGROUND);

        getContentPane().add(
                scroll,
                BorderLayout.CENTER
        );
    }

    // =====================================
    // LEGEND - EAST
    // =====================================

    private void createLegend() {

        JPanel legendPanel = new JPanel();

        legendPanel.setLayout(
                new BoxLayout(
                        legendPanel,
                        BoxLayout.Y_AXIS
                )
        );

        legendPanel.setBackground(AppTheme.CARD_BACKGROUND);

        legendPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 15, 15, 15
                )
        );

        JLabel title = new JLabel("LEGENDA ROLE");

        title.setFont(AppTheme.SUBTITLE_FONT);
        title.setForeground(AppTheme.GOLD);

        legendPanel.add(title);

        legendPanel.add(
                Box.createVerticalStrut(20)
        );

        // Mengambil seluruh role dari CharacterType
        for (CharacterType type : CharacterType.values()) {

            JPanel item = new JPanel(
                    new FlowLayout(
                            FlowLayout.LEFT,
                            8,
                            5
                    )
            );

            item.setBackground(AppTheme.CARD_BACKGROUND);

            item.setMaximumSize(
                    new Dimension(
                            Integer.MAX_VALUE,
                            40
                    )
            );

            JLabel colorBox = new JLabel("     ");

            colorBox.setOpaque(true);
            colorBox.setBackground(
                    AppTheme.colorFor(type)
            );

            JLabel roleName = new JLabel(
                    type.name()
            );

            roleName.setFont(AppTheme.BODY_FONT);
            roleName.setForeground(AppTheme.TEXT);

            item.add(colorBox);
            item.add(roleName);

            legendPanel.add(item);

            legendPanel.add(
                    Box.createVerticalStrut(10)
            );
        }

        legendPanel.add(
                Box.createVerticalGlue()
        );

        legendPanel.setPreferredSize(
                new Dimension(170, 400)
        );

        getContentPane().add(
                legendPanel,
                BorderLayout.EAST
        );
    }

    // =====================================
    // STATUS BAR - SOUTH
    // =====================================

    private void createStatusBar() {

        JPanel statusPanel = new JPanel(
                new BorderLayout()
        );

        statusPanel.setBackground(AppTheme.CARD_BACKGROUND);

        statusPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 12, 10, 12
                )
        );

        JLabel statusText = new JLabel(
                "Character Manager siap digunakan"
        );

        statusText.setFont(AppTheme.SMALL_FONT);
        statusText.setForeground(AppTheme.MUTED_TEXT);

        JLabel versionText = new JLabel("v0.5");

        versionText.setFont(AppTheme.SMALL_FONT);
        versionText.setForeground(AppTheme.GOLD);

        statusPanel.add(
                statusText,
                BorderLayout.WEST
        );

        statusPanel.add(
                versionText,
                BorderLayout.EAST
        );

        getContentPane().add(
                statusPanel,
                BorderLayout.SOUTH
        );
    }

    // =====================================
    // REFRESH CHARACTER
    // =====================================

    public void refreshCharacters() {

        cardPanel.removeAll();

        List<Character> characters =
                manager.getAllCharacters();

        for (Character character : characters) {

            cardPanel.add(
                    createCharacterCard(character)
            );
        }

        totalLabel.setText(
                "Total Karakter: "
                + manager.getTotalCharacters()
        );

        averageLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        cardPanel.revalidate();
        cardPanel.repaint();
    }

    // =====================================
    // CHARACTER CARD
    // =====================================

    private JPanel createCharacterCard(
            Character character
    ) {

        JPanel card = new JPanel(
                new GridLayout(3, 1, 5, 5)
        );

        card.setOpaque(true);
        card.setBackground(AppTheme.CARD_BACKGROUND);

        card.setBorder(
                AppTheme.borderFor(
                        character.getType()
                )
        );

        JLabel nameLabel = new JLabel(
                character.getName(),
                SwingConstants.LEFT
        );

        JLabel levelLabel = new JLabel(
                "Level: " + character.getLevel()
        );

        JLabel roleLabel = new JLabel(
                "Role: " + character.getType().name()
        );

        nameLabel.setFont(AppTheme.SUBTITLE_FONT);
        nameLabel.setForeground(AppTheme.TEXT);

        levelLabel.setFont(AppTheme.BODY_FONT);
        levelLabel.setForeground(AppTheme.MUTED_TEXT);

        roleLabel.setFont(AppTheme.BODY_FONT);
        roleLabel.setForeground(
                AppTheme.colorFor(character.getType())
        );

        // Mini-challenge: level tinggi berwarna emas
        if (character.getLevel()
                >= AppTheme.HIGH_LEVEL_THRESHOLD) {

            nameLabel.setForeground(AppTheme.GOLD);
            nameLabel.setFont(AppTheme.TITLE_FONT);
        }

        card.add(nameLabel);
        card.add(levelLabel);
        card.add(roleLabel);

        card.setPreferredSize(
                new Dimension(250, 110)
        );

        return card;
    }
}

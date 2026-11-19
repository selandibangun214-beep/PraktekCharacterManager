
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private JPanel listPanel;
    private JLabel lblTotal;
    private JLabel lblAverage;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(AppTheme.BACKGROUND);
        setLayout(new BorderLayout(15, 15));

        initializeUI();

        refreshList();

        pack();
        setLocationRelativeTo(null);
    }

    private void initializeUI() {

        JPanel header = new JPanel(new GridLayout(2, 1, 5, 5));
        header.setBackground(AppTheme.BACKGROUND);
        header.setBorder(new EmptyBorder(15, 15, 5, 15));

        JLabel title = new JLabel("CHARACTER MANAGER");
        title.setFont(AppTheme.TITLE_FONT);
        title.setForeground(AppTheme.PRIMARY);

        JPanel statistics = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statistics.setBackground(AppTheme.BACKGROUND);

        lblTotal = new JLabel();
        lblAverage = new JLabel();

        lblTotal.setFont(AppTheme.NORMAL_FONT);
        lblAverage.setFont(AppTheme.NORMAL_FONT);

        statistics.add(lblTotal);
        statistics.add(new JLabel("     |     "));
        statistics.add(lblAverage);

        header.add(title);
        header.add(statistics);

        add(header, BorderLayout.NORTH);

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(AppTheme.BACKGROUND);
        listPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        add(scrollPane, BorderLayout.CENTER);

        CharacterFormPanel formPanel =
            new CharacterFormPanel(manager, this::refreshList);

        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(5, 15, 15, 15),
            BorderFactory.createTitledBorder("Input Karakter")
        ));

        add(formPanel, BorderLayout.SOUTH);
    }

    public void refreshList() {

        listPanel.removeAll();

        for (Character character : manager.getAllCharacters()) {

            JPanel card = new JPanel(new BorderLayout(10, 5));

            card.setOpaque(true);
            card.setBackground(
                AppTheme.colorFor(character.getType())
            );

            card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                new EmptyBorder(12, 12, 12, 12)
            ));

            JLabel name = new JLabel(character.getName());

            name.setFont(AppTheme.CARD_FONT);

            if (character.getLevel() >= AppTheme.HIGH_LEVEL) {
                name.setForeground(new Color(170, 120, 0));
                name.setFont(new Font(
                    AppTheme.CARD_FONT.getName(),
                    Font.BOLD,
                    AppTheme.CARD_FONT.getSize()
                ));
            }

            JLabel details = new JLabel(
                "Role: " + character.getType()
                + " | Level: " + character.getLevel()
            );

            details.setFont(AppTheme.NORMAL_FONT);

            card.add(name, BorderLayout.NORTH);
            card.add(details, BorderLayout.CENTER);

            card.setMaximumSize(new Dimension(
                Integer.MAX_VALUE, 75
            ));

            listPanel.add(card);
            listPanel.add(Box.createVerticalStrut(8));
        }

        lblTotal.setText(
            "Total Karakter: " + manager.getTotalCharacters()
        );

        lblAverage.setText(
            String.format(
                "Rata-rata Level: %.2f",
                manager.getAverageLevel()
            )
        );

        listPanel.revalidate();
        listPanel.repaint();
    }
}

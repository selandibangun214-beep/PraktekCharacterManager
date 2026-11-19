
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.ParseException;

public class CharacterFormPanel extends JPanel {

    private JTextField txtName;
    private JComboBox<CharacterType> cmbRole;
    private JSpinner spnLevel;

    private JLabel lblError;

    private Border originalNameBorder;
    private Border originalRoleBorder;
    private Border originalLevelBorder;

    private final CharacterManager manager;
    private final Runnable onSuccess;

    public CharacterFormPanel(
            CharacterManager manager,
            Runnable onSuccess) {

        this.manager = manager;
        this.onSuccess = onSuccess;

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder(
            "Tambah Karakter Baru"
        ));

        initializeComponents();
    }

    private void initializeComponents() {

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));

        txtName = new JTextField(15);

        cmbRole = new JComboBox<>(CharacterType.values());

        spnLevel = new JSpinner(
            new SpinnerNumberModel(1, 1, 99, 1)
        );

        originalNameBorder = txtName.getBorder();
        originalRoleBorder = cmbRole.getBorder();
        originalLevelBorder = spnLevel.getBorder();

        form.add(new JLabel("Nama Karakter:"));
        form.add(txtName);

        form.add(new JLabel("Role:"));
        form.add(cmbRole);

        form.add(new JLabel("Level (1-99):"));
        form.add(spnLevel);

        JButton btnAdd = new JButton("Tambah Karakter");

        lblError = new JLabel(" ");
        lblError.setForeground(Color.RED);

        JPanel bottom = new JPanel(new BorderLayout(5, 5));
        bottom.add(lblError, BorderLayout.CENTER);
        bottom.add(btnAdd, BorderLayout.SOUTH);

        add(form, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        btnAdd.addActionListener(e -> addCharacter());
    }

    private String validateName(String name) {

        // 1. Kelengkapan
        if (name.isEmpty()) {
            return "Nama karakter wajib diisi.";
        }

        // 2. Panjang
        if (name.length() > 20) {
            return "Nama maksimal 20 karakter.";
        }

        // 3. Format
        if (!name.matches("[a-zA-Z][a-zA-Z ]*")) {
            return "Nama hanya boleh berisi huruf dan spasi.";
        }

        if (name.contains("  ")) {
            return "Nama tidak boleh mengandung spasi ganda.";
        }

        // 4. Keunikan
        if (manager.isNameTaken(name)) {
            return "Nama karakter sudah digunakan.";
        }

        return null;
    }

    private void addCharacter() {

        resetBorders();

        String name = txtName.getText().trim();

        String error = validateName(name);

        if (error != null) {
            showError(error, txtName);
            return;
        }

        int level;

        try {
            spnLevel.commitEdit();

            level = ((Number) spnLevel.getValue()).intValue();

        } catch (ParseException ex) {

            showError(
                "Level harus berupa angka yang valid.",
                spnLevel
            );

            return;
        }

        CharacterType type =
            (CharacterType) cmbRole.getSelectedItem();

        try {

            Character character =
                new Character(name, type, level);

            manager.addCharacter(character);

            lblError.setForeground(new Color(0, 128, 0));
            lblError.setText("Karakter berhasil ditambahkan!");

            txtName.setText("");
            cmbRole.setSelectedIndex(0);
            spnLevel.setValue(1);

            if (onSuccess != null) {
                onSuccess.run();
            }

        } catch (IllegalArgumentException ex) {

            showError(ex.getMessage(), txtName);
        }
    }

    private void showError(String message, JComponent component) {

        lblError.setForeground(Color.RED);
        lblError.setText(message);

        component.setBorder(
            BorderFactory.createLineBorder(Color.RED, 2)
        );

        component.requestFocusInWindow();
    }

    private void resetBorders() {

        txtName.setBorder(originalNameBorder);
        cmbRole.setBorder(originalRoleBorder);
        spnLevel.setBorder(originalLevelBorder);

        lblError.setText(" ");
    }
}

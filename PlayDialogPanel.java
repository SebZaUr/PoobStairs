import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayDialogPanel extends JPanel {

    private JTextField player1NameField;
    private JTextField player2NameField;
    private JComboBox<String> colorComboBox;
    private JButton playButton;
    private JButton closeButton;

    public PlayDialogPanel() {
        // Configurar el panel
        setLayout(new GridLayout(4, 2, 10, 10)); // GridLayout con 4 filas, 2 columnas y espacios de 10 píxeles

        // Agregar los componentes al panel
        JLabel player1Label = new JLabel("Player 1 Name:");
        add(player1Label);
        player1NameField = new JTextField();
        player1NameField.getDocument().addDocumentListener(new InputDocumentListener());
        add(player1NameField);

        JLabel player2Label = new JLabel("Player 2 Name:");
        add(player2Label);
        player2NameField = new JTextField();
        player2NameField.getDocument().addDocumentListener(new InputDocumentListener());
        add(player2NameField);

        JLabel colorLabel = new JLabel("Select Color:");
        add(colorLabel);
        String[] colors = {"Red", "Green", "Blue"};
        colorComboBox = new JComboBox<>(colors);
        add(colorComboBox);

        // Agregar botón Jugar
        playButton = new JButton("Jugar");
        playButton.setEnabled(false);
        add(playButton);

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isInputValid()) {
                    // Obtener los valores de los campos de texto y la lista desplegable
                    String player1 = getPlayer1Name();
                    String player2 = getPlayer2Name();
                    String color = getColor();
        
                    // Crear una nueva ventana de juego
                    GameFrame gameFrame = new GameFrame(player1, player2, color);
        
                    // Cerrar la ventana actual
                    Window window = SwingUtilities.getWindowAncestor(PlayDialogPanel.this);
                    if (window != null) {
                        window.dispose();
                    }
                }
            }
        });

        // Agregar botón Cerrar
        closeButton = new JButton("Cerrar");
        add(closeButton);

        // Configurar la acción del botón Cerrar
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(PlayDialogPanel.this);
                if (window != null) {
                    window.dispose();
                }
            }
        });
    }

    public boolean isInputValid() {
        // Verificar si el usuario ingresó los nombres de los jugadores y seleccionó un color
        String player1Name = player1NameField.getText().trim();
        String player2Name = player2NameField.getText().trim();
        if (player1Name.isEmpty() || player2Name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter both player names", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (colorComboBox.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Please select a color", "Invalid input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public String getPlayer1Name() {
        return player1NameField.getText().trim();
    }

    public String getPlayer2Name() {
        return player2NameField.getText().trim();
    }

    public String getColor1() {
        return colorComboBox.getSelectedItem().toString();
    }
    public String getColor() {
        return colorComboBox.getSelectedItem().toString();
    }

    private class InputDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateButtonState();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateButtonState();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateButtonState();
        }

        private void updateButtonState() {
            boolean enableButton = !player1NameField.getText().isEmpty() && !player2NameField.getText().isEmpty();
            playButton.setEnabled(enableButton);
        }
    }
}

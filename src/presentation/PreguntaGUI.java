package presentation;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import domain.Pregunta;

public class PreguntaGUI extends JDialog {

    private String questionT, opA, opB, opC, opD;

    public PreguntaGUI(Pregunta question) {
        questionT = question.getPregunta();
        String[] respuestas = question.getRespuestas();
        opA = respuestas[0];
        opB = respuestas[1];
        opC = respuestas[2];
        opD = respuestas[3];

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        getContentPane().add(panel, BorderLayout.NORTH);

        JLabel pregunta = new JLabel(questionT);
        panel.add(pregunta);

        JPanel panel_1 = new JPanel();
        panel_1.setOpaque(false);
        getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        JButton OpcionA = new JButton(opA);
        JButton OpcionB = new JButton(opB);
        JButton OpcionC = new JButton(opC);
        JButton OpcionD = new JButton(opD);

        OpcionA.setFont(Estilos.FUENTE_LETRA);
        OpcionB.setFont(Estilos.FUENTE_LETRA);
        OpcionC.setFont(Estilos.FUENTE_LETRA);
        OpcionD.setFont(Estilos.FUENTE_LETRA);

        OpcionA.setBackground(Estilos.COLOR_LETRAS);
        OpcionB.setBackground(Estilos.COLOR_LETRAS);
        OpcionC.setBackground(Estilos.COLOR_LETRAS);
        OpcionD.setBackground(Estilos.COLOR_LETRAS);

        panel_1.add(OpcionA);
        panel_1.add(OpcionB);
        panel_1.add(OpcionC);
        panel_1.add(OpcionD);

        OpcionA.setFont(Estilos.FUENTE_LETRA);
        OpcionA.setBackground(Estilos.COLOR_LETRAS);
    }

}


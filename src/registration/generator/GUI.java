/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration.generator;

import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.event.*;

/**
 *
 * @author Alex
 */
public class GUI extends JFrame //implements ActionListener
{

    private final JButton generate;
    private final JTextArea txtArea;
    private final JLabel lblCA, lblZN, lblMP, lblEC, lblL, lblGP, lblNC, lblFS, lblNW;
    private final JTextField tfCA, tfZN, tfMP, tfEC, tfL, tfGP, tfNC, tfFS, tfNW;
    private final JPanel buttonPanel, txtAreaPanel, lblPanel;

    public GUI()
    {
        super("Vehicle Registration Number Generator");

        setLayout(new BorderLayout());

        buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.red);
        generate = new JButton("generate");
        buttonPanel.add(generate);

        txtAreaPanel = new JPanel();
        add(txtAreaPanel, BorderLayout.CENTER);
        txtAreaPanel.setBackground(Color.cyan);
        txtAreaPanel.setLayout(new BorderLayout());
        txtArea = new JTextArea();
        txtAreaPanel.add(new JScrollPane(txtArea));
        txtArea.setEditable(false);

        lblPanel = new JPanel();
        add(lblPanel, BorderLayout.SOUTH);
        lblPanel.setBackground(Color.green);
        lblPanel.setLayout(new GridLayout(5, 2, 1, 1));
        lblCA = new JLabel("Western Cape");
        tfCA = new JTextField(10);
        lblZN = new JLabel("KwaZulu-Natal");
        tfZN = new JTextField(10);
        lblMP = new JLabel("Mpumalanga");
        tfMP = new JTextField(10);
        lblEC = new JLabel("Eastern Cape");
        tfEC = new JTextField(10);
        lblL = new JLabel("Limpopo");
        tfL = new JTextField(10);
        lblGP = new JLabel("Gauteng");
        tfGP = new JTextField(10);
        lblNC = new JLabel("Northern Cape");
        tfNC = new JTextField(10);
        lblFS = new JLabel("Free State");
        tfFS = new JTextField(10);
        lblNW = new JLabel("North West");
        tfNW = new JTextField(10);
        
        lblPanel.add(lblCA);
        lblPanel.add(tfCA);
        lblPanel.add(lblZN);
        lblPanel.add(tfZN);
        lblPanel.add(lblMP);
        lblPanel.add(tfMP);
        lblPanel.add(lblEC);
        lblPanel.add(tfEC);
        lblPanel.add(lblL);
        lblPanel.add(tfL);
        lblPanel.add(lblGP);
        lblPanel.add(tfGP);
        lblPanel.add(lblNC);
        lblPanel.add(tfNC);
        lblPanel.add(lblFS);
        lblPanel.add(tfFS);
        lblPanel.add(lblNW);
        lblPanel.add(tfNW);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setVisible(true);

        ActionHandler handler = new ActionHandler();
        generate.addActionListener(handler);

    }

    private class ActionHandler implements ActionListener
    {

        RegistrationGenerator regGen = new RegistrationGenerator();

        @Override
        public void actionPerformed(ActionEvent e)
        {
            for (int i = 0; i < 1000000; i++)
            {
                txtArea.append(regGen.getRegistration() + "\n");
            }
            tfCA.setText(String.format("%d", regGen.provinceCodes[0]));
            tfZN.setText(String.format("%d", regGen.provinceCodes[1]));
            tfMP.setText(String.format("%d", regGen.provinceCodes[2]));
            tfEC.setText(String.format("%d", regGen.provinceCodes[3]));
            tfL.setText(String.format("%d", regGen.provinceCodes[4]));
            tfGP.setText(String.format("%d", regGen.provinceCodes[5]));
            tfNC.setText(String.format("%d", regGen.provinceCodes[6]));
            tfFS.setText(String.format("%d", regGen.provinceCodes[7]));
            tfNW.setText(String.format("%d", regGen.provinceCodes[8]));

        }

    }

}

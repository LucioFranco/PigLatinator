package com.luciofranco.piglatinator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame {

	JFrame frame;
	PigLatinTranslator pig;
	JButton b1, b2;
	JLabel l1;
	JTextField t1;

	Frame() {
		pig = new PigLatinTranslator();
		frame = new JFrame("Pig Latin Translator");
		l1 = new JLabel("Note: Phrase must follow US English rules");
		t1 = new JTextField(25);
		b1 = new JButton("Translate");
		b2 = new JButton("Exit");

		createFrame();
		run();
	}

	public void createFrame() {
		t1.setFocusable(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());

		frame.add(new JLabel("Enter English phrase then click translate"));
		frame.add(t1);
		frame.add(b1);
		frame.add(b2);
		frame.add(l1);

		frame.getRootPane().setDefaultButton(b1);

		frame.pack();
		frame.setSize(330, 200);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void run() {

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText(("<html><table><td align = 'center' width='" + 290
						+ "'>" + pig.getPigLatinPhrase(t1.getText()) + "</td></table></html>"));
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Frame();
	}
}
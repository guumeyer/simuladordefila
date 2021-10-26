package com.edu.gui.componentes;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class NumberField extends JTextField implements FocusListener {

	public NumberField() {

		this.addFocusListener(this);
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!((c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE)
						|| (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB) || (Character
						.isDigit(c)))) {
					e.consume();
				}
			}
		});
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		String text = this.getText();
		int input = 0;
		try {
			input = Integer.parseInt(text);
		} catch (Exception ex) {
			// For simplicity, I'm simply outputting a msg to the console.
//			JOptionPane.showMessageDialog(null,
//					"O Campo deverá ser preencher com valores númericos.");
			this.requestFocus(); // send cursor back to the text field
		}

	}

}

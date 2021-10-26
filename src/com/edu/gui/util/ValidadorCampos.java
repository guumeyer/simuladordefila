package com.edu.gui.util;

import java.awt.Color;

import javax.swing.JTextField;

public class ValidadorCampos {
	
	public static void setColorField(JTextField field, Color color){
		field.setBackground(color);
	}
	
	
	public static boolean validarCampoIntervaloChegada(JTextField field){
		if (isCampoInteger(field))
			if (Integer.valueOf(field.getText()) >= 0)
				return true;
			else{
				setColorField(field, Color.RED);
				return false;
			}
		else{
			setColorField(field, Color.RED);
			return false;
		}
	}
	
	
	
	public static boolean validarCampoInteger(JTextField field){
		if (isCampoInteger(field))
			if (Integer.valueOf(field.getText()) > 0)
				return true;
			else{
				setColorField(field, Color.RED);
				return false;
			}
		else{
			setColorField(field, Color.RED);
			return false;
		}
	}
	
	public static boolean validarCampoString(JTextField field){
		if (field.getText().isEmpty()){
			setColorField(field, Color.RED);
			return false;
		}
		else
			return true;
	}
	
	public static boolean isCampoInteger( JTextField field){
		try {
			int numero = Integer.parseInt(field.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

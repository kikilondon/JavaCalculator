package com.chiara.client;

import javax.swing.SwingUtilities;

import com.chiara.presentation.CalculatorGui;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
            new CalculatorGui();
        });
    }
	

}

package com.xdpm;

import javax.swing.SwingUtilities;

import com.xdpm.ui.UI_Main;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new UI_Main());
	}
}

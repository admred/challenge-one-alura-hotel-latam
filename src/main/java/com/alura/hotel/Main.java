package com.alura.hotel;
import java.awt.EventQueue;

import com.alura.hotel.views.MenuPrincipal;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal menuPrincipal=new MenuPrincipal();
					menuPrincipal.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

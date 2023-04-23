package com.alura.hotel;
import javax.persistence.EntityManager;

import com.alura.hotel.utils.JPAUtils;
import com.alura.hotel.views.Login;

public class Main {
	
	public static void main(String[] args) {
		
		new Login().setVisible(true);
	}
}

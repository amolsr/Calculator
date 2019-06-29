package com.calculator.controller;

import java.awt.EventQueue;

import com.calculator.model.Model;
import com.calculator.view.MainContainer;

public class Controller {

	static Model m;
	static MainContainer v;

	private Controller() {
		v = new MainContainer();
		m = new Model();
	}

	public static String getIntListString() {
		String str = "";
		for (int i = 0; i < m.getNumList().size(); i++) {
			str += String.valueOf(m.getNumList().get(i));
		}
		return str;
	}

	public static String getDisplayListString() {
		for (Object nxt : m.getDisplayList()) {
			String s = String.valueOf(nxt);
			s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
			m.setStr(m.getStr() + s);
		}
		return m.getStr();
	}

	public static String getOpListString() {
		String str = "";
		for (int i = 0; i < m.getOpList().size(); i++) {
			str += String.valueOf(m.getOpList().get(i));
		}
		return str;
	}

	public static void setStr() {
		m.setStr("");
	}

	public static void setTemp() {
		m.setTemp(0d);
	}

	public static void delTemp() {
		String s = adjust(m.getTemp());
		String st = "0";
		if (s.length() == 1) {
			st = "0";
		} else {
			if (!(s.charAt(s.length() - 1) == '.')) {
				st = s.substring(0, s.length() - 1);
			} else {
				st = s;
			}
		}
		m.setTemp(Double.parseDouble(st));
	}
//		m.setTemp(m.getTemp() / 10);

	public static void setTemp(Integer n) {
		if (v.down.getText().equals("Calculator BY Amol ") || checkdeci(v.down.getText())) {
			m.setTemp(m.getTemp() * 10 + n);
		} else {
			String str = v.down.getText();
			str = str.concat(String.valueOf(n));
			m.setTemp(Double.parseDouble(str));
		}
	}

	public static void root() {
		m.setDisplayList('\u221A');
		m.setDisplayList(m.getTemp());
		m.setTemp(Math.sqrt(m.getTemp()));
		m.setNumList(m.getTemp());
		v.top.setText(getDisplayListString());
		v.down.setText(String.valueOf(adjust(m.getTemp())));
		setStr();
		setTemp();
	}

	public static void sign() {
		m.setTemp(m.getTemp() * -1);
		v.down.setText(String.valueOf(adjust(m.getTemp())));
	}

	public static void inv() {
		m.setDisplayList(m.getTemp());
		m.setDisplayList('\u207B');
		m.setDisplayList('\u00B9');
		m.setTemp(1 / m.getTemp());
		m.setNumList(m.getTemp());
		v.top.setText(getDisplayListString());
		v.down.setText(String.valueOf(adjust(m.getTemp())));
		setStr();
		setTemp();
	}

	public void sqr() {
		if (m.getNumList().size() >= 1) {
			Double i = m.getNumList().get(m.getNumList().size() - 1);
			m.setTemp(i * m.getTemp());
			m.getNumList().remove(m.getNumList().size() - 1);
			m.getNumList().add(m.getTemp());
		} else {
			m.setTemp(m.getTemp() * m.getTemp());
			m.getNumList().add(m.getTemp());
		}
	}

	public void cube() {
		if (m.getNumList().size() >= 1) {
			Double i = m.getNumList().get(m.getNumList().size() - 1);
			m.setTemp(i * m.getTemp() * m.getTemp());
			m.getNumList().remove(m.getNumList().size() - 1);
			m.getNumList().add(m.getTemp());
		} else {
			m.setTemp(m.getTemp() * m.getTemp() * m.getTemp());
			m.getNumList().add(m.getTemp());
		}
	}

	public static void powerOperation(Boolean b, Double i) {
		if (b)
			m.setTemp(i * m.getTemp());
		else
			m.setTemp(i * m.getTemp() * m.getTemp());
	}

	public static void powerOperation(Boolean b) {
		if (b)
			m.setTemp(m.getTemp() * m.getTemp());
		else
			m.setTemp(m.getTemp() * m.getTemp() * m.getTemp());
	}

	public static void power(Boolean b) {
		if (m.getNumList().size() >= 1) {
			Double i = m.getNumList().get(m.getNumList().size() - 1);
			powerOperation(b, i);
			m.getNumList().remove(m.getNumList().size() - 1);
			m.getNumList().add(m.getTemp());
		} else {
			powerOperation(b);
			m.getNumList().add(m.getTemp());
		}
	}

	public static void cla() {
		m.getDisplayList().clear();
		m.getNumList().clear();
		m.getOpList().clear();
		m.setTemp(0d);
		m.setStr("");
	}

	public static void operate() {
		Character ch = m.getOpList().get(m.getOpList().size() - 1);
		Double i = m.getNumList().get(m.getNumList().size() - 1);
		switch (ch) {
		case '/':
			m.setTemp(i / m.getTemp());
			m.getNumList().remove(m.getNumList().size() - 1);
//			m.getOpList().remove(m.getOpList().size() - 1);
			m.getNumList().add(m.getTemp());
			break;
		case 'X':
			m.setTemp(i * m.getTemp());
			m.getNumList().remove(m.getNumList().size() - 1);
//			m.getOpList().remove(m.getOpList().size() - 1);
			m.getNumList().add(m.getTemp());
			break;
		case '+':
			m.setTemp(i + m.getTemp());
			m.getNumList().remove(m.getNumList().size() - 1);
//			m.getOpList().remove(m.getOpList().size() - 1);
			m.getNumList().add(m.getTemp());
			break;
		case '-':
			m.setTemp(i - m.getTemp());
			m.getNumList().remove(m.getNumList().size() - 1);
//			m.getOpList().remove(m.getOpList().size() - 1);
			m.getNumList().add(m.getTemp());
			break;
		}
	}

	public static void numInput(Integer i) {
		setTemp(i);
		v.down.setText(adjust(m.getTemp()));
	}

	public static void functionKey(String c) {
		switch (c) {
		case "c":
			cla();
			v.top.setText(String.valueOf(getIntListString()));
			v.down.setText(adjust(m.getTemp()));
			break;
		case "ce":
			setTemp();
			v.down.setText(adjust(m.getTemp()));
			break;
		case "del":
			delTemp();
			v.down.setText(adjust(m.getTemp()));
			break;
		}
	}

	public static void operatorInput(Character c, Character charOperator) {
		if (m.getOpList().size() == 0 && m.getNumList().size() == 0) {
			m.setDisplayList();
			m.setNumList(m.getTemp());
			m.setOpList(charOperator);
			m.setDisplayList(m.getTemp());
			m.setDisplayList(c);
			v.top.setText(getDisplayListString());
			setTemp();
			v.down.setText(adjust(m.getTemp()));
			setStr();
			System.out.println(getIntListString());
			System.out.println(getOpListString());

		} else if (m.getOpList().size() == 0 || m.getNumList().size() >= 2) {
			if (m.getNumList().size() >= 2) {
				m.setTemp(m.getNumList().get(0));
				operate();
				m.getNumList().remove(0);
			}
			m.setDisplayList(c);
			m.setOpList(charOperator);
			v.top.setText(getDisplayListString());
			v.down.setText(adjust(m.getTemp()));
			System.out.println(getIntListString());
			System.out.println(getOpListString());
			setStr();
			setTemp();

		} else {
			setStr();
			m.setDisplayList(m.getTemp());
			m.setDisplayList(c);
			operate();
			m.setOpList(charOperator);
			v.top.setText(getDisplayListString());
			v.down.setText(adjust(m.getTemp()));
			System.out.println(getIntListString());
			System.out.println(getOpListString());
			setTemp();

		}
	}

	public static void powerInput(Character c, Boolean b) {
		if (m.getNumList().size() == 0) {
			m.setDisplayList(m.getTemp());
			m.setDisplayList(c);
			power(b);
			v.top.setText(getDisplayListString());
			v.down.setText(adjust(m.getTemp()));
			System.out.println(getIntListString());
			System.out.println(getOpListString());
			setStr();

		} else if (m.getDisplayList().get(m.getDisplayList().size() - 1).equals('\u00B3')
				|| m.getDisplayList().get(m.getDisplayList().size() - 1).equals('\u00B2')) {
			m.setDisplayList(c);
			power(b);
			v.top.setText(getDisplayListString());
			v.down.setText(adjust(m.getTemp()));
			System.out.println(getIntListString());
			System.out.println(getOpListString());
			setStr();

		} else {
			setStr();
			m.setNumList(m.getTemp());
			m.setDisplayList(m.getTemp());
			m.setDisplayList(c);
			power(b);
			v.top.setText(getDisplayListString());
			v.down.setText(adjust(m.getTemp()));
			System.out.println(getIntListString());
			System.out.println(getOpListString());
			setStr();
		}
	}

	public static void evaluate() {
		try {
			// Block of code to try
			operate();
		} catch (Exception e1) {
			// Block of code to handle errors
		}
		v.top.setText("");
//		v.down.setText(String.valueOf(getIntListString()));
		v.down.setText(adjust(m.getTemp()));
		m.getDisplayList().clear();
		m.getNumList().clear();
		m.getOpList().clear();
		m.setStr("");
		m.setTemp(0.0d);
	}

	public static String adjust(Double d) {
		String s = String.valueOf(d);
		s = s.indexOf(".") < 0 ? s : s.replaceAll("0*$", "").replaceAll("\\.$", "");
		return s;
	}

	public static void deci() {
		if (checkdeci(v.down.getText()))
			v.down.setText(v.down.getText() + ".");

	}

	public static boolean checkdeci(String str) {
		if (str.equals("Calculator BY Amol "))
			return false;
		else {
			char[] a = str.toCharArray();
			for (int i = 0; i < a.length; i++) {
				if (a[i] == '.') {
					return false;
				}
			}
		}
		return true;

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				try {
					Controller c = new Controller();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
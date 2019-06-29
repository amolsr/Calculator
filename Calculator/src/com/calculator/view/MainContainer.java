package com.calculator.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.calculator.controller.Controller;

public class MainContainer extends KeyAdapter {
	private JFrame frame;
	public JButton mod, root, sqr, cube, inv, ce, c, del, num0, num1, num2, num3, num4, num5, num6, num7, num8, num9,
			sign, deci, div, mul, add, sub, eq;
	public JTextField down, top;
	public Action num0Action, num1Action, num2Action, num3Action, num4Action, num5Action, num6Action, num7Action,
			num8Action, num9Action, divAction, mulAction, addAction, subAction, eqAction, cAction, ceAction, delAction,
			sqrAction, cubeAction, deciAction, invAction, signAction, rootAction;

	/**
	 * Create the application.
	 */
	public MainContainer() {
		frame = new JFrame("Calculator");
		frame.setResizable(false);
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		initialize();

		initializeEvent();

		setFont();

		setDimension();

		addComponent();

		addEvent();

		bindingKey();

		frame.setVisible(true);

	}

	private void bindingKey() {
		// TODO Auto-generated method stub
		num0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0, true),
				"0");
		num0.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_0, 0, true), "0");
		num0.getActionMap().put("0", num0Action);
		num1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0, true),
				"1");
		num1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0, true), "1");
		num1.getActionMap().put("1", num1Action);
		num2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0, true),
				"2");
		num2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0, true), "2");
		num2.getActionMap().put("2", num2Action);
		num3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0, true),
				"3");
		num3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0, true), "3");
		num3.getActionMap().put("3", num3Action);
		num4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0, true),
				"4");
		num4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0, true), "4");
		num4.getActionMap().put("4", num4Action);
		num5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0, true),
				"5");
		num5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0, true), "5");
		num5.getActionMap().put("5", num5Action);
		num6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0, true),
				"6");
		num6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0, true), "6");
		num6.getActionMap().put("6", num6Action);
		num7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0, true),
				"7");
		num7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0, true), "7");
		num7.getActionMap().put("7", num7Action);
		num8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, true),
				"8");
		num8.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0, true), "8");
		num8.getActionMap().put("8", num8Action);
		num9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0, true),
				"9");
		num9.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0, true), "9");
		num9.getActionMap().put("9", num9Action);
		div.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0, true),
				"/");
		div.getActionMap().put("/", divAction);
		mul.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0, true),
				"*");
		mul.getActionMap().put("*", mulAction);
		add.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0, true), "+");
		add.getActionMap().put("+", addAction);
		sub.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0, true),
				"-");
		sub.getActionMap().put("-", subAction);
		del.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0, true),
				"b");
		del.getActionMap().put("b", delAction);
		c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0, true), "c");
		c.getActionMap().put("c", cAction);
		eq.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "e");
		eq.getActionMap().put("e", eqAction);
		deci.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0, true),
				"d");
		deci.getActionMap().put("d", deciAction);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mod = new JButton("%");
		root = new JButton("\u221A");
		sqr = new JButton("x\u00B2");
		cube = new JButton("x\u00B3");
		inv = new JButton("1/x");
		ce = new JButton("CE");
		c = new JButton("C");
		del = new JButton("DEL");
		num0 = new JButton("0");
		num1 = new JButton("1");
		num2 = new JButton("2");
		num3 = new JButton("3");
		num4 = new JButton("4");
		num5 = new JButton("5");
		num7 = new JButton("7");
		num6 = new JButton("6");
		num8 = new JButton("8");
		num9 = new JButton("9");
		sign = new JButton("\u00B1");
		deci = new JButton(".");
		div = new JButton("\u00F7");
		mul = new JButton("X");
		add = new JButton("+");
		sub = new JButton("-");
		eq = new JButton("=");
		down = new JTextField();
		top = new JTextField();
		down.setHorizontalAlignment(SwingConstants.TRAILING);
		down.setEditable(false);
		top.setEditable(false);
		down.setText("Calculator BY Amol ");
		top.setColumns(10);
	}

	public void addComponent() {
		frame.getContentPane().add(mod);
		frame.getContentPane().add(root);
		frame.getContentPane().add(sqr);
		frame.getContentPane().add(cube);
		frame.getContentPane().add(inv);
		frame.getContentPane().add(ce);
		frame.getContentPane().add(c);
		frame.getContentPane().add(del);
		frame.getContentPane().add(num0);
		frame.getContentPane().add(num1);
		frame.getContentPane().add(num2);
		frame.getContentPane().add(num3);
		frame.getContentPane().add(num4);
		frame.getContentPane().add(num5);
		frame.getContentPane().add(num6);
		frame.getContentPane().add(num7);
		frame.getContentPane().add(num8);
		frame.getContentPane().add(num9);
		frame.getContentPane().add(sign);
		frame.getContentPane().add(deci);
		frame.getContentPane().add(div);
		frame.getContentPane().add(mul);
		frame.getContentPane().add(add);
		frame.getContentPane().add(sub);
		frame.getContentPane().add(eq);
		frame.getContentPane().add(down);
		frame.getContentPane().add(top);

	}

	public void setFont() {
		mod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		root.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sqr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cube.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inv.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ce.setFont(new Font("Tahoma", Font.PLAIN, 12));
		c.setFont(new Font("Tahoma", Font.PLAIN, 12));
		del.setFont(new Font("Tahoma", Font.PLAIN, 9));
		num0.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		num9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sign.setFont(new Font("Tahoma", Font.PLAIN, 12));
		deci.setFont(new Font("Tahoma", Font.PLAIN, 12));
		div.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mul.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sub.setFont(new Font("Tahoma", Font.PLAIN, 12));
		eq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		down.setFont(new Font("Tahoma", Font.PLAIN, 21));
	}

	public void setDimension() {
		mod.setBounds(25, 90, 50, 50);
		root.setBounds(25, 150, 50, 50);
		sqr.setBounds(25, 210, 50, 50);
		cube.setBounds(25, 270, 50, 50);
		inv.setBounds(25, 330, 50, 50);
		ce.setBounds(85, 90, 50, 50);
		c.setBounds(145, 90, 50, 50);
		del.setBounds(205, 90, 50, 50);
		num0.setBounds(145, 330, 50, 50);
		num1.setBounds(85, 150, 50, 50);
		num2.setBounds(145, 150, 50, 50);
		num3.setBounds(205, 150, 50, 50);
		num4.setBounds(85, 210, 50, 50);
		num5.setBounds(145, 210, 50, 50);
		num6.setBounds(205, 210, 50, 50);
		num7.setBounds(85, 270, 50, 50);
		num8.setBounds(145, 270, 50, 50);
		num9.setBounds(205, 270, 50, 50);
		sign.setBounds(85, 330, 50, 50);
		deci.setBounds(205, 330, 50, 50);
		div.setBounds(265, 90, 50, 50);
		mul.setBounds(265, 150, 50, 50);
		add.setBounds(265, 210, 50, 50);
		sub.setBounds(265, 270, 50, 50);
		eq.setBounds(265, 330, 50, 50);
		down.setBounds(25, 45, 290, 30);
		top.setBounds(25, 15, 290, 25);
	}

	public void addEvent() {
		num0.setAction(num0Action);
		num1.setAction(num1Action);
		num2.setAction(num2Action);
		num3.setAction(num3Action);
		num4.setAction(num4Action);
		num5.setAction(num5Action);
		num6.setAction(num6Action);
		num7.setAction(num7Action);
		num8.setAction(num8Action);
		num9.setAction(num9Action);
		ce.setAction(ceAction);
		c.setAction(cAction);
		del.setAction(delAction);
		eq.setAction(eqAction);
		div.setAction(divAction);
		mul.setAction(mulAction);
		add.setAction(addAction);
		sub.setAction(subAction);
		sqr.setAction(sqrAction);
		cube.setAction(cubeAction);
		deci.setAction(deciAction);
		sign.setAction(signAction);
		inv.setAction(invAction);
		root.setAction(rootAction);
	}

	@SuppressWarnings("serial")
	public void initializeEvent() {

		num0Action = new AbstractAction("0") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(0);
			}
		};
		num1Action = new AbstractAction("1") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(1);
			}
		};
		num2Action = new AbstractAction("2") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(2);
			}
		};
		num3Action = new AbstractAction("3") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(3);
			}
		};
		num4Action = new AbstractAction("4") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(4);
			}
		};
		num5Action = new AbstractAction("5") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(5);
			}
		};
		num6Action = new AbstractAction("6") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(6);
			}
		};
		num7Action = new AbstractAction("7") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(7);
			}
		};
		num8Action = new AbstractAction("8") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(8);
			}
		};
		num9Action = new AbstractAction("9") {
			public void actionPerformed(ActionEvent e) {
				Controller.numInput(9);
			}
		};
		divAction = new AbstractAction("\u00F7") {
			public void actionPerformed(ActionEvent e) {
				Controller.operatorInput('\u00F7', '/');
			}
		};
		mulAction = new AbstractAction("X") {
			public void actionPerformed(ActionEvent e) {
				Controller.operatorInput('X', 'X');
			}
		};
		addAction = new AbstractAction("+") {
			public void actionPerformed(ActionEvent e) {
				Controller.operatorInput('+', '+');
			}
		};
		subAction = new AbstractAction("-") {
			public void actionPerformed(ActionEvent e) {
				Controller.operatorInput('-', '-');
			}
		};
		ceAction = new AbstractAction("CE") {
			public void actionPerformed(ActionEvent e) {
				Controller.functionKey("ce");
			}
		};
		cAction = new AbstractAction("C") {
			public void actionPerformed(ActionEvent e) {
				Controller.functionKey("c");
			}
		};
		delAction = new AbstractAction("DEL") {
			public void actionPerformed(ActionEvent e) {
				Controller.functionKey("del");
			}
		};
		eqAction = new AbstractAction("=") {
			public void actionPerformed(ActionEvent e) {
				Controller.evaluate();
			}
		};
		sqrAction = new AbstractAction("x\u00B2") {
			public void actionPerformed(ActionEvent e) {
				Controller.powerInput('\u00B2', true);
			}
		};
		cubeAction = new AbstractAction("x\u00B3") {
			public void actionPerformed(ActionEvent e) {
				Controller.powerInput('\u00B3', false);
			}
		};
		deciAction = new AbstractAction(".") {
			public void actionPerformed(ActionEvent e) {
				Controller.deci();
			}
		};
		invAction = new AbstractAction("1/x") {
			public void actionPerformed(ActionEvent e) {
				Controller.inv();
			}
		};
		signAction = new AbstractAction("\u00B1") {
			public void actionPerformed(ActionEvent e) {
				Controller.sign();
			}
		};
		rootAction = new AbstractAction("\u221A") {
			public void actionPerformed(ActionEvent e) {
				Controller.root();
			}
		};

	}
}
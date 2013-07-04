package com.sirma.itt.javacourse.networkingandgui.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates the UI for the calculator and adds functionality to the buttons.
 * 
 * @author gdimitrov
 */
public class Calculator extends JFrame implements ActionListener {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1085577739628334454L;
	private static final String[] BUTTON_CAPTIONS = { "CE", "Bck", "", "", "7", "8", "9", "/", "4",
			"5", "6", "*", "1", "2", "3", "-", "0", ".", "+", "=" };
	private StringBuilder operand;
	private JButton[] buttons;
	private JLabel screen;
	private boolean firstOperand;
	private String expression;
	private Command command;

	/**
	 * Creates a calculator instance and gives it height and width.
	 * 
	 * @param width
	 *            the width of the initial window.
	 * @param height
	 *            the height of the initial window.
	 */
	public Calculator(int width, int height) {
		buttons = new JButton[BUTTON_CAPTIONS.length];
		operand = new StringBuilder("0");
		initUI(width, height);
		firstOperand = true;
		expression = null;
	}

	/**
	 * @param width
	 *            the width of the initial window.
	 * @param height
	 *            the height of the initial window.
	 */
	private void initUI(int width, int height) {

		JPanel buttonsPane = new JPanel();
		buttonsPane.setLayout(new GridLayout(5, 4, 5, 5));
		for (int i = 0; i < BUTTON_CAPTIONS.length; i++) {
			if ("".equals(BUTTON_CAPTIONS[i])) {
				buttonsPane.add(new JLabel(BUTTON_CAPTIONS[i]));
				continue;
			}
			buttons[i] = new JButton(BUTTON_CAPTIONS[i]);
			buttons[i].addActionListener(this);
			buttonsPane.add(buttons[i]);
		}

		JPanel screenPanel = new JPanel(new BorderLayout());
		screen = new JLabel(operand.toString());
		screen.setBackground(Color.white);
		screen.setHorizontalAlignment(JLabel.RIGHT);
		screen.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		screen.setOpaque(true);
		screenPanel.add(screen);

		setTitle("Calculator");
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(screenPanel, BorderLayout.NORTH);
		getContentPane().add(buttonsPane, BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// When an operation is chosen for the first time the calculator takes
		// the operand and stores it to the expression. If another operation was already chosen
		// it acts as a "=" operation and performs the previously chosen operation.
		if ("0".equals(operand.toString())) {
			operand.delete(0, 1);
		}
		if (e.getSource().equals(buttons[0])) {
			operand = new StringBuilder("0");
		} else if (e.getSource().equals(buttons[1])) {
			operand.delete(operand.length() - 1, operand.length());
		} else if (e.getSource().equals(buttons[3])) {
			operand.append("7");
		} else if (e.getSource().equals(buttons[4])) {
			operand.append("7");
		} else if (e.getSource().equals(buttons[5])) {
			operand.append("8");
		} else if (e.getSource().equals(buttons[6])) {
			operand.append("9");
		} else if (e.getSource().equals(buttons[7])) {
			// This is the "/" operation.
			if (firstOperand) {
				firstOperand = false;
				operand.append("/");
				expression = operand.toString();
				command = CommandFactory.createInstance(3);
				operand = new StringBuilder(" ");
			} else {
				executeCommand();
			}
		} else if (e.getSource().equals(buttons[8])) {
			operand.append("4");
		} else if (e.getSource().equals(buttons[9])) {
			operand.append("5");
		} else if (e.getSource().equals(buttons[10])) {
			operand.append("6");
		} else if (e.getSource().equals(buttons[11])) {
			// This is the "*" operation.
			if (firstOperand) {
				firstOperand = false;
				operand.append("*");
				expression = operand.toString();
				command = CommandFactory.createInstance(2);
				operand = new StringBuilder(" ");
			} else {
				executeCommand();
			}
		} else if (e.getSource().equals(buttons[12])) {
			operand.append("1");
		} else if (e.getSource().equals(buttons[13])) {
			operand.append("2");
		} else if (e.getSource().equals(buttons[14])) {
			operand.append("3");
		} else if (e.getSource().equals(buttons[15])) {
			// This is the "-" operation.
			if (firstOperand) {
				firstOperand = false;
				operand.append("-");
				expression = operand.toString();
				command = CommandFactory.createInstance(1);
				operand = new StringBuilder(" ");
			} else {
				executeCommand();
			}
		} else if (e.getSource().equals(buttons[16])) {
			operand.append("0");
		} else if (e.getSource().equals(buttons[17])) {
			operand.append(".");
		} else if (e.getSource().equals(buttons[18])) {
			// This is the "+" operation.
			if (firstOperand) {
				firstOperand = false;
				operand.append("+");
				expression = operand.toString();
				command = CommandFactory.createInstance(0);
				operand = new StringBuilder(" ");
			} else {
				executeCommand();
			}
		} else if (e.getSource().equals(buttons[19])) {
			if (!firstOperand) {
				executeCommand();
			}
		}
		screen.setText(operand.toString());
	}

	/**
	 * Executes the previous command with the second operand.
	 */
	private void executeCommand() {
		expression += operand;
		double execute = command.execute(expression);
		operand = new StringBuilder(Double.toString(execute));
		firstOperand = true;
	}
}

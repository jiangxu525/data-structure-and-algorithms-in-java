package com.xu.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {
	// this main method is used to test the InfixToPostfix
	// eg. (3+4)*5-6 -->3 4 + 5 * 6 -
	public static void main(String[] args) {
		String infixExpression = "(3+4)*5-6";
		List<String> listInfix = toinfixExpressionList(infixExpression);
		List<String> listSuffix = parseSuffixExpressionList(listInfix);
		System.out.println(listSuffix);
	}

	// use List to store infixExpression
	public static List<String> toinfixExpressionList(String s) {
		List<String> list = new ArrayList<>();
		int i = 0;
		String str;
		char ch;
		do {
			// ch -> non-number
			if ((ch = s.charAt(i)) < 48 || (ch = s.charAt(i)) > 57) {
				list.add("" + ch);
				i++;
			} else {
				// ch -> number
				str = "";
				while (i < s.length() && (ch = s.charAt(i)) >= 48 && (ch = s.charAt(i)) <= 57) {
					str += ch;
					i++;
				}
				list.add(str);
			}
		} while (i < s.length());
		return list;
	}

	// convert infix to postfix expression
	public static List<String> parseSuffixExpressionList(List<String> list) {
		Stack<String> operStack = new Stack<String>();
		List<String> listRes = new ArrayList<String>();

		for (String s : list) {
			// s: number
			if (s.matches("\\d+")) {
				listRes.add(s);
			} else if (s.equals("(")) {
				operStack.push(s);
			} else if (s.equals(")")) {
				while (!operStack.peek().equals("(")) {
					listRes.add(operStack.pop());
				}
				operStack.pop(); // pop out the "("
			} else {
				while (operStack.size() != 0 && Operation.getValue(operStack.peek()) >= Operation.getValue(s)) {
					listRes.add(operStack.pop());
				}
				operStack.push(s);
			}
		}
		while (operStack.size() != 0) {
			listRes.add(operStack.pop());
		}
		return listRes;
	}
}

class Operation {
	private static final int ADD = 1;
	private static final int SUB = 1;
	private static final int MUL = 2;
	private static final int DIV = 2;

	// return the priority of different operations
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		case "(":
			break;
		default:
			System.out.println("Wrong input.");
			break;
		}
		return result;
	}
}

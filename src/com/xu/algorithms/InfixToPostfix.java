package com.xu.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: InfixToPostfix
 * @Description: example for InfixToPostfix
 * @author xu
 * @date 2020-03-07
 */
public class InfixToPostfix {
	/**
	 * @Title: main
	 * @Description: this main method is used to test the InfixToPostfix, eg.
	 *               (3+4)*5-6 -->3 4 + 5 * 6 -
	 * @param args
	 * @author author
	 * @date 2020-06-07 10:59:24
	 */

	public static void main(String[] args) {
		String infixExpression = "(3+4)*5-6";
		List<String> listInfix = toinfixExpressionList(infixExpression);
		List<String> listSuffix = parseSuffixExpressionList(listInfix);
		System.out.println(listSuffix);
	}

	/**
	 * 
	 * @Title: toinfixExpressionList
	 * @Description: use List to store infixExpression
	 * @param s
	 * @return the list that contains the infixExpression
	 * @author author
	 * @date 2020-06-07 10:59:43
	 */
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

	/**
	 * 
	 * @Title: parseSuffixExpressionList
	 * @Description: convert infix to postfix expression
	 * @param list
	 * @return the postfix expression
	 * @author xu
	 * @date 2020-03-07
	 */
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

/**
 * 
 * @ClassName: Operation
 * @Description: store the operation constants
 * @author Xu
 * @date 2020-06-07 11:01:38
 */
class Operation {
	private static final int ADD = 1;
	private static final int SUB = 1;
	private static final int MUL = 2;
	private static final int DIV = 2;

	/**
	 * 
	 * @Title: getValue
	 * @Description: calculate the priority of different operations
	 * @param operation
	 * @return the priority of different operations
	 * @author Xu
	 * @date 2020-06-07 11:06:40
	 */
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

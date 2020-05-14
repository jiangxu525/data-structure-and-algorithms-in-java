package com.xu.datastructure;

import java.util.Scanner;

public class HashTableDemo {

	public static void main(String[] args) {
		HashTab hashTab = new HashTab(7);

		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("add: add a new employee");
			System.out.println("list: show all employees");
			System.out.println("exit: exit the program");
			System.out.println("find: find employee by id");
			key = scanner.next();

			switch (key) {
			case "add":
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("Enter name");
				String name = scanner.next();
				Employee emp = new Employee(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.print("Please enter the employee id: ");
				int findId = scanner.nextInt();
				hashTab.findEmployeeById(findId);
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}
		}
	}

}

class HashTab {
	private EmployeeLinkedList[] employeeLinkedListArray;
	private int size;

	public HashTab(int size) {
		this.size = size;
		employeeLinkedListArray = new EmployeeLinkedList[size];
		for (int i = 0; i < size; i++) {
			employeeLinkedListArray[i] = new EmployeeLinkedList();
		}
	}

	public void add(Employee emp) {
		int empLinkedListNo = hashFun(emp.id);
		employeeLinkedListArray[empLinkedListNo].add(emp);
	}

	public void list() {
		for (int i = 0; i < employeeLinkedListArray.length; i++) {
			System.out.print("No" + (i + 1) + ": ");
			employeeLinkedListArray[i].list();
		}
	}

	public void findEmployeeById(int id) {

		Employee emp = employeeLinkedListArray[hashFun(id)].find(id);
		if (emp != null) {
			System.out.println(emp.id + "   " + emp.name);
		} else {
			System.out.println("no records");
		}

	}

	// discrete function using modulus
	public int hashFun(int id) {
		return id % size;
	}
}

//create EmployeeLinkedList
class EmployeeLinkedList {
	private Employee head;

	public void add(Employee emp) {
		if (head == null) {
			head = emp;
			return;
		}
		Employee currEmp = head;
		while (true) {
			if (currEmp.next == null) {
				break;
			}
			currEmp = currEmp.next;
		}
		currEmp.next = emp;
	}

	public void list() {
		if (head == null) {
			System.out.println("Empty!");
			return;
		}

		Employee curEmp = head;
		while (true) {
			System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}

	}

	public Employee find(int id) {
		if (head == null) {
			System.out.println("no found!");
			return null;
		}
		Employee curEmp = head;
		while (true) {
			if (curEmp.id == id) {
				return curEmp;
			}
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		System.out.println("No found !");
		return null;
	}

}

class Employee {

	public int id;
	public String name;
	public Employee next;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}

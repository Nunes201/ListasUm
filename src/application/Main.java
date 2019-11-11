package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<Employee>();
		
		System.out.println("How many employees will be registered?");
		int e = sc.nextInt();
		
		for (int i = 1; i <= e; i++) {
			System.out.println();
			System.out.println("Employee #"+i+":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.println("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Salary:");
			Double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}
		System.out.println();
		System.out.println("Enter the employee id that will have salary increase :");
		int id = sc.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.println("Enter the percentage:");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		System.out.println();
		for (Employee obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

}

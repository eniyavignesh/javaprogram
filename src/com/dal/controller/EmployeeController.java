package com.dal.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dal.model.Employee;

public class EmployeeController implements EmployeeInterface {
	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();
	
	public void addEmployee()
	{		
		emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Eid");
		int eid= sc.nextInt();
		emp.setEid(eid);
		
		System.out.println("Enter Ename");
		String ename= sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		System.out.println("Employee Added Succesfully");
	}
	
	public void viewEmployee() {
		//System.out.println(emp);
		Iterator i = emplist.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}

	@Override
	public void serializeEmp() {
	
		try {
			FileOutputStream fout = new FileOutputStream("myemprec.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(emplist);
			oos.close();
			fout.close();
			System.out.println("Serialized..");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void deserializeEmp() {
		try {
			FileInputStream fin = new FileInputStream("myemprec.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			List<Employee> emlist = (List<Employee>) oin.readObject();

			Iterator<Employee> it = emlist.iterator();
			while (it.hasNext()) {

				System.out.println(it.next());
			}
			oin.close();
			fin.close();

		} catch (ClassNotFoundException | IOException e) {
		
			e.printStackTrace();
		}
		
	}

	@Override
	public void sortByEid() {
		Collections.sort(emplist);
		System.out.println("After sorting by EID");
		System.out.println(emplist);
	}

	@Override
	public void sortByEname() {
		Collections.sort(emplist, Employee.NameComparator);
		System.out.println(emplist);
		
	}
}

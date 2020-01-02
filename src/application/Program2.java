package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1 - department Find By Id ====");
		Department dep = depDao.findById(2);
		System.out.println(dep);
		
		System.out.println("\n==== TEST 2 - department Find All ====");
		List<Department> list = new ArrayList<>();
		list = depDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3 - department Insert ====");
		Department newDep = new Department(null, "Music");
		depDao.insert(newDep);
		System.out.println("Done! New ID inserted: " + newDep.getId());
		
		System.out.println("\n==== TEST 4 - department Update ====");
		dep = depDao.findById(1);
		dep.setName("Make-Up");
		depDao.update(dep);
		System.out.println("Registry updated sucessfully!");
		
		System.out.println("\n==== TEST 4 - department Delete ====");
		System.out.print("Inform the Id you want to delete: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete sucessfully!");
		
		sc.close();
	}

}

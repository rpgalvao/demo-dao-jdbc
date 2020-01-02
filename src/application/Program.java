package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1 - seller Find By Id ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2 - seller Find By Department ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3 - seller Find All ====");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 4 - seller Insert ====");
		Seller newSeller = new Seller(null, "Greg Olson", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Done! New ID inserted: " + newSeller.getId());
		
		System.out.println("\n==== TEST 5 - seller Update ====");
		seller = sellerDao.findById(1);
		seller.setName("Diane Kruger");
		sellerDao.update(seller);
		System.out.println("Updated registry");
	}
}

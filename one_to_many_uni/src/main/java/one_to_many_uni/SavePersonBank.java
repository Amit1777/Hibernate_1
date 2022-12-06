package one_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonBank {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("pawar");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		
		List<BankAccount> bnk=new ArrayList();
		
		Person person=new Person();
		person.setName("milind");
		person.setCno(35342922);
		person.setAddress("mumbai");
		
		BankAccount bankAccount=new BankAccount();
		bankAccount.setAccount_no(123456);
		bankAccount.setBankname("bank of india");
		bankAccount.setBranch("panvel");
		
		
		BankAccount bankAccount1=new BankAccount();
		bankAccount1.setAccount_no(789100);
		bankAccount1.setBankname("SBI");
		bankAccount1.setBranch("khanda");
		
		BankAccount bankAccount2=new BankAccount();
		bankAccount2.setAccount_no(112131);
		bankAccount2.setBankname("HDFC");
		bankAccount2.setBranch("colony");
		
		
		bnk.add(bankAccount);
		bnk.add(bankAccount1);
		bnk.add(bankAccount2);
		person.setBankAccounts(bnk);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bankAccount);
		entityManager.persist(bankAccount1);
		entityManager.persist(bankAccount2);
		entityTransaction.commit();
		
		
		
		
		
		
		
	}
}

package com.xiaofu.entities;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Test {
	
	
	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		// 1. 创建EntityManagerFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");

		// 2. 创建EntityManager
		EntityManager entityManager = factory.createEntityManager();

		//add(entityManager);
		//search(entityManager, "tom");
		//delete(entityManager);
		change(entityManager);

		// 6. 关闭EntityManager
		entityManager.close();

		// 7. 关闭EntityManagerFactory
		factory.close();
	}




	public static void add(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		// 4. 持久化操作
		/*User user=new User();
		user.setUid("3");
		user.setUname("三三");*/
		
		Author author=new Author();
		author.setId(1);
		author.setName("一一");

		// 添加user到数据库，相当于hibernate的save();
		//entityManager.persist(user);
		entityManager.persist(author);
		
		// 5. 提交事务
		transaction.commit();

	}

	public static void search(EntityManager entityManager, String name) {

		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		/*List<User> list = entityManager.createQuery("SELECT u FROM User u WHERE u.name LIKE ?1")
				.setParameter(1, name).getResultList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
*/
		List<User> list2 = entityManager.createQuery("SELECT a FROM Author a WHERE a.name LIKE ?1")
				.setParameter(1, name).getResultList();
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).toString());
		}
		
	}

	private static void delete(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		//User list =  entityManager.createQuery(" DELETE FROM user WHERE id= ?1 ",User.class).setParameter(1, 5).getSingleResult();
		
		Author list2 =  entityManager.createQuery(" DELETE FROM author WHERE id= ?1 ",Author.class).setParameter(1, 5).getSingleResult();
		
		// 5. 提交事务
		transaction.commit();
	}
	
	private static void change(EntityManager entityManager) {
		// 3.开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
				
		//User list =  entityManager.createQuery(" UPDATE User SET Uname= ?1 WHERE id= ?3 ",User.class).setParameter(1, "一一").getSingleResult();
		
		Author list2 =  entityManager.createQuery(" UPDATE Author SET name= ?1 WHERE id= ?3 ",Author.class).setParameter(1, "一一").getSingleResult();
		
		// 5. 提交事务
		transaction.commit();
	}
	
}








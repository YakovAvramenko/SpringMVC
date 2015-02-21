package com.mkyong.common.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.common.model.UserAccount;

public class UserAccountDaoTest {
		private SessionFactory factory;
		private ApplicationContext ctx;

		@Before
		public void init() {
			ctx = new ClassPathXmlApplicationContext("persistence.xml");
			factory = ctx.getBean(SessionFactory.class);
		}

		@Test
		public void testList() {
			Session session = factory.openSession();
			try {
				List list = session.createCriteria(UserAccount.class).list();
				System.out.println(list);
			} catch (HibernateException ex) {
				System.out.print(ex);
			} finally {
				session.close();
			}
		}

//		@Test
//		public void testSaveCourse() {
//			Session session = factory.openSession();
//			Transaction tx = null;
//			try {
//				tx = session.beginTransaction();
//				Student au = new Student();
//				au.setName("alone name");
//				au.setStudent_card("as-z-2122");
//
//				Course crs = new Course();
//				crs.setDuration(12);
//				crs.setTitle("asdasd");
//				crs.setStudents(Arrays.asList(au));
//
//				au.setBestCourse(crs);
//
//				Object id = session.save(crs);
//				tx.commit();
//				System.out.println("new id = " + id);
//			} catch (HibernateException ex) {
//				if (tx != null)
//					tx.rollback();
//				System.out.println(ex);
//			} finally {
//				session.close();
//			}
//		}

}

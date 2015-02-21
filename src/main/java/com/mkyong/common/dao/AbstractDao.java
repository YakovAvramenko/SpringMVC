package com.mkyong.common.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.common.entity.AbstractEntity;

public class AbstractDao<T extends AbstractEntity> implements GenericDao<T> {
	@Autowired
	private SessionFactory factory;
	private Class<T> clazz;

	// @Transactional(propagation = Propagation.REQUIRED)
	public Long save(T entity) {
		Session session = factory.openSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			System.out.println("saving");
			session.save(entity);
			session.getTransaction().commit();
			System.out.println("commited");
		} catch (Exception e) {
			if (tr != null)
				tr.rollback();
			System.out.println("rollback, e = " + e);
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return entity.getId();
	}

	// @Transactional(propagation = Propagation.REQUIRED, rollbackFor =
	// Exception.class)
	public T update(T object) {
		Session session = factory.openSession();
		Transaction tr = null;
		try {
			tr = session.beginTransaction();
			session.saveOrUpdate(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (tr != null)
				tr.rollback();
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return object;
	}

	// @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = factory.openSession();
		try {
			return session.createCriteria(clazz).list();
		} finally {
			session.close();
		}
	}

	// @Transactional(propagation = Propagation.NEVER, readOnly = true)
	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		Session session = factory.openSession();
		try {
			return (T) session.get(clazz, id);
		} finally {
			session.close();
		}
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

}

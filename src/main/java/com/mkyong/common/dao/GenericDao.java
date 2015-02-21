package com.mkyong.common.dao;

import java.util.List;

import com.mkyong.common.entity.AbstractEntity;

public interface GenericDao<T extends AbstractEntity> {
	Long save(T object);

	T update(T object);

	List<T> findAll();

	T findById(Long id);
}

package com.tornado.ecommerce.business.service.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.tornado.ecommerce.common.exception.EcommerceException;
import com.tornado.ecommerce.model.entity.base.BaseEntity;
import com.tornado.ecommerce.model.repository.generic.GenericRepository;

public abstract class GenericService<T extends BaseEntity, ID extends Serializable> {
	
	
	private GenericRepository<T,ID> genericRepository;
	
	public GenericService(GenericRepository<T,ID> genericRepository) {
		this.genericRepository = genericRepository;
	}

	public List<T> findAll() {
		return genericRepository.findAll();
	}

	public List<T> findAll(Sort sort) {
		if(sort==null)
			throw new EcommerceException("");
		return genericRepository.findAll(sort);
	}

	public List<T> findAll(Iterable<ID> ids){
		if(ids==null)
			throw new EcommerceException("");
		return genericRepository.findAll(ids);
	}


	public T findOne(ID id) {
		if(id==null)
			throw new EcommerceException("");
		T t = genericRepository.findOne(id);
		if(t==null)
			throw new EcommerceException("");
		return t; 
	}

	public T delete(ID id){
		if(id==null)
			throw new EcommerceException("");
		T deleteEntity = (T) genericRepository.findOne(id);
		if(deleteEntity==null)
			throw new EcommerceException("");
		genericRepository.delete(deleteEntity);
		return deleteEntity;
	}
	
	public Long getCountOfRow() {
		return genericRepository.count();
	}
	
	public T save(T entity) {
		return genericRepository.save(entity);
	}

	public T update(T entity) {
		return genericRepository.save(entity);
	}
}

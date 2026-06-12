package com.sedena.app.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.sedena.app.daos.IMicroserviceDAO;
import com.sedena.app.entities.User;

@Service
public class ServiceImpl implements IService {

	//@Autowired inicializa el DAO en ejecución
	//se crea el constructor reemplazando el autowired
	public ServiceImpl(IMicroserviceDAO dao) {
		this.dao=dao;
	}
	private IMicroserviceDAO dao;
	
	@Override
	public boolean insert(User u) {
		if(u.getId()==0) {
			User result=dao.save(u);
			return result!=null;
		}
		return false;
	}

	@Override
	public User selectByEmail(String email) {
		return dao.searchByEmail(email).orElseThrow();
	}

	@Override
	public boolean updateById(User u) {
		if(dao.existsById(u.getId())) {
			dao.save(u);
			return true;
		}
		throw new NoSuchElementException("usuario "+u.getId()+" no existe");
	}

	@Override
	public List<User> selectAll() {
		return (List<User>)dao.findAll();
	}

	@Override
	public boolean deleteById(long id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		throw new NoSuchElementException("El usuario "+id+" no existe");
	}

	
}

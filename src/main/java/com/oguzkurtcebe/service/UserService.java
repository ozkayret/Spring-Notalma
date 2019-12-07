package com.oguzkurtcebe.service;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguzkurtcebe.dao.UserDAO;
import com.oguzkurtcebe.entity.Note;
import com.oguzkurtcebe.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private MailService mailService;

	@Autowired
	private UserDAO userDAO;

	public Long insert(User user) {
		String uuid = UUID.randomUUID().toString();
		user.setValue_key(uuid);

		if (userDAO.insert(user) > 0) {
			mailService.registerMail(user.getEmail(), user.getValue_key());
		}
		return 1l;
	}

	public void update(User user) {
		userDAO.update(user);
	}

	public User getFindByUsernameAndPass(String username, String pass) {
		return userDAO.getFindByUsernameAndPass(username, pass);

	}

	public User getFindByUsername(String username) {
		return userDAO.getFindByUsername(username);
	}

	public boolean getFindByKey(String key) {
		User user=userDAO.getFindByKey(key);
		if(user!=null) {
			user.setActive(true);
			update(user);
			return true;
		}else
			return false;
	
	}

}

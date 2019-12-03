package com.oguzkurtcebe.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oguzkurtcebe.entity.Note;

@Repository
public class NoteDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public long insert(Note note) {
		return (long) sessionFactory.getCurrentSession().save(note);
	}

	public void update(Note note) {
		sessionFactory.getCurrentSession().update(note);
	}

	public void persist(Note note) {
		sessionFactory.getCurrentSession().persist(note);
	}

	public void delete(Note note) {
		sessionFactory.getCurrentSession().delete(note);
	}
//Read
	
	public Note getFindById(Long user_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE user_id=:user_id")
				.setLong("user_id", user_id);

		return (Note) query.getSingleResult();
	}
	
	public ArrayList<Note> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Note");
		return (ArrayList<Note>) query.getResultList();

	}

	public ArrayList<Note> getAll(Long user_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Note WHERE user_id=:user_id")
				.setLong("user_id", user_id);

		return (ArrayList<Note>) query.getResultList();
	}

}

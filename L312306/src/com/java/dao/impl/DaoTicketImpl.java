package com.java.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.java.dao.idao.ITicketDao;

import hibernate.Ticket;
@SuppressWarnings("unchecked")
@Repository("ticketDao")
public class DaoTicketImpl implements ITicketDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Ticket t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);

	}

	@Override
	public void delete(Ticket t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);

	}

	@Override
	public void update(Ticket newT) throws Exception {
		sessionFactory.getCurrentSession().update(newT);

	}

	@Override
	public List<Ticket> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("From Ticket").list();
	}

	@Override
	public Ticket findById(Integer k) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Ticket entity = (Ticket) session.get(Ticket.class, k);
		session.clear();
		return entity;
	}

	@Override
	public List<Ticket> findByProperty(String propName, Object propVal) throws Exception{
		Session session = sessionFactory.openSession();
		List<Ticket> ticketList = session.createQuery("from Ticket d where d." + propName + "=?")
				.setParameter(0, propVal)
				.list();
		session.close();
		return ticketList;
	}

}

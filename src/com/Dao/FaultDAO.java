package com.Dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Fault
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.Dao.Fault
 * @author MyEclipse Persistence Tools
 */

public class FaultDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(FaultDAO.class);
	// property constants
	public static final String DID = "did";
	public static final String CONTENT = "content";
	public static final String SOLVED = "solved";

	public void save(Fault transientInstance) {
		log.debug("saving Fault instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Fault persistentInstance) {
		log.debug("deleting Fault instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Fault findById(java.lang.Integer id) {
		log.debug("getting Fault instance with id: " + id);
		try {
			Fault instance = (Fault) getSession().get("com.Dao.Fault", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Fault instance) {
		log.debug("finding Fault instance by example");
		try {
			List results = getSession().createCriteria("com.Dao.Fault").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Fault instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Fault as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDid(Object did) {
		return findByProperty(DID, did);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findBySolved(Object solved) {
		return findByProperty(SOLVED, solved);
	}

	public List findAll() {
		log.debug("finding all Fault instances");
		try {
			String queryString = "from Fault";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Fault merge(Fault detachedInstance) {
		log.debug("merging Fault instance");
		try {
			Fault result = (Fault) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Fault instance) {
		log.debug("attaching dirty Fault instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Fault instance) {
		log.debug("attaching clean Fault instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
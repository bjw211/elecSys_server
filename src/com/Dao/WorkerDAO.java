package com.Dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Worker entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.Dao.Worker
 * @author MyEclipse Persistence Tools
 */

public class WorkerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(WorkerDAO.class);
	// property constants
	public static final String WNAME = "wname";
	public static final String PWD = "pwd";
	public static final String AGE = "age";
	public static final String ADDRESS = "address";
	public static final String TYPE = "type";
	public static final String WTIME = "wtime";

	public void save(Worker transientInstance) {
		log.debug("saving Worker instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Worker persistentInstance) {
		log.debug("deleting Worker instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Worker findById(java.lang.String id) {
		log.debug("getting Worker instance with id: " + id);
		try {
			Worker instance = (Worker) getSession().get("com.Dao.Worker", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Worker instance) {
		log.debug("finding Worker instance by example");
		try {
			List results = getSession().createCriteria("com.Dao.Worker").add(
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
		log.debug("finding Worker instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Worker as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWname(Object wname) {
		return findByProperty(WNAME, wname);
	}

	public List findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByWtime(Object wtime) {
		return findByProperty(WTIME, wtime);
	}

	public List findAll() {
		log.debug("finding all Worker instances");
		try {
			String queryString = "from Worker";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Worker merge(Worker detachedInstance) {
		log.debug("merging Worker instance");
		try {
			Worker result = (Worker) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Worker instance) {
		log.debug("attaching dirty Worker instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Worker instance) {
		log.debug("attaching clean Worker instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
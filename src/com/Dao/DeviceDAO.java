package com.Dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Device entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.Dao.Device
 * @author MyEclipse Persistence Tools
 */

public class DeviceDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DeviceDAO.class);
	// property constants
	public static final String DNAME = "dname";
	public static final String TYPE = "type";
	public static final String ADDRESS = "address";
	public static final String QR = "qr";
	public static final String CHECK_ITEM = "checkItem";

	public void save(Device transientInstance) {
		log.debug("saving Device instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Device persistentInstance) {
		log.debug("deleting Device instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Device findById(java.lang.String id) {
		log.debug("getting Device instance with id: " + id);
		try {
			Device instance = (Device) getSession().get("com.Dao.Device", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Device instance) {
		log.debug("finding Device instance by example");
		try {
			List results = getSession().createCriteria("com.Dao.Device").add(
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
		log.debug("finding Device instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Device as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDname(Object dname) {
		return findByProperty(DNAME, dname);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByQr(Object qr) {
		return findByProperty(QR, qr);
	}

	public List findByCheckItem(Object checkItem) {
		return findByProperty(CHECK_ITEM, checkItem);
	}

	public List findAll() {
		log.debug("finding all Device instances");
		try {
			String queryString = "from Device";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Device merge(Device detachedInstance) {
		log.debug("merging Device instance");
		try {
			Device result = (Device) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Device instance) {
		log.debug("attaching dirty Device instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Device instance) {
		log.debug("attaching clean Device instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
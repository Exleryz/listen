package com.listen.dao.base.impl;

import com.listen.dao.base.BaseDao;
import com.listen.utils.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


/**
 * FileName BaseDaoImpl
 * Created by Exler
 * Time 2018-08-30 10:43
 * Description: 持久层通用实现
 */

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    // 代表的是某个实体的类型
    private Class<T> entityClass;

    // 注入sessionFactory 根据类型注入spring工厂中的 对象
    @Resource
    public void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    // 在父类的构造方法中动态获得entityClass
    public BaseDaoImpl() {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获得父类上声明的泛型数组
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        entityClass = (Class<T>) actualTypeArguments[0];
    }

    @Override
    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public T findById(Serializable id) {
        return this.getHibernateTemplate().get(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        String hql = "from " + entityClass.getSimpleName();
        return (List<T>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public void executeUpdate(String queryName, Object... objects) {
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery(queryName);
        // 为hql语句中的?赋值
        int i = 0;
        for (Object object :
                objects) {
            query.setParameter(i++, object);
        }
        // 执行更新
        query.executeUpdate();
    }

    /**
     * 通用分页查询方法
     *
     * @param pageBean
     */
    @Override
    public void pageQuery(PageBean pageBean) {
        int currentPage = pageBean.getCurrentPage();
        int pageSize = pageBean.getPageSize();
        DetachedCriteria dc = pageBean.getDc();
        // 查询total 总数据量
        dc.setProjection(Projections.rowCount());   // 指定hibernate框架发出sql的形式    select count(*) from bc_staff;
        List<Long> countList = (List<Long>) getHibernateTemplate().findByCriteria(dc);
        Long count = countList.get(0);
        pageBean.setTotalCount(count.intValue());
        // 查询rows 当前页需要展示的数据集合
        dc.setProjection(null);    // select * from bc_staff;
        int firstResult = (currentPage - 1) * pageSize;
        int maxResults = pageSize;
        List rows = getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
        pageBean.setList(rows);
    }
}

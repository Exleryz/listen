package com.listen.dao.base;

import com.listen.utils.PageBean;

import java.io.Serializable;
import java.util.List;

/**
 * 持久层通用接口
 *
 * @param <T>
 */
public interface BaseDao<T> {

    void save(T entity);

    void delete(T entity);

    void update(T entity);

    void saveOrUpdate(T entity);

    T findById(Serializable id);

    List<T> findAll();

    void executeUpdate(String queryName, Object... objects);

    void pageQuery(PageBean pageBean);
}

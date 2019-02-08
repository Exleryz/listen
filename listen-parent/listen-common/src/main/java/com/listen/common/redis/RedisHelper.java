package com.listen.common.redis;

/**
 * redis缓存处理类
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.*;

public class RedisHelper {

    //redis数据库连接池
    private static Dictionary<Integer, JedisPool> pools = new Hashtable();

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("redis");
        if (bundle == null) {
            throw new IllegalArgumentException(
                    "[redis.properties] is not found!");
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.valueOf(bundle
                .getString("redis.pool.maxActive")));
        config.setMaxIdle(Integer.valueOf(bundle
                .getString("redis.pool.maxIdle")));
        config.setTestOnBorrow(Boolean.valueOf(bundle
                .getString("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(bundle
                .getString("redis.pool.testOnReturn")));

        //循环创建16个redis数据库连接池,存放在字典里面
        for (int i = 0; i < 16; i++) {
            JedisPool item = new JedisPool(config, bundle.getString("redis.ip"),
                    Integer.valueOf(bundle.getString("redis.port")), 0,
                    bundle.getString("redis.password"), i);
            pools.put(i, item);
        }
    }

    /**
     * 直接返回redispool 方便灵活操作
     * @param db 数据库序号
     */
    public static JedisPool getRedisPool(Integer db) {
        return pools.get(db);
    }

    /**
     * 设置数据
     * @param key     //key
     * @param value   //值
     * @param timeOut //过期时间 秒
     * @param db      //数据库序号
     */
    public static void set(String key, String value, Integer timeOut, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        jredis.set(key, value);
        if (timeOut > 0) {
            jredis.expire(key, timeOut);
        }
        jredis.close();
    }

    /**
     *  获得hash型key某个字段的值
     * @param key     //key
     * @param field   //hash字段
     * @param db      //数据库序号
     * */
    public static String getHashField(String key, String field, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        String result = jredis.hget(key, field);
        jredis.close();
        return result;
    }

    /**
     * 根据hashid获取Map 获得hash型key某个字段的值
     * @param hashId  //key键
     * @param db      //数据库序号
     * */
    public static Map<String, String> getHashValues(String hashId, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        Map<String, String> result = jredis.hgetAll(hashId);
        jredis.close();
        return result;
    }

    /**
     * 设置数据
     * @param key     //key
     * @param value   //值
     * @param field   //hash字段
     * @param db      //数据库序号
     */
    public static void SetHashField(String key, String field, String value, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        jredis.hset(key, field, value);
        jredis.close();
    }

    /**
     * 获取数据
     * @param key     //key
     * @param db      //数据库序号
     */
    public static String get(String key, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        String result = jredis.get(key);
        jredis.close();
        return result;
    }

    /**
     * 删除数据
     * @param key     //key
     * @param db      //数据库序号
     */
    public static void del(String key, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        Long result = jredis.del(key);
        jredis.close();
    }

    /**
     * 更新过期时间
     * @param key       // key
     * @param timeOut       // 过期时间
     * @param db        // 数据库序号
     */
    public static void expire(String key, Integer timeOut,Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        jredis.expire(key, timeOut);
        jredis.close();
    }

    /**
     * 队列插入数据
     * @param key     //键
     * @param value   //值
     * @param db      //数据库序号
     */
    public static void lpush(String key, String value, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        jredis.lpush(key, value);
        jredis.close();
    }

    /**
     * 队列取出数据
     * @param key     //键
     * @param db      //数据库序号
     */
    public static String lpop(String key, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        String result = jredis.lpop(key);
        jredis.close();
        return result;
    }

    /**
     * hash 获取键字段
     * @param key     //键
     * @param field   //hash字段
     * @param db      //数据库序号
     */
    public static String hget(String key, String field, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        String result = jredis.hget(key, field);
        jredis.close();
        return result;
    }

    /**
     * hash 删除键字段
     * @param key     //键
     * @param field   //hash字段
     * @param db      //数据库序号
     *
     */
    public static void hdel(String key, String field, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        jredis.hdel(key, field);
        jredis.close();
    }

    /**
     * 获取key下所有的值
     * @param key     //键
     * @param db      //数据库序号
     * @return list
     */
    public static List<String> llist(String key, Integer db) {
        JedisPool poolItem = pools.get(db);
        Jedis jredis = poolItem.getResource();
        List<String> result = jredis.lrange(key, 0, -1);
        jredis.close();
        return result;
    }
}

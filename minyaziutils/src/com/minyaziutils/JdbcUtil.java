package com.minyaziutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC工具类<br>
 * 
 * @author minyazi
 */
public class JdbcUtil {
	
	private static DataSource ds;
	private static QueryRunner qr;
	private static QueryRunner qr_conn;
	private static String ds_name = "testdb"; // 数据源名称
	
	/**
	 * 初始化数据库连接池<br>
	 */
	public static void init() {
		ds = new ComboPooledDataSource(ds_name);
		qr = new QueryRunner(ds);
		qr_conn = new QueryRunner();
	}
	
	/**
	 * 获取数据源<br>
	 * 
	 * @return 返回数据源。
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * 获取数据库连接<br>
	 * 
	 * @return 返回数据库连接。
	 */
	public static synchronized Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("获取数据库连接出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param sql SQL语句
	 * @return 返回查询到的数据集。
	 */
	public static List<Map<String, Object>> queryToMap(String sql) {
		try {
			List<Map<String, Object>> result = qr.query(sql, new MapListHandler());
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
			}
			return result;
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("查询数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询到的数据集。
	 */
	public static List<Map<String, Object>> queryToMap(String sql, Object... params) {
		try {
			List<Map<String, Object>> result = qr.query(sql, new MapListHandler(), params);
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
			}
			return result;
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("查询数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param conn 数据库连接
	 * @param sql SQL语句
	 * @return 返回查询到的数据集。
	 */
	public static List<Map<String, Object>> queryToMap(Connection conn, String sql) {
		try {
			List<Map<String, Object>> result = qr_conn.query(conn, sql, new MapListHandler());
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
			}
			return result;
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("查询数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param conn 数据库连接
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询到的数据集。
	 */
	public static List<Map<String, Object>> queryToMap(Connection conn, String sql, Object... params) {
		try {
			List<Map<String, Object>> result = qr_conn.query(conn, sql, new MapListHandler(), params);
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
			}
			return result;
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("查询数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param c 类型参数
	 * @param sql SQL语句
	 * @return 返回查询到的数据集。
	 */
	public static <T> List<T> queryToBean(Class<T> c, String sql) {
		try {
			List<T> result = qr.query(sql, new BeanListHandler<T>(c));
			if (result == null) {
				result = new ArrayList<T>();
			}
			return result;
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("查询数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param c 类型参数
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询到的数据集。
	 */
	public static <T> List<T> queryToBean(Class<T> c, String sql, Object... params) {
		try {
			List<T> result = qr.query(sql, new BeanListHandler<T>(c), params);
			if (result == null) {
				result = new ArrayList<T>();
			}
			return result;
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("查询数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param c 类型参数
	 * @param conn 数据库连接
	 * @param sql SQL语句
	 * @return 返回查询到的数据集。
	 */
	public static <T> List<T> queryToBean(Class<T> c, Connection conn, String sql) {
		try {
			List<T> result = qr_conn.query(conn, sql, new BeanListHandler<T>(c));
			if (result == null) {
				result = new ArrayList<T>();
			}
			return result;
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("查询数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 查询数据<br>
	 * 
	 * @param <T> 类型参数
	 * @param c 类型参数
	 * @param conn 数据库连接
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回查询到的数据集。
	 */
	public static <T> List<T> queryToBean(Class<T> c, Connection conn, String sql, Object... params) {
		try {
			List<T> result = qr_conn.query(conn, sql, new BeanListHandler<T>(c), params);
			if (result == null) {
				result = new ArrayList<T>();
			}
			return result;
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("查询数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 更新数据<br>
	 * 
	 * @param sql SQL语句
	 * @return 返回更新的结果。
	 */
	public static int update(String sql) {
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("更新数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
		
	}
	
	/**
	 * 更新数据<br>
	 * 
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回更新的结果。
	 */
	public static int update(String sql, Object... params) {
		try {
			return qr.update(sql, params);
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("更新数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 更新数据<br>
	 * 
	 * @param conn 数据库连接
	 * @param sql SQL语句
	 * @return 返回更新的结果。
	 */
	public static int update(Connection conn, String sql) {
		try {
			return qr_conn.update(conn, sql);
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("更新数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
	/**
	 * 更新数据<br>
	 * 
	 * @param conn 数据库连接
	 * @param sql SQL语句
	 * @param params 参数集
	 * @return 返回更新的结果。
	 */
	public static int update(Connection conn, String sql, Object... params) {
		try {
			return qr_conn.update(conn, sql, params);
		} catch (SQLException e) {
			PlatformException pe = new PlatformException("更新数据出错：" + e.getMessage(), e);
			LogUtil.exception(pe);
			throw pe;
		}
	}
	
}

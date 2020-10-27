package com.hikari.confg.util;

import java.sql.Connection;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class DataSourceUtil {
	static DataSourceStore ds;
	public DataSourceUtil() {
		ds = new DataSourceStore();
	}
	public void removePool(String key) {
		System.out.println("Before remove ds : " + DataSourceStore.dsMap);
		DataSource ds = DataSourceStore.dsMap.get(key);
		if (ds != null) {
			@SuppressWarnings("resource")
			HikariDataSource hk = (HikariDataSource) ds;
			if (hk.getHikariPoolMXBean().getTotalConnections() == 0) {
				hk.close();
				HikariDataSourceFactory.ds = null;
				DataSourceStore.dsMap.remove(key);
			}
		}
		System.out.println("After remove ds : " + DataSourceStore.dsMap);
	}
	public Connection getConnection(String key) throws Exception {
		return ds.getConnection(key);
	}
}

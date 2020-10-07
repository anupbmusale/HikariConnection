package com.hikari.confg.util;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class DataSourceStore {
	
	protected static Map<String, DataSource> dsMap = new HashMap<>();
	
	private void cacheDataSource(String key) {
		DataSource dataSource = null;
		dataSource = HikariDataSourceFactory.getDataSource();
		if(dataSource != null) {
			dsMap.put(key, dataSource);
		}	
	}
	
	private DataSource getDataSource(String key) {
		if(dsMap.containsKey(key)) {
			return dsMap.get(key);
		} else {
			cacheDataSource(key);
		}
		return dsMap.get(key);
	}
	
	protected Connection getConnection(String key) throws Exception {
		DataSource ds = getDataSource(key);
		if(ds != null) {
			return ds.getConnection();
		} else throw new Exception("Datasource: " + ds);
	}
}

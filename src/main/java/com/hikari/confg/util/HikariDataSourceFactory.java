package com.hikari.confg.util;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceFactory {
	
	protected static DataSource ds = null;
	
	public static synchronized DataSource getDataSource() {
		if(ds == null) {
			ds = new HikariDataSource(setDBProperties());
		}
		return ds;
	}
	protected static HikariConfig setDBProperties() {

		HikariConfig hConf = new HikariConfig();

		hConf.setDriverClassName("oracle.jdbc.OracleDriver");
		hConf.setConnectionTestQuery("SELECT 1 FROM DUAL");
		hConf.setPassword("Oracle_1");
		hConf.setUsername("system");
		hConf.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl1");
		hConf.setMaximumPoolSize(100);
		hConf.setIdleTimeout(10000);
		hConf.setMaxLifetime(1800000);
		hConf.setValidationTimeout(2000);
		hConf.setMinimumIdle(10);
		hConf.setConnectionTimeout(3000);
		hConf.addDataSourceProperty("prepStmtCacheSize", 250);
		hConf.addDataSourceProperty("cachePrepStmts", true);
		hConf.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
		hConf.setLeakDetectionThreshold(30000);

		return hConf;
	}

}

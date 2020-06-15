package com.spring.rentcar;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/dataSource-context.xml" })
public class MySQLConnectionTest {

	private static final Logger logger = LoggerFactory.getLogger(MySQLConnectionTest.class);

	@Inject
	private DataSource ds;

	@Test
	public void testConnection() {

		try (Connection con = ds.getConnection()) {

			logger.info("mysql연결 :" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package main.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * This object is disposable, we need it only to construct SqlSessionFactory
 */
public class MyBatisSessionBuilder {
	public SqlSessionFactory build() throws IOException {
		String resource = "mybatis-config.xml"; 
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader); 
		return sqlMapper;
	}
}

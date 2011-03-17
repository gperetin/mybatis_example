package main.persistence;

import java.io.IOException;

import main.domain.Person;
import main.domain.mappings.PersonMapper;
import main.util.MyBatisSessionBuilder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/*
 * This would usually be an interface, and implementation would be injected via DI
 * to those objects that need access to database.
 * It is done this way for simplicity.
 */
public class PersonRepository {
	/*
	 * We need only one SqlSessionFactory per application.
	 */
	private SqlSessionFactory sessionFactory;
	
	public PersonRepository() {
		MyBatisSessionBuilder builder = new MyBatisSessionBuilder();
		try {
			sessionFactory = builder.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Person getById(long id) {
		System.out.println("Getting by id: " + id);
		SqlSession session = sessionFactory.openSession(); 
		try { 
		  PersonMapper mapper = session.getMapper(PersonMapper.class);
		  Person person = mapper.getById(id);
		  return person;
		} finally { 
		  session.close();
		}
	}
	
	public void insert(Person p) {
		SqlSession session = sessionFactory.openSession(); 
		try { 
		  PersonMapper mapper = session.getMapper(PersonMapper.class);
		  mapper.insertAd(p);
		  session.commit();
		} finally { 
		  session.close();
		}
	}
}

package main.domain.mappings;

import main.domain.Person;

public interface PersonMapper {
	public Person getById(long id);
	public int insertAd(Person p);
}

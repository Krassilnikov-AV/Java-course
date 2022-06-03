package com.javaСourse.hibernate.oneToMany.dao;

public interface DAO<Entity, Key> {
	void create(Entity entity);
	Entity read(Key key);
	void update(Entity entity);
	void delete(Entity entity);
}

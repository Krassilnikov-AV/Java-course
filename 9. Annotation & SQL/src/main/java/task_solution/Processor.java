package task_solution;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * Класс Processor
 * анализирует класс Cat и формирует по нему запрос в БД
 */
public class Processor {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;


	public static void main(String[] args) {
		try {
			connect();
			builTable(Cat.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
	public static void connect() throws SQLException {
		System.out.println("=====// Получение соединения");
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:main.db");
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
		} catch (ClassNotFoundException | SQLException e) {
			throw new SQLException("Unable to connect");
		}
	}


	/*метод для обработки*/
	public static void builTable(Class cl) throws SQLException {
		if (!cl.isAnnotationPresent(Table.class)) {
			throw new RuntimeException("@Table missed");
		}
		Map<Class, String> map = new HashMap<>();
		map.put(int.class, "INTEGER");
		map.put(String.class, "TEXT");
		// создание SQL запроса
		// CREATE TABLE cats (id INTEGER, name TEXT, age INTEGER);
		StringBuilder stringBuilder = new StringBuilder("CREATE TABLE");
		// CREATE TABLE cats
		stringBuilder.append(((Table) cl.getAnnotation(Table.class)));
		//CREATE TABLE cats
		stringBuilder.append(" (");
		Field[] fields = cl.getDeclaredFields();
		for (Field o : fields) {
			if (o.isAnnotationPresent(Columb.class)) {
				stringBuilder.append(o.getName())
					.append(" ")
					.append(map.get(o.getType()))
					.append(", ");
			}
		}
// 'CREATE TABLE cats (id INTEGER, name TEXT, age INTEGER'
		stringBuilder.setLength(stringBuilder.length() - 2);
// 'CREATE TABLE cats (id INTEGER, name TEXT, age INTEGER);'
		stringBuilder.append(");");
// 'CREATE TABLE cats (id INTEGER, name TEXT, age INTEGER);'
		statement.executeUpdate(stringBuilder.toString());

	}


	public static void disconnect() {
		System.out.println("====//подключение к БД");
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
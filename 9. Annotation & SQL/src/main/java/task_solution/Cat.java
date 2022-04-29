package task_solution;

/*разметка класса*/

@Table(title = "cats")
public class Cat {
	@Columb
	int id;

	@Columb
	String name;

	@Columb
	int age;

	public Cat(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
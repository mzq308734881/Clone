package deepClone;

import java.io.*;

class Teacher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int age;

	Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

// 利用串行化来做深复制
public class DeepStudent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Object deepClone() throws IOException, ClassNotFoundException {
		// 将对象写到流里
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		// 从流里读出来
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}

	String name;// 常量对象
	int age;
	Teacher t;// 学生1和学生2的引用值都是一样的。

	DeepStudent(String name, int age, Teacher t) {
		this.name = name;
		this.age = age;
		this.t = t;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
		Teacher t = new Teacher("tangliang", 30);
		DeepStudent s1 = new DeepStudent("zhangsan", 18, t);
		DeepStudent s2 = (DeepStudent) s1.deepClone();
		s2.t.name = "tony";
		s2.t.age = 40;
		System.out.println("name=" + s1.t.name + "," + "age=" + s1.t.age);
		// 学生1的老师不改变
	}
}

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

// ���ô��л��������
public class DeepStudent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Object deepClone() throws IOException, ClassNotFoundException {
		// ������д������
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		// �����������
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}

	String name;// ��������
	int age;
	Teacher t;// ѧ��1��ѧ��2������ֵ����һ���ġ�

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
		// ѧ��1����ʦ���ı�
	}
}

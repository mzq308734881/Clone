package dlpack;

class Professor {
	String name;
	int age;

	Professor(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class MyStudent implements Cloneable {

	String name;// ��������
	int age;
	Professor p;// ѧ��1��ѧ��2������ֵ����һ���ġ�

	MyStudent(String name, int age, Professor p) {
		this.name = name;
		this.age = age;
		this.p = p;
	}

	public Object clone() {
		MyStudent o = null;
		try {
			o = (MyStudent) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}
		o.p = (Professor) p;
		return o;
	}

	public static void main(String[] args) {
		Professor p = new Professor("wangwu", 50);
		MyStudent s1 = new MyStudent("zhangsan", 18, p);
		MyStudent s2 = (MyStudent) s1.clone();
		s2.p.name = "lisi";
		s2.p.age = 30;	
		//ѧ��1�Ľ��ڳ�Ϊlisi,ageΪ30����s1���������ݱ�s2�ı�
		System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age);		
	}

}

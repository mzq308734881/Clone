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

	String name;// 常量对象。
	int age;
	Professor p;// 学生1和学生2的引用值都是一样的。

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
		//学生1的教授成为lisi,age为30。即s1的属性内容被s2改变
		System.out.println("name=" + s1.p.name + "," + "age=" + s1.p.age);		
	}

}

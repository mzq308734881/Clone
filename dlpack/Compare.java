package dlpack;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1=new String("abc");
        String s2=s1;  /*s1�������ȫ������ָ����ͬ�Ķ���*/
        String s3="abc";
        String s4=new String("abc");  /* ��s1��ʾ�Ĳ���ͬһ�����󣬼�ָ��Ĳ���ͬһ���ڴ���*/
        
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s2.equals(s3));
        
        System.out.println();
        
        System.out.println(s1==s2);   
        System.out.println(s1==s4);
        System.out.println(s1==s3);
        System.out.println(s2==s3);

	}

}

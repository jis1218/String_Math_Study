
public class StringApi {
	
	public void text(){
		
		String a = "String Test";
		
		String[] abc = {"hello", "goodbye"};
		
		// ����
		System.out.println(a.length());
		
		// ��ġ �˻�
		System.out.println(a.indexOf("T"));
		
		// Ư�� �����ڷ� ����
		System.out.println(a.split(" "));
		
		String temp[] = a.split("");
		
		for(String item : temp){
			System.out.println(item);
		}
		
		for(String item : abc){
		System.out.println(item);
		}
		
		//���ڿ� �ڸ���
		System.out.println(a.substring(2, 7));
		
		// ���ڿ� �ٲٱ�
		System.out.println(a.replace("Te", "Px"));
		
		//�� ��¥�� �ش� ���ڷ� �����ϴ��� �˷���,
		System.out.println(a.startsWith("Str"));
		
		String address = "naver.com";
		
		if(!address.startsWith("http:")){
			address = "http:" + address;
		}
		
		
	}
	
	public void builderVsBuffer(){
	
		/*String constant pool�� �ִµ� '��'�� �����, 
		�ٸ� ���� '�ȳ���'�� ����, '�ȳ��ϼ���'�� ����, ��� constant pool�� ���̰� �ȴ�. 
		����  �޸𸮸� �Ƴ��� ���� StringBuffer�� ����ϴ°� ����.(������ ���)
		jdk 1.5 �̻���ʹ� �Ϲ����� ��Ʈ�� ������ StringBuilder�� �����Ϸ��� �ڵ���ȯ ����*/
		String result = "��" + "����" + "����";
		
		//�̷��� ó���ϸ� �޸𸮰� ������� ����, �ӵ��� Builder���ٴ� �������� �׷��� ����, �񵿱⿡�� �������� �����, ����ȭó�� �Ǿ� ����
		//����ȭ ó���� ���� ���� ������ �ٸ� ����� ������ ���� ����
		StringBuffer buffer = new StringBuffer();
		buffer.append("��");
		buffer.append("����").append("����");
		System.out.println(buffer.toString());
		
		//String Builder�� ����, �ӵ��� Buffer���� ����
		//�񵿱⿡�� ������ ������� �ʴ´�.
		//���������� �Ѹ��� ����, �Ѹ��� �а� �ְ�, �Ѹ��� ����� �ִٶ�� �ϸ� ������� ó���Ǵ°� �ƴ϶� ���׹��� �ǹ���, ���߽����� ȯ�濡���� ������� ����
		StringBuilder builder = new StringBuilder();
		builder.append("��");
		builder.append("����").append("����");
		System.out.println(builder.toString());
		
	
	}
	
	public void stringConstantPool(){
		String a = "�ȳ��ϼ���";
		String b = "�ȳ��ϼ���";
		
		System.out.println(a==b); //�ּ� üũ
		System.out.println(a.equals(b)); //�� üũ
		
		//�ֵ���ǥ �ȿ��� String ��������� constant pool�� ���µ� ���ڿ��� ���� ��� �ּҰ� ����
		//���� ���� key�� integer�� ��, hashcode�� �˻��Ͽ� ������ ������ ���� �ּҸ� ����Ű�� �� ����
		//Hashcode�� ���ڸ��� �˻��� Ʈ�� ������ ���� ex)1ã�� 12ã�� 123ã�� 1235ã�� 12352ã��....
		
		//new�� ���� �Ǹ� �ٸ� Ǯ�� ��
		
		//constant pool�� Heap ������ �ִ�. ������ Permanent ������ �־����� �̵��� 1.7 ���ķ�
		//�ڹٿ��� �޸𸮿� ��� �����ϴ��� �� �ʿ䰡 ����
		
		String c = new String("�ȳ��ϼ���");
		
		System.out.println(a==c);
		System.out.println(a.equals(c));
		String d = c.intern();
	}

}

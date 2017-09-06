
public class StringApi {
	
	public void text(){
		
		String a = "String Test";
		
		String[] abc = {"hello", "goodbye"};
		
		// 길이
		System.out.println(a.length());
		
		// 위치 검색
		System.out.println(a.indexOf("T"));
		
		// 특정 구분자로 분해
		System.out.println(a.split(" "));
		
		String temp[] = a.split("");
		
		for(String item : temp){
			System.out.println(item);
		}
		
		for(String item : abc){
		System.out.println(item);
		}
		
		//문자열 자르기
		System.out.println(a.substring(2, 7));
		
		// 문자열 바꾸기
		System.out.println(a.replace("Te", "Px"));
		
		//내 글짜가 해당 문자로 시작하는지 알려줌,
		System.out.println(a.startsWith("Str"));
		
		String address = "naver.com";
		
		if(!address.startsWith("http:")){
			address = "http:" + address;
		}
		
		
	}
	
	public void builderVsBuffer(){
	
		/*String constant pool이 있는데 '안'이 저장됨, 
		다른 곳에 '안녕하'이 저장, '안녕하세요'가 저장, 계속 constant pool에 쌓이게 된다. 
		따라서  메모리를 아끼기 위해 StringBuffer를 사용하는게 좋다.(옛날의 경우)
		jdk 1.5 이상부터는 일반적인 스트링 연산을 StringBuilder로 컴파일러가 자동변환 해줌*/
		String result = "안" + "녕하" + "세요";
		
		//이렇게 처리하면 메모리가 낭비되지 않음, 속도는 Builder보다는 느리지만 그래도 빠름, 비동기에서 안정성이 보장됨, 동기화처리 되어 있음
		//동기화 처리란 내가 쓰고 있으면 다른 사람은 접근할 수가 없음
		StringBuffer buffer = new StringBuffer();
		buffer.append("안");
		buffer.append("녕하").append("세요");
		System.out.println(buffer.toString());
		
		//String Builder가 있음, 속도는 Buffer보다 빠름
		//비동기에서 안정성 보장되지 않는다.
		//웹서버에서 한명은 수정, 한명은 읽고 있고, 한명은 지우고 있다라고 하면 순서대로 처리되는게 아니라 뒤죽박죽 되버림, 다중스레드 환경에서는 사용하지 않음
		StringBuilder builder = new StringBuilder();
		builder.append("안");
		builder.append("녕하").append("세요");
		System.out.println(builder.toString());
		
	
	}
	
	public void stringConstantPool(){
		String a = "안녕하세요";
		String b = "안녕하세요";
		
		System.out.println(a==b); //주소 체크
		System.out.println(a.equals(b)); //값 체크
		
		//쌍따옴표 안에서 String 만들어지면 constant pool로 들어가는데 문자열이 같을 경우 주소가 같음
		//값에 대한 key가 integer로 들어감, hashcode를 검색하여 같은게 있으면 같은 주소를 가르키는 것 같음
		//Hashcode의 앞자리를 검색해 트리 구조로 만듦 ex)1찾고 12찾고 123찾고 1235찾고 12352찾고....
		
		//new를 쓰게 되면 다른 풀로 들어감
		
		//constant pool은 Heap 영역에 있다. 원래는 Permanent 영역에 있었지만 이동함 1.7 이후로
		//자바에서 메모리에 어떻게 저장하는지 알 필요가 있음
		
		String c = new String("안녕하세요");
		
		System.out.println(a==c);
		System.out.println(a.equals(c));
		String d = c.intern();
	}

}

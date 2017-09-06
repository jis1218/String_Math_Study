# Java String API

## String API
스트링 함수
> 1. length - 문자열의 길이를 구한다.
```java
  String a = "String Test";
  System.out.println(a.length());
```

> 2. indexOf - 문자열의 위치를 리턴한다
```java
System.out.println(a.indexOf(Te"));
```

> 3. split - 특정 구분자로 분해
```java
System.out.println(a.split(" "));
```

> 4. substring - 문자열 자르기
```java
System.out.println(a.substring(2, 7));
```

> 5. replace - 문자열 바꾸기
```java
System.out.println(a.replace("Te", "Px"));
```

>6. startsWith - 내 글자가 해당 문자로 시작하는지 알려줌
```java
System.out.println(a.startsWith("Str"));
```

## StringBuffer와 StringBuilder의 차이
>  StringBuffer와 StringBuilder 모두 메모리를 낭비하지 않는다는 장점이 있다. String의 경우는
```java
String result = "안" + "녕하" + "세요";
```
할 때마다 constant pool에 데이터가 계속 쌓이게 된다. (하지만 jdk1.5부터 이런 문제는 해결되었다)
> ### 1. StringBuffer의 쓰임
>> 메모리가 낭비되지 않는다는 장점이 있고 StringBuilder보다는 느리나 여전히 String보다는 빠르고 동기화처리가 되어 있어 혹시나 다른 사람이 쓰려고 하면 접근이 제한된다.
```java
  StringBuffer buffer = new StringBuffer();
	buffer.append("안");
	buffer.append("녕하").append("세요");
	System.out.println(buffer.toString());
```

>### 2. StringBuilder의 쓰임
>> 역시 메모리가 낭비되지 않는 장점이 있고 StringBuilder보다 빠르다. 하지만 동기화처리가 안되어 여러 사람이 같이 접근할 경우 데이터가 뒤죽박죽이 될 수 있다.
```java
  StringBuilder builder = new StringBuilder();
	builder.append("안");
	builder.append("녕하").append("세요");
	System.out.println(builder.toString());
```

> ### 3. Constant Pool에 대한 메모


```java


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
  ```


## Algorithm
String 함수를 이용한 Algorithm 풀이

> ### 1. 로또번호 생성기

>> #### 1.1 Version 1

```java

  public int[] getLottoNumbers(){

    int [] result = new int[6];

    Random random = new Random();

    int[] index = new int[46];

    for(int i=0; i<46; i++){
      index[i] = 0;
    }

    int a = 0;

    while(a<6){

    result[a] = random.nextInt(45)+1;

    if(index[result[a]]==0){
      index[result[a]]++;
      a++;
    }		
    }
    return result;
    }
```

> ### 1.2 Version 2

```java

    public ArrayList<Integer> getLottoNumber(){
		ArrayList<Integer> result = new ArrayList<>();
		Set<Integer> treeSet = new TreeSet<>();

		Random random = new Random();

		//동적 배열 - 크기를 제한하지 않는 객체 배열
		//종류 : List, Set, Map
		//List = 인덱스와 값을 갖고 있는 배열
		// Set = 리스트와 유사한데 중복값이 입력되지 않는다
		// Map = 키와 값을 가지고 있는 동적 배열
		// Map map = new HashMap();
		// map.put("키", 33);
		for(int i= 6; i != treeSet.size();){
			treeSet.add(random.nextInt(45)+1);
		}

		Iterator<Integer> iterator = treeSet.iterator(); //treeSet은 get하는 함수가 없다. 따라서 ArrayList에 값을 넘겨줘야 하는데 그 역할을 하는게 Iterator
		while(iterator.hasNext()){
			result.add(iterator.next());
		}

		return result;

	}
  ```

  > ### 2. Anagram 이용 알고리즘

  >> #### 2.1 Version 1

  ```java

    public boolean checkAnagram(String a, String b){

  		String[] fArray = a.split("");
  		String[] sArray = b.split("");

  		if(fArray.length!=sArray.length){
  			return false;
  		}
  		for(int i=0; i<fArray.length; i++){

  			for(int j=0; j<sArray.length; j++){

  				if(fArray[i].equals(sArray[j])){

  				fArray[i] = "0";
  				sArray[j] = "0";

  				break;
  				}
  			}		
  		}
  		int num = 0;
  		for(int i=0; i<fArray.length; i++){

  			if(fArray[i].equals("0")){
  				num++;
  			}

  			if(num==fArray.length){
  				return true;
  			}
  		}
  		return false;
  	}  
  ```

  >> #### 2.2 Version 2

  ```java
      public boolean checkAnagramVerTwo(String a, String b){
  		int[] firstIndex = new int[27];
  		int[] secondIndex = new int[27];
  		char[] alpha = new char[27];
  		for(int i = 0; i<27; i++){

  			firstIndex[i] = 0;
  			secondIndex[i] = 0;
  			alpha[i] = (char)(i+97);

  		}

  		char[] firstArray = a.toCharArray();
  		char[] secondArray = b.toCharArray();

  		for(int i=0; i<firstArray.length; i++){

  			for(int j = 0; j<27; j++){
  				if(firstArray[i] == alpha[j]){
  					firstIndex[j]++;
  				}
  			}			
  		}

  		for(int i=0; i<secondArray.length; i++){

  			for(int j=0; j<27; j++){
  				if(secondArray[i]==alpha[j]){
  					secondIndex[j]++;
  				}
  			}
  		}

  		for(int i=0; i<27; i++){
  			if(firstIndex[i]!=secondIndex[i]){
  				return false;
  			}
  		}

  		return true;

  	}
```

>> #### 2.3 Version 3

```java

public boolean checkAnagramVerThree(String a, String b){

  boolean result = false;

  a = a.toLowerCase();
  b = b.toLowerCase();

  String aTemp[] = a.replace(" ", "").split("");
  String bTemp[] = b.replace(" ", "").split("");
  if(a.length() != b.length()){
  return false;
  }//이렇게 먼저 나오는게 좋을 듯


  //정렬을 하기 위해 char 배열로 변경
  char aCharTemp[] = a.toCharArray();
  char bCharTemp[] = b.toCharArray();

  //문자열 정렬
  Arrays.sort(aTemp);
  Arrays.sort(bTemp);

  a = aCharTemp.toString();
  b = bCharTemp.toString();

//		StringBuilder aBuilder = new StringBuilder();
//		StringBuilder bBuilder = new StringBuilder();
//		
//		if(aTemp.length!=bTemp.length){
//			return false;
//		}else{
//			for(String aItem : aTemp){
//				aBuilder.append(aItem);
//			}
//			a = aBuilder.toString();
//			
//			for(String bItem : bTemp){
//				bBuilder.append(bItem);
//			}
//			b = bBuilder.toString();

    return a.equals(b);
  }
  ```

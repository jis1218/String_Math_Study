import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * @author 정인섭
 *
 */



public class AlgoMath {
	
	/*
	 * 아나그램 알고리즘
	 * 
	 * 두 개의 문자열 입력을 받아서 두 개의 관계가 아나그램 관계인지 확인하는 프로그램을 개발하세요
	 */
	
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
	
	public int[] getLottoNumbersVerTwo(){
		
		int [] result = new int[6];
		
		Random random = new Random();
		
		int temp = 0;
		int cnt = 0;
		for(int i=0; i<result.length; i++){
			temp = random.nextInt(45)+1;
			if(cnt > 0){
				for(int item :result){
					while(item == temp){
						temp = random.nextInt(45)+1;
					}
				}
			}
			
			result[cnt]=temp;
			cnt++;
		}
		return result;
	}
	
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
	
	public void testMath(){
		//static으로 선언되어 있음
		int a = Math.abs(-123);
		
		//반올림
		int b = (int) Math.round(123.5);
		//올림
		double c = Math.ceil(341.231);
		//내림
		double d = Math.floor(123.431);
		
		System.out.println(a + "\n" + b + "\n" + c + "\n" + d);
		
		Math.random(); //0보다 크거나 같고 1보다 작은 실수를 return 함
		
		Random random = new Random();
		
		//1부터 100 사이의 Random한 숫자 가져오기
		
		int r = random.nextInt(100) + 1; //0 부터 99 사이의 정수가 리턴되고 1부터 100사이의 정수를 하려면 +1을 하면 된다.
	}

}

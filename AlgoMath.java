import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
/**
 * 
 * @author ���μ�
 *
 */



public class AlgoMath {
	
	/*
	 * �Ƴ��׷� �˰���
	 * 
	 * �� ���� ���ڿ� �Է��� �޾Ƽ� �� ���� ���谡 �Ƴ��׷� �������� Ȯ���ϴ� ���α׷��� �����ϼ���
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
		}//�̷��� ���� �����°� ���� ��
		
		
		//������ �ϱ� ���� char �迭�� ����
		char aCharTemp[] = a.toCharArray();
		char bCharTemp[] = b.toCharArray();

		//���ڿ� ����
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
		
		//���� �迭 - ũ�⸦ �������� �ʴ� ��ü �迭
		//���� : List, Set, Map
		//List = �ε����� ���� ���� �ִ� �迭
		// Set = ����Ʈ�� �����ѵ� �ߺ����� �Էµ��� �ʴ´�
		// Map = Ű�� ���� ������ �ִ� ���� �迭
		// Map map = new HashMap();
		// map.put("Ű", 33);
		for(int i= 6; i != treeSet.size();){
			treeSet.add(random.nextInt(45)+1);
		}
		
		Iterator<Integer> iterator = treeSet.iterator(); //treeSet�� get�ϴ� �Լ��� ����. ���� ArrayList�� ���� �Ѱ���� �ϴµ� �� ������ �ϴ°� Iterator
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
		
		return result;
		
	}
	
	public void testMath(){
		//static���� ����Ǿ� ����
		int a = Math.abs(-123);
		
		//�ݿø�
		int b = (int) Math.round(123.5);
		//�ø�
		double c = Math.ceil(341.231);
		//����
		double d = Math.floor(123.431);
		
		System.out.println(a + "\n" + b + "\n" + c + "\n" + d);
		
		Math.random(); //0���� ũ�ų� ���� 1���� ���� �Ǽ��� return ��
		
		Random random = new Random();
		
		//1���� 100 ������ Random�� ���� ��������
		
		int r = random.nextInt(100) + 1; //0 ���� 99 ������ ������ ���ϵǰ� 1���� 100������ ������ �Ϸ��� +1�� �ϸ� �ȴ�.
	}

}

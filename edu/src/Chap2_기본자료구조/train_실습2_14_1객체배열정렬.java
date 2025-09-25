package Chap2_기본자료구조;

/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;
import java.util.Comparator;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2> {

	String name;
	int height;
	double vision;

	public PhyscData2(String string, int i, double d) {
		// TODO 자동 생성된 생성자 스텁
		this.name = string;
		this.height = i;
		this.vision = d;

	}
	public String getName() {
		return name;
	}
	public int getHeight() {
		return height;
	}
	public double getVision() {
		return vision;
	}

	@Override
	public int compareTo(PhyscData2 o) {
		// TODO 자동 생성된 메소드 스텁
		return name.compareTo(o.name);
	}
}

public class train_실습2_14_1객체배열정렬 {

	public static void main(String[] args) {
		PhyscData2[] data = { new PhyscData2("홍길동", 162, 0.3), new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7), new PhyscData2("김홍길동", 172, 0.3), new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2), new PhyscData2("최길동", 169, 0.5), };
		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		
		
		Comparator<PhyscData2> heightComparator = (a, b) -> Integer.compare(a.getHeight(), b.getHeight());
		Arrays.sort(data, heightComparator);// comparator가 필요하다
		showData("Arrays.sort() 실행후", data);

		int resultIndex = binarySearch(data, "이길동");
		if (resultIndex >= 0)
			System.out.println("이길동이 존재하면 인덱스 = " + resultIndex);
		else

			System.out.println("이길동이 존재하지 않는다");

	
		PhyscData2[] newData = insertObject(data, new PhyscData2("소주다", 179, 1.5));
		// 배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		System.out.println();
		showData("삽입후", newData);
	}

	private static PhyscData2[] insertObject(PhyscData2[] data, PhyscData2 physcData2) {
		// TODO 자동 생성된 메소드 스텁
		sortData(data);
		PhyscData2 newData[] = new PhyscData2[data.length + 1];
		int i = 0;
		boolean m = false;
		for (i = 0; i < data.length; i++) {
			if (physcData2.getName().compareTo(data[i].getName()) < 0) {
				newData[i] = physcData2;
				m = true;
				break;
			}
			newData[i] = data[i];
		}
		if (!m) {
			newData[newData.length - 1] = physcData2;
		}
		for (int j = i; j < data.length; j++) {
			newData[j + 1] = data[j];
		}
		return newData;
	}

	private static int binarySearch(PhyscData2[] data, String string) {
		// TODO 자동 생성된 메소드 스텁
		int f = 0;
		int e = data.length - 1;
		while (f <= e) {
			int m = (f + e) / 2;
			if (data[m].getName().equals(string)) {
				return m;
			} else if (data[m].getName().compareTo(string) < 0) {
				f = m + 1;
			} else {
				e = m - 1;
			}
		}
		return -1;
	}

	private static void sortData(PhyscData2[] data) {
		// TODO 자동 생성된 메소드 스텁
		// Arrays.sort(data);
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].getName().compareTo(data[j].getName()) > 0) {
					swap(data, i, j);
				}
			}
		}
	}

	private static void swap(PhyscData2[] data, int i, int j) {
		// TODO 자동 생성된 메소드 스텁
		PhyscData2 a = data[i];
		data[i] = data[j];
		data[j] = a;
	}
  
	private static void showData(String string, PhyscData2[] data) {
		// TODO 자동 생성된 메소드 스텁
		System.out.println(string);
		for (int j = 0; j < data.length; j++) {
			System.out.println("[" + data[j].getName() + "\t" + data[j].getHeight() + "\t" + data[j].getVision() + "]");
		}
		System.out.println("");
	}

}

package Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementMain {

	public static void main(String[] args) {
		String name;
		String major;
		String studentId;
		String telNumber;
		String sexValue;
		int grade;
		Methods methods = new Methods();
		ArrayList<Student> list = new ArrayList<>();
		int menuselect; // 메뉴 선택 번호
		Scanner sc = new Scanner(System.in);

		System.out.println("==============================================");
		System.out.println("                                   학사 관리 시스템                                             ");
		System.out.println("==============================================");

		while (true) {
			System.out.println("==============================================");
			System.out.println("|1. 학생 등록 |  2. 학생 목록 조회 | 3. 학생 정보 조회 |  ");
			System.out.println("|4. 학생 정보 수정| 5. 학생 정보 삭제 | 6. 종료");
			System.out.println("==============================================");
			System.out.print("메뉴번호를 입력하세요 >>  ");

			menuselect = sc.nextInt();

			switch (menuselect) {
			case 1: // 등록
				methods.enrollmethod();
				break;

			case 2: // 전체조회
				methods.readmem();
				break;

			case 3: // 선택조회 
				methods.search();
				break;

			case 4: // 정보 수정
				methods.edit();				
				break;
				
			case 5: // 정보 삭제
				methods.delete();
				break;
			case 6:
				System.out.println("학사관리 시스템을 종료합니다");
				sc.close();
			}

		}
	
		
	}

}

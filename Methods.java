package Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> list = new ArrayList<>();

	String name;
	String major;
	String studentId;
	String telNumber;
	String sexValue;
	int grade;

	public void enrollmethod() {
		System.out.println("학생 등록 페이지로 이동합니다");
		System.out.print("학생의 성명 >> ");
		name = sc.next();
		System.out.print("학생의 전공 >> ");
		major = sc.next();

		while (true) {
			System.out.print("학생의 전화번호 (010생략 8자리)  >> ");
			telNumber = sc.next();
			if (telNumber.length() != 8)
				System.out.println("잘못 입력했습니다. 다시 입력해주세요");
			else if (telNumber.length() == 8) {
				telNumber = "010-" + telNumber.substring(0, 4) + "-" + telNumber.substring(4);
				break;
			}

		}

		while (true) {
			System.out.print("학생의 학번 (9자리 입력) >> ");
			studentId = sc.next();
			if (studentId.length() != 9)
				System.out.println("잘못 입력했습니다. 다시 입력해주세요");
			else if (studentId.length() == 9)
				break;
		}

		System.out.print("학생의 학년 >> ");
		grade = sc.nextInt();
		System.out.print("학생의 성별(남자 / 여자)>> ");
		sexValue = sc.next();
		System.out.println("학생 정보 입력이 완료되었습니다.");
		list.add(new Student(name, major, telNumber, studentId, sexValue, grade));
//		System.out.println(list.size());
//		list.add(new Student());
//		System.out.print("학생의 성명 >> ");
//		list.get(list.size()).setName(sc.nextLine());
	}

	public void readmem() {
		System.out.println("학생 목록 조회 페이지로 이동합니다");
		System.out.println();
		System.out.println("<학생 목록>");
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			System.out.println(s.getName());
		}
		System.out.println();
	}

	public void search() {
		String id;
		System.out.println("학생 정보 조회 페이지로 이동합니다");
		System.out.print("학번을 입력하세요");
		id = sc.next();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getStudentId().equals(id)) {
				System.out.println("해당 학번과 일치하는 학생을 조회합니다");
				System.out.println("이름 :" + list.get(i).getName());
				System.out.println("성별 :" + list.get(i).getSexValue());
				System.out.println("학년 :" + list.get(i).getGrade());
				System.out.println("학번 :" + list.get(i).getStudentId());
				System.out.println("전공 :" + list.get(i).getMajor());
				System.out.println("전화번호 :" + list.get(i).getTelNumber());
			}
	}

	public void edit() {
		String editInfo; // 수정할 학생의 학번 변수
		String edit = null; // 수정할 내용에대한 변수
		int select; // 정보 수정 메뉴 번호 변수
		System.out.println("학생 정보 수정 페이지로 이동합니다");
		System.out.print("수정하고자 하는 학생의 학번을 입력하세요");
		editInfo = sc.next();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getStudentId().equals(editInfo)) {
				System.out.println(list.get(i).getName() + "학생의 정보를 수정합니다");
				System.out.println("==============================================");
				System.out.println("수정할 부분을 선택해주세요 >> |1. 일괄 수정| 2. 이름 수정| 3. 학번 수정|");
				System.out.println("                                            |4. 전공 수정 |5. 전화번호 수정 |6. 종료|");
				System.out.println("==============================================");
				select = sc.nextInt();
				switch (select) {
				case 1:
					System.out.println("<일괄 수정>");
					System.out.print("이름 수정 :");
					edit = sc.next();
					list.get(i).setName(edit);
					System.out.print("학번 수정 :");
					edit = sc.next();
					list.get(i).setStudentId(edit);
					System.out.print("전공 수정 :");
					edit = sc.next();
					list.get(i).setMajor(edit);
					System.out.print("전화번호 수정 :");
					edit = sc.next();
					list.get(i).setTelNumber(edit);
					System.out.println("<수정 되었습니다>");
					System.out.println(" 이름 :" + list.get(i).getName() + " 학번 :" + list.get(i).getStudentId() + " 전공 : "
							+ list.get(i).getMajor() + " 전화번호 : " + list.get(i).getTelNumber());
					break;
				case 2:
					System.out.println("<이름 수정>");
					edit = sc.next();
					list.get(i).setName(edit);
					System.out.println("<수정 되었습니다>");
					break;
				case 3:
					System.out.println("학번 수정 (9자리) :");
					edit = sc.next();
					list.get(i).setStudentId(edit);
					System.out.println("<수정 되었습니다>");
					break;
				case 4:
					System.out.println("전공 수정 :");
					edit = sc.next();
					list.get(i).setMajor(edit);
					System.out.println("<수정 되었습니다>");
					break;
				case 5:
					System.out.println("전화번호 수정 (11자리) :");
					edit = sc.next();
					list.get(i).setTelNumber(edit);
					System.out.println("<수정 되었습니다>");
					break;
				case 6:
					System.out.println("학생 정보 수정을 종료합니다");
					break;
				}
			}
	}

	public void delete() {
		int select; // 삭제 메뉴 번호 변수
		int agree; // 삭제 동의 거절 변수
		String removeId; // 삭제하기 위해 입력받은 학번
		System.out.println("학생 정보 삭제 페이지로 이동합니다");
		while (true) {
			System.out.println("삭제 유형을 선택하세요>> | 1. 전체 삭제 | 2. 개별 삭제 | 3. 삭제 종료");
			select = sc.nextInt();
			if (select == 1) {
				System.out.println("학생 정보를 모두 삭제합니다. 동의하십니까? |1. 동의 | 2. 취소 |");
				agree = sc.nextInt();
				if (agree == 1) {
					list.clear();
					System.out.println("학생 정보가 모두 삭제되었습니다.");
					System.out.println("초기 메뉴로 돌아갑니다.");
					break;
				} else if (agree == 2) {
					System.out.println("전체 삭제를 취소합니다. 다시 선택해주세요");
					continue;
				}
			}
			if (select == 2) {
				while (true) {
					System.out.println("삭제하고자 하는 학생의 학번을 입력하세요");
					for (int i = 0; i < list.size(); i++) {
						removeId = sc.next();
						if (list.get(i).getStudentId().equals(removeId)) {
							System.out.println("해당 학생의 다음 정보를 삭제합니다. ");
							System.out.println("이름 :" + list.get(i).getName());
							System.out.println("성별 :" + list.get(i).getSexValue());
							System.out.println("학년 :" + list.get(i).getGrade());
							System.out.println("학번 :" + list.get(i).getStudentId());
							System.out.println("전공 :" + list.get(i).getMajor());
							System.out.println("전화번호 :" + list.get(i).getTelNumber());
							System.out.println("동의하십니까? |1. 동의 | 2. 취소 |");
							agree = sc.nextInt();
							if (agree == 1) {
								list.remove(i);
								System.out.println("학생 정보가 모두 삭제되었습니다.");
								System.out.println("초기 메뉴로 돌아갑니다.");
							} else if (agree == 2) {
								System.out.println("해당 학생의 정보 삭제를 취소합니다. 다시 선택해주세요");
							}
						}
					}

				}
			}
			if (select == 3)
				System.out.println("학생 정보 삭제를 종료합니다.");
			break;
		}
	}
}
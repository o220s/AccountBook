package main;

import java.util.Scanner;

import accountbook.AccountBook;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AccountBook book = new AccountBook();
		
		out:while(true) {
			
			System.out.println(" << 가계부 >> ");
			System.out.println("1. 가계부 정보추가");
			System.out.println("2. 가계부 정보삭제");
			System.out.println("3. 가계부 정보수정");
			System.out.println("4. 가계부 정보검색");
			System.out.println("5. 월별로 (수입-지출)출력");
			System.out.println("6. 총 결산을 출력");
			System.out.println("7. 프로그램종료");
			
			System.out.print(">> ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:		
					book.add();
					break;				
				case 2:		
					book.drop();
					break;			
				case 3:		
					book.upgrade();
					break;				
				case 4:		
					System.out.println("<< 검색메뉴 >> ");
					System.out.println("1. 날짜로 검색 ");
					System.out.println("2. 제목으로 검색 ");
					System.out.println("3. 메모로 검색 ");
					System.out.println("4. 기간별 검색 ");
					
					System.out.print(">> ");
					int selectMenu =sc.nextInt();
					switch(selectMenu) {
					case 1:
						book.dateSearch();
						break;
					case 2:
						book.titleSearch();
						break;
					case 3:
						book.memoSearch();
						break;
					case 4:
						book.periodSearch();
					}
					break;										
				case 5:
					book.monthSum();
					break;
				case 6:
					book.total();
					break;
				case 7:
					break out;
				default:					
			}
		}
		
		System.out.println("프로그램을 종료합니다");
		
		
		
	

	}

}

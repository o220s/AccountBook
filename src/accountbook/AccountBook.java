package accountbook;

import java.util.List;
import java.util.Scanner;
import dao.AccontBookDao;
import dto.AccountBookDto;

public class AccountBook {

Scanner sc = new Scanner(System.in);
	
	// input
	public void add() {
		System.out.println("가계부추가 입니다");
		
		System.out.print("날짜 >> ");
		String date = sc.next();
		
		System.out.print("가격 >> ");
		int money = sc.nextInt();
		
		System.out.print("제목 >> ");
		String title = sc.next();
		
		System.out.print("상세메모 >> ");
		String memo = sc.next();
		
		System.out.print("수입/지출 >> ");
		String classify = sc.next();
		
		AccontBookDao dao = AccontBookDao.getInstance();
		
		boolean b = dao.insert (new AccountBookDto(date, money, title, memo, classify));
		
		if(!b) {
			System.out.println("지인이 추가되지 않았습니다");
		}
		System.out.println("성공적으로 추가되었습니다");
	}
	
	public void drop() {
		System.out.print("삭제할 정보의 번호를 입력하세요 >> ");
		int seq = sc.nextInt();
		
		AccontBookDao dao = AccontBookDao.getInstance();
		boolean drop = dao.delete(seq);
		
		if(drop) {
			System.out.println("삭제되었습니다");
		}else {
			System.out.println("삭제되지않았습니다");
		}
	}
	
	public void upgrade() {
		System.out.print("수정할 정보의 번호를 입력하세요 >> ");
		int seq = sc.nextInt();
		
		System.out.println("수정할 날짜를 입력 >> ");
		String newDate = sc.next();
		
		System.out.println("수정할 금액를 입력 >> ");
		int newMoney = sc.nextInt();
	
		System.out.println("수정할 제목를 입력 >> ");
		String newTitle = sc.next();
		
		System.out.println("수정할 메모를 입력 >> ");
		String newMemo = sc.next();
		
		System.out.println("수정할 (수입/지출)를 입력 >> ");
		String newClassify = sc.next();
		
		AccountBookDto dto = new AccountBookDto(newDate, newMoney, newTitle, newMemo, newClassify);
		
		AccontBookDao dao = AccontBookDao.getInstance();
		boolean upgrade = dao.update(seq, dto);
		
		if(upgrade) {
			System.out.println("수정되었습니다");
		}else {
			System.out.println("수정되지않았습니다");		
		}
	}
	
public void dateSearch() {
	
		System.out.print("검색할 날짜를 입력하세요 >> ");
		String date = sc.next();
		
		AccontBookDao dao = AccontBookDao.getInstance();
		
		List<AccountBookDto> list = dao.dateSelect(date);
		if(list.size() > 0) {
			for (AccountBookDto Dto : list) {
				System.out.println(Dto.toString());
			}
		}else {
			System.out.println("등록된 날짜가 없습니다");
		}
	}

public void titleSearch() {
	
	System.out.print("검색할 제목을 입력하세요 >> ");
	String title = sc.next();
	
	AccontBookDao dao = AccontBookDao.getInstance();
	
	List<AccountBookDto> list = dao.titleSelect(title);
	if(list.size() > 0) {
		for (AccountBookDto Dto : list) {
			System.out.println(Dto.toString());
		}
	}else {
		System.out.println("등록된 제목이 없습니다");
	}
}

public void memoSearch() {

	System.out.print("검색할 메모를 입력하세요 >> ");
	String memo = sc.next();
	
	AccontBookDao dao = AccontBookDao.getInstance();
	
	List<AccountBookDto> list = dao.memoSelect(memo);
	if(list.size() > 0) {
		for (AccountBookDto Dto : list) {
			System.out.println(Dto.toString());
		}
	}else {
		System.out.println("등록된 메모가 없습니다");
	}
}

public void periodSearch() {

    System.out.print("시작 할 날짜를 입력하세요 >>  ");
    String startDate = sc.next();

    System.out.print("종료 할 날짜를 입력하세요 >> ");
    String endDate = sc.next();

    System.out.print("거래유형 (수입/지출)을 입력 >> ");
    String transaction = sc.next();
    
AccontBookDao dao = AccontBookDao.getInstance();
	
	List<AccountBookDto> list = dao.periodSelect(startDate, endDate, transaction);
	if(list.size() > 0) {
		for (AccountBookDto Dto : list) {
			System.out.println(Dto.toString());
		}
	}else {
		System.out.println("등록된 기간이 아닙니다");
	  }
	}

public void monthSum() {
	
	System.out.print("월별 결산 날짜 입력 (예 : 23-01) >> ");
    String startDate = sc.next();
    
    AccontBookDao dao = AccontBookDao.getInstance();
	
	List<AccountBookDto> list = dao.monthBalance(startDate);
	if(list.size() > 0) {
		for (AccountBookDto Dto : list) {
			System.out.println("결산 날짜 : "+Dto.getDate()+ ", (수입 - 지출) 금액 : "+ Dto.getMoney());
		}
	}else {
		System.out.println("등록된 기간이 아닙니다");
	  }
	}

public void total() {
	
	System.out.println("총 결산을 출력합니다 ");
    AccontBookDao dao = AccontBookDao.getInstance();
    int[] total = dao.totalMoney();

    System.out.println("총 수입: " + total[0]);
    System.out.println("총 지출: " + total[1]);
    System.out.println("총 결산: " + (total[0] - total[1]));
	}

}
	
    

	






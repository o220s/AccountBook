package dto;

public class AccountBookDto {
	
	private String date;
	private int money ;
	private String title;
	private String memo;
	private String classify;
	
	
	public AccountBookDto() {
	} 	
	
	public AccountBookDto(String date, int money, String title, String memo, String classify) {
		super();
		this.date = date;
		this.money = money;
		this.title = title;
		this.memo = memo;
		this.classify = classify;
	
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	
	@Override
	public String toString() {
		return "AccountBookDto [date=" + date + ", money=" + money + ", title=" + title + ", memo=" + memo
				+ ", classify=" + classify + "]";
	}




	
	
	

}

package Pages.org;

public class PageManager {
	private LoginPage logInPage;
	private SearchHotel searchHotel;
	private SelectHotel selectHotel;
	private BookHotel bookHotel;

	public BookHotel getBookHotel() {
		if(bookHotel==null) {
			bookHotel=new BookHotel();
		}
		return bookHotel;
	}
	public SelectHotel getSelectHotel() {
		if(selectHotel==null) {
			selectHotel=new SelectHotel();
		}
		return selectHotel;
	}
	public LoginPage getLogInPage() {
		if(logInPage==null) {
			logInPage=new LoginPage();
		}
		return logInPage;
	}
	public SearchHotel getSearchHotel() {
		if(searchHotel==null) {
			searchHotel=new SearchHotel();
		}
		return searchHotel;
	}
	
}

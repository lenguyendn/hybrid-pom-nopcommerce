package pageUIs.alada;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX ="//input[@id='txtLoginUsername']";
	public static final String PASSWORD_TEXTBOX ="//input[@id='txtLoginPassword']";
	public static final String LOGIN_BUTTON = "//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-lg ')]";
	public static final String EMAIL_ERROR_MESSAGE ="//label[@id='txtLoginUsername-error']";
	public static final String PASSWORD_ERROR_MESSAGE ="//label[@id='txtLoginPassword-error']";
	public static final String FORM_ERROR_MESSAGE = "//p[@class='cred']";
}

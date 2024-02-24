package page.constants;

public class ExpectedValues {
    public static final String LANDING_PAGE_EXPECTED_TITLE="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
    public static final String LANDING_PAGE_TITLE_NEGATIVE_VALIDATION="Amazon.in";
    public static final String SIGN_IN_PAGE_EXPECTED_TITLE="Amazon Sign In";
    public static final String USER_LANDING_PAGE_TITLE_NEGATIVE_VALIDATION="Authentication required";
    public static final String PAGE_NOT_DISPLAYED_BOT_DETECTED_EXCEPTION_MESSAGE="Landed in user verification page as bot operation detected by web app";
    public static final String BASE_URL="https://www.amazon.in";

    //to be moved out into csv file or something and fed into test cases via TestNg dataproviders
    public static final String USER_LOGIN_USERNAME="..enter user email or phone here...";
    public static final String USER_LOGIN_PASSWORD="..enter user password here...";
}

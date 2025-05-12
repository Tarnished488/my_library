package my_library;

public interface library_user_interface {
	boolean login(int id);    // log in method
    void logout();            // log out method
    int getId();              // get user ID
    boolean isLoggedIn();     // check the log state
}

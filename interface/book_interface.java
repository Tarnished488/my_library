package my_library;

public interface book_interface {
	// get the information of book
    String getTitle();
    String getAuthor();
    String getCategory();

    // 
    boolean isAvailable();              // 是否可用（可借或可读）
    void setAvailability(boolean available); // 设置可用性
    boolean isValid();                  // 检查有效期

    // 特定行为
    boolean canBorrow();                // 是否允许借阅
    boolean canReserve();               // 是否允许预约
}

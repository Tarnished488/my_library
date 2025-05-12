package my_library;

public interface book_interface {
	// get the information of book
    String getTitle();
    String getAuthor();
    String getCategory();

    // 
    boolean isAvailable();              // �Ƿ���ã��ɽ��ɶ���
    void setAvailability(boolean available); // ���ÿ�����
    boolean isValid();                  // �����Ч��

    // �ض���Ϊ
    boolean canBorrow();                // �Ƿ��������
    boolean canReserve();               // �Ƿ�����ԤԼ
}

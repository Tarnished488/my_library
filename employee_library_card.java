package my_library;


	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.time.format.DateTimeParseException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class employee_library_card implements library_card {
	    // �ֶΣ�ʹ���շ���������
	    private int borrowCount = 0; // ��ǰ��������
	    private int reservationCount = 0; // ��ǰԤԼ����
	    private int maximumBorrowNumber;
	    private int maximumBorrowTime;
	    private int maximumReservationTime;
	    private int maximumReservationNumber;

	    private LocalDate today = LocalDate.now();
	    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    private List<Reservation> reservations = new ArrayList<>();

	    // �ڲ��ࣺ�洢ԤԼ��¼
	    private static class Reservation {
	        String bookName;
	        LocalDate reservationDate;

	        Reservation(String bookName, LocalDate reservationDate) {
	            this.bookName = bookName;
	            this.reservationDate = reservationDate;
	        }

	        @Override
	        public String toString() {
	            return "Book: " + bookName + ", Reserved for: " +
	                   reservationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	        }
	    }

	    // ���캯������ʼ��Ĭ��ֵ
	    public employee_library_card() {
	        maximumBorrowNumber = 20;
	        maximumBorrowTime = 61;
	        maximumReservationTime = 90; // ���ԤԼʱ�䣨�죩
	        maximumReservationNumber = 10; // ���ԤԼ����
	    }

	    @Override
	    public void reservation_time() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Today is: " + today.format(formatter));
	        System.out.print("Enter book name to reserve: ");
	        String bookName = scanner.nextLine();

	        System.out.print("Enter reservation date (yyyy-MM-dd): ");
	        String inputDate = scanner.nextLine();

	        try {
	            LocalDate reservationDate = LocalDate.parse(inputDate, formatter);

	            // ��֤����
	            if (reservationDate.isBefore(today)) {
	                System.out.println("Error: Reservation date cannot be in the past.");
	            } else if (reservationDate.isAfter(today.plusDays(maximumReservationTime))) {
	                System.out.println("Error: Reservation date cannot be more than " +
	                                   maximumReservationTime + " days in the future.");
	            } else if (reservationCount >= maximumReservationNumber) {
	                System.out.println("Error: Maximum reservation number (" +
	                                   maximumReservationNumber + ") reached.");
	            } else {
	                // ����ԤԼ
	                reservations.add(new Reservation(bookName, reservationDate));
	                reservationCount++;
	                System.out.println("Reservation successful! " + bookName +
	                                   " reserved for: " + reservationDate.format(formatter));
	            }
	        } catch (DateTimeParseException e) {
	            System.out.println("Error: Invalid date format. Please use yyyy-MM-dd.");
	        }
	    }

	    @Override
	    public void reservation_number() {
	        System.out.println("Current reservation number: " + reservationCount);
	        System.out.println("Maximum reservation number: " + maximumReservationNumber);
	        if (!reservations.isEmpty()) {
	            System.out.println("Reservations:");
	            for (Reservation res : reservations) {
	                System.out.println(res);
	            }
	        } else {
	            System.out.println("No reservations found.");
	        }
	    }

	    @Override
	    public void reservation_left_time() {
	        if (reservations.isEmpty()) {
	            System.out.println("No reservations to show remaining time.");
	            return;
	        }

	        for (Reservation res : reservations) {
	            long daysUntilReservation = today.until(res.reservationDate).getDays();
	            System.out.println("Book: " + res.bookName + ", Days until reservation: " + daysUntilReservation);
	        }
	    }

	    @Override
	    public void reservation_left_number() {
	        int remaining = maximumReservationNumber - reservationCount;
	        System.out.println("Remaining reservation slots: " + remaining);
	    }

	    @Override
	    public void borrow_left_number() {
	        int remaining = maximumBorrowNumber - borrowCount;
	        System.out.println("Remaining borrow slots: " + remaining);
	    }

	    @Override
	    public void borrow_left_time() {
	        System.out.println("Maximum borrow time: " + maximumBorrowTime + " days");
	        // ����н��ļ�¼�����Լ���ʣ��黹ʱ�䣨��Ҫ�������ݽṹ��
	    }

	    @Override
	    public void borrow_maximum_number() {
	        System.out.println("The maximum borrow number is: " + maximumBorrowNumber);
	    }

	    @Override
	    public void borrow_maximum_time() {
	        System.out.println("The maximum borrow time is: " + maximumBorrowTime + " days");
	    }

	    // ����������
	    public static void main(String[] args) {
	        StudentLibraryCard card = new StudentLibraryCard();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n=== Employee System ===");
	            System.out.println("1. Reserve a book");
	            System.out.println("2. View reservations");
	            System.out.println("3. View remaining reservation slots");
	            System.out.println("4. View remaining reservation time");
	            System.out.println("5. View maximum borrow number");
	            System.out.println("6. View maximum borrow time");
	            System.out.println("7. Exit");
	            System.out.print("Choose an option: ");

	            String choice = scanner.nextLine();
	            switch (choice) {
	                case "1":
	                    card.reservation_time();
	                    break;
	                case "2":
	                    card.reservation_number();
	                    break;
	                case "3":
	                    card.reservation_left_number();
	                    break;
	                case "4":
	                    card.reservation_left_time();
	                    break;
	                case "5":
	                    card.borrow_maximum_number();
	                    break;
	                case "6":
	                    card.borrow_maximum_time();
	                    break;
	                case "7":
	                    System.out.println("Exiting...");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid option. Try again.");
	           }
	       }
	   }
}

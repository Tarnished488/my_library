package my_library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class employee_library_card extends library_card {
    private int borrowCount = 0;
    private int reservationCount = 0;
    private int maximumBorrowNumber;
    private int maximumBorrowTime;
    private int maximumReservationTime;
    private int maximumReservationNumber;

    private final LocalDate today = LocalDate.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final List<Reservation> reservations = new ArrayList<>();

    // 内部类：预约信息
    private static class Reservation {
        String bookName;
        LocalDate reservationDate;

        Reservation(String bookName, LocalDate reservationDate) {
            this.bookName = bookName;
            this.reservationDate = reservationDate;
        }

        @Override
        public String toString() {
            return "Book: " + bookName + ", Reserved for: " + reservationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }

    public employee_library_card() {
        this.maximumBorrowNumber = 20;
        this.maximumBorrowTime = 61;
        this.maximumReservationTime = 90;
        this.maximumReservationNumber = 10;
    }

    public void reservation_time() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Today is: " + today.format(formatter));
        System.out.print("Enter book name to reserve: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter reservation date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();

        try {
            LocalDate reservationDate = LocalDate.parse(inputDate, formatter);
            if (reservationDate.isBefore(today)) {
                System.out.println("Error: Reservation date cannot be in the past.");
            } else if (reservationDate.isAfter(today.plusDays(maximumReservationTime))) {
                System.out.println("Error: Reservation date cannot exceed " + maximumReservationTime + " days from today.");
            } else if (reservationCount >= maximumReservationNumber) {
                System.out.println("Error: Maximum reservations reached.");
            } else {
                reservations.add(new Reservation(bookName, reservationDate));
                reservationCount++;
                System.out.println("Reservation successful! " + bookName + " reserved for " + reservationDate.format(formatter));
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Use yyyy-MM-dd.");
        }
    }

    public void reservation_number() {
        System.out.println("Current reservation count: " + reservationCount + " / " + maximumReservationNumber);
        if (!reservations.isEmpty()) {
            System.out.println("Reservations:");
            for (Reservation res : reservations) {
                System.out.println(res);
            }
        }
    }

    public void reservation_left_time() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations to show.");
            return;
        }
        for (Reservation res : reservations) {
            long days = today.until(res.reservationDate).getDays();
            System.out.println("Book: " + res.bookName + ", Days left: " + days);
        }
    }

    public void reservation_left_number() {
        int left = maximumReservationNumber - reservationCount;
        System.out.println("Remaining reservation slots: " + left);
    }

    public void borrow_left_number() {
        int left = maximumBorrowNumber - borrowCount;
        System.out.println("Remaining borrow slots: " + left);
    }

    public void borrow_left_time() {
        System.out.println("Maximum borrow time: " + maximumBorrowTime + " days");
        // 如需计算实际剩余时间，请引入借阅记录
    }

    public void borrow_maximum_number() {
        System.out.println("Maximum borrow number: " + maximumBorrowNumber);
    }

    public void borrow_maximum_time() {
        System.out.println("Maximum borrow time: " + maximumBorrowTime + " days");
    }

    // 主方法测试
    public static void main(String[] args) {
        employee_library_card card = new employee_library_card();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Library System ===");
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
                case "1": card.reservation_time(); break;
                case "2": card.reservation_number(); break;
                case "3": card.reservation_left_number(); break;
                case "4": card.reservation_left_time(); break;
                case "5": card.borrow_maximum_number(); break;
                case "6": card.borrow_maximum_time(); break;
                case "7": System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }
}


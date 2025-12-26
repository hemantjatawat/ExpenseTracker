package main;

import dao.ExpenseDAO;
import model.Expense;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {
            System.out.println("\n---- EXPENSE TRACKER ----");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.print("Category: ");
                String category = sc.nextLine();

                System.out.print("Date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                dao.addExpense(new Expense(title, amount, category, date));

            } else if (choice == 2) {
                dao.viewExpenses();
            } else {
                System.out.println("Thank you!");
                break;
            }
        }
    }
}

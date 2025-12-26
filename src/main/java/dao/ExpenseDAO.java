package dao;

import db.DBConnection;
import model.Expense;

import java.sql.*;

public class ExpenseDAO {

    public void addExpense(Expense exp) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO expenses(title, amount, category, expense_date) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, exp.getTitle());
            ps.setDouble(2, exp.getAmount());
            ps.setString(3, exp.getCategory());
            ps.setString(4, exp.getDate());

            ps.executeUpdate();
            System.out.println("Expense Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewExpenses() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM expenses");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getDouble("amount") + " | " +
                        rs.getString("category") + " | " +
                        rs.getDate("expense_date")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package kata05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata05.Model.Histogram;
import kata05.Model.Mail;
import kata05.View.HistogramDisplay;
import kata05.View.MailHistogramBuilder;

public class Kata05 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/US500.db");
                Statement stm = connection.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT email FROM people");
            List<Mail> mailList = new ArrayList<>();
            
            while (rs.next()){
                String email = rs.getString("email");
                mailList.add(new Mail(email));
                System.out.println("Email: " + email);
            }
            Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        
            HistogramDisplay histogramDisplay = new HistogramDisplay(histogram, "HISTOGRAM...");
            histogramDisplay.execute(); 
        }
    }
    
}

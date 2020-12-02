package kata05.View;

import java.util.List;
import kata05.Model.Histogram;
import kata05.Model.Mail;

public class MailHistogramBuilder {

    public static Histogram<String> build(List<Mail> mailList) {
       Histogram<String> histogram = new Histogram<>();
       
        for (Mail mail : mailList) {
            histogram.increment(mail.getDomain());
        }
       
       return histogram;
    }
    
}

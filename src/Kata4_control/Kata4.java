package Kata4_control;

import Kata4_view.HistogramDisplay;
import Kata4_model.Histogram;
import Kata4_model.Mail;
import Kata4_view.MailHistogramBuilder;
import Kata4_view.MailListReader;
import java.util.List;

public class Kata4 {

    public static void main(String[] args) {
        String fileName = new String("email.txt");
        List<Mail> mailList = MailListReader.read(fileName);
        Histogram histogram = MailHistogramBuilder.build(mailList);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram,
                                                                 "Emails",
                                                                 "Ocurrences", 
                                                                 "Custom Title");
        histogramDisplay.execute();
    }
    
}

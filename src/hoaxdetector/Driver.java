/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxdetector;

import hoaxdetector.Models.News;

/**
 *
 * @author ghost
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HoaxDetector hd = new HoaxDetector();
        String tempState = "";
        
        hd.addNews(new News("B01", 96, 74));
        hd.addNews(new News("B02", 36, 85));
        hd.addNews(new News("B03", 63, 43));
        hd.addNews(new News("B04", 82, 90));
        hd.addNews(new News("B05", 71, 25));
        hd.addNews(new News("B06", 79, 81));
        hd.addNews(new News("B07", 55, 62));
        hd.addNews(new News("B08", 57, 45));
        hd.addNews(new News("B09", 40, 65));
        hd.addNews(new News("B10", 57, 45));
        hd.addNews(new News("B11", 77, 70));
        hd.addNews(new News("B12", 68, 75));
        hd.addNews(new News("B13", 60, 70));
        hd.addNews(new News("B14", 82, 90));
        hd.addNews(new News("B15", 40, 85));
        hd.addNews(new News("B16", 80, 68));
        hd.addNews(new News("B17", 60, 72));
        hd.addNews(new News("B18", 50, 95));
        hd.addNews(new News("B19", 100, 18));
        hd.addNews(new News("B20", 11, 99));
        hd.addNews(new News("B21", 58, 63));
        hd.addNews(new News("B22", 68, 70));
        hd.addNews(new News("B23", 64, 66));
        hd.addNews(new News("B24", 57, 77));
        hd.addNews(new News("B25", 77, 55));
        hd.addNews(new News("B26", 98, 64));
        hd.addNews(new News("B27", 91, 59));
        hd.addNews(new News("B28", 50, 95));
        hd.addNews(new News("B29", 95, 55));
        hd.addNews(new News("B30", 27, 79));
        
        hd.checkNews();
        hd.convertNews();
        hd.compareNews();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ID\t|\t\tEmotion\t\t\t|\t\tProvocation\t\t|\t\tHoax\t\t|");
        System.out.println("  \t|---------------------------------------|---------------------------------------|-------------------------------|");
        System.out.println("  \t|  Crisp  |   Low   |  Normal  |  High  |  Crisp  |   Low   |  Normal  |  High  |   Membership   |     State    |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        for (News news : hd.getListNews()) {
            if (news.getHoax().isTrue()) {
                tempState = "YA";
            }else {
                tempState = "TIDAK";
            }
            System.out.println(String.format("%6s%3s", news.getIdNews(), "|") + String.format("%7s%3s", news.getEmotion().getCrispEmotion(), "|") + String.format("%7s%3s", String.format("%.2f", news.getEmotion().getFuzzyLow()), "|") + String.format("%7s%4s", String.format("%.2f", news.getEmotion().getFuzzyNormal()), "|") + String.format("%6s%3s", String.format("%.2f", news.getEmotion().getFuzzyHigh()), "|") + 
                    String.format("%7s%3s", news.getProvocation().getCrispProvocation(), "|") + String.format("%7s%3s", String.format("%.2f", news.getProvocation().getFuzzyLow()), "|") + String.format("%7s%4s", String.format("%.2f", news.getProvocation().getFuzzyNormal()), "|") + String.format("%6s%3s", String.format("%.2f", news.getProvocation().getFuzzyHigh()), "|") + 
                    String.format("%10s%7s", String.format("%.2f", news.getHoax().getMembershipHoax()), "|") + String.format("%9s%6s", tempState, "|"));
        }
//        hd.getListNews().forEach((news) -> {
//            System.out.println(news.getIdNews() +"\t|\t"+ 
//                    news.getEmotion().getCrispEmotion() +" - "+ news.getProvocation().getCrispProvocation() + "\t|\t" +
//                    news.getEmotion().isLow() + " - " + news.getEmotion().isNormal() + " - " + news.getEmotion().isHigh() + "\t|\t" +
//                    String.format("%.2f", news.getEmotion().getFuzzyLow()) + " - " + String.format("%.2f", news.getEmotion().getFuzzyNormal()) + " - " + String.format("%.2f", news.getEmotion().getFuzzyHigh()) + "\t|\t" +
//                    news.getProvocation().isLow() + " - " + news.getProvocation().isNormal() + " - " + news.getProvocation().isHigh() + "\t|\t" +
//                    String.format("%.2f", news.getProvocation().getFuzzyLow()) + " - " + String.format("%.2f", news.getProvocation().getFuzzyNormal()) + " - " + String.format("%.2f", news.getProvocation().getFuzzyHigh()) + "\t|\t" +
//                    String.format("%.2f", news.getHoax().getMembershipHoax()) + "\t" +news.getHoax().isTrue());
//        });
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxdetector.Utils;

import hoaxdetector.Models.Emotion;
import hoaxdetector.Models.Hoax;
import hoaxdetector.Models.News;
import hoaxdetector.Models.Provocation;
import java.util.ArrayList;

/**
 *
 * @author ghost
 */
public interface Operations {
    interface fuzzification {
        public void checkEmotion(Emotion emotion);
        public void checkProvocation(Provocation provocation);
        public void convertEmotion(ArrayList<News> listNews);
        public void convertProvocation(ArrayList<News> listNews);
        
        public double convertEmotionToSecondLow(double crispEmotion);
        public double convertEmotionToFirstNormal(double crispEmotion);
        public double convertEmotionToSecondNormal(double crispEmotion);
        public double convertEmotionToFirstHigh(double crispEmotion);
        
        public double convertProvocationToSecondLow(double crispProv);
        public double convertProvocationToFirstNormal(double crispProv);
        public double convertProvocationToSecondNormal(double crispProv);
        public double convertProvocationToFirstHigh(double crispProv);
        
    }
    
    interface inference {
        public Hoax compareNews(News news);
        public Hoax compareHoax(ArrayList<Hoax> hoaxs);
        public Hoax compareAlliedHoax(ArrayList<Hoax> hoaxs);
        
    }
    
    interface defuzzification {
        public Hoax countYStarSingle(Hoax h);
        public Hoax countYStarMultipe(ArrayList<Hoax> h);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxdetector.Implements;

import hoaxdetector.Models.Emotion;
import hoaxdetector.Models.News;
import hoaxdetector.Models.Provocation;
import hoaxdetector.Utils.Limits;
import hoaxdetector.Utils.Operations;
import java.util.ArrayList;

/**
 *
 * @author ghost
 */
public class Fuzzification implements Operations.fuzzification{

    @Override
    public void checkEmotion(Emotion emotion) {
        if (emotion.getCrispEmotion() >= Limits.EMOTION_LOWEST_LIMIT_LOW
                && emotion.getCrispEmotion() <= Limits.EMOTION_HIGHEST_LIMIT_LOW) {
            emotion.setLow(true);
        }
        if (emotion.getCrispEmotion() >= Limits.EMOTION_LOWEST_LIMIT_NORMAL
                && emotion.getCrispEmotion() <= Limits.EMOTION_HIGHEST_LIMIT_NORMAL) {
            emotion.setNormal(true);
        }
        if (emotion.getCrispEmotion() >= Limits.EMOTION_LOWEST_LIMIT_HIGH
                && emotion.getCrispEmotion() <= Limits.EMOTION_HIGHEST_LIMIT_HIGH) {
            emotion.setHigh(true);
        }
    }

    @Override
    public void checkProvocation(Provocation provocation) {
        if (provocation.getCrispProvocation() >= Limits.EMOTION_LOWEST_LIMIT_LOW
                && provocation.getCrispProvocation() <= Limits.EMOTION_HIGHEST_LIMIT_LOW) {
            provocation.setLow(true);
        }
        if (provocation.getCrispProvocation() >= Limits.EMOTION_LOWEST_LIMIT_NORMAL
                && provocation.getCrispProvocation() <= Limits.EMOTION_HIGHEST_LIMIT_NORMAL) {
            provocation.setNormal(true);
        }
        if (provocation.getCrispProvocation() >= Limits.EMOTION_LOWEST_LIMIT_HIGH
                && provocation.getCrispProvocation() <= Limits.EMOTION_HIGHEST_LIMIT_HIGH) {
            provocation.setHigh(true);
        }
    }

    @Override
    public double convertEmotionToSecondLow(double crispEmotion) {
        return -(crispEmotion - Limits.EMOTION_HIGHEST_LIMIT_LOW)/(Limits.EMOTION_HIGHEST_LIMIT_LOW - Limits.EMOTION_LOWEST_LIMIT_NORMAL);
    }

    @Override
    public double convertEmotionToFirstNormal(double crispEmotion) {
        return (crispEmotion - Limits.EMOTION_LOWEST_LIMIT_NORMAL)/(Limits.EMOTION_HIGHEST_LIMIT_LOW - Limits.EMOTION_LOWEST_LIMIT_NORMAL);
    }
    
    @Override
    public double convertEmotionToSecondNormal(double crispEmotion) {
        return -(crispEmotion - Limits.EMOTION_HIGHEST_LIMIT_NORMAL)/(Limits.EMOTION_HIGHEST_LIMIT_NORMAL - Limits.EMOTION_LOWEST_LIMIT_HIGH);
    }

    @Override
    public double convertEmotionToFirstHigh(double crispEmotion) {
        return (crispEmotion - Limits.EMOTION_LOWEST_LIMIT_HIGH)/(Limits.EMOTION_HIGHEST_LIMIT_NORMAL - Limits.EMOTION_LOWEST_LIMIT_HIGH);
    }
    
//    ----------------------------------------------------
    
    @Override
    public double convertProvocationToSecondLow(double crispProv) {
        return -(crispProv - Limits.PROVOCATION_HIGHEST_LIMIT_LOW)/(Limits.PROVOCATION_HIGHEST_LIMIT_LOW - Limits.PROVOCATION_LOWEST_LIMIT_NORMAL);
    }

    @Override
    public double convertProvocationToFirstNormal(double crispProv) {
        return (crispProv - Limits.PROVOCATION_LOWEST_LIMIT_NORMAL)/(Limits.PROVOCATION_HIGHEST_LIMIT_LOW - Limits.PROVOCATION_LOWEST_LIMIT_NORMAL);
    }

    @Override
    public double convertProvocationToSecondNormal(double crispProv) {
        return -(crispProv - Limits.PROVOCATION_HIGHEST_LIMIT_NORMAL)/(Limits.PROVOCATION_HIGHEST_LIMIT_NORMAL - Limits.PROVOCATION_LOWEST_LIMIT_HIGH);
    }

    @Override
    public double convertProvocationToFirstHigh(double crispProv) {
        return (crispProv - Limits.PROVOCATION_LOWEST_LIMIT_HIGH)/(Limits.PROVOCATION_HIGHEST_LIMIT_NORMAL - Limits.PROVOCATION_LOWEST_LIMIT_HIGH);
    }
    
    
    @Override
    public void convertEmotion(ArrayList<News> listNews) {
        listNews.forEach((news) -> {
            Emotion emotion = news.getEmotion();
            double crisp       = emotion.getCrispEmotion();
            
            if (emotion.isLow()) {
                if (crisp <= Limits.EMOTION_LOWEST_LIMIT_LOW || crisp >= Limits.EMOTION_HIGHEST_LIMIT_LOW) {
                    emotion.setFuzzyLow(0);
                } else if(crisp > Limits.EMOTION_LOWEST_LIMIT_LOW && crisp <=  Limits.EMOTION_LOWEST_LIMIT_NORMAL) {
                    emotion.setFuzzyLow(1);
                } else if(crisp > Limits.EMOTION_LOWEST_LIMIT_NORMAL && crisp < Limits.EMOTION_HIGHEST_LIMIT_LOW){
                    emotion.setFuzzyLow(convertEmotionToSecondLow(crisp));
                    emotion.setFuzzyNormal(convertEmotionToFirstNormal(crisp));
                }
            }
            if (emotion.isNormal()) {
                if (crisp <= Limits.EMOTION_LOWEST_LIMIT_NORMAL || crisp >= Limits.EMOTION_HIGHEST_LIMIT_NORMAL) {
                    emotion.setFuzzyNormal(0);
                } else if(crisp >= Limits.EMOTION_HIGHEST_LIMIT_LOW && crisp <= Limits.EMOTION_LOWEST_LIMIT_HIGH) {
                    emotion.setFuzzyNormal(1);
                } else if(crisp > Limits.EMOTION_LOWEST_LIMIT_HIGH && crisp < Limits.EMOTION_HIGHEST_LIMIT_NORMAL) {
                    emotion.setFuzzyNormal(convertEmotionToSecondNormal(crisp));
                    emotion.setFuzzyHigh(convertEmotionToFirstHigh(crisp));
                }
            }
            if (emotion.isHigh()) {
                if (crisp <= Limits.EMOTION_LOWEST_LIMIT_HIGH || crisp >= Limits.EMOTION_HIGHEST_LIMIT_HIGH) {
                    emotion.setFuzzyHigh(0);
                } else if(crisp >= Limits.EMOTION_HIGHEST_LIMIT_NORMAL && crisp < Limits.EMOTION_HIGHEST_LIMIT_HIGH) {
                    emotion.setFuzzyHigh(1);
                } 
            }
        });
    }

    @Override
    public void convertProvocation(ArrayList<News> listNews) {
        listNews.forEach((news) -> {
            Provocation provocation = news.getProvocation();
            double crisp       = provocation.getCrispProvocation();
            
            if (provocation.isLow()) {
                if (crisp <= Limits.PROVOCATION_LOWEST_LIMIT_LOW || crisp >= Limits.PROVOCATION_HIGHEST_LIMIT_LOW) {
                    provocation.setFuzzyLow(0);
                } else if(crisp > Limits.PROVOCATION_LOWEST_LIMIT_LOW && crisp <  Limits.PROVOCATION_LOWEST_LIMIT_NORMAL) {
                    provocation.setFuzzyLow(1);
                } else if(crisp > Limits.PROVOCATION_LOWEST_LIMIT_NORMAL && crisp < Limits.PROVOCATION_HIGHEST_LIMIT_LOW){
                    provocation.setFuzzyLow(convertProvocationToSecondLow(crisp));
                    provocation.setFuzzyNormal(convertProvocationToFirstNormal(crisp));
                }
            }
            if (provocation.isNormal()) {
                if (crisp <= Limits.PROVOCATION_LOWEST_LIMIT_NORMAL || crisp >= Limits.PROVOCATION_HIGHEST_LIMIT_NORMAL) {
                    provocation.setFuzzyNormal(0);
                } else if(crisp > Limits.PROVOCATION_HIGHEST_LIMIT_LOW && crisp < Limits.PROVOCATION_LOWEST_LIMIT_HIGH) {
                    provocation.setFuzzyNormal(1);
                } else if(crisp > Limits.PROVOCATION_LOWEST_LIMIT_HIGH && crisp < Limits.PROVOCATION_HIGHEST_LIMIT_NORMAL) {
                    provocation.setFuzzyNormal(convertProvocationToSecondNormal(crisp));
                    provocation.setFuzzyHigh(convertProvocationToFirstHigh(crisp));
                }
            }
            if (provocation.isHigh()) {
                if (crisp <= Limits.PROVOCATION_LOWEST_LIMIT_HIGH || crisp >= Limits.PROVOCATION_HIGHEST_LIMIT_HIGH) {
                    provocation.setFuzzyHigh(0);
                } else if(crisp > Limits.PROVOCATION_HIGHEST_LIMIT_NORMAL && crisp < Limits.PROVOCATION_HIGHEST_LIMIT_HIGH) {
                    provocation.setFuzzyHigh(1);
                }
            }
        });
    }

    
    
}

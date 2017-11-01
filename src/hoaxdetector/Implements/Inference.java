/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxdetector.Implements;

import hoaxdetector.Models.Emotion;
import hoaxdetector.Models.Hoax;
import hoaxdetector.Models.News;
import hoaxdetector.Models.Provocation;
import hoaxdetector.Utils.Limits;
import hoaxdetector.Utils.Operations;
import java.util.ArrayList;

/**
 *
 * @author ghost
 */
public class Inference implements Operations.inference{

    Hoax h = new Hoax();
    
    @Override
    public Hoax compareNews(News news) {
        Emotion e = news.getEmotion();
        Provocation p = news.getProvocation();
        ArrayList<Hoax> hoaxs = new ArrayList<>();
        double linguistic;
        boolean isHoax = false;
        
        
        if (e.isLow()) {
            if (p.isLow()) {
                if (e.getFuzzyLow() < p.getFuzzyLow()) {
                    linguistic = e.getFuzzyLow();
                }else {
                    linguistic = p.getFuzzyLow();
                }
                hoaxs.add(new Hoax(linguistic, false));
            }
            if (p.isNormal()) {
                if (e.getFuzzyLow() < p.getFuzzyNormal()) {
                    linguistic = e.getFuzzyLow();
                }else {
                    linguistic = p.getFuzzyNormal();
                }
                hoaxs.add(new Hoax(linguistic, false));
            }
            if (p.isHigh()) {
                if (e.getFuzzyLow() < p.getFuzzyHigh()) {
                    linguistic = e.getFuzzyLow();
                }else {
                    linguistic = p.getFuzzyHigh();
                }
                hoaxs.add(new Hoax(linguistic, true));
            }
        }
        
        if (e.isNormal()) {
            if (p.isLow()) {
                if (e.getFuzzyNormal()< p.getFuzzyLow()) {
                    linguistic = e.getFuzzyNormal();
                }else {
                    linguistic = p.getFuzzyLow();
                }
                hoaxs.add(new Hoax(linguistic, false));
            }
            if (p.isNormal()) {
                if (e.getFuzzyNormal()< p.getFuzzyNormal()) {
                    linguistic = e.getFuzzyNormal();
                }else {
                    linguistic = p.getFuzzyNormal();
                }
                hoaxs.add(new Hoax(linguistic, false));
            }
            if (p.isHigh()) {
                if (e.getFuzzyNormal()< p.getFuzzyHigh()) {
                    linguistic = e.getFuzzyNormal();
                }else {
                    linguistic = p.getFuzzyHigh();
                }
                hoaxs.add(new Hoax(linguistic, true));
            }
        }
        
        if (e.isHigh()) {
            if (p.isLow()) {
                if (e.getFuzzyHigh()< p.getFuzzyLow()) {
                    linguistic = e.getFuzzyHigh();
                }else {
                    linguistic = p.getFuzzyLow();
                }
                hoaxs.add(new Hoax(linguistic, true));
            }
            if (p.isNormal()) {
                if (e.getFuzzyHigh()< p.getFuzzyNormal()) {
                    linguistic = e.getFuzzyHigh();
                }else {
                    linguistic = p.getFuzzyNormal();
                }
                hoaxs.add(new Hoax(linguistic, true));
            }
            if (p.isHigh()) {
                if (e.getFuzzyHigh()< p.getFuzzyHigh()) {
                    linguistic = e.getFuzzyHigh();
                }else {
                    linguistic = p.getFuzzyHigh();
                }
                hoaxs.add(new Hoax(linguistic, true));
            }
        }
        
        Hoax h = compareHoax(hoaxs);
        return h;
//        System.out.println(h.isTrue() + " - " + h.getMembershipHoax());
    }

    @Override
    public Hoax compareHoax(ArrayList<Hoax> hoaxs) {
        Hoax h = new Hoax();
        ArrayList<Hoax> listTrue = new ArrayList<>();
        ArrayList<Hoax> listFalse = new ArrayList<>();
        ArrayList<Hoax> listTemp = new ArrayList<>();
        
        Operations.defuzzification deff = new Defuzzification();
        
        if (hoaxs.size() == 1) {
            h = deff.countYStarSingle(hoaxs.get(0));
        }else if (hoaxs.size() == 2 && 
                (hoaxs.get(0).isTrue() && hoaxs.get(1).isTrue()) || 
                (!hoaxs.get(0).isTrue() && !hoaxs.get(1).isTrue())) {
            if (hoaxs.get(0).getMembershipHoax() > hoaxs.get(1).getMembershipHoax()) {
                h = deff.countYStarSingle(hoaxs.get(0));
            }else{
                h = deff.countYStarSingle(hoaxs.get(1));
            }
            
        }else {
            hoaxs.forEach((hoax) -> {
                if (hoax.isTrue()) {
                    listTrue.add(hoax);
                }else {
                    listFalse.add(hoax);
                }
            });
            listTemp.add(compareAlliedHoax(listTrue));
            listTemp.add(compareAlliedHoax(listFalse));
            h = deff.countYStarMultipe(listTemp);
//            h = compareToThreshold(listTemp);
//            System.out.println(listTemp.size());
        }        
        return h;
    } 

    
    @Override
    public Hoax compareAlliedHoax(ArrayList<Hoax> hoaxs) {
        Hoax hx = hoaxs.get(0);
        for (Hoax hoax : hoaxs) {
             if (hx.getMembershipHoax() < hoax.getMembershipHoax()) {
               hx = hoax;
            }
        }
        return hx;
    }

//    @Override
//    public Hoax compareToThreshold(ArrayList<Hoax> hoaxs) {
//        Hoax h = hoaxs.get(0);
//        double dev = delta(h);
//        for (Hoax hx : hoaxs) {
//            if ((hx.isTrue() || !hx.isTrue()) && dev >= delta(hx) ) {
//                h = hx;
//            }
//            dev = delta(h);
//        }
//        return h;
//    }
//
//    @Override
//    public double delta(Hoax h) {
//        double d = 0;
//        if (h.isTrue()) {
//            d = h.getMembershipHoax() - Limits.THRESHOLD;
//        }else {
//            d = -(h.getMembershipHoax() - Limits.THRESHOLD);
//        }
//        return d;
//    }
    
}

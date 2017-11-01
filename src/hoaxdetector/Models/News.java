/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxdetector.Models;

/**
 *
 * @author ghost
 */
public class News {
    
    private String idNews;
    private Emotion emotion;
    private Provocation provocation;
    private Hoax hoax;

    public News(String idNews, double crispEmotion, double crispProv) {
        this.emotion = new Emotion(crispEmotion);
        this.provocation = new Provocation(crispProv);
        this.hoax = new Hoax();
        this.idNews = idNews;
    }

    public String getIdNews() {
        return idNews;
    }

    public void setIdNews(String idNews) {
        this.idNews = idNews;
    }

    
    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Provocation getProvocation() {
        return provocation;
    }

    public void setProvocation(Provocation provocation) {
        this.provocation = provocation;
    }

    public Hoax getHoax() {
        return hoax;
    }

    public void setHoax(Hoax hoax) {
        this.hoax = hoax;
    }
    
    
}

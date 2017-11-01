/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaxdetector.Utils;

/**
 *
 * @author ghost
 */
public class Limits {
    public static double EMOTION_LOWEST_LIMIT_LOW = 0;
    public static double EMOTION_HIGHEST_LIMIT_LOW = 45;
    public static double EMOTION_LOWEST_LIMIT_NORMAL = 36;
    public static double EMOTION_HIGHEST_LIMIT_NORMAL = 76;
    public static double EMOTION_LOWEST_LIMIT_HIGH = 60;
    public static double EMOTION_HIGHEST_LIMIT_HIGH = 100;
    
    public static double PROVOCATION_LOWEST_LIMIT_LOW = 0;
    public static double PROVOCATION_HIGHEST_LIMIT_LOW = 40;
    public static double PROVOCATION_LOWEST_LIMIT_NORMAL = 25;
    public static double PROVOCATION_HIGHEST_LIMIT_NORMAL = 80;
    public static double PROVOCATION_LOWEST_LIMIT_HIGH = 76;
    public static double PROVOCATION_HIGHEST_LIMIT_HIGH = 100;
    
    
    public static double THRESHOLD = 0.5;
    public static double SUGENO_TRUE = 60;
    public static double SUGENO_FALSE = 20;
}

package model;
import java.text.DecimalFormat;
  
public class Move
{
    private String name;
    private int power;
    private int accuracy;
    private Effect effect;
    private DecimalFormat df = new DecimalFormat("0");

    public Move(String name, int power, int accuracy, Effect effect)
    {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.effect = effect;
    }

    public Move(String name, int power, int accuracy)
    {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.effect = null;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPower()
    {
        return this.power;
    }

    public int getAccuracy()
    {
        return this.accuracy;
    }

    public Effect getEffect()
    {        
        if(!hasEffect())
        {
            return null;
        }
        return this.effect;
    }


    public boolean hasEffect()
    {
        if(effect == null)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public String getSoundFileName()
    {
        String fileName;

        if(!this.hasEffect())
        {
            fileName = "sounds/hit.wav";
        }
        else if(this.getEffect().isBadForDefender())
        {
            fileName = "sounds/effect.wav";
        }
        else
        {
            fileName = "sounds/powerup.wav";
        }

        if(this.getName().equals("Splash"))
        {
            fileName = "sounds/magikarp.wav";
        }

        return fileName;
    }

    public String getToolTipText(Javamon j)
    {
        String message; 
        if(this.hasEffect())
        {
            message = "" + this.getEffect().getToolTipName() + ", Accuracy: " + df.format(this.accuracy * j.getAccuracy()) + "%";
        }
        else
        {
            message = "Power: " + this.power + ", Accuracy: " + df.format(this.accuracy * j.getAccuracy())  + "%";
        }
        return message;
    }
}

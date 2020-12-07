package model;

public class Javamon 
{
    // name
    protected String name;
    protected boolean isPlayer;

    // stats
    private int maxHealth;
    private int currentHealth;
    private int baseAttack;
    private int baseDefense;
    private int baseSpeed;
    private double accuracy;
    private int attackStage;
    private int defenseStage; 
    private int paralyzeTurns;
    private boolean isEmpowered;

    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;

    // image;
    private String imageFileName; //image should be 200x200 pixels
    private String soundFileName;

    public Javamon(String name, int maxHealth, int attack, int defense, int speed, boolean isPlayer)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.baseAttack = (int) (attack*1.6);
        this.baseDefense = defense;
        this.baseSpeed = speed;
        this.attackStage = 0;
        this.defenseStage = 0;
        this.accuracy = 1;
        this.isPlayer = isPlayer;
        soundFileName = null;
        paralyzeTurns = 0;
        
    }

    public String getName()
    {
        return this.name;
    }

    public String getSoundFileName()
    {
        return soundFileName;
    }

    public Boolean isEmpowered()
    {
        return isEmpowered;
    }

    public void setIsEmpowered(boolean b)
    {
        isEmpowered = b;
    }


    public void setSoundFileName(String s)
    {
        soundFileName = s;
    }

    public boolean isParalyzed()
    {
        if(paralyzeTurns>0)
        {
            return true;
        }
        return false;
    }

    public int getParalyzeTurns()
    {
        return paralyzeTurns;
    }

    public void changeParalyzeTurns(int x)
    {
        paralyzeTurns += x;

        if(paralyzeTurns > 3)
        {
            paralyzeTurns = 3;
        }

        if(paralyzeTurns < 0)
        {
            paralyzeTurns = 0;
        }
    }

    public String getImageFileName()
    {
        return imageFileName;
    }

    public String getJavamonName()
    {
        return name;
    }

    public void setHealth(int newHealth)
    {
        this.currentHealth = newHealth;
    }

    public int getCurrentHealth()
    {
        return currentHealth;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void changeHealth(int changeAmount)
    {
        currentHealth += changeAmount;
        if (currentHealth < 0)
        {
            currentHealth = 0;
        }
        if(currentHealth > maxHealth)
        {
            currentHealth = maxHealth;
        }
    }

    public Move getMove1()
    {
        return move1;
    }

    public Move getMove2()
    {
        return move2;
    }

    public Move getMove3()
    {
        return move3;
    }

    public Move getMove4()
    {
        return move4;
    }

    public void setAttackStage(int x)
    {
        this.attackStage = x;
    }

    public void setDefenseStage(int x)
    {
        this.defenseStage = x;
    }

    public int getAttackStage()
    {
        return attackStage;
    }

    public int getDefenseStage()
    {
        return defenseStage;
    }

    public void changeAttackModifier(int x)
    {
        this.attackStage += x;
    }

    public void changeDefenseModifier(int x)
    {
        this.defenseStage += x;
    }

    public void changeAccuracy(double x)
    {
        accuracy += x;
    }

    public double getAccuracy()
    {
        return accuracy;
    }
    
    public int getBaseAttack()
    {
        return baseAttack;
    }

    public int getBaseDefense()
    {
        return baseDefense;
    }

    public int getSpeed()
    {
        return baseSpeed;
    }

    public String toString() {
        return this.getJavamonName() + " has " + this.getCurrentHealth() + " health";
    }

    public boolean getIsPlayer()
    {
        return isPlayer;
    }

    public void setIsPlayer(boolean isPlayer)
    {
        this.isPlayer = isPlayer;
    }

    public String getOwnerName()
    {
        if(isPlayer)
        {
            return "Player";
        }
        else
        {
            return "Rival";
        }
    }

    public void setImageFileName(String s)
    {
        imageFileName = s;
    }

    public String getToolTipText()
    {
        String atkStatus = "";
        String defStatus = "";
        int attackModifier = this.getAttackStage();
        int defenseModifier = this.getDefenseStage();
        if (attackModifier > 0)
        {
            for (int i=0;i<attackModifier;i++)
            {
                atkStatus += "+";
            }
        }
        else if (attackModifier < 0)
        {
            for (int i=attackModifier;i<0;i++)
            {
                atkStatus += "-";
            }
        }
        if (defenseModifier > 0)
        {
            for (int i=0;i<defenseModifier;i++)
            {
                defStatus += "+";
            }
        }
        else if (defenseModifier < 0)
        {
            for (int i=defenseModifier;i<0;i++)
            {
                defStatus += "-";
            }
        }
        return "Attack: " + Rules.getModifiedAttack(this) + atkStatus + ", Defense: " + Rules.getModifiedDefense(this) + defStatus;
    }

    public void setMoves(Move m1, Move m2, Move m3, Move m4)
    {
        move1 = m1;
        move2 = m2;
        move3 = m3;
        move4 = m4;
    }
}

 
package model;

public enum Effect 
{ 
    increaseAttack, increaseDefense, decreaseAttack, decreaseDefense, decreaseAccuracy, leech, nothing, paralyze, empower;

    public boolean isBadForDefender()
    {
        if(this == Effect.decreaseAccuracy || this == Effect.decreaseAttack || this == Effect.leech || this == Effect.decreaseDefense || this == Effect.paralyze)
        {
            return true;
        }

        return false;
    }

    public boolean isGoodForAttacker()
    {
        if(this == Effect.increaseAttack || this == Effect.increaseDefense || this == Effect.leech || this == empower)
        {
            return true;
        }

        return false;
    }



    public String getToolTipName()
    {
        if(this == increaseAttack)
        {
            return "Raises your attack";
        }
        if(this == increaseDefense)
        {
            return "Raises your defence";
        }
        if(this == decreaseAttack)
        {
            return "Lowers their attack";
        }
        if(this == decreaseDefense)
        {
            return "Lowers their defense";
        }
        if(this == decreaseAccuracy)
        {
            return "Decreases their accuracy";
        }
        if(this == leech)
        {
            return "Steals health";
        }
        if(this == paralyze)
        {
            return "Paralyzes your opponent";
        }
        if(this == empower)
        {
            return "Empowers your next move";
        }
        if(this == nothing)
        {
            return "Does nothing";
        }

        return "no desc";
    }


    public String getEffectDescription(int leechDamage)
    {
        //javamon used move... [fill in the rest]

        if(this == increaseAttack)
        {
            return "which increased their attack";
        }
        if(this == increaseDefense)
        {
            return "which increased their defense";
        }
        if(this == decreaseAttack)
        {
            return "which decreased attack of opponent";
        }
        if(this == decreaseDefense)
        {
            return "which decreased defense of opponent";
        }
        if(this == decreaseAccuracy)
        {
            return "which decreased accuracy of opponent";
        }
        if(this == paralyze)
        {
            return "which caused paralysis";
        }
        if(this == leech)
        {
            return "which sapped " + leechDamage + " health from opponent";
        }
        if(this == nothing)
        {
            return "which did absolutely nothing";
        }
        if(this == empower)
        {
            return "which empowered their next move";
        }


        return "no desc";
    }
} 

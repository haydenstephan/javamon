package model;

import java.util.*;


public class Rules {

    public static double empowerMultiplier = 2.3;

    public static double getModifierFromStage(int x)
    {
        // create map from stage (int) to stat modifier (double)
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        map.put(0, 1.0);
        map.put(1, 1.6);
        map.put(2, 2.2);
        map.put(3, 2.6);
        map.put(4, 3.0);
        map.put(5, 3.4);
        map.put(6, 3.8);
        map.put(-1, 0.70);
        map.put(-2, 0.55);
        map.put(-3, 0.45);
        map.put(-4, 0.40);
        map.put(-5, 0.35);
        map.put(-6, 0.30);
        return map.get(x);
    }


    public static Move chooseRivalMove(Javamon player, Javamon rival)
    {
        Random rng = new Random();
        Move rivalMove;

        int randomNumber = rng.nextInt(6);
        if(rival.isEmpowered() || player.isParalyzed()) {
            rivalMove = rival.getMove2();
        } else if(player.getCurrentHealth() < 300 || rival.getCurrentHealth() < 250) {
            rivalMove = rival.getMove1();
        } else if (randomNumber == 0) {
            rivalMove = rival.getMove1();
        } else if (randomNumber == 1) {
            rivalMove = rival.getMove1();
        } else if (randomNumber == 2) {
            rivalMove = rival.getMove2();
        } else if (randomNumber == 3) {
            rivalMove = rival.getMove2();
        } else if (randomNumber == 4) {
            rivalMove = rival.getMove3();
        } else {
            rivalMove = rival.getMove4();
        }

        return rivalMove;
    }

    public static int getModifiedAttack(Javamon j)
    {
        return (int) (  (j.getBaseAttack() * getModifierFromStage(j.getAttackStage())  ));
    }

    public static int getModifiedDefense(Javamon j)
    {
        return (int) (  j.getBaseDefense() * getModifierFromStage(j.getDefenseStage())  );
    }

    public static int getLeechDamage(Javamon attacker, Javamon target)
    {
        int damage = attacker.getBaseAttack() - target.getBaseDefense() + 50;

        if(damage <= 50)
        {
            damage = 50;
        }
        return damage;
    }

    public static int calculateDamageDone(Move move, Javamon attacker, Javamon target) {
        int damage;

        //-----MOVE HAS NO POWER, NO DAMAGE-----//
        if (move.getPower() == 0) {
            damage = 0;
        } 
        
        //-----attack of attacker - defense of defender + power of move-----//
        else 
        {
            damage = (int) (getModifiedAttack(attacker) - getModifiedDefense(target) + move.getPower());

            //-----EMPOWERMENT INCREASES DAMAGE-----//
            if(attacker.isEmpowered())
            {
                damage = (int) (damage * empowerMultiplier);
            }

            //-----DAMAGE SHOULD BE AT LEAST 50-----//
            if (damage < 50) {
                damage = 50;
            }
        }  
        return damage;
    }



    public static boolean isJavamonFaster(Javamon j1, Javamon j2) {
        if (j1.getSpeed() >= j2.getSpeed()) {
            return true;
        }
        return false;
    }


    public static void applyEffect(Move move, Javamon attacker, Javamon target) {

        if (move.getEffect() == Effect.decreaseAttack) {
            if (target.getAttackStage() > -6) {
                target.setAttackStage(target.getAttackStage() - 1);
            }
        } 
        
        else if (move.getEffect() == Effect.decreaseDefense) {
            if (target.getDefenseStage() > -6) {
                target.setDefenseStage(target.getDefenseStage() - 1);
            }
        } 
        
        else if (move.getEffect() == Effect.increaseAttack) {
            attacker.setAttackStage(attacker.getAttackStage() + 1);
            if (attacker.getAttackStage() > 6) {
                attacker.setAttackStage(6);
            }
        } 
        
        else if (move.getEffect() == Effect.increaseDefense) {
            attacker.setDefenseStage(attacker.getDefenseStage() + 1);
            if (attacker.getDefenseStage() > 6) {
                attacker.setDefenseStage(6);
            }
        } 
        
        else if (move.getEffect() == Effect.decreaseAccuracy) {
            if(target.getAccuracy() > 0.50)
            {
                target.changeAccuracy(-0.10);
            }       
        }

        else if (move.getEffect() == Effect.leech) {       
            int damage = getLeechDamage(attacker, target);
            target.changeHealth(-damage);     
            attacker.changeHealth(damage);
        }

        else if (move.getEffect() == Effect.paralyze) {       
            target.changeParalyzeTurns(2);
        }

        else if (move.getEffect() == Effect.empower) {       
            attacker.setIsEmpowered(true);
        }


    }






        
    public static boolean didMovePass(Javamon attacker, Move move) {
        Random rng = new Random();
        int randomNumber = rng.nextInt(100) + 1;

        int accuracyNumber = (int) (attacker.getAccuracy() * move.getAccuracy());

        //increase chances if empowered
        if(attacker.isEmpowered())
        accuracyNumber += 10;

        //the higher the accuracy number the greater chance it will succeed
        if (randomNumber <= accuracyNumber) {
            return true;
        }

        return false;

    }

    /*
     * 
     * Random rng = new Random();
     * 
     * public static boolean criticalHit(Javamon attacker) { int speed =
     * attacker.getSpeed(); double chance = speed / 512; boolean output = false; //
     * if rng between [1,100] > chance => output = true }
     * 
     * // method for decreasing javamon's accuracy? // should accuracy be a javamon
     * attribute? // should stat increasing moves have "accuracy"?
     * 
     * 
     */

}


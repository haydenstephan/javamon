package model;

import java.util.ArrayList;
import java.util.Random;

public class JavamonFactory 
{
    final static int power1 = 130;
    final static int accuracy1 = 90;

    final static int power2 = 170;
    final static int accuracy2 = 80;

    final static int power3 = 250;
    final static int accuracy3 = 70;

    final static int effectAccuracy = 100;

    public static Javamon makePikachu(boolean isPlayer)
    {
        Javamon j = new Javamon("Pikachu", 1000, 48, 40, 140, isPlayer);
        j.setImageFileName("images/javamonImages/Pikachu.png"); 
        j.setSoundFileName("sounds/pikachu.wav"); 
        Move m1 = new Move("Spark", power1, accuracy1);
        Move m2 = new Move("Thunderbolt", power2, accuracy2);
        Move m3 = new Move("Flash", 0, accuracy1, Effect.decreaseAccuracy);
        Move m4 = new Move("Thunder Wave", 0, 60, Effect.paralyze);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeCharmander(boolean isPlayer)
    {
        Javamon j = new Javamon("Charmander",1000,58,50,65, isPlayer);
        if(isPlayer)
        j.setImageFileName("images/javamonImages/Charmander.png"); 
        else
        j.setImageFileName("images/javamonImages/CharmanderFlipped.png"); 
        j.setSoundFileName("sounds/charmander.wav");
        Move m1 = new Move("Ember", power1, accuracy1);
        Move m2 = new Move("Flamethrower", power3, accuracy3);  
        Move m3 = new Move("Roar", 0, effectAccuracy, Effect.increaseAttack);
        Move m4 = new Move("Growl", 0, accuracy1, Effect.decreaseAttack);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeSquirtle(boolean isPlayer)
    {
        Javamon j = new Javamon("Squirtle",1000,50,64,43,isPlayer);
        if(isPlayer)
        j.setImageFileName("images/javamonImages/Squirtle.png"); 
        else
        j.setImageFileName("images/javamonImages/SquirtleFlipped.png"); 
        j.setSoundFileName("sounds/squirtle.wav");
        Move m1 = new Move("Bubble", power1, accuracy1);
        Move m2 = new Move("Water Gun", power2, accuracy2);
        Move m3 = new Move("Rain Dance", 0, 85, Effect.empower);
        Move m4 = new Move("Withdraw", 0, effectAccuracy, Effect.increaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeBulbasaur(boolean isPlayer)
    {
        Javamon j = new Javamon("Bulbasaur",1000,62,65,45,isPlayer);
        j.setImageFileName("images/javamonImages/Bulbasaur.png"); 
        j.setSoundFileName("sounds/bulbasaur.wav");
        Move m1 = new Move("Vine Whip", power1, accuracy1);
        Move m2 = new Move("Solar Beam", power3, accuracy3);
        Move m3 = new Move("Leech Seed", 0, accuracy1, Effect.leech); 
        Move m4 = new Move("Growl", 0, effectAccuracy, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeCharizard(boolean isPlayer)
    {
        Javamon j = new Javamon("Charizard",1000,109,85,100,isPlayer);
        j.setImageFileName("images/javamonImages/Charizard.png");
        j.setSoundFileName("sounds/charizard.wav");
        Move m1 = new Move("Fire Blast", power2, accuracy2);
        Move m2 = new Move("Sky Attack", power3, accuracy3);
        Move m3 = new Move("Seismic Toss", power1, accuracy1);
        Move m4 = new Move("Swords Dance", 0, effectAccuracy, Effect.increaseAttack);
        j.setMoves(m1,m2,m3,m4);
        return j;
    }

    public static Javamon makePidgey(boolean isPlayer)
    {
        Javamon j = new Javamon("Pidgey",1000,35,35,56,isPlayer);
        j.setImageFileName("images/javamonImages/Pidgey.png");      
        Move m1 = new Move("Gust", power1, accuracy1);
        Move m2 = new Move("Sky Attack", power2, accuracy2);
        Move m3 = new Move("Sand Attack", 0, accuracy1, Effect.decreaseAccuracy); 
        Move m4 = new Move("Mud-Slap", power1, accuracy2, Effect.decreaseAccuracy);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeGengar(boolean isPlayer)
    {
        Javamon j = new Javamon("Gengar",1000,130,75,110,isPlayer);
        j.setImageFileName("images/javamonImages/Gengar.png");      
        Move m1 = new Move("Lick", power1, accuracy3, Effect.paralyze);
        Move m2 = new Move("Shadow Ball", power2, accuracy2);
        Move m3 = new Move("Curse", 0, accuracy1, Effect.leech); 
        Move m4 = new Move("Spook", 0, accuracy1, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeHaunter(boolean isPlayer)
    {
        Javamon j = new Javamon("Haunter",1000,110,75,110,isPlayer);
        j.setImageFileName("images/javamonImages/Haunter.png");      
        Move m1 = new Move("Hex", power1, accuracy1, Effect.paralyze);
        Move m2 = new Move("Dark Pulse", power2, accuracy2);
        Move m3 = new Move("Curse", 0, accuracy1, Effect.leech); 
        Move m4 = new Move("Psychic", 0, accuracy1, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeSpearow(boolean isPlayer)
    {
        Javamon j = new Javamon("Spearow",1000,31,31,70,isPlayer);
        j.setImageFileName("images/javamonImages/Spearow.png");        
        Move m1 = new Move("Headbutt", power1, accuracy1);
        Move m2 = new Move("Sky Attack", power2, accuracy2);
        Move m3 = new Move("Leer", 0, accuracy1, Effect.decreaseDefense); 
        Move m4 = new Move("Growl", 0, accuracy1, Effect.decreaseAttack);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeMudkip(boolean isPlayer)
    {
        Javamon j = new Javamon("Mudkip",1000,50,50,40,isPlayer);
        j.setImageFileName("images/javamonImages/Mudkip.png");        
        Move m1 = new Move("Dig", power1, accuracy1);
        Move m2 = new Move("Hydro Pump", power2, accuracy2);
        Move m3 = new Move("Endeavor", 0, effectAccuracy, Effect.leech); 
        Move m4 = new Move("Mud-Slap", power1, accuracy1, Effect.decreaseAccuracy);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeInfernape(boolean isPlayer)
    {
        Javamon j = new Javamon("Infernape",1000,104,71,108,isPlayer);
        j.setImageFileName("images/javamonImages/Infernape.png");        
        Move m1 = new Move("Scratch", power1, accuracy1);
        Move m2 = new Move("Fire Blast", power2, accuracy2);
        Move m3 = new Move("Calm Mind", 0, effectAccuracy, Effect.increaseDefense); 
        Move m4 = new Move("War Drums", 0, 80, Effect.empower);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeUmbreon(boolean isPlayer)
    {
        Javamon j = new Javamon("Umbreon",1000,60,130,65,isPlayer);
        j.setImageFileName("images/javamonImages/Umbreon.png");        
        Move m1 = new Move("Covet", power1, accuracy1);
        Move m2 = new Move("Hyper Beam", power2, accuracy2);
        Move m3 = new Move("Mean Look", 0, 60, Effect.paralyze); 
        Move m4 = new Move("Tail Whip", 0, accuracy1, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeJigglypuff(boolean isPlayer)
    {
        Javamon j = new Javamon("Jigglypuff",1000,45,25,20,isPlayer);
        j.setImageFileName("images/javamonImages/Jigglypuff.png");        
        Move m1 = new Move("Pound", power2, accuracy2);
        Move m2 = new Move("Disable", 0, accuracy1, Effect.decreaseAccuracy);
        Move m3 = new Move("Sing", 0, 75, Effect.paralyze);
        Move m4 = new Move("Charm", 0, accuracy1, Effect.decreaseAttack);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeAbsol(boolean isPlayer)
    {
        Javamon j = new Javamon("Absol",1000,75,60,75,isPlayer);
        j.setImageFileName("images/javamonImages/Absol.png");        
        Move m1 = new Move("Quick Attack", power1, accuracy1);
        Move m2 = new Move("Night Slash", power2, accuracy2);
        Move m3 = new Move("Leer", 0, accuracy1, Effect.decreaseDefense); 
        Move m4 = new Move("Sand Attack", 0, accuracy1, Effect.decreaseAccuracy);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeCubone(boolean isPlayer)
    {
        Javamon j = new Javamon("Cubone",1000,40,50,35,isPlayer);
        j.setImageFileName("images/javamonImages/Cubone.png");    
        Move m1 = new Move("Mud Slap", power1, accuracy2, Effect.decreaseAccuracy);
        Move m2 = new Move("Bonemerang", power2, accuracy2);
        Move m3 = new Move("Growl", 0, effectAccuracy, Effect.decreaseAttack); 
        Move m4 = new Move("Bone Club", power1, accuracy1);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeEevee(boolean isPlayer)
    {
        Javamon j = new Javamon("Eevee",1000,45,65,55,isPlayer);
        j.setImageFileName("images/javamonImages/Eevee.png"); 
        Move m1 = new Move("Bite", power1, accuracy1);
        Move m2 = new Move("Tackle", power2, accuracy2);
        Move m3 = new Move("Tail Whip", 0, accuracy1, Effect.decreaseDefense);
        Move m4 = new Move("Sand Attack", 0, accuracy1, Effect.decreaseAccuracy);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeZubat(boolean isPlayer)
    {
        Javamon j = new Javamon("Zubat",1000,30,40,55,isPlayer);
        j.setImageFileName("images/javamonImages/Zubat.png");    
        Move m1 = new Move("Bite", power1, accuracy1, Effect.decreaseDefense);
        Move m2 = new Move("Air Cutter", power2, accuracy2);
        Move m3 = new Move("Leech Life", 0, accuracy1, Effect.leech);
        Move m4 = new Move("Supersonic", 0, accuracy1, Effect.decreaseAccuracy);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeSnivy(boolean isPlayer)
    {
        Javamon j = new Javamon("Snivy",1000,45,55,63,isPlayer);
        j.setImageFileName("images/javamonImages/Snivy.png"); 
        Move m1 = new Move("Wrap", power1, accuracy1);
        Move m2 = new Move("Leaf Tornado", power2, accuracy2);
        Move m3 = new Move("Leech Seed", 0, accuracy1, Effect.leech);
        Move m4 = new Move("Tail Whip", 0, accuracy1, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeRattata(boolean isPlayer)
    {
        Javamon j = new Javamon("Rattata",1000,25,35,72,isPlayer);
        j.setImageFileName("images/javamonImages/Rattata.png"); 
        Move m1 = new Move("Quick Attack", power1, accuracy1);
        Move m2 = new Move("Hyper Fang", power2, accuracy2);
        Move m3 = new Move("Tail Whip", 0, accuracy1, Effect.decreaseDefense);
        Move m4 = new Move("Bite", 0, accuracy2, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeOshawott(boolean isPlayer)
    {
        Javamon j = new Javamon("Oshawott",1000,63,45,45,isPlayer);
        j.setImageFileName("images/javamonImages/Oshawott.png");    
        Move m1 = new Move("Tackle", power1, accuracy1);
        Move m2 = new Move("Razor Shell", power2, accuracy2);
        Move m3 = new Move("Water Sport", 0, accuracy1, Effect.decreaseAttack);
        Move m4 = new Move("Withdraw", 0, accuracy1, Effect.increaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeFennekin(boolean isPlayer)
    {
        Javamon j = new Javamon("Fennekin",1000,62,60,60,isPlayer);
        j.setImageFileName("images/javamonImages/Fennekin.png");    
        Move m1 = new Move("Scratch", power1, accuracy1);
        Move m2 = new Move("Ember", power2, accuracy2);
        Move m3 = new Move("Sunny Day", 0, accuracy1, Effect.decreaseAccuracy);
        Move m4 = new Move("Howl", 0, 80, Effect.empower);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeCaterpie(boolean isPlayer)
    {
        Javamon j = new Javamon("Caterpie",1000,20,20,45,isPlayer);
        j.setImageFileName("images/javamonImages/Caterpie.png");  
        Move m1 = new Move("Tackle", power1, accuracy1);
        Move m2 = new Move("Bug Bite", power2, accuracy2);
        Move m3 = new Move("String Shot", 0, 80, Effect.paralyze);;
        Move m4 = new Move("Silk Screen", 0, accuracy1, Effect.increaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeLapras(boolean isPlayer)
    {
        Javamon j = new Javamon("Lapras",1000,85,95,60,isPlayer);
        j.setImageFileName("images/javamonImages/Lapras.png"); 
        Move m1 = new Move("Ice Shard", power1, accuracy1);
        Move m2 = new Move("Hydro Pump", power3, accuracy3);
        Move m3 = new Move("Thunder Wave", 0, 60, Effect.paralyze);;
        Move m4 = new Move("Confuse Ray", 0, accuracy1, Effect.decreaseAccuracy);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeGrowlithe(boolean isPlayer)
    {
        Javamon j = new Javamon("Growlithe",1000,61,35,60,isPlayer);
        j.setImageFileName("images/javamonImages/Growlithe.png"); 
        Move m1 = new Move("Bite", power1, accuracy1);
        Move m2 = new Move("Fire Fang", power2, accuracy2);
        Move m3 = new Move("Howl", 0, accuracy1, Effect.increaseAttack);
        Move m4 = new Move("Fire Blast", power3, accuracy3);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeVulpix(boolean isPlayer)
    {
        Javamon j = new Javamon("Vulpix",1000,50,65,65,isPlayer);
        j.setImageFileName("images/javamonImages/Vulpix.png");     
        Move m1 = new Move("Bite", power1, accuracy1);
        Move m2 = new Move("Inferno", power2, accuracy2);
        Move m3 = new Move("Safeguard", 0, accuracy1, Effect.increaseDefense);
        Move m4 = new Move("Tail Whip", 0, accuracy1, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeDoduo(boolean isPlayer)
    {
        Javamon j = new Javamon("Doduo",1000,35,35,75,isPlayer);
        j.setImageFileName("images/javamonImages/Doduo.png");     
        Move m1 = new Move("Peck", power1, accuracy1);
        Move m2 = new Move("Rage", power2, accuracy2);
        Move m3 = new Move("Growl", 0, accuracy1, Effect.decreaseAttack);
        Move m4 = new Move("Sand Attack", 0, accuracy1, Effect.decreaseAccuracy);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makePonyta(boolean isPlayer)
    {
        Javamon j = new Javamon("Ponyta",1000,65,65,90,isPlayer);
        j.setImageFileName("images/javamonImages/Ponyta.png");     
        Move m1 = new Move("Ember", power1, accuracy1);
        Move m2 = new Move("Flare Blitz", power2, accuracy2);;
        Move m3 = new Move("Tail Whip", 0, effectAccuracy, Effect.decreaseDefense);
        Move m4 = new Move("Stomp", power1, accuracy2, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeEkans(boolean isPlayer)
    {
        Javamon j = new Javamon("Ekans",1000,40,54,55,isPlayer);
        j.setImageFileName("images/javamonImages/Ekans.png");     
        Move m1 = new Move("Poison Sting", power1, accuracy1);
        Move m2 = new Move("Sludge Bomb", power3, accuracy3);
        Move m3 = new Move("Screech", 0, accuracy1, Effect.decreaseDefense);
        Move m4 = new Move("Glare", 0, 60, Effect.paralyze);;
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeMagnemite(boolean isPlayer)
    {
        Javamon j = new Javamon("Magnemite",1000,95,55,45,isPlayer);
        j.setImageFileName("images/javamonImages/Magnemite.png");     
        Move m1 = new Move("Spark", power1, accuracy1);
        Move m2 = new Move("Zap Cannon", power2, accuracy2);
        Move m3 = new Move("Thunder Wave", 0, 60, Effect.paralyze);;
        Move m4 = new Move("Supersonic", 0, accuracy1, Effect.decreaseAccuracy);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makePoochyena(boolean isPlayer)
    {
        Javamon j = new Javamon("Poochyena",1000,30,30,35,isPlayer);
        j.setImageFileName("images/javamonImages/Poochyena.png");      
        Move m1 = new Move("Bite", power1, accuracy1);
        Move m2 = new Move("Take Down", power2, accuracy2);
        Move m3 = new Move("Howl", 0, effectAccuracy, Effect.increaseAttack);
        Move m4 = new Move("Tail Whip", 0, accuracy1, Effect.decreaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeMachop(boolean isPlayer)
    {
        Javamon j = new Javamon("Machop",1000,35,35,35,isPlayer);
        j.setImageFileName("images/javamonImages/Machop.png");   
        Move m1 = new Move("Low Kick", power1, accuracy1);
        Move m2 = new Move("Cross Chop", power2, accuracy2);
        Move m3 = new Move("Bulk Up", 0, effectAccuracy, Effect.increaseAttack);
        Move m4 = new Move("Hi Jump Kick", power3, accuracy3);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeGeodude(boolean isPlayer)
    {
        Javamon j = new Javamon("Geodude",1000,30,30,20,isPlayer);
        j.setImageFileName("images/javamonImages/Geodude.png"); 
        Move m1 = new Move("Rock Throw", power1, accuracy1);
        Move m2 = new Move("Earthquake", power3, accuracy3);
        Move m3 = new Move("Sand Attack", 0, accuracy1, Effect.decreaseAccuracy);
        Move m4 = new Move("Harden", 0, accuracy1, Effect.increaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeTorchic(boolean isPlayer)
    {
        Javamon j = new Javamon("Torchic",1000,70,50,45,isPlayer);
        j.setImageFileName("images/javamonImages/Torchic.png"); 
        Move m1 = new Move("Peck", power1, accuracy1);
        Move m2 = new Move("Aerial Ace", power2, accuracy2);
        Move m3 = new Move("Feather Dance", 0, accuracy1, Effect.empower);
        Move m4 = new Move("Growl", 0, accuracy1, Effect.decreaseAttack);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeMagikarp(boolean isPlayer)
    {
        Javamon j = new Javamon("Magikarp",1000,50,20,1,isPlayer);
        if(isPlayer)
        j.setImageFileName("images/javamonImages/MagikarpFlipped.png"); 
        else
        j.setImageFileName("images/javamonImages/Magikarp.png");   
        j.setSoundFileName("sounds/magikarp.wav");
        Move m1 = new Move("Flail", power2, accuracy2);
        Move m2 = new Move("Splash", 0, 100, Effect.nothing);
        Move m3 = new Move("Splash", 0, 100, Effect.nothing);
        Move m4 = new Move("Splash", 0, 100, Effect.nothing);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeKakuna(boolean isPlayer)
    {
        Javamon j = new Javamon("Kakuna",1000,56,37,20,isPlayer);
        j.setImageFileName("images/javamonImages/Kakuna.png"); 
        Move m1 = new Move("Whip", power1, accuracy1);
        Move m2 = new Move("Harden", 0, accuracy1, Effect.increaseDefense);
        Move m3 = new Move("Harden", 0, accuracy1, Effect.increaseDefense);
        Move m4 = new Move("Harden", 0, accuracy1, Effect.increaseDefense);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeRiolu(boolean isPlayer)
    {
        Javamon j = new Javamon("Riolu",1000,25,63,20,isPlayer);
        j.setImageFileName("images/javamonImages/Riolu.png"); 
        Move m1 = new Move("Whip", power1, accuracy1);
        Move m2 = new Move("Force Palm", power2, accuracy2);;
        Move m3 = new Move("Swords Dance", 0, effectAccuracy, Effect.increaseAttack);
        Move m4 = new Move("Whip", power1, accuracy1);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }

    public static Javamon makeFurret(boolean isPlayer)
    {
        Javamon j = new Javamon("Furret",1000,73,38,90,isPlayer);
        j.setImageFileName("images/javamonImages/Furret.png"); 
        Move m1 = new Move("Quick Attack", power1, accuracy1);
        Move m2 = new Move("Sucker Punch", power2, accuracy2);
        Move m3 = new Move("Defense Curl", 0, effectAccuracy, Effect.increaseDefense);
        Move m4 = new Move("Quick Attack", power1, accuracy1);
        j.setMoves(m1, m2, m3, m4);
        return j;
    }


    





    public static Javamon makeRandomJavamon(boolean isPlayer)
    {
        Random rng = new Random();
        ArrayList <Javamon> javamons = new ArrayList<Javamon>();

        javamons.add(makeBulbasaur(isPlayer));
        javamons.add(makeSquirtle(isPlayer));
        javamons.add(makeCharmander(isPlayer));
        javamons.add(makePikachu(isPlayer));
        javamons.add(makeCubone(isPlayer));
        javamons.add(makeEevee(isPlayer));
        javamons.add(makeOshawott(isPlayer));
        javamons.add(makePidgey(isPlayer));
        javamons.add(makeRattata(isPlayer));
        javamons.add(makeSnivy(isPlayer));
        javamons.add(makeZubat(isPlayer));
        javamons.add(makeFennekin(isPlayer));
        javamons.add(makeCaterpie(isPlayer));
        javamons.add(makeLapras(isPlayer));
        javamons.add(makeGrowlithe(isPlayer));
        javamons.add(makeMagikarp(isPlayer));
        javamons.add(makeVulpix(isPlayer));
        javamons.add(makeSpearow(isPlayer));
        javamons.add(makeTorchic(isPlayer));
        javamons.add(makePoochyena(isPlayer));
        javamons.add(makeMachop(isPlayer));
        javamons.add(makeGeodude(isPlayer));
        javamons.add(makeKakuna(isPlayer));
        javamons.add(makeRiolu(isPlayer));
        javamons.add(makeFurret(isPlayer));
        javamons.add(makeGengar(isPlayer));
        javamons.add(makeEkans(isPlayer));
        javamons.add(makeMagnemite(isPlayer));
        javamons.add(makeDoduo(isPlayer));
        javamons.add(makePonyta(isPlayer));
        javamons.add(makeAbsol(isPlayer));
        javamons.add(makeUmbreon(isPlayer));
        javamons.add(makeMudkip(isPlayer));
        javamons.add(makeInfernape(isPlayer));
        javamons.add(makeJigglypuff(isPlayer));
        int randomNumber = rng.nextInt(javamons.size());
        Javamon randomJavamon = javamons.get(randomNumber);

        //return makeTorchic(false);
        return randomJavamon;

        //magikarp mode
        //return makeMagikarp(isPlayer);
    }
    

}

package edu.eci.arsw.highlandersim;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Immortal extends Thread {

    private ImmortalUpdateReportCallback updateCallback = null;

    private int health;

    private int defaultDamageValue;

    private final List<Immortal> immortalsPopulation;

    private final String name;

    private AtomicBoolean isPaused;

    private AtomicBoolean isDead;

    private final Random r = new Random(System.currentTimeMillis());

    public Immortal(String name, List<Immortal> immortalsPopulation, int health, int defaultDamageValue,
            AtomicBoolean isPaused, ImmortalUpdateReportCallback ucb) {
        super(name);
        this.updateCallback = ucb;
        this.name = name;
        this.immortalsPopulation = immortalsPopulation;
        this.health = health;
        this.defaultDamageValue = defaultDamageValue;
        this.isPaused = isPaused;
        this.isDead=new AtomicBoolean(false);
    }

    public void run() {
        while (!isDead.get()) {
            synchronized (isPaused) {
                while (isPaused.get()) {
                    try {
                        isPaused.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            Immortal im;

            synchronized (immortalsPopulation) {
                int myIndex = immortalsPopulation.indexOf(this);

                int nextFighterIndex = r.nextInt(immortalsPopulation.size());

                // avoid self-fight
                if (nextFighterIndex == myIndex) {
                    nextFighterIndex = ((nextFighterIndex + 1) % immortalsPopulation.size());
                }

                im = immortalsPopulation.get(nextFighterIndex);

                this.fight(im);
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void fight(Immortal i2) {

        if (i2.getHealth() > 0) {
            i2.changeHealth(i2.getHealth() - defaultDamageValue);
            this.health += defaultDamageValue;
            updateCallback.processReport("Fight: " + this + " vs " + i2 + "\n");
        } else {
            i2.stopFight();
            updateCallback.processReport(this + " says:" + i2 + " is already dead!\n");
        }

    }

    public void changeHealth(int v) {
        health = v;
    }

    public int getHealth() {
        return health;
    }

    public void stopFight(){
        isDead.set(true);
    }

    @Override
    public String toString() {

        return name + "[" + health + "]";
    }

}

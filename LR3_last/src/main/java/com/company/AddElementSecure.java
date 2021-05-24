package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AddElementSecure {

    private ArrayList<Drink> d;
    private int index = 0;
    int r = 0;

    ApplicationContext context = new AnnotationConfigApplicationContext("com.company");

    Tea tea = context.getBean("tea", Tea.class);
    Coffee coffee = context.getBean("coffee", Coffee.class);

    int Presets[][] =
            {
                    {1, 0, 0},
                    {1, 1, 1},
                    {2, 4, 5},
                    {0, 0, 0},
                    {0, 1, 1},
                    {1, 0, 2}
            };

    private final int n = 8;
    private final Lock l = new ReentrantLock();
    private final Semaphore free = new Semaphore(n);
    private final Semaphore full = new Semaphore(n);

    public AddElementSecure(ArrayList<Drink> d)
    {
        super();
        this.d = d;
    }

    public void add() {
        try {
            free.acquire();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            //e1.printStackTrace();
            Thread.currentThread().interrupt();
        }
        l.lock();
        try {
            //Write your code here

            switch (index)
            {
                case (0):
                    d.add(tea.getTea());
                    r = (int)(Math.random()*(3));
                    System.out.println("(Tea) Current thread id:" +  Thread.currentThread().getId() + " |Preset: " + r);
                    d.get(d.size() - 1).AddConfig(Presets[r]);
                    index = 1;
                    break;

                case (1):
                    d.add(coffee.getCoffee());
                    r = (int)(Math.random()*(3))+3;
                    System.out.println("(Coffee) Current thread id:" +  Thread.currentThread().getId() + " |Preset: " + r);
                    d.get(d.size() - 1).AddConfig(Presets[r]);
                    index = 0;
                    break;
            }

        } catch (Exception e) {
        } finally {
            l.unlock();
        }
        full.release();
    }
}

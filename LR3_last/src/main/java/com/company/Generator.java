package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class Generator implements Runnable {

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

    public Generator(ArrayList<Drink> d)
    {
        super();
        this.d = d;
    }

    @Override
    public void run() {
        while (true) {
            // Проверяем, был ли получен сигнал на прерывание потока, если да, то выходим
            // из цикла и завершаем работу потока
            if (Thread.currentThread().isInterrupted()) break;

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

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Проверяем, был ли получен сигнал на прерывание потока, если да, то
                //выходим из цикла и завершаем работу потока
                break;
            }
        }
    }
}

package com.company;

import java.util.concurrent.TimeUnit;

public class FillGlass implements Runnable
{
    public static class Glass {
        void Fill()
        {
            FirstFill();

            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {}

            SecondFill();

            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {}

            ThirdFill();
        }

        void FirstFill()
        {
            System.out.print("\n|    |\n" +
                    "|    |\n" +
                    "|    |\n" +
                    "+----+\n\n");
        }

        void SecondFill()
        {
            System.out.print("|    |\n" +
                    "|____|\n" +
                    "|####|\n" +
                    "+----+\n\n");
        }

        void ThirdFill()
        {
            System.out.print("|____|\n" +
                    "|####|\n" +
                    "|####|\n" +
                    "+----+\n\n");
        }
    }

    @Override
    public void run() {
        Glass glass = new Glass();
        glass.Fill();
//        while (true) {
//            // Проверяем, был ли получен сигнал на прерывание потока, если да, то выходим
//            // из цикла и завершаем работу потока
//            if (Thread.currentThread().isInterrupted()){
//                break;
//            }
//
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                // Проверяем, был ли получен сигнал на прерывание потока, если да, то
//                //выходим из цикла и завершаем работу потока
//                break;
//            }
//        }
    }
}


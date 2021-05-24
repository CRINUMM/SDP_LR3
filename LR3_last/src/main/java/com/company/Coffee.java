package com.company;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Component("coffee")
public class Coffee implements Drink {
    int Sugar = 0;
    String Producer = "None";
    int Milk = 0;

    String path = "C:\\Users\\CRINUM\\Desktop\\Java\\LR3\\src\\main\\java\\com\\company\\coffee.txt";

    Scanner cin = new Scanner(System.in);
    Scanner cin2 = new Scanner(System.in);

    public Coffee getCoffee()
    {
        return new Coffee();
    }

    public void AddConfig(int[] c)
    {
        IndividMethod(c[0]);
        ChooseProducer(c[1]);
        AddSugar(c[2]);
    }

    //Метод выбора производителя
    public void ChooseProducer(int c)
    {
        Producer = returnProducer(c);
    };

    //Метод добавления сахара
    public void AddSugar(int c)
    {
        Sugar = c;
    };

    //Метод расчета стоимости
    public int CalculateCost() {
        int res = 0;
        String temp = "0";

        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {

                if (line.contains(Producer))
                {
                    temp = line.substring(line.indexOf('-') + 1);
                    break;
                }
                line = reader.readLine();
            }
            res += Integer.parseInt(temp);
            res += Sugar + Milk * 20;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    //Индивидуальные методы класса
    public void IndividMethod(int c) {
        switch (c) {
            case (1):
                Milk = 1;
                break;
            case (0):
                Milk = 0;
                break;
            default:
                break;
        }
    }

    //Метод поиска производителя
    private void findProducer() {
        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            int n = 0;
            String line = reader.readLine();
            while (line != null)
            {
                int end = line.indexOf('-');

                System.out.println(n + ". " + line.substring(0, end));
                line = reader.readLine();
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод, возвращающий имя производителя
    private String returnProducer(int a) {
        String res = "0";

        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            int n = 0;
            while (line != null)
            {
                if (n == a) {
                    int end = line.indexOf('-');
                    res = line.substring(0, end);

                    break;
                }

                line = reader.readLine();
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    //Метод вывода заказа
    public void PrintOrder() {
        if (Milk == 1) {
            System.out.println("Coffee with milk, " + Producer + ", Sugar: " + Sugar);
        } else {
            System.out.println("Coffee without milk, " + Producer + ", Sugar: " + Sugar);
        }
        System.out.print("..........\n");
    }
}

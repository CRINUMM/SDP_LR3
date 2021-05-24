package com.company;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Component("tea")
public class Tea implements Drink {
    int Sugar = 0;
    String Producer = "None", Type = "None";

    String path = "C:\\Users\\CRINUM\\Desktop\\Java\\LR3_last\\src\\main\\java\\com\\company\\tea.txt";

    Scanner cin = new Scanner(System.in);
    Scanner cin2 = new Scanner(System.in);

    public Tea getTea()
    {
        return new Tea();
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
    public int CalculateCost()
    {
        int res = 0;
        String temp = "0", name;

        name = Type + "_" + Producer;

        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {

                if (line.contains(name))
                {
                    temp = line.substring(line.indexOf('-') + 1);
                    break;
                }
                line = reader.readLine();
            }
            res += Integer.parseInt(temp);
            res += Sugar;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    };

    //Индивидуальные методы класса
    public void IndividMethod(int c)
    {
        switch (c)
        {
            case (1):
                Type = "green";
                break;
            case (2):
                Type = "black";
                break;
            default:
                break;
        }
    };

    //Метод поиска производителя
    private void findProducer(String s)
    {
        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            int n = 0;
            while (line != null) {
                if (line.contains(s))
                {
                    int begin = line.indexOf('_') + 1;
                    int end = line.indexOf('-');

                    System.out.println(n + ". " + line.substring(begin, end));
                }
                line = reader.readLine();
                n++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    };

    //Метод, возвращающий имя производителя
    private String returnProducer(int a)
    {
        String res = "0";
        try {
            File file = new File(path);

            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            int n = 0;
            while (line != null) {
                if (n == a)
                {
                    int begin = line.indexOf('_') + 1;
                    int end = line.indexOf('-');

                    res = line.substring(begin, end);
                    break;
                }

                line = reader.readLine();
                n++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    };

    //Метод вывода заказа
    public void PrintOrder()
    {
        System.out.println(Type + " tea, " + Producer + ", Sugar: " + Sugar);
        System.out.print("..........\n");
    };
}

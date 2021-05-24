package com.company;

import org.springframework.stereotype.Component;

//Интерфейс напитки
@Component
public interface Drink{

    public void ChooseProducer(int c);
    public void AddSugar(int c);
    public int CalculateCost();
    public void IndividMethod(int c);
    public void PrintOrder();
    public void AddConfig(int[] c);

}

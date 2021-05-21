package com.company;

import org.springframework.stereotype.Component;

//Интерфейс напитки
@Component
public interface Drink extends Product{

    public void ChooseProducer();
    public void AddSugar();
    public int CalculateCost();
    public void ChangeConfiguration();
    public void IndividMethods();
    public void PrintOrder();

}

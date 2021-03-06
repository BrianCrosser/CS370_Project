package com.example.lisa.shakennotstirred.models;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Brian on 10/23/2015.
 */


public class CalculatorModel {

    public int weight;
    private Date beginTime;
    public double man = .73;
    public double woman = .66;
    public int shots;
    public int beers;
    public int wine;


    public void CalculatorModel(){
        shots = 0;
        beers = 0;
        wine = 0;
    }


    public void setWeight(String inputWeight)
    {
        weight = Integer.parseInt(inputWeight);
    }

    public void startTimer()
    {
        beginTime = new Date();
    }

    public double getGender(String gender)
    {
        if(Objects.equals(gender, "Male"))
            return man;
        else
            return woman;
    }

    public double getConsumptionTime()
    {
        Date currentTime = new Date();
        return currentTime.getTime() - beginTime.getTime();
    }

    public double totalConsumed()
    {
        // Still need to implement
        return 2;
    }

    public double getBAC(String gender)
    {
        return (totalConsumed() * 5.15 / weight * getGender(gender)) - .015 * getConsumptionTime();
    }

    public int getShotCount()
    {
        return shots;
    }

    public int getBeerCount()
    {
        return shots;
    }

    public int getWineCount()
    {
        return shots;
    }

    public void addShot() {
        shots += 1;
    }

    public void addWine() { wine += 1; }

    public void addBeer() {
        beers += 1;
    }

    public void subShot() {
        if (shots > 0)
            shots -= 1;
    }

    public void subWine() {
        if (wine > 0)
            wine -= 1;
    }

    public void subBeer() {
        if (beers > 0)
            beers -= 1;
    }


}

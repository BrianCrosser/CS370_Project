package com.example.lisa.shakennotstirred.models;

import java.util.Date;

/**
 * Created by Brian on 10/23/2015.
 */
public class CalculatorModel {
    private int weight;
    private Date beginTime;
    private final double man = .73;
    private final double woman = .66;
    private int shots = 0;
    private int beers = 0;
    private int wine = 0;


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
        if(gender == "Male")
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

    public void addShot() {shots++;}

    public void addWine() {wine++;}

    public void addBeer() {beers++;}

    public void subShot() {shots--;}

    public void subWine() {wine--;}

    public void subBeer() {beers--;}


}

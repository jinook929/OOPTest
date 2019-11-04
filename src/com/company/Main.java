package com.company;

class Hamburger {
    private String name;
    private String breadRollType;
    private String meat;
    private boolean lettuce;
    private boolean tomato;
    private boolean carrot;
    private boolean cheese;
    private int totalAdditions = 0;
    private double price;

    public Hamburger(String name, String breadRollType, String meat, double price) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeat() {
        return meat;
    }

    public int getTotalAdditions() {
        return totalAdditions;
    }

    public double getPrice() {
        return price;
    }

    public void addTotalAdditions() {
        this.totalAdditions++;
    }

    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
        if(this.lettuce) {
            this.addTotalAdditions();
        }
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
        if(this.tomato) {
            this.addTotalAdditions();
        }
    }

    public void setCarrot(boolean carrot) {
        this.carrot = carrot;
        if(this.carrot) {
            this.addTotalAdditions();
        }
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
        if(this.cheese) {
            this.addTotalAdditions();
        }
    }

    public double totalPrice() {
        this.price += (totalAdditions * 0.50);
        return this.price;
    }
}

class HealthyBurger extends Hamburger {

    private boolean onion;
    private boolean mushroom;

    public HealthyBurger(String meat) {
        super("Bills Healthy Burger", "Brown Rye Bread Roll", meat, 2.75);
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
        if(this.onion) {
            super.addTotalAdditions();
        }
    }

    public void setMushroom(boolean mushroom) {
        this.mushroom = mushroom;
        if(this.mushroom) {
            super.addTotalAdditions();
        }
    }
}

class DeluxBurger extends Hamburger {

    private boolean chips;
    private boolean drinks;

    public DeluxBurger(String breadRollType, String meat) {
        super("Bills Burger Delux", breadRollType, meat, 2.50);
        this.chips = true;
        if(this.chips) {
            super.addTotalAdditions();
        }
        this.drinks = true;
        if(this.drinks) {
            super.addTotalAdditions();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Bills Burger", "White Bread", "Beef", 2.50);
//        hamburger.setLettuce(true);
        System.out.println(hamburger.getName() + " w/ " + hamburger.getTotalAdditions() + " additions : $" + hamburger.totalPrice());

        HealthyBurger healthyBurger = new HealthyBurger("Fish");
        healthyBurger.setMushroom(true);
        healthyBurger.setMushroom(true);
        System.out.println(healthyBurger.getName() + " w/ " + hamburger.getTotalAdditions() + " additions : $" + healthyBurger.totalPrice());

        DeluxBurger deluxBurger = new DeluxBurger("Wheat Bread", "Chicken");
        deluxBurger.setLettuce(true);
        deluxBurger.setTomato(true);
        deluxBurger.setCheese(true);
        System.out.println(deluxBurger.getName() + " w/ " + (deluxBurger.getTotalAdditions() - 2) + " additions : $" + deluxBurger.totalPrice());
    }
}

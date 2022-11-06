package com.example.casino_tcuik;

public class lider_spisok {
    String name_lider;
    int image;
    int money;

    public lider_spisok(int image, String name, int money){
        this.image = image;
        this.name_lider = name;
        this.money = money;
    }

    public int getImage(){ return this.image;}
    public void SetImage(int image){ this.image = image;}

    public String getName_lider(){ return this.name_lider;}
    public void SetName_lider(String name_lider){ this.name_lider = name_lider;}

    public int getMoney(){ return this.money;}
    public void SetMoney(int money){ this.money = money;}
}

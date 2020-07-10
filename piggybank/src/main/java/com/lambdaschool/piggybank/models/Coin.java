package com.lambdaschool.piggybank.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "coins")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long coinid;
    String name;
    String namepural;
    double value;
    int quantity;

    public Coin(String name, String namepural, double value, int quantity) {
        this.name = name;
        this.namepural = namepural;
        this.value = value;
        this.quantity = quantity;
    }

    public Coin() {
    }

    public long getCoinid() {
        return coinid;
    }

    public void setCoinid(long coinid) {
        this.coinid = coinid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamepural() {
        return namepural;
    }

    public void setNamepural(String namepural) {
        this.namepural = namepural;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return quantity * value;
    }

    @Override
    public String toString() {
        return "coin{" +
                "coinid=" + coinid +
                ", name='" + name + '\'' +
                ", namepural='" + namepural + '\'' +
                ", value=" + value +
                ", quantity=" + quantity +
                '}';
    }
}

package com.adarga.web.data;

import java.util.Map;
import java.util.Objects;

public class OrderItem {
    private String itemname;
    private String itemcount;
    private String totalcost;

    public OrderItem(Map<String, String> itemMap) {
        this.itemname = itemMap.get("itemname");
        this.itemcount = itemMap.get("itemcount");
        this.totalcost = itemMap.get("totalcost");
    }


    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemcount() {
        return itemcount;
    }

    public void setItemcount(String itemcount) {
        this.itemcount = itemcount;
    }

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "itemname='" + itemname + '\'' +
                ", itemcount='" + itemcount + '\'' +
                ", totalcost='" + totalcost + '\'' +
                '}';
    }

    public OrderItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return getItemname().equals(orderItem.getItemname()) && getItemcount().equals(orderItem.getItemcount()) && getTotalcost().equals(orderItem.getTotalcost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemname(), getItemcount(), getTotalcost());
    }
}

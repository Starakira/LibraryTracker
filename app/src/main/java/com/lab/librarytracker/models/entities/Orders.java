package com.lab.librarytracker.models.entities;

import com.lab.librarytracker.helper.DateConverter;

import java.io.Serializable;
import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(foreignKeys = {
        @ForeignKey(entity = Users.class, parentColumns = "id", childColumns = "userId"),
        @ForeignKey(entity = Copies.class, parentColumns = "id", childColumns = "copyId")
})
@TypeConverters(DateConverter.class)
public class Orders implements Serializable {

    @PrimaryKey(autoGenerate = true)
        private int id = 0;

    @ColumnInfo(name = "userId")
    private int orderUserId = 0;

    @ColumnInfo(name = "copyId")
    private int orderCopyId = 0;

    @ColumnInfo (name = "orderDate")
    private Date orderDate;

    @ColumnInfo (name = "returnDate")
    private Date returnDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(int orderUserId) {
        this.orderUserId = orderUserId;
    }

    public int getOrderCopyId() {
        return orderCopyId;
    }

    public void setOrderCopyId(int orderCopyId) {
        this.orderCopyId = orderCopyId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

package com.lab.librarytracker.models.relations;

import com.lab.librarytracker.models.entities.Copies;
import com.lab.librarytracker.models.entities.Orders;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class CopiesWithOrders {
    @Embedded
    public Copies copies;

    @Relation(parentColumn = "id", entityColumn = "copyId")
    public List<Orders> copyOrders;
}

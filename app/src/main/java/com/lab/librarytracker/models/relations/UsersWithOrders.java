package com.lab.librarytracker.models.relations;

import com.lab.librarytracker.models.entities.Orders;
import com.lab.librarytracker.models.entities.Users;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UsersWithOrders {
    @Embedded
    public Users users;

    @Relation(parentColumn = "id", entityColumn = "userId")
    public List<Orders> userOrders;
}

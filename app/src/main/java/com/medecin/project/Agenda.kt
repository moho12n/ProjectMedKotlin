package com.medecin.project

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date


@Entity(tableName = "Team")
data class Agenda(
    @PrimaryKey
    var id_agenda:Int,
    var patient : Int,
    val medecin : Int,
    val date: Date
)
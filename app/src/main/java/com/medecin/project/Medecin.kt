package com.medecin.project

import androidx.room.Entity
import androidx.room.PrimaryKey

import androidx.room.ForeignKey
import java.sql.Time

@Entity(tableName = "Player", foreignKeys = arrayOf(ForeignKey(entity =
Agenda::class, parentColumns = arrayOf("id_agenda"),
    childColumns = arrayOf("id_agenda"),
    onDelete = ForeignKey.CASCADE)))
data class Medecin (
    val full_name : String,
    val commune : String,
    val specialite : String,
    val localisation : String,
    val heure_ouverture : Time,
    val heure_fermeture : Time
){
    @PrimaryKey (autoGenerate = true)
    var phone : Int?=null
}
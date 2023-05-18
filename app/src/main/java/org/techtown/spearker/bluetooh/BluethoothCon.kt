package org.techtown.spearker.bluetooh

class BluethoothCon {
    var statusBlue: Boolean = false

    fun connection(): Boolean{
        statusBlue = true
        return statusBlue
    }

    fun disconnection() : Boolean {
        statusBlue = false
        return statusBlue
    }
}
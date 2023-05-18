package org.techtown.spearker.type

interface BluetoothSpeaker : Speaker {

    fun connect()
    fun disconnect()
}
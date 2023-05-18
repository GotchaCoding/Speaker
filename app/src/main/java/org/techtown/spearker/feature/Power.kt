package org.techtown.spearker.feature

class Power() {

    var isOn: Boolean = false

    fun pushOnOff(): Boolean {
        isOn = !isOn
        return isOn
    }

}
package org.techtown.spearker.feature

class Player {

    var isPlay: Boolean = false

    fun start() {
        isPlay = true
    }

    fun pause() {
        isPlay = false
    }

}
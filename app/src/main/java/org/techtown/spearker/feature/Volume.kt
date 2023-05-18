package org.techtown.spearker.feature

class Volume() {

    var size: Int = 10  //상한 30, 하한 0

    fun volumeUp(): Int {
        size += 1

        if (size == 21) {
            size = 20  // Max 는 20
        }
        return size
    }

    fun volumeDown(): Int {
        size -= 1

        if(size == -1) {  //Min 0
            size = 0
        }
        return size
    }

}
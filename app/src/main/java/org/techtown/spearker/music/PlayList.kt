package org.techtown.spearker.music

import org.techtown.spearker.music.Music

class PlayList() {
    val song1: Music = Music(title = "OMG", singer = "뉴진스")
    val song2: Music = Music(title = "사건의지평선", singer = "윤하")
    val song3: Music = Music(title = "캔디", singer = "NCT")
    val song4: Music = Music(title = "꽃", singer = "지수")
    val song5: Music = Music(title = "손오공", singer = "세븐틴")


    val musicList: List<Music> = listOf(song1, song2, song3, song4, song5)
}
package org.techtown.spearker

import android.util.Log
import org.techtown.spearker.bluetooh.BluethoothCon
import org.techtown.spearker.feature.Player
import org.techtown.spearker.feature.Power
import org.techtown.spearker.feature.Volume
import org.techtown.spearker.music.PlayList
import org.techtown.spearker.type.BluetoothSpeaker

class BlutoothSpeaker(
    val playList: PlayList,
    val volume: Volume,
    val power: Power,
    val player: Player,
    val bluethoothCon: BluethoothCon,
) : BluetoothSpeaker {

    var nowSong: Int = 0


    override fun connect() {
        bluethoothCon.connection()
        Log.e("kmh", "블루투스가 연결되었습니다.")
    }

    override fun disconnect() {
        bluethoothCon.disconnection()
        Log.e("kmh", "블루투스가 연결이 해지되었습니다.")
    }

    override fun power() {
        power.pushOnOff()
        if (power.isOn) {
            Log.e("kmh", "전원을 킵니다.")
        } else Log.e("kmh", "전원을 끕니다.")
    }

    override fun volumeUp() {
        volume.volumeUp()
        Log.e("kmh", "현재 볼륨은 ${volume.size} 입니다. ")
    }

    override fun volumeDown() {
        volume.volumeDown()
        Log.e("kmh", "현재 볼륨은 ${volume.size} 입니다. ")
    }

    fun pressPlayOrPause() {
        if (player.isPlay) {
            player.pause()
            Log.e("kmh", "${playList.musicList[nowSong]}곡을 재생 합니다")
        } else {
            player.start()
            Log.e("kmh", "일시정지 합니다.")
        }
    }

    override fun nextSong() {
        if (nowSong + 1 < playList.musicList.size) {
            nowSong++
            if (player.isPlay) {
                Log.e("kmh", "${playList.musicList[nowSong]}곡을 재생 합니다")
            } else {
                Log.e("kmh", "일시정지 합니다.")
            }
        } else {
            Log.e("kmh", "다음 곡이 없습니다.")
        }
    }


}


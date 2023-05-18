package org.techtown.spearker

import android.os.Bundle
import androidx.activity.ComponentActivity
import org.techtown.spearker.bluetooh.BluethoothCon
import org.techtown.spearker.databinding.ActivityMainBinding
import org.techtown.spearker.feature.Player
import org.techtown.spearker.feature.Power
import org.techtown.spearker.feature.Volume
import org.techtown.spearker.music.PlayList

class MainActivity : ComponentActivity() {

    private val bluetootheSpeaker = BlutoothSpeaker(
       playList = PlayList(),
       bluethoothCon = BluethoothCon(),
       player = Player(),
       volume = Volume(),
       power = Power(),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            power.setOnClickListener {
                bluetootheSpeaker.power()
                if (bluetootheSpeaker.power.isOn) {
                    tvMessege.text = "전원이 켜졌습니다."
                } else tvMessege.text = "전원이 꺼졋습니다."
            }

            minus.setOnClickListener {
                if (bluetootheSpeaker.power.isOn) {
                    bluetootheSpeaker.volumeDown()
                    tvMessege.text = "현재 볼륨은 ${bluetootheSpeaker.volume.size} 입니다."
                }
            }
            plus.setOnClickListener {
                if (bluetootheSpeaker.power.isOn) {
                    bluetootheSpeaker.volumeUp()
                    tvMessege.text = "현재 볼륨은 ${bluetootheSpeaker.volume.size} 입니다."
                }
            }
            play.setOnClickListener {
                if (bluetootheSpeaker.power.isOn) {
                    bluetootheSpeaker.pressPlayOrPause() //전원시만 작동

                    try {
                        if (bluetootheSpeaker.player.isPlay) { //플레이중에만 곡변경
                            tvMessege.text =
                                "${bluetootheSpeaker.playList.musicList[bluetootheSpeaker.nowSong]}곡을 재생 합니다"
                        } else tvMessege.text = "일시정지 합니다."
                    } catch (e: Exception) {
                        bluetootheSpeaker.nowSong = 0
                        if (bluetootheSpeaker.player.isPlay) {
                            tvMessege.text =
                                "${bluetootheSpeaker.playList.musicList[bluetootheSpeaker.nowSong]}곡을 재생 합니다"
                        } else tvMessege.text = "일시정지 합니다."
                    }
                }
            }
            play.setOnLongClickListener {
                if (bluetootheSpeaker.power.isOn) {
                    bluetootheSpeaker.nextSong()

                    try {
                        if (bluetootheSpeaker.player.isPlay) { //플레이중에만 곡변경
                            tvMessege.text =
                                "${bluetootheSpeaker.playList.musicList[bluetootheSpeaker.nowSong]}곡을 재생 합니다"
                        } else tvMessege.text = "일시정지 합니다."
                    } catch (e: Exception) {
                        bluetootheSpeaker.nowSong = 0
                        if (bluetootheSpeaker.player.isPlay) {
                            tvMessege.text =
                                "${bluetootheSpeaker.playList.musicList[bluetootheSpeaker.nowSong]}곡을 재생 합니다"
                        } else tvMessege.text = "일시정지 합니다."
                    }
                }
                true // false 이면  숏클릭이랑 같이 실행됨. 이벤트 둘다 받음. true로 해야 동시실행 안됌 .

            }

        }

    }
}

package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel (finalScore: Int ): ViewModel() {

    private var score = MutableLiveData<Int>()
        val ldScore : LiveData<Int>
            get() = score
    private var eventPlayAgain = MutableLiveData<Boolean>()
        val ldEventPlayAgain : LiveData<Boolean>
            get() = eventPlayAgain

    init {
        score.value = finalScore
        eventPlayAgain.value = false
        Log.i("ScoreViewModel", "final score $finalScore")
    }

    fun setEventPlayAgain(bool : Boolean ){
        eventPlayAgain.value = bool
    }

//    fun getScore() : LiveData<Int> {
//        return ldScore
//    }

    fun getEventPlayAgain() : LiveData<Boolean>{
        return ldEventPlayAgain
    }

}

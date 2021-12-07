package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    // The current word
    private var word = MutableLiveData<String>()
    val ldWord :LiveData<String>
        get() = word

    // The current score
    private val score = MutableLiveData<Int>()
    val ldScore : LiveData<Int>
        get() = score

    // The event game ended
    private val eventGameFinish = MutableLiveData<Boolean>()
    val ldEventGameFinish : LiveData<Boolean>
        get() = eventGameFinish

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        word.value = ""
        score.value = 0
        eventGameFinish.value = false
        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i( "GameViewModel", "GameViewModel destroyed")
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }
    fun onSkip() {
        score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            eventGameFinish.value = true
        } else {
            word.value = wordList.removeAt(0)
        }
    }

    fun getWord() : LiveData<String> {
        return ldWord
    }
    fun getScore() : LiveData<Int> {
        return ldScore
    }

    fun getEventGameFinish() : LiveData<Boolean>{
        return ldEventGameFinish
    }

    fun setEventGameFinish( hasFinished : Boolean ){
        eventGameFinish.value = hasFinished
    }
}

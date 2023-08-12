package com.sgut.android.nationalfootballleague.ui.screens.scoreboardscreen


interface One {
    fun name():String
}

interface Two {
    fun lastName(): String
}

interface Three : One, Two {
    fun madeUpName():String
}

open class Fuck(): Three {
    override fun name(): String {
       return "Sal"
    }

    override fun lastName(): String {
       return "Gutierrez"
    }

    override fun madeUpName(): String {
       return "Rust Shakelford"
    }
}

interface INormal {
    val thing: String
    fun madeUpName(): String
}

open class Normal2(override val thing: String = "Thinggg") : Fuck(), INormal {
    override fun madeUpName(): String {
        return "jj"
    }
}

class Normal(thing: String = "Thinggg") : Normal2(thing) {
}
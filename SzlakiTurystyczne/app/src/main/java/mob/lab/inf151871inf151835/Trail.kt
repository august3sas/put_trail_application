package mob.lab.inf151871inf151835

class Trail(
    private var name: String,
    private var length: Double,
    private var time: Double,
    private var times: MutableList<String>
    ) {

    companion object{
        val trails = arrayOf(
            Trail("Przełęcz Krowiarki - Babia Góra", 4.6, 2.4, mutableListOf()),
            Trail("Zawoja Podryzowane - Schronisko PTTK Markowe Szczawiny", 5.7, 2.35, mutableListOf()),
            Trail("Perć Akademików", 2.6, 1.61, mutableListOf()),
            Trail("Krowiarki - Schronisko PTTK Na Hali Krupowej", 9.4, 3.16, mutableListOf()),
            Trail("Zawoja Markowa - Schronisko PTTK Markowe Szczawiny", 3.3, 1.66, mutableListOf()),
            Trail("Zawoja Markowa - Las Ryzowane", 1.3, 0.6, mutableListOf()),
            Trail("Przełęcz Krowiarki - Schronisko PTTK Markowe Szczawiny", 6.3, 2.0, mutableListOf()),
            Trail("Szkolnikowe Rozstaje - Nad Sokolicą", 1.3, 0.83, mutableListOf()),
            Trail("Schronisko PTTK Markowe Szczawiny - Babia Góra", 3.0, 1.5, mutableListOf()),
            Trail("Fickowe Rozstaje - Schronisko PTTK Markowe Szczawiny", 2.7, 1.0, mutableListOf()),
            Trail("Główny Szlak Beskidzki im. Kazimierza Sosnowskiego", 502.5, 162.41, mutableListOf()),
            Trail("Zawoja Policzne - Przełęcz Krowiarki", 4.2, 1.583, mutableListOf()),
            Trail("Zawoja Podryzowane - Pod Mosornym Groniem", 3.1, 1.433, mutableListOf()),
            Trail("Pod Mosornym Groniem - Polica", 4.0, 1.666, mutableListOf()),
            Trail("Zawoja Mosorne - Wodospad na Mosornym Potoku", 2.3, 0.85, mutableListOf()),
            Trail("Wodospad na Mosornym Potoku - Pod Mosornym Groniem", 1.6, 0.85, mutableListOf()),
            Trail("Zawoja Centrum - Schronisko PTTK Na Hali Krupowej", 10.4, 3.916, mutableListOf()),
            Trail("Skawica - Schronisko PTTK Na Hali Krupowej", 7.4, 3.0, mutableListOf()),
            Trail("Stańcowa - Babia Góra", 4.5, 2.516, mutableListOf()),
        )
    }

    fun getName(): String{
        return name
    }
    fun getLength(): Double{
        return length
    }
    fun getTime(): Double{
        return time
    }
    fun getTimes(): List<String>{
        return times
    }

    fun addTime(newTime: String){
        times.add(newTime)
    }
    override fun toString(): String{
        return this.name
    }




}
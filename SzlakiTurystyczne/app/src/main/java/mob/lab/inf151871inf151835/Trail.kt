package mob.lab.inf151871inf151835

class Trail(
    private var name: String,
    private var length: Double,
    private var time: Double,
    private var times: MutableList<String>,
    private var resourceId: Int
    ) {

    companion object{
        val trails = arrayOf(
            Trail("Przełęcz Krowiarki - Babia Góra", 4.6, 2.4, mutableListOf(), R.drawable.image01),
            Trail("Zawoja Podryzowane - Schronisko PTTK Markowe Szczawiny", 5.7, 2.35, mutableListOf(), R.drawable.image02),
            Trail("Perć Akademików", 2.6, 1.61, mutableListOf(), R.drawable.image03),
            Trail("Przełęcz Krowiarki - Schronisko PTTK Na Hali Krupowej", 9.4, 3.16, mutableListOf(), R.drawable.image04),
            Trail("Zawoja Markowa - Schronisko PTTK Markowe Szczawiny", 3.3, 1.66, mutableListOf(), R.drawable.image05),
            Trail("Zawoja Markowa - Las Ryzowane", 1.3, 0.6, mutableListOf(), R.drawable.image06),
            Trail("Przełęcz Krowiarki - Schronisko PTTK Markowe Szczawiny", 6.3, 2.0, mutableListOf(), R.drawable.image07),
            Trail("Szkolnikowe Rozstaje - Nad Sokolicą", 1.3, 0.83, mutableListOf(), R.drawable.image08),
            Trail("Schronisko PTTK Markowe Szczawiny - Babia Góra", 3.0, 1.5, mutableListOf(), R.drawable.image09),
            Trail("Fickowe Rozstaje - Schronisko PTTK Markowe Szczawiny", 2.7, 1.0, mutableListOf(), R.drawable.image10),
            Trail("Główny Szlak Beskidzki im. Kazimierza Sosnowskiego", 502.5, 162.41, mutableListOf(), R.drawable.image11),
            Trail("Zawoja Policzne - Przełęcz Krowiarki", 4.2, 1.583, mutableListOf(), R.drawable.image12),
            Trail("Zawoja Podryzowane - Pod Mosornym Groniem", 3.1, 1.433, mutableListOf(), R.drawable.image13),
            Trail("Pod Mosornym Groniem - Polica", 4.0, 1.666, mutableListOf(), R.drawable.image14),
            Trail("Zawoja Mosorne - Wodospad na Mosornym Potoku", 2.3, 0.85, mutableListOf(), R.drawable.image15),
            Trail("Wodospad na Mosornym Potoku - Pod Mosornym Groniem", 1.6, 0.85, mutableListOf(), R.drawable.image16),
            Trail("Zawoja Centrum - Schronisko PTTK Na Hali Krupowej", 10.4, 3.916, mutableListOf(), R.drawable.image17),
            Trail("Skawica - Schronisko PTTK Na Hali Krupowej", 7.4, 3.0, mutableListOf(), R.drawable.image18),
            Trail("Stańcowa - Babia Góra", 4.5, 2.516, mutableListOf(), R.drawable.image19),
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
    fun getImageResourceId(): Int{
        return resourceId

    }
    fun addTime(newTime: String){
        times.add(newTime)
    }
    override fun toString(): String{
        return this.name
    }




}
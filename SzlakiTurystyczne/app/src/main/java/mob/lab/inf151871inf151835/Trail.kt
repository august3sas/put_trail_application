package mob.lab.inf151871inf151835

class Trail(private var name: String, private var length: Double, private var time: Double) {

    companion object{
        val trails = arrayOf(
            Trail("Przełęcz Krowiarki - Babia Góra", 4.6, 2.4),
            Trail("Zawoja Podryzowane - Schronisko PTTK Markowe Szczawiny", 5.7, 2.35),
            Trail("Perć Akademików", 2.6, 1.61),
            Trail("Krowiarki - Schronisko PTTK na Hali Krupowej", 9.4, 3.16),
            Trail("Zawoja Markowa - Schronisko PTTK Markowe Szczawiny", 3.3, 1.66),
            Trail("Zawoja Markowa - Las Ryzowane", 1.3, 0.6),
            Trail("Przełęcz Krowiarki - Schronisko PTTK Markowe Szczawiny", 6.3, 2.0),
            Trail("Szkolnikowe Rozstaje - Nad Sokolicą", 1.3, 0.83),
            Trail("Schronisko PTTK Markowe Szczawiny - Babia Góra", 3.0, 1.5),
            Trail("Fickowe Rozstaje - Schronisko PTTK Markowe Szczawiny", 2.7, 1.0),
            Trail("Główny Szlak Beskidzki im. Kazimierza Sosnowskiego", 502.5, 162.41)
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
    override fun toString(): String{
        return this.name
    }




}
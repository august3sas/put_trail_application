package mob.lab.inf151871inf151835

class Trail(
    private var id: Int,
    private var name: String,
    private var length: Double,
    private var time: Double,
    private var type: Int,
    private var resourceId: Int
    ) {

    companion object{
        val trails = arrayOf(
            Trail(0,"Przełęcz Krowiarki - Babia Góra", 4.6, 2.4, 1, R.drawable.image01),
            Trail(1,"Zawoja Podryzowane - Schronisko PTTK Markowe Szczawiny", 5.7, 2.35, 1, R.drawable.image02),
            Trail(2,"Perć Akademików", 2.6, 1.61, 1, R.drawable.image03),
            Trail(3,"Przełęcz Krowiarki - Schronisko PTTK Na Hali Krupowej", 9.4, 3.16, 2, R.drawable.image04),
            Trail(4,"Zawoja Markowa - Schronisko PTTK Markowe Szczawiny", 3.3, 1.66, 1, R.drawable.image05),
            Trail(5,"Zawoja Markowa - Las Ryzowane", 1.3, 0.6, 1, R.drawable.image06),
            Trail(6,"Przełęcz Krowiarki - Schronisko PTTK Markowe Szczawiny", 6.3, 2.0, 1, R.drawable.image07),
            Trail(7,"Szkolnikowe Rozstaje - Nad Sokolicą", 1.3, 0.83, 1, R.drawable.image08),
            Trail(8,"Schronisko PTTK Markowe Szczawiny - Babia Góra", 3.0, 1.5, 1, R.drawable.image09),
            Trail(9,"Fickowe Rozstaje - Schronisko PTTK Markowe Szczawiny", 2.7, 1.0, 1, R.drawable.image10),
            Trail(10,"Główny Szlak Beskidzki im. Kazimierza Sosnowskiego", 502.5, 162.41, 0, R.drawable.image11),
            Trail(11,"Zawoja Policzne - Przełęcz Krowiarki", 4.2, 1.583, 1, R.drawable.image12),
            Trail(12,"Zawoja Podryzowane - Pod Mosornym Groniem", 3.1, 1.433, 2, R.drawable.image13),
            Trail(13,"Pod Mosornym Groniem - Polica", 4.0, 1.666, 2, R.drawable.image14),
            Trail(14,"Zawoja Mosorne - Wodospad na Mosornym Potoku", 2.3, 0.85, 2, R.drawable.image15),
            Trail(15,"Wodospad na Mosornym Potoku - Pod Mosornym Groniem", 1.6, 0.85, 2, R.drawable.image16),
            Trail(16,"Zawoja Centrum - Schronisko PTTK Na Hali Krupowej", 10.4, 3.916, 2, R.drawable.image17),
            Trail(17,"Skawica - Schronisko PTTK Na Hali Krupowej", 7.4, 3.0, 2, R.drawable.image18),
            Trail(18,"Stańcowa - Babia Góra", 4.5, 2.516, 1, R.drawable.image19)
        )
    }
    fun getId(): Int{
        return id
    }
    fun getType(): Int{
        return type
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
    fun getImageResourceId(): Int{
        return resourceId

    }
    override fun toString(): String{
        return this.name
    }
}
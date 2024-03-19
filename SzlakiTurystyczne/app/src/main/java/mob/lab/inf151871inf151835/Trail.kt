package mob.lab.inf151871inf151835

class Trail(private var name: String, private var length: Double) {

    companion object{
        val trails = arrayOf(
            Trail("Krowiarki - Babia Góra", 4.6),
            Trail("Zawoja Podryzowane - Schronisko PTTK Markowe Szczawiny", 5.7),
            Trail("Perć Akademików", 2.6),
            Trail("Krowiarki - Schronisko PTTK na Hali Krupowej", 9.4)
        )
    }
    fun getName(): String{
        return name
    }
    fun getLength(): Double{
        return length
    }
    override fun toString(): String{
        return this.name
    }




}
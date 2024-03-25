package mob.lab.inf151871inf151835

class TrailHelpers {
    companion object{
        fun timeToString(time: Double): String{
            val hours = time.toInt()
            val minutes = ((time - hours) * 60).toInt()
            return "$hours h $minutes min"
        }
    }

}
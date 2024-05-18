package mob.lab.inf151871inf151835

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {

    private lateinit var backgroundImage: ImageView
    private var currentPhase = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        backgroundImage = findViewById(R.id.SplashScreenImage)
        backgroundImage.visibility = View.INVISIBLE
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_animation)
        slideAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                backgroundImage.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation?) {
                backgroundImage.visibility = View.INVISIBLE
                currentPhase++
                if (currentPhase > 4) {
                    currentPhase = 1
                }

                when (currentPhase) {
                    1 -> backgroundImage.setImageResource(R.drawable.mountain_1)
                    2 -> backgroundImage.setImageResource(R.drawable.mountain_2)
                    3 -> backgroundImage.setImageResource(R.drawable.mountain_3)
                    4 -> backgroundImage.setImageResource(R.drawable.mountain_4)
                }

                Handler().postDelayed({
                    if (!isFinishing) {
                        backgroundImage.visibility = View.VISIBLE
                        backgroundImage.startAnimation(slideAnimation)
                    }
                }, 100)
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }
        })

        backgroundImage.startAnimation(slideAnimation)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}
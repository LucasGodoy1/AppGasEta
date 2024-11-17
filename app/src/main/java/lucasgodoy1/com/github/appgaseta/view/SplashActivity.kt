package lucasgodoy1.com.github.appgaseta.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import lucasgodoy1.com.github.appgaseta.R

class SplashActivity : AppCompatActivity() {
    val TIME_OUT_SPLASH = 300L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_gaseta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        comutarTelaSplash()


    }

    private fun comutarTelaSplash() {
        Handler(Looper.getMainLooper()).postDelayed({
            val telaPrincipal = Intent(this, GasEtaActivity::class.java)
            startActivity(telaPrincipal)
            finish()
        }, TIME_OUT_SPLASH)
    }
}
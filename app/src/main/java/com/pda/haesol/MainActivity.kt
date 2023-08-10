package com.pda.haesol

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.pda.haesol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // AppBarConfiguration을 위한 변수
    private lateinit var appBarConfiguration: AppBarConfiguration

    // ViewBinding을 위한 변수
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding을 사용하여 레이아웃 요소를 바인딩합니다.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 앱 바의 툴바를 설정합니다.
        setSupportActionBar(binding.appBarMain.toolbar)

        // FloatingActionButton을 클릭하면 Snackbar가 표시되도록 설정합니다.
        /*
        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
         */

        // DrawerLayout과 NavigationView를 초기화하고 네비게이션 컨트롤러를 가져옵니다.
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // 탑 레벨 목적지와 DrawerLayout을 설정합니다.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )

        // 앱 바와 네비게이션을 연결합니다.
        setupActionBarWithNavController(navController, appBarConfiguration)

        // NavigationView와 네비게이션을 연결합니다.
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // 옵션 메뉴를 인플레이트하고 표시합니다.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        // Up 버튼을 처리하는 로직입니다.
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
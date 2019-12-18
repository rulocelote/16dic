package com.miempresa.a16dic

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_songs.*

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar
    val REQUEST_IMAGE_CAPTURE = 1
    val PERMISSION_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!

        setNav(navigationView as BottomNavigationView)
        openFragment( SongsFragment.newInstance())


        if (checkPermissionCam()) dispatchTakePictureIntent() else requestPermissionCam()


    }


    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }


    private fun checkPermissionCam(): Boolean {
        return (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED)
    }

    private fun requestPermissionCam() {
        ActivityCompat.requestPermissions(this, arrayOf(
            Manifest.permission.CAMERA
        ), PERMISSION_REQUEST_CODE)
    }


    fun setNav(navigationBar: BottomNavigationView) {


        navigationBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
               1-> {
                    toolbar.title = "Songs"
                    val songsFragment = SongsFragment.newInstance()
                    openFragment(songsFragment)

                }
                R.id.navigation_albums -> {
                    toolbar.title = "Albums"
                    val albumsFragment = AlbumsFragment.newInstance()
                    openFragment(albumsFragment)

                }
                R.id.navigation_artists -> {
                    toolbar.title = "Artists"
                    val artistsFragment = ArtistsFragment.newInstance()
                    openFragment(artistsFragment)

                }
            }
            false
        }

    }



    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.item_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.it1 -> {
                Toast.makeText(this, "Ajustado :)!", Toast.LENGTH_LONG).show()
                true
            }
            R.id.it2 -> {
                Toast.makeText(this, "Ayudado :)", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
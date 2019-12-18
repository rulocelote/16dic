package com.miempresa.a16dic

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_inicio.*
import android.os.Build




class ExampleFragment : Fragment() {

    val REQUEST_IMAGE_CAPTURE = 1
    val PERMISSION_CODE = 1000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)




    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        camera.setOnClickListener {
            if (checkPermissionCam()) dispatchTakePictureIntent() else requestPermissionCam()
        }
    }

    companion object {
        fun newInstance(): ExampleFragment = ExampleFragment()
    }




    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }


    private fun checkPermissionCam(): Boolean {
        return (ContextCompat.checkSelfPermission(activity!!.applicationContext, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED)
    }

    private fun requestPermissionCam() {
        requestPermissions( arrayOf(
            Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE
        ), PERMISSION_CODE)
    }




}
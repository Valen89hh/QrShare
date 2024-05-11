package com.example.qrshare.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

object BitmapUtils {

    fun getImageUri(context: Context, bitmap: Bitmap): Uri? {
        // Guarda el bitmap en un archivo temporal y obtén su URI
        val file = saveBitmapToFile(context, bitmap)
        return getImageContentUri(context, file)
    }

    private fun saveBitmapToFile(context: Context, bitmap: Bitmap): File {
        // Guarda el bitmap en el directorio de imágenes de la aplicación
        val imagesDir = File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "my_images")
        if (!imagesDir.exists()) {
            imagesDir.mkdirs()
        }

        val imageFile = File(imagesDir, "image_QrCode${System.currentTimeMillis()}.jpg")

        try {
            val os: OutputStream = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os)
            os.flush()
            os.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return imageFile
    }

    fun getImageContentUri(context: Context, imageFile: File): Uri? {
        val filePath = imageFile.absolutePath
        return Uri.parse(MediaStore.Images.Media.insertImage(context.contentResolver, filePath, null, null))
    }
}

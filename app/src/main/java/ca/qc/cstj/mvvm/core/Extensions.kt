package ca.qc.cstj.mvvm.core

import android.annotation.SuppressLint
import android.widget.ImageView

@SuppressLint("DiscouragedApi")
fun ImageView.loadFromResource(resourceName: String){
    //val resId = binding.root.context.resources.getIdentifier(imagePlanet, "drawable", binding.root.context.packageName)


    //binding.imvItemPlanet.setImageResource(resId)
    val resId = resources.getIdentifier(resourceName, " drawable", context.packageName)
}
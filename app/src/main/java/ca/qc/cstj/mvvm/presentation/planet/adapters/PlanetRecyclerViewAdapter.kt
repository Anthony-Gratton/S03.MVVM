package ca.qc.cstj.mvvm.presentation.planet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ca.qc.cstj.mvvm.R
import ca.qc.cstj.mvvm.core.loadFromResource
import ca.qc.cstj.mvvm.databinding.ItemPlanetBinding
import ca.qc.cstj.mvvm.domain.models.Planet

class PlanetRecyclerViewAdapter(var planets: List<Planet>)
    : RecyclerView.Adapter<PlanetRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int = planets.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val planet = planets[position]
        holder.bind(planet)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemPlanetBinding.bind(view)

        fun bind(planet: Planet){
            binding.txtName.text = planet.name
            binding.txtTemperature.text = String.format("%.2f", planet.temperature)

            val imagePlanet = "planet${planet.image}"


            binding.imvItemPlanet.loadFromResource(imagePlanet)

        }
    }
}
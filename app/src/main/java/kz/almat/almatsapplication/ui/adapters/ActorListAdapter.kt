package kz.almat.almatsapplication.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.almat.almatsapplication.R
import kz.almat.almatsapplication.data.models.Actor
import kz.almat.almatsapplication.data.models.Movie

class ActorListAdapter:
        RecyclerView.Adapter<ActorListAdapter.ActorViewHolder>() {

    private var actorList = mutableListOf<Actor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false))
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(actor = actorList[position])
    }

    inner class ActorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val name: TextView = itemView.findViewById<TextView>(R.id.tvActorName)
        private val image: ImageView = itemView.findViewById<ImageView>(R.id.ivActor)

        fun bind(
            actor: Actor
        ) {
            name.text = actor.name
            setImage(actor = actor)
        }

        private fun setImage(actor: Actor) {
            image.apply {
                actor.image?.let { setImageResource(it) }
            }
        }
    }

    fun setUpAactors(list: List<Actor>) {
        actorList = list as MutableList<Actor>
        notifyDataSetChanged()
    }
}


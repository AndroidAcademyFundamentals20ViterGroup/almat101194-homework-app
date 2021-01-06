package kz.almat.almatsapplication.data

import kz.almat.almatsapplication.R
import kz.almat.almatsapplication.data.models.Actor

class ActorDataResource {
    fun getActors(): ArrayList<Actor> = arrayListOf(
        Actor(1, "Robert Downey Jr.", R.drawable.downey_jr),
        Actor(2, "Chris Evans", R.drawable.evans_c),
        Actor(3, "Mark Ruffalo", R.drawable.ruffalo_m),
        Actor(4, "Chris Hemsworth", R.drawable.hemswoth_c),
        Actor(5, "Robert Downey Jr.", R.drawable.downey_jr),
        Actor(6, "Chris Evans", R.drawable.evans_c),
        Actor(7, "Mark Ruffalo", R.drawable.ruffalo_m),
        Actor(8, "Chris Hemsworth", R.drawable.hemswoth_c)
    )
}
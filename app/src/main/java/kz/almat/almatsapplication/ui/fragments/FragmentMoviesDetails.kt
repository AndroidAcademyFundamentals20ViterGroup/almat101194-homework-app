package kz.almat.almatsapplication.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.almat.almatsapplication.R
import kz.almat.almatsapplication.data.ActorDataResource
import kz.almat.almatsapplication.data.models.Movie
import kz.almat.almatsapplication.ui.adapters.ActorListAdapter
import kz.almat.almatsapplication.ui.adapters.MovieListAdapter

class FragmentMoviesDetails : Fragment(R.layout.fragment_movies_details) {

    private var actorsAdapter = ActorListAdapter()
    private var actorsResource = ActorDataResource()

    companion object {
        private const val MOVIE_ID = "movie_id"

        fun newInstance(id: Int): FragmentMoviesDetails {
            val fragment = FragmentMoviesDetails()
            fragment.arguments = bundleOf(MOVIE_ID to id)
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpGUI()
    }

    private fun setUpGUI() {
        val actorListRecyclerView = requireView().findViewById<RecyclerView>(R.id.ivRecyclerViewActor)
        actorListRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        actorListRecyclerView.adapter = actorsAdapter
        actorsAdapter.setUpAactors(list = actorsResource.getActors())
    }


}
package kz.almat.almatsapplication.ui.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.almat.almatsapplication.R
import kz.almat.almatsapplication.data.MovieDataResource
import kz.almat.almatsapplication.data.models.Movie
import kz.almat.almatsapplication.ui.adapters.MovieListAdapter
import kz.almat.almatsapplication.ui.fragments.interfaces.FragmentClickListener

class FragmentMoviesList : Fragment(R.layout.fragment_movies_list) {

//    private var fragmentClickListener: FragmentClickListener? = null
//    private var clickListener: ((Movie) -> Unit)? = null
//    private var movieRecyclerView: RecyclerView? = null
    private var moviesAdapter = MovieListAdapter()
    private var moviesResource = MovieDataResource()

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//
//        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
//
////        view?.findViewById<CardView>(R.id.iv_cardView)?.apply{
////            setOnClickListener{
////                fragmentClickListener?.onMoveNextDetaielsClicked()
////            }
////        }
//        return view
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpGUI()
//        movieRecyclerView = view.findViewById<RecyclerView>(R.id.iv_recyclerView)
//        movieRecyclerView?.layoutManager = GridLayoutManager(context, 2)
//        movieRecyclerView?.adapter = moviesAdapter

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentClickListener) {
//            fragmentClickListener = context
            moviesAdapter.listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
//        fragmentClickListener = null
        moviesAdapter.listener = null
    }

    private fun setUpGUI() {
        val movieListRecyclerView = requireView().findViewById<RecyclerView>(R.id.ivRecyclerView)
        movieListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        movieListRecyclerView.adapter = moviesAdapter
        moviesAdapter.setUpMovies(list = moviesResource.getMovies())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        //handle screen rotation
        setUpGUI()
    }


}
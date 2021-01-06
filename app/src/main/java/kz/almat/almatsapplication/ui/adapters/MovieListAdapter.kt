package kz.almat.almatsapplication.ui.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.almat.almatsapplication.R
import kz.almat.almatsapplication.data.MovieDataResource
import kz.almat.almatsapplication.data.models.Movie
import kz.almat.almatsapplication.ui.fragments.interfaces.FragmentClickListener

class MovieListAdapter:
        RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var moviesList = mutableListOf<Movie>()
    var listener: FragmentClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false),
        listener = this.listener
    )

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movie = moviesList[position])
    }

    inner class MovieViewHolder(itemView: View, listener: FragmentClickListener?): RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById<TextView>(R.id.tvTitle)
        private val ivLiked: ImageView = itemView.findViewById<ImageView>(R.id.ivIsLiked)
        private val poster: ImageView = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val genre: TextView = itemView.findViewById<TextView>(R.id.tvGenre)
        private val reviews: TextView = itemView.findViewById<TextView>(R.id.tvReviews)
        private val duration: TextView = itemView.findViewById<TextView>(R.id.tvDuration)
        private val ratingBar: RatingBar = itemView.findViewById<RatingBar>(R.id.ratingBar)
        private val ageRating: TextView = itemView.findViewById<TextView>(R.id.tvAgeRating)

        fun bind(
            movie: Movie
        ) {
            title.text = movie.title
            genre.text = movie.tags.joinToString( separator = "," )
            reviews.text = "${movie.reviews} reviews"
            duration.text = "${movie.length} min"
            ageRating.text = "${movie.ageLimit} +"
            ratingBar.rating = movie.rating
            setLike(isLiked = movie.isLiked)
            setPoster(movie = movie)
            itemView.setOnClickListener {
                listener?.onMoveNextDetaielsClicked(id = adapterPosition)
            }

        }

        private fun setPoster(movie: Movie) {
            poster.apply {
                movie.coverDrawable?.let { setImageResource(it) }
            }
        }

        private fun setLike(isLiked: Boolean) {
            when {
                isLiked -> ivLiked.setImageDrawable(
                    ContextCompat.getDrawable(
                        this.itemView.context,
                        R.drawable.ic_baseline_favorite_red_24
                    )
                )
                else -> ivLiked.setImageDrawable(
                    ContextCompat.getDrawable(
                        this.itemView.context,
                        R.drawable.ic_baseline_favorite_24
                    )
                )
            }
        }

    }

    fun setUpMovies(list: List<Movie>) {
        moviesList = list as MutableList<Movie>
        notifyDataSetChanged()
    }

}


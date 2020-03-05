import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medecin.project.MainActivity
import com.medecin.project.Medecin
import com.medecin.project.R
import java.util.*
import kotlin.collections.ArrayList


class MedecinAdapter(private val myDataset: ArrayList<Medecin>) :
    RecyclerView.Adapter<MedecinAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

         val medecinName = view?.findViewById(R.id.medecin_name) as TextView
         val medecinSpecialite = view?.findViewById(R.id.medecin_specialite) as TextView
         val medecinPhone = view?.findViewById(R.id.medecin_phone) as TextView
         val medecinCommune = view?.findViewById(R.id.medecin_commun) as TextView
         val medecinOpen = view?.findViewById(R.id.medecin_open_time) as TextView
         val medecinClose = view?.findViewById(R.id.medecin_close_time) as TextView

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MedecinAdapter.MyViewHolder {
        // create a new view
        val listElement = LayoutInflater.from(parent.context)
            .inflate(R.layout.medecin_list_element, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(listElement)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.medecinClose.text = myDataset[position].heure_fermeture
        holder.medecinOpen.text = myDataset[position].heure_ouverture
        holder.medecinCommune.text = myDataset[position].commune
        holder.medecinSpecialite.text = myDataset[position].specialite
        holder.medecinName.text = myDataset[position].full_name
        holder.medecinPhone.text = myDataset[position].phone.toString()

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}

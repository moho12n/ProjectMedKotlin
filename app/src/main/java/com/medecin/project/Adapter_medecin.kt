import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import android.widget.TextView
import com.medecin.project.Medecin
import com.medecin.project.R

class MedecinAdapter (val ctx:Context,val data:List<Medecin>):BaseAdapter(){
    override fun getView(i: Int, p0: View?, parent: ViewGroup?): View {
        var view = p0
        var holder:ViewHolder
        if (view == null) {
            view = LayoutInflater.from(ctx).inflate(R.layout.medecin_list_element,parent,false)
            val medecinName = view?.findViewById(R.id.medecin_name) as TextView
            val medecinSpecialite = view?.findViewById(R.id.medecin_specialite) as TextView
            val medecinPhone = view?.findViewById(R.id.medecin_phone) as TextView
            val medecinCommune = view?.findViewById(R.id.medecin_commun) as TextView
            val medecinOpen = view?.findViewById(R.id.medecin_open_time) as TextView
            val medecinClose = view?.findViewById(R.id.medecin_close_time) as TextView
            holder = ViewHolder(medecinName,medecinSpecialite,medecinPhone,medecinCommune,medecinOpen,medecinClose)
            view?.tag = holder
        }
        else {
            holder = view.tag as ViewHolder
        }
        holder.medecinName.text = data[i].full_name
        holder.medecinSpecialite.text = data[i].specialite
        holder.medecinPhone.text = data[i].phone.toString()
        holder.medecinCommune.text = data[i].commune
        holder.medecinOpen.text = data[i].heure_ouverture
        holder.medecinClose.text = data[i].heure_fermeture

        return view
    }
    private class ViewHolder(val medecinName: TextView,val medecinSpecialite: TextView, val medecinPhone: TextView,val medecinCommune: TextView,val medecinOpen: TextView,val medecinClose: TextView)


    override fun getItem(p0: Int)= data[p0]

    override fun getItemId(p0: Int) = data[p0].hashCode().toLong()

    override fun getCount() = data.size
}
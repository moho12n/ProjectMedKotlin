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
            val textView = view?.findViewById(R.id.medecin_name) as TextView
            holder = ViewHolder(textView)
            view?.tag = holder
        }
        else {
            holder = view.tag as ViewHolder
        }
        holder.textView.text = data[i].full_name
        return view
    }
    private class ViewHolder(val textView: TextView)


    override fun getItem(p0: Int)= data[p0]

    override fun getItemId(p0: Int) = data[p0].hashCode().toLong()

    override fun getCount() = data.size
}
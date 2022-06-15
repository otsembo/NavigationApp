package com.otsembo.navigationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.otsembo.navigationapp.databinding.ListItemBinding
import java.lang.System.load

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = peopleList()[position]
        holder.bindData(person)
    }

    override fun getItemCount(): Int  = peopleList().size

    class PersonViewHolder(private  val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(person: Person){
            binding.person = person
            binding.imgPerson.setOnClickListener { view:View ->
                // navigate with fragments
                val navController = view.findNavController()
                val navBundle = Bundle()
                navBundle.putString("image", person.image)
                navController.navigate(R.id.action_listFragment_to_detailsFragment, navBundle)
            }
            binding.executePendingBindings()
        }
    }

}

data class Person(val name:String, val image:String)
fun peopleList() : List<Person> {
    val list = ArrayList<Person>()
    list.add( Person(name = "John Stones", image = "https://resources.premierleague.com/premierleague/photos/players/250x250/p97299.png"))
    list.add( Person(name = "Lionel Messi", image = "https://images.indianexpress.com/2022/06/Lionel-Messi.jpg") )
    list.add( Person(name = "Zinadine Zidane", image = "https://cdn.britannica.com/78/128778-050-3BEDC27B/Zinedine-Zidane-ball-final-World-Cup-Italy-2006.jpg") )
    list.add( Person(name = "Thierry Henry", image = "https://resources.premierleague.com/photos/2021/04/16/07add54c-938a-4b36-89aa-58318f717485/HOF-Inductees-Henry.jpeg?width=1600&height=700") )
    list.add( Person(name = "Johan Cruyff", image = "https://imgresizer.eurosport.com/unsafe/1200x0/filters:format(jpeg):focal(1286x184:1288x182)/origin-imgresizer.eurosport.com/2014/09/10/1311002-28213173-2560-1440.jpg") )
    return list
}

@BindingAdapter("imageDisplay")
fun ImageView.displayImage(image:String){
   this.load(image)
}
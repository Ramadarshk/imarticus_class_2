package com.example.imarticus_class_2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imarticus_class_2.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

lateinit var datalist:ArrayList<MarsPhoto>
lateinit var myadapter:adapter
lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v , insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left , systemBars.top , systemBars.right , systemBars.bottom)
            insets
        }
        //recyclerView=findViewById(R.id.recyclerView)
        binding.recyclerView.layoutManager= GridLayoutManager(this,2)
       datalist= arrayListOf()
        binding.recyclerView.setHasFixedSize(true)
        try{
         myadapter=adapter(datalist)
        binding.recyclerView.adapter=myadapter}
        catch (e:Exception){
            Log.i("error","${e.message}")
        }
/*        runBlocking {
            Log.i("result","running started")
            val list=marsapi.retrofits.getphotos()
            datalist=list
            recyclerView.adapter=adapter(datalist)
            Log.i("result","running ended $datalist")
           // myadapter.submitList(datalist)
        }
        binnding.button.setOnClickListener{
            getmarsphotos()
        }*/
        }

/*    fun getjson(view: View) {
         getmarsphotos()
    }*/

    @OptIn(DelicateCoroutinesApi::class)
    private fun getmarsphotos() {
        GlobalScope.launch() {
             val list=marsapi.retrofits.getphotos()
/*            for (i in 0..10){
            datalist.add(list[i])}*/
            datalist.addAll(list)
            Log.i("helo1","${datalist.size}")
/*           val imageView: ImageView =findViewById(R.id.imageView)
            binniding.imageView.load(list.get(0).img_src)*/
            withContext(Dispatchers.Main){
            binding.recyclerView.adapter=adapter(datalist)}
            Log.i("helo","${list.size}")}}
           /* myadapter.notifyDataSetChanged()}}
                    Log.i("result", list.get(0).img_src)
            withContext(Dispatchers.Main){
               // val textview:ImageView=findViewById(R.id.imageView)
                val imageurl=list.get(0).img_src
                //textview.load(imageurl)
                recyclerView.adapter=adapter(list)
            }*/
}
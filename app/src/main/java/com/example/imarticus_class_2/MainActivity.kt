package com.example.imarticus_class_2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
lateinit var recyclerView: RecyclerView
lateinit var datalist:ArrayList<MarsPhoto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v , insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left , systemBars.top , systemBars.right , systemBars.bottom)
            insets
        }
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager(this)
       datalist= arrayListOf()
        recyclerView.setHasFixedSize(true)
        val myadapter=adapter(datalist)
        recyclerView.adapter=myadapter
//        runBlocking {
//            Log.i("result","running started")
//            val list=marsapi.retrofits.getphotos()
//            datalist=list
//            recyclerView.adapter=adapter(datalist)
//            Log.i("result","running ended $datalist")
//           // myadapter.submitList(datalist)
//        }
        }

    fun getjson(view: View) {
         getmarsphotos()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getmarsphotos() {
        GlobalScope.launch() {
             val list=marsapi.retrofits.getphotos()
            for (i in 1..700){
            datalist.add(list[i])}
         /*   val imageView:ImageView=findViewById(R.id.imageView3)
            imageView.load(list.get(0).img_src)*/
            withContext(Dispatchers.Main){
            recyclerView.adapter=adapter(datalist)}
            Log.i("helo","${list.size}")}}

            //myadapter.notifyDataSetChanged()
        //            Log.i("result", list.get(0).img_src)
//            withContext(Dispatchers.Main){
//               // val textview:ImageView=findViewById(R.id.imageView)
//                val imageurl=list.get(0).img_src
//                //textview.load(imageurl)
//                recyclerView.adapter=adapter(list)
//            }




}
package com.example.mycart

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.appcompat.widget.ListPopupWindow.WRAP_CONTENT
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.smarteist.autoimageslider.SliderView

class MainActivity : AppCompatActivity()
{

    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var toolbar: MaterialToolbar
    private lateinit var drawerLayout: DrawerLayout

    private  lateinit var navigationView:NavigationView
    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var secondrecycler:RecyclerView
    private lateinit var newArrayList: ArrayList<CircularImg>
    private lateinit var datalist: ArrayList<MyData>
    lateinit var imageidsecond:Array<Int>
    lateinit var  introsliderViewPager2: ViewPager2
    lateinit var inicatorsContainer:LinearLayout

    lateinit var titlesecond:Array<String>
    private  val introSliderAdapter=IntroSlideAdapter(
    listOf(
        IntroSlide(R.drawable.img1),
        IntroSlide(R.drawable.img2),
        IntroSlide(R.drawable.img3),
        IntroSlide(R.drawable.img4)
    )
     )

    lateinit var imageid:Array<Int>
    lateinit var title:Array<String>
    override fun onCreate(savedInstanceState: Bundle?)
    {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initView()
    drawerCode()
        introsliderViewPager2.adapter=introSliderAdapter
        setUpIndicators()
    imageid= arrayOf(R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1)
    title= arrayOf("first image ","second image ","third image ","fourth image ","fifth image ")

        imageidsecond= arrayOf(R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1,R.drawable.img1)
        titlesecond= arrayOf("first image ","second image ","third image ","fourth image ","fifth image ")

        secondrecycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        secondrecycler.setHasFixedSize(true)
        datalist= arrayListOf<MyData>()
        getData()


        newRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        newRecyclerView.setHasFixedSize(true)
        newArrayList= arrayListOf<CircularImg>()
        getuserData()


    }

    private fun getuserData() {
        for (i in imageid.indices)
        {
            val data=CircularImg(imageid[i],title[i])
            newArrayList.add(data)
        }
        newRecyclerView.adapter=MyAdapter(newArrayList)
    }
    private fun getData() {
        for (i in imageidsecond.indices)
        {
            val data=MyData(imageidsecond[i],titlesecond[i])
            datalist.add(data)
        }
        secondrecycler.adapter=SecondAdapter(datalist)
    }


    private fun initView() {
        drawerLayout = findViewById(R.id.mydrawer)
        toolbar = findViewById(R.id.toolbar_main)
        navigationView=findViewById(R.id.navigationView)
        newRecyclerView=findViewById(R.id.myrecyclervertical)
        secondrecycler=findViewById(R.id.recyclerfirst)
        introsliderViewPager2=findViewById(R.id.introSliderViewpager)
        inicatorsContainer=findViewById(R.id.inicatorscon)

    }
    private fun drawerCode() {

        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close)
        drawerToggle.isDrawerIndicatorEnabled = false
        drawerToggle.setHomeAsUpIndicator(R.drawable.hams)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {     menuItem ->

            when (menuItem.itemId) {
                R.id.home -> {

                    drawerLayout.closeDrawers()
                }
                R.id.settings -> {

                    drawerLayout.closeDrawers()
                }
                R.id.account -> {
                    drawerLayout.closeDrawers()
                }
            }

            true

        }
    }
    private fun setUpIndicators()
    {
        val indicators= arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutparamss:LinearLayout.LayoutParams=LinearLayout.LayoutParams(WRAP_CONTENT,
            WRAP_CONTENT)

        layoutparamss.setMargins(8,0,8,0)

//        val layouprams:LinearLayout.LayoutParams=LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
//        layouprams.setMargins(8,0,8,0)
        for (i in indicators.indices)
        {
            indicators[i]= ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,
                    R.drawable.indicator_inactive
                ))
                this?.layoutParams=layoutparamss
            }
            inicatorsContainer.addView(indicators[i])
        }

    }


}

package com.example.wavesoffood.Fragment

import android.content.ClipData.Item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.constants.ScaleTypes.CENTER_CROP
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.example.wavesoffood.databinding.FragmentHomeBinding
import com.example.wavesoffood.R
import com.denzcoskun.imageslider.models.SlideModel
import com.example.wavesoffood.MenuBottomSheetFragment
import com.example.wavesoffood.adaptar.PopularAddaptar

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.viewAllMenu.setOnClickListener{
          val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"MenuBottomSheet")

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://www.dropbox.com/scl/fi/19x7j54qbdwbrzqqxeuqm/banner1.jpg?rlkey=nlhmifmzdjj28a6euxn10dk93&raw=1\n",CENTER_CROP))
        imageList.add(SlideModel("https://www.dropbox.com/scl/fi/2reeag8in7iwfzsc8xwpx/banner2.webp?rlkey=iruxyxk8gagq5shwlxlwq4z3h&raw=1\n",CENTER_CROP))
        imageList.add(SlideModel("https://www.dropbox.com/scl/fi/emi97v710uiy6s88m4t46/banner3.webp?rlkey=sflska5rcjesqebgcr8pq4ot6&raw=1\n",CENTER_CROP))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val  itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })
        val foodName = listOf("Sandwich","MoMo","Noodles","Burger","Noodles","momo")
        val Price = listOf("$5","$7","$8","$10","$10","$12")
        val popularFodImages = listOf(R.drawable.menu2,R.drawable.menu3,R.drawable.menu1,R.drawable.menu1,R.drawable.menu3,R.drawable.menu2)
        val adapter = PopularAddaptar(foodName,Price,popularFodImages)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }
}

package com.example.invisiademo.presentation.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.invisiademo.R
import com.example.invisiademo.databinding.FragmentOrderDetailsBinding
import com.example.myapplication.common.Constant.KEY_IMG_RES
import com.example.myapplication.common.Constant.KEY_PRICE
import com.example.myapplication.common.Constant.KEY_SHORT_DESC
import com.example.myapplication.common.Constant.KEY_TITLE
import com.example.myapplication.common.Constant.validationMessage
import com.example.myapplication.presentation.corelogic.PizzaCategory
import com.example.myapplication.presentation.corelogic.PizzaType
import com.example.myapplication.presentation.ui.gallery.OrderDetailsViewModel

class OrderDetailsFragment : Fragment() {

    private var _binding: FragmentOrderDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var pizzaCategory = PizzaCategory()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(OrderDetailsViewModel::class.java)

        _binding = FragmentOrderDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val languages = resources.getStringArray(R.array.customer)

        val adapter = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_list_item_1, languages
            )
        }
        binding.spinner.adapter = adapter
        setListener()
        setBundleData()
        return root
    }
    private fun setListener(){
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                binding.smallSizeInputLayout.setText("0")
                binding.mediumSizeInputLayout.setText("0")
                binding.largeSizeInputLayout.setText("0")
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        binding.button.setOnClickListener {
            if(binding.smallSizeInputLayout.text.isNotEmpty()
                && binding.mediumSizeInputLayout.text.isNotEmpty()
                && binding.largeSizeInputLayout.text.isNotEmpty()) {
                binding.totalAmountTitle.visibility = View.VISIBLE
                binding.totalAmountValue.text = "${getTotalPrice()}$"
            }else{
                Toast.makeText(context, validationMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setBundleData(){
        arguments?.let {
          binding.pizzaType.text = requireArguments().getString(KEY_TITLE)
            binding.shortDescTxt.text = requireArguments().getString(KEY_SHORT_DESC)
            binding.pricetxt.text = requireArguments().getString(KEY_PRICE)
            binding.pizzaImg.setBackgroundResource(requireArguments().getInt(KEY_IMG_RES))
        }
    }
    private fun getTotalPrice(): Double{
        val smallSize = binding.smallSizeInputLayout.text.toString()
        val mediumSize = binding.mediumSizeInputLayout.text.toString()
        val largeSize = binding.largeSizeInputLayout.text.toString()
        val customerName = binding.spinner.selectedItem.toString()

        val smallList = pizzaCategory.getProducts(PizzaType.SMALL_PIZZA, smallSize.toInt())
        val mediumList = pizzaCategory.getProducts(PizzaType.MEDIUM_PIZZA, mediumSize.toInt())
        val largeList = pizzaCategory.getProducts(PizzaType.LARGE_PIZZA, largeSize.toInt())

       return pizzaCategory.calculateTotalAmount(customerName, smallList + mediumList + largeList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
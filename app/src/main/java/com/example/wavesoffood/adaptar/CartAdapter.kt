package com.example.wavesoffood.adaptar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.CartItemBinding

class CartAdapter(private val CartItems:MutableList<String>,private val CartItemPrice:MutableList<String>,private var CartImage: MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
private val  itemQuantities = IntArray(CartItems.size){1}

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
      val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)

    }
    override fun getItemCount(): Int = CartItems.size
    inner class CartViewHolder(private val binding: CartItemBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
         binding.apply {
             val quantity = itemQuantities[position]
                 cartfoodname.text= CartItems[position]
             cartitemprice.text = CartItemPrice[position]
             cartimage.setImageResource(CartImage[position])
             cartItemQuantity.text = quantity.toString()

             minusbutton.setOnClickListener{
                 decreaseQuantity(position)


             }
             plusbutton.setOnClickListener{
                 increaseQuantity(position)

             }
             deletebutton.setOnClickListener{
                 val itemPosition = adapterPosition
                 if (itemPosition != RecyclerView.NO_POSITION){
                     deleteItem(itemPosition)
                 }

             }




         }

        }
        private fun increaseQuantity(position: Int){
            if (itemQuantities[position]<10){
                itemQuantities[position]++
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }

        }
        private fun decreaseQuantity(position: Int){
            if (itemQuantities[position]>1){
                itemQuantities[position]--
                binding.cartItemQuantity.text = itemQuantities[position].toString()
            }

        }
        private fun deleteItem(position: Int){
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, CartItems.size)



        }

    }
}
package com.pocketimps.sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

/**
 * List adapter which displays an array of [ItemData] items.
 */
class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    // ViewHolder which displays single [ItemData]
    inner class ViewHolder(private val mView: TextView) : RecyclerView.ViewHolder(mView) {
        // Current data
        private lateinit var mItemData: ItemData

        init {
            // Set click listener once
            mView.setOnClickListener {
                itemClickListener?.invoke(mItemData)
            }
        }

        fun bind(itemData: ItemData) {
            // Store new current item data and update title

            mItemData = itemData
            mView.text = itemData.title
        }
    }


    private val mData = ArrayList<ItemData>()

    // Item click listener, set from outside
    var itemClickListener: ((data: ItemData) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount() = mData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create item layout and bind to view holder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false) as TextView
        return ViewHolder(view)
    }

    fun setData(data: List<ItemData>) {
        // Updata data. We just clear previous content and put a new one.

        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }
}

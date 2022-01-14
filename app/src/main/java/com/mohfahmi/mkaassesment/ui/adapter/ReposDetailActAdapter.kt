package com.mohfahmi.mkaassesment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohfahmi.mkaassesment.R
import com.mohfahmi.mkaassesment.data.source.remote.response.ReposResponseItem
import com.mohfahmi.mkaassesment.databinding.DetailRepoItemsLayoutBinding

class ReposDetailActAdapter :
    RecyclerView.Adapter<ReposDetailActAdapter.ReposDetailAdapterViewHolder>() {

    var repos = ArrayList<ReposResponseItem>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    inner class ReposDetailAdapterViewHolder(private val binding: DetailRepoItemsLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repos: ReposResponseItem) {
            with(binding) {
                tvRepoDescriptionDetail.text = repos.description
                tvRepoNameDetail.text = repos.name
                tvRepoStarsDetail.text = repos.stargazersCount.toString()
                tvRepoLastUpdatedDetail.text =
                    itemView.context.getString(R.string.updated_format, repos.updatedAt)
                Glide.with(itemView.context).load(repos.owner?.avatarUrl)
                    .into(imgRepoProfileDetail)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReposDetailAdapterViewHolder {
        return ReposDetailAdapterViewHolder(
            DetailRepoItemsLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ReposDetailAdapterViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int = repos.size
}
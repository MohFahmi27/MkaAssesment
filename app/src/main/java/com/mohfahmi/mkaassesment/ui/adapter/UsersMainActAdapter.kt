package com.mohfahmi.mkaassesment.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohfahmi.mkaassesment.R
import com.mohfahmi.mkaassesment.databinding.MainProfileItemsLayoutBinding
import com.mohfahmi.mkaassesment.domain.entity.UsersGithubEntity
import com.mohfahmi.mkaassesment.utils.ViewUtils.setRoundedGlide

class UsersMainActAdapter :
    RecyclerView.Adapter<UsersMainActAdapter.UsersMainActAdapterViewHolder>() {

    var onItemClick: ((UsersGithubEntity) -> Unit)? = null

    var listItems = ArrayList<UsersGithubEntity>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    inner class UsersMainActAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = MainProfileItemsLayoutBinding.bind(itemView)
        fun bind(userGithub: UsersGithubEntity) {
            with(binding) {
                imgProfileMain.setRoundedGlide(userGithub.avatarUrl)
                tvDescriptionProfileMain.text = if (userGithub.bio.toString().length > 85) {
                    itemView.context.getString(
                        R.string.description_main_format,
                        userGithub.bio.toString().substring(0, 85)
                    )
                } else {
                    userGithub.bio.toString()
                }
                tvEmailMain.text = userGithub.email.toString()
                tvFullnameMain.text = userGithub.fullName
                tvLocationMain.text = userGithub.location ?: "Earth"
                tvUsernameMain.text =
                    itemView.context.getString(R.string.username_format, userGithub.login)
            }
        }

        init {
            itemView.setOnClickListener { onItemClick?.invoke(listItems[adapterPosition]) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersMainActAdapterViewHolder {
        return UsersMainActAdapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_profile_items_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UsersMainActAdapterViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int = listItems.size
}


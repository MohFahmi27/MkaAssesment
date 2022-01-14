package com.mohfahmi.mkaassesment.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SearchResponse(
	@field:SerializedName("items")
	val items: List<ItemsItem>
)

data class ItemsItem(
	@field:SerializedName("login")
	val login: String
)

package com.kitesoft.kakaosearchapp.model

data class KeywordPlaceResponse(val meta:PlaceItem, val documents:MutableList<PlaceItem>)

data class PlaceMeta(val total_count:Int, val pageable_count:Int, val is_end:Boolean)

data class PlaceItem(
    val id:String,
    val place_name:String,
    val category_name:String,
    val address_name:String,
    val road_address_name:String,
    val x:String,
    val y:String,
    val place_url:String,
    val distance:String
    )

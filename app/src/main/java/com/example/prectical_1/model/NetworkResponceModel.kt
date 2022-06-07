package com.example.prectical_1.model

import com.google.gson.annotations.SerializedName

data class NetworkResponseModel(

	@field:SerializedName("hits")
	val hits: List<HitsItem> ,

	@field:SerializedName("exhaustiveTypo")
	val exhaustiveTypo: Boolean? = null,

	@field:SerializedName("hitsPerPage")
	val hitsPerPage: Int? = null,

	@field:SerializedName("processingTimeMS")
	val processingTimeMS: Int? = null,

	@field:SerializedName("query")
	val query: String? = null,

	@field:SerializedName("nbHits")
	val nbHits: Int? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("params")
	val params: String? = null,

	@field:SerializedName("nbPages")
	val nbPages: Int? = null,

	@field:SerializedName("exhaustiveNbHits")
	val exhaustiveNbHits: Boolean? = null
)

data class Author(

	@field:SerializedName("matchLevel")
	val matchLevel: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("matchedWords")
	val matchedWords: List<Any?>? = null
)

data class HighlightResult(

	@field:SerializedName("author")
	val author: Author? = null,

	@field:SerializedName("title")
	val title: Title? = null,

	@field:SerializedName("url")
	val url: Url? = null,

	@field:SerializedName("story_text")
	val storyText: StoryText? = null
)

data class Title(

	@field:SerializedName("matchLevel")
	val matchLevel: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("matchedWords")
	val matchedWords: List<Any?>? = null
)

data class Url(

	@field:SerializedName("matchLevel")
	val matchLevel: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("matchedWords")
	val matchedWords: List<Any?>? = null
)

data class StoryText(

	@field:SerializedName("matchLevel")
	val matchLevel: String? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("matchedWords")
	val matchedWords: List<Any?>? = null
)

data class HitsItem(

	@field:SerializedName("comment_text")
	val commentText: Any? = null,

	@field:SerializedName("story_text")
	val storyText: Any? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("story_id")
	val storyId: Any? = null,

	@field:SerializedName("_tags")
	val tags: List<String?>? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("created_at_i")
	val createdAtI: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("points")
	val points: Int? = null,

	@field:SerializedName("_highlightResult")
	val highlightResult: HighlightResult? = null,

	@field:SerializedName("num_comments")
	val numComments: Int? = null,

	@field:SerializedName("story_title")
	val storyTitle: Any? = null,

	@field:SerializedName("parent_id")
	val parentId: Any? = null,

	@field:SerializedName("story_url")
	val storyUrl: Any? = null,

	@field:SerializedName("objectID")
	val objectID: String? = null
){
	fun getYYYYMMDD() : String?{
		return createdAt?.split('T')?.get(0)			//get date from createAt
	}

	fun getDate():String?{
		return getYYYYMMDD()?.split('-')?.get(2)		//get date from date
	}

	fun getMonth() : String?{									//get month from date
		when(getYYYYMMDD()?.split('-')?.get(1)){
			"01" ->{return "January"}
			"02" ->{return "February"}
			"03" ->{return "March"}
			"04" ->{return "April"}
			"05" ->{return "May"}
			"06" ->{return "June"}
			"07" ->{return "July"}
			"08" ->{return "August"}
			"09" ->{return "September"}
			"10" ->{return "October"}
			"11" ->{return "November"}
			"12" ->{return "December"}
		}
		return null
	}

	fun getYear() : String?{									//get year from date
		return getYYYYMMDD()?.split('-')?.get(0)
	}

	fun getDDMMYYYY() : String?{								// format in mm dd yyyy
		return if (getDate()!=null && getMonth()!=null && getYear()!=null){
			getMonth() + " "+getDate()+", "+getYear()
		}else{
			null
		}
	}

}

package com.example.kulinerapp.remote.POJO

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseKuliner(

	@field:SerializedName("kuliner")
	val kuliner: List<KulinerItem?>? = null
) : Parcelable

@Parcelize
data class KulinerItem(

	@field:SerializedName("jam_buka_tutup")
	val jamBukaTutup: String? = null,

	@field:SerializedName("kordinat")
	val kordinat: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("gambar_url")
	val gambarUrl: String? = null,

	@field:SerializedName("kategori")
	val kategori: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
) : Parcelable

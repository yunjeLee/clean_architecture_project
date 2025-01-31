package com.android.data_coin.entity.coin_detail

import com.android.domain_coin.model.coin_detail.CoinDetailModel
import com.android.domain_coin.model.coin_detail.TeamModel
import com.google.gson.annotations.SerializedName

data class CoinDetailEntity(
    val description: String,
    @SerializedName("development_status")
    val developmentStatus: String,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String,
    val id: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: LinksEntity,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtendedEntity>,
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<TagEntity>,
    val team: List<TeamEntity>,
    val type: String,
    val whitePaper: WhitePaperEntity
)

fun CoinDetailEntity.toCoinDetailModel(): CoinDetailModel =
    CoinDetailModel(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team.map { it.toTeamModel() }
    )

fun TeamEntity.toTeamModel(): TeamModel =
    TeamModel(
        name = name,
        position = position
    )

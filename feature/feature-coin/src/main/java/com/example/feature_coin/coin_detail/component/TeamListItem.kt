package com.example.feature_coin.coin_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.android.domain_coin.model.coin_detail.TeamModel

@Composable
fun TeamListItem(
    teamModel: TeamModel,
    modifier: Modifier
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamModel.name,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamModel.position,
            fontStyle = FontStyle.Italic
        )
    }
}
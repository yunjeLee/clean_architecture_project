package com.example.feature_coin.coin_detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.domain_coin.model.coin_detail.TeamModel

@Composable
fun CoinTeamScreen(
    members: List<TeamModel>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Team members",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        members.forEach { member ->
            TeamListItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                teamModel = member
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Color.DarkGray)
            )
        }
    }
}
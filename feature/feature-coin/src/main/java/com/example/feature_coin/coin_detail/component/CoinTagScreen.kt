package com.example.feature_coin.coin_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinTageScreen(
    tags: List<String>
) {
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Tags",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        FlowRow (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            tags.forEach { tag ->  
                CoinTag(tag = tag)
            }
        }
    }
}
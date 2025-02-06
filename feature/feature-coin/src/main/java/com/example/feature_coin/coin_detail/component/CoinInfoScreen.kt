package com.example.feature_coin.coin_detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.feature_coin.coin_detail.data.CoinInfo

@Composable
fun CoinInfoScreen(
    data: CoinInfo
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${data.rank}. ${data.name}. (${data.symbol})",
            fontSize = 20.sp
        )
        Text(
            text = if(data.isActive) "active" else "inactive",
            color = if(data.isActive) Color.Green else Color.Red,
            fontSize = 15.sp,
            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
            textAlign = TextAlign.End
        )
    }
}
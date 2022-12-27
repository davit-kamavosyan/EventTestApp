package xyz.davitkamavosyan.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import xyz.davitkamavosyan.app.R
import xyz.davitkamavosyan.app.ui.components.text.TextTitle3

@Composable
fun Weather(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    degreeInCelsius: String?,
) {
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .height(48.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (imageUrl.isNullOrEmpty() && degreeInCelsius.isNullOrEmpty()) {
                TextTitle3(text = stringResource(id = R.string.weather_is_unavailable))
            } else {
                imageUrl?.let {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = rememberAsyncImagePainter(model = imageUrl),
                        contentDescription = null
                    )
                }
                degreeInCelsius?.let {
                    TextTitle3(text = "$degreeInCelsius°")
                }
            }
        }
    }
}
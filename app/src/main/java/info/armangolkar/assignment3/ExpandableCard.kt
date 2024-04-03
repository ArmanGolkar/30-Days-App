package info.armangolkar.assignment3
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import info.armangolkar.assignment3.ui.theme.Shapes
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    modifier: Modifier,
    title: String,
    day: String,
    titleFontSize: TextUnit = 24.sp,
    titleFontWeight: FontWeight = FontWeight.Bold,
    ingredients: String,
    descriptionFontSize: TextUnit = 18.sp,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    shape: Shape = Shapes.medium,
    padding: Dp = 12.dp,
    painter: Int,
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                expandedState = !expandedState

            },
        elevation = CardDefaults.cardElevation(10.dp),
        shape = shape,
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter),
                contentDescription = title,
                modifier = Modifier.size(140.dp)
            )

            Column(modifier = Modifier.weight(1f)
                .padding(8.dp)
            ) {
                Text(
                    text = day,
                    fontSize = 18.sp,
                )
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = titleFontWeight

                )
                if (expandedState) {
                    Text(
                        text = ingredients,
                        fontSize = descriptionFontSize,
                        fontWeight = descriptionFontWeight,
                        maxLines = 8,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            IconButton(
                modifier = Modifier.alpha(ContentAlpha.medium),
                onClick = {
                    expandedState = !expandedState
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Drop-Down Arrow",
                    modifier = Modifier.rotate(rotationState)
                )
            }
        }
    }
}







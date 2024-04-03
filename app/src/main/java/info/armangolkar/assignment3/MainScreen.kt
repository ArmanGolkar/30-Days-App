package info.armangolkar.assignment3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun MainScreen(
    imageId: Array<Int>,
    names: Array<String>,
    ingredients: Array<String>,
    modifier: Modifier = Modifier,
) {

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = imageId.size

        items(itemCount) {
            ExpandableCard(
                modifier = modifier,
                painter = imageId[it],
                title =  names[it],
                ingredients = ingredients[it],
                day = "Day: ${it + 1}"

            )
        }
    }

}

//@Composable
//fun ColumnItem(
//    modifier: Modifier,
//    painter: Array<Int>,
//    title: Array<String>,
//    ingredients: Array<String>,
//    itemIndex: Int,
//    navController: NavController
//) {
//
//
//    Card(
//        modifier
//            .padding(10.dp)
//            .wrapContentSize()
//            .clickable {
//                navController.navigate(route= "DetailScreen/$itemIndex")
//            },
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        ),
//        elevation = CardDefaults.cardElevation(10.dp)
//    ) {
//        Row(
//            modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.Top,
//            horizontalArrangement = Arrangement.spacedBy(15.dp)
//        ) {
//            Image(
//                painter = painterResource(id = painter[itemIndex]),
//                contentDescription = title[itemIndex],
//                modifier.size(140.dp)
//            )
//            Column(modifier.padding(12.dp)) {
//                Text(text = title[itemIndex], fontSize = 24.sp, fontWeight = FontWeight.Bold)
//                Text(text = ingredients[itemIndex], fontSize = 18.sp)
//
//            }
//        }
//    }
//}
package com.carolmusyoka.dazn.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.rounded.CalendarViewDay
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.Timelapse
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.carolmusyoka.dazn.domain.model.events.GetEventsResponseItem
import com.carolmusyoka.dazn.presentation.theme.lightGrey
import com.carolmusyoka.dazn.R
import com.carolmusyoka.dazn.domain.model.scheduled.GetScheduledEventsItem
import com.carolmusyoka.dazn.presentation.theme.blueDark
import com.carolmusyoka.dazn.presentation.theme.titleTextColor

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun EventCardItem(
    eventsResponseItem: GetEventsResponseItem,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 2.dp,
        onClick = {

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = lightGrey
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    modifier = Modifier.height(100.dp),
                    contentScale = ContentScale.Inside,
                    // populate product image
                    painter = rememberImagePainter(eventsResponseItem.imageUrl),
                    contentDescription = stringResource(R.string.app_name),
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // event name
                Text(
                    text = eventsResponseItem.title,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = titleTextColor
                )
                Spacer(modifier = Modifier.height(2.5.dp))


                Text(
                    text = eventsResponseItem.subtitle,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = blueDark,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }

            // event date and time
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            blueDark,
                            fontWeight = FontWeight.Bold,
                        )
                    ) {
                        append("Happening:  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            titleTextColor
                        )
                    ) {
                        // propulate date and time
                        append(eventsResponseItem.date.toString())
                    }
                },
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier,
                fontSize = 12.sp,
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalCoilApi::class)
@Composable
fun ScheduledCardItem(
    scheduledEventsItem: GetScheduledEventsItem,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 2.dp,
        onClick = {

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = lightGrey
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Image(
                    modifier = Modifier.height(100.dp),
                    contentScale = ContentScale.Inside,
                    // populate product image
                    painter = rememberImagePainter(scheduledEventsItem.imageUrl),
                    contentDescription = stringResource(R.string.app_name),
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // event name
                Text(
                    text = scheduledEventsItem.title,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = titleTextColor
                )
                Spacer(modifier = Modifier.height(2.5.dp))


                Text(
                    text = scheduledEventsItem.subtitle,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = blueDark,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }

            // event date and time
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            blueDark,
                            fontWeight = FontWeight.Bold,
                        )
                    ) {
                        append("Happening:  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            titleTextColor
                        )
                    ) {
                        // propulate date and time
                        append(scheduledEventsItem.date.toString())
                    }
                },
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier,
                fontSize = 12.sp,
            )
        }
    }
}

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterialApi::class)
@Composable
fun ScheduledItem(
    scheduledEventsItem: GetScheduledEventsItem
) {
    Card(onClick = {}) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(scheduledEventsItem.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(width = 90.dp, height = 110.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(text = scheduledEventsItem.title, style = MaterialTheme.typography.button, fontSize = 18.sp)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(text = scheduledEventsItem.subtitle, style = MaterialTheme.typography.body2, fontSize = 12.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Rounded.Timer,
                        contentDescription = null,
                        tint = blueDark,
                        modifier = Modifier.padding(end = 2.dp)
                    )
                    // time and date
                    Text(
                        text = "time and date",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ScheduleItemPreview(){
    ScheduledItem(
        scheduledEventsItem = GetScheduledEventsItem(
            id = "3",
            title = "Tottenham v Man City",
            subtitle = "UEFA Champions League",
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/dazn-recruitment/o/310511685198_image-header_pDach_1554872450000.jpeg?alt=media&token=5524d719-261e-49e6-abf3-a74c30df3e27",
            date = "2022-08-03T05:10:40.937Z",
        )
    )
}

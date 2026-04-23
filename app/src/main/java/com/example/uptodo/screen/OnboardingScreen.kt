package com.example.uptodo.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.uptodo.data.models.OnboardingPage
import com.example.uptodo.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

val titles = listOf(
    "Manage your tasks",
    "Create daily routine",
    "Organize your tasks"
)

val pages = listOf(
    OnboardingPage(
        image = R.drawable.onboarding_first,
        title = "Manage your tasks",
        description = "You can easily manage all of your daily tasks in DoMe for free"
    ),
    OnboardingPage(
        image = R.drawable.onboarding_second,
        title = "Create daily routine",
        description = "In Uptodo you can create your personalized routine to stay focused"
    ),
    OnboardingPage(
        image = R.drawable.onboarding_third,
        title = "Organize your tasks",
        description = "You can organize your daily tasks by adding your tasks into separate categories"
    )
)

val descriptions = listOf(
    "You can easily manage all of your daily tasks in DoMe for free",
    "In Uptodo you can create your personalized routine to stay focused",
    "You can organize your daily tasks by adding your tasks into separate categories"
)

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF121212)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // 1. SKIP Button
            TextButton(
                onClick = {},
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "SKIP",
                    color = Color.White.copy(alpha = 0.6f)
                )
            }

            // 2. Middle Section (Pager)
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) { pageIndex ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = pages[pageIndex].image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(280.dp)
                            .padding(top = 2.dp),
                        contentScale = ContentScale.Fit
                    )

                    /* Paging Indicator (Dashes) */
                    Row(
                        modifier = Modifier.padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(pages.size) { index ->
                            val isSelected = pagerState.currentPage == index
                            Box(
                                modifier = Modifier
                                    .width(26.dp)
                                    .height(4.dp)
                                    .clip(RoundedCornerShape(56.dp))
                                    .background(
                                        if (isSelected) Color.White else Color.White.copy(alpha = 0.2f)
                                    )
                            )
                        }
                    }

                    /* Title */
                    Text(
                        text = pages[pageIndex].title,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    /* Description */
                    Text(
                        text = pages[pageIndex].description,
                        color = Color.White.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 38.dp)
                    )
                }
            }
        }
    }
}

package com.example.uptodo.screen

import androidx.annotation.DrawableRes
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

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
fun OnboardingScreen(onFinish : () -> Unit){
    val pagerState = rememberPagerState(pageCount = { 3 })
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF121212),
    ) { innerPadding ->
        Column(
            modifier = Modifier.systemBarsPadding(),
        ) {
            TextButton(
                onClick = {},
            ) {
                Text(text = "Skip", color = Color.White.copy(alpha = 0.44f))
            }

            Spacer(modifier = Modifier.size(2.dp))

            HorizontalPager(state = pagerState, modifier = Modifier.weight(1f), verticalAlignment = Alignment.Top) { page ->
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(id = pages[page].image),
                        contentDescription = null,
                        modifier = Modifier.size(280.dp),
                        contentScale = ContentScale.Fit,
                    )

                    Spacer(modifier = Modifier.size(51.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        repeat(pagerState.pageCount) { iteration ->
                            val color = if (pagerState.currentPage == iteration) Color.White else Color.Gray
                            Box(
                                modifier = Modifier.background(color).height(4.dp).width(26.dp).padding(horizontal = 4.dp).clip(RoundedCornerShape(56.dp))

                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(50.dp))
                    Text(
                        text = "Manage your tasks",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White.copy(alpha = 87f)
                    )
                    Spacer(modifier = Modifier.size(50.dp))
                    Text(
                        text = "You can easily manager all of your daily tasks in DoMe for free",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White.copy(alpha = 8.87f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 38.dp),
                        lineHeight = 30.sp
                    )
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                TextButton(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }) {
                    Text(text = "BACK", color = Color.White.copy(alpha = 0.44f))
                }
                Button(
                    onClick = {
                        scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF8875FF)
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = if (pagerState.pageCount == pagerState.currentPage + 1) "Get Started" else "NEXT", color = Color.White)
                }
            }
        }
    }
}

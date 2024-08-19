package uz.soatov.congratulations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.soatov.congratulations.ui.theme.CongratulationsTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			CongratulationsTheme {
				Surface {
					CongratulationCard()
				}
			}
		}
	}
}

@Composable
fun CongratulationCard(modifier: Modifier = Modifier) {
	Box(modifier = modifier) {
		CongratulationImage(modifier = modifier.fillMaxSize())
		CongratulationsText(
			message = "Loyiha muvaffaqiyatli ishga tushirildi", signature = "Kotlin+Java"
		)
	}
}

@Composable
fun CongratulationsText(message: String, signature: String, modifier: Modifier = Modifier) {
	Column(
		verticalArrangement = Arrangement.Center,
		modifier = modifier
			.fillMaxSize()
			.padding(horizontal = 15.dp)
	) {
		Text(
			text = message,
			fontSize = 30.sp,
			lineHeight = 40.sp,
			fontWeight = FontWeight.Bold,
			textAlign = TextAlign.Center,
			color = Color.Black,
			modifier = modifier
		)
		Text(
			text = signature,
			fontSize = 24.sp,
			lineHeight = 32.sp,
			color = Color.Black,
			modifier = modifier.align(alignment = Alignment.End)
		)
	}
}

@Composable
fun CongratulationImage(modifier: Modifier = Modifier) {
	val backgroundImage = painterResource(id = R.drawable.congratulations)
	Image(
		painter = backgroundImage,
		contentDescription = "",
		alpha = 0.3F,
		contentScale = ContentScale.Crop,
		modifier = modifier.fillMaxSize()
	)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CongratulationCardPreview() {
	CongratulationsTheme {
		CongratulationCard()
	}
}
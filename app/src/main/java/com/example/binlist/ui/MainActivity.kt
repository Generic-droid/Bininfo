package com.example.binlist.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.binlist.BinlistApplication
import com.example.binlist.R
import com.example.binlist.di.viewmodelfactory.ViewModelFactory
import com.example.binlist.ui.theme.BinlistTheme
import com.example.core.models.BinInfo
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as BinlistApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        setContent {
            BinlistTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }

    @Composable
    private fun MyApp(
        modifier: Modifier = Modifier
    ) {

        var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

        Surface(modifier) {
            if (shouldShowOnBoarding) {
                OnBoardingScreen(onContinueClicked = { shouldShowOnBoarding = false })
            } else BinInfoScreen()
        }
    }

    @Composable
    fun BinInfoScreen(
        modifier: Modifier = Modifier
    ) {

        val binInfoState by viewModel.binList.collectAsState()
        val binInfoBoxState by viewModel.binInfoBoxState.collectAsState()

        Log.d("MyLog", "$binInfoState")

        LazyColumn(
            modifier = modifier
                .padding(vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                BinInfoCard(binInfo = binInfoBoxState)
            }
            items(items = binInfoState) { binInfo ->
                BinInfoCard(
                    binInfo = binInfo,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            }
        }
    }

    @Composable
    fun BinInfoCard(
        binInfo: BinInfo,
        containerColor: Color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = containerColor
            ),
            modifier = Modifier
                .sizeIn(maxWidth = 400.dp)
                .wrapContentHeight()
                .padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            BinInfoCardContent(binInfo = binInfo)
        }
    }

    @Composable
    private fun BinInfoCardContent(
        binInfo: BinInfo
    ) {
        var expanded by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            var binNumber by rememberSaveable { mutableStateOf("0000") }

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = binInfo.bankName)
                    Text(text = binInfo.bankCity)
                }
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (expanded) {
                            stringResource(R.string.show_less)
                        } else {
                            stringResource(R.string.show_more)
                        }
                    )
                }
            }
            if (expanded) {
                Text(text = binInfo.bankUrl)
                Text(text = binInfo.bankPhone)
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp, horizontal = 0.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                CardNumberElement(number = "")
                Spacer(modifier = Modifier.width(8.dp))
                CardNumberElement(number = "")
                Spacer(modifier = Modifier.width(8.dp))
                CardNumberElement(number = "****", false)
                Spacer(modifier = Modifier.width(8.dp))
                CardNumberElement(number = "****", false)
            }

            if (expanded) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "SCHEME / NETWORK",
                                    fontSize = 10.sp
                                )
                                Text(text = "VISA")
                            }
                        }
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "BRAND",
                                    fontSize = 10.sp
                                )
                                Text(text = "Visa / Dancort")
                            }
                        }
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "CARD NUMBER",
                                    fontSize = 10.sp
                                )
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text(
                                            text = "LENGTH",
                                            fontSize = 8.sp
                                        )
                                        Text(text = "16")
                                    }
                                    Spacer(modifier = Modifier.size(32.dp))
                                    Column {
                                        Text(
                                            text = "LUHN",
                                            fontSize = 8.sp
                                        )
                                        Text(text = "YES/NO")
                                    }
                                }
                            }
                        }
                    }

                    Column {
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "TYPE",
                                    fontSize = 10.sp
                                )
                                Text(text = "Debit")
                            }
                        }
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "PREPAID",
                                    fontSize = 10.sp
                                )
                                Text(text = "No")
                            }
                        }
                        Box(
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                            ) {
                                Text(
                                    text = "COUNTRY",
                                    fontSize = 10.sp
                                )
                                Text(text = "dk Denmark")
                                Text(
                                    text = "(latitude 56, longitude 10",
                                    fontSize = 8.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun CardNumberElement(
        number: String = "0000",
        enabled: Boolean = true
    ) {

        var value by rememberSaveable { mutableStateOf(number) }
        val maxChar = 4

        BasicTextField(
            modifier = Modifier
                .requiredWidth(72.dp)
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.background
                    ),
                    shape = RoundedCornerShape(percent = 60)
                ),
            value = value,
            onValueChange = { if (it.length <= maxChar) value = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            enabled = enabled,
            decorationBox = {
                Text(
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp,
                            vertical = 8.dp

                        ),
                    text = value.ifEmpty { "" },
                    textAlign = TextAlign.Center
                )
            }
        )
    }
}
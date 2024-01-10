package com.calculatooor.simple_calculator.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.calculatooor.simple_calculator.R
import com.calculatooor.simple_calculator.ui.theme.Simple_CalculatorTheme
import com.calculatooor.simple_calculator.viewmodel.CalcViewModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp


@Preview(showSystemUi = true, device = "id:pixel_6")
@Composable
fun MainScreen(viewModel: CalcViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val isD = isSystemInDarkTheme()
    val isDark = remember {
         mutableStateOf(isD)
    }

    Simple_CalculatorTheme(darkTheme = isDark.value) {
        val textValue = remember {
            viewModel.expression
        }

        val errorValue = remember {
            viewModel.error
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = if (isDark.value) colorResource(id = R.color.RaisinBlack) else Color.White)
                .padding(top = 10.sdp), verticalArrangement = Arrangement.SpaceBetween
        ) {
            LightAndDartCard(modifier = Modifier.align(Alignment.CenterHorizontally),isDark)

            CalcText(textValue, errorValue,isDark)

            CalcTools(textValue, viewModel,isDark)
        }
    }
}



@Composable
fun CalcTools(text: MutableState<String>, viewModel: CalcViewModel, isDark: MutableState<Boolean>) {
    Card(colors = CardDefaults.cardColors(containerColor = if (isDark.value) colorResource(
        id = R.color.Gunmetal
    ) else colorResource(id = R.color.SeaSalt)),
        shape =
        RoundedCornerShape(
            topEnd = 20.sdp,
            topStart = 20.sdp,
            bottomEnd = 0.sdp,
            bottomStart = 0.sdp
        ), modifier = Modifier
            .wrapContentSize()

    ) {

       LazyVerticalGrid(columns = GridCells.Fixed(4), modifier = Modifier
           .padding(10.sdp)
           , verticalArrangement = Arrangement.spacedBy(8.sdp,Alignment.Bottom),
           horizontalArrangement = Arrangement.spacedBy(8.sdp)){
           item {
              ButtonTool(isDark,"AC",13.ssp, colorResource(id = R.color.green)){viewModel.clearAll()}
          }
           item {
               ButtonTool(isDark, "C", 13.ssp, colorResource(id = R.color.green)){if(text.value.isNotEmpty())viewModel.clear()}
           }
           item {
               ButtonTool(isDark, "%", 13.ssp, colorResource(id = R.color.green)){viewModel.parseText("%") }
           }
           item {
               ButtonTool(isDark, "÷", 18.ssp, colorResource(id = R.color.red)){viewModel.parseText("÷")}
           }
           item {
               ButtonTool(isDark, "7", 13.ssp){viewModel.parseText("7")}
           }
           item {
               ButtonTool(isDark, "8", 13.ssp){viewModel.parseText("8")}
           }
           item {
               ButtonTool(isDark, "9", 13.ssp){viewModel.parseText("9")}
           }
           item {
               ButtonTool(isDark, "×", 18.ssp, colorResource(id = R.color.red)){viewModel.parseText("×")}
           }
           item {
               ButtonTool(isDark, "4", 13.ssp){viewModel.parseText("4")}
           }
           item {
               ButtonTool(isDark, "5", 13.ssp){viewModel.parseText("5")}
           }
           item {
               ButtonTool(isDark, "6", 13.ssp){viewModel.parseText("6")}
           }
           item {
               ButtonTool(isDark, "-", 18.ssp, colorResource(id = R.color.red)){viewModel.parseText("-")}
           }
           item {
               ButtonTool(isDark, "1", 13.ssp){viewModel.parseText("1")}
           }
           item {
               ButtonTool(isDark, "2", 13.ssp){viewModel.parseText("2")}
           }
           item {
               ButtonTool(isDark, "3", 13.ssp){viewModel.parseText("3")}
           }
           item {
               ButtonTool(isDark, "+", 18.ssp, colorResource(id = R.color.red)){viewModel.parseText("+")}
           }
           item {
               ButtonTool(isDark, "00", 13.ssp){viewModel.parseText("00")}
           }
           item {
               ButtonTool(isDark, "0", 13.ssp){viewModel.parseText("0")}
           }
           item {
               ButtonTool(isDark, ".", 13.ssp){viewModel.parseText(".")}
           }
           item {
               ButtonTool(isDark, "=", 18.ssp, colorResource(id = R.color.red)){if (text.value.isNotEmpty())viewModel.getResult(text.value)}
           }


       }
    }
}

@Composable
fun ButtonTool(
    isDark: MutableState<Boolean>,
    text: String,
    fontSize: TextUnit,
    color: Color = if (isDark.value) Color.White else Color.Black,
    action: () -> Unit
){
    Button(onClick = action ,
        shape = RoundedCornerShape(10.sdp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.sdp,
            pressedElevation = 8.sdp,
            disabledElevation = 0.sdp
        ),
        modifier = Modifier
            .aspectRatio(1f)
            .fillMaxWidth()
            .padding(2.sdp)
     , colors = ButtonDefaults.buttonColors(containerColor = if(isDark.value) colorResource(
            id = R.color.Gunmetal2
        ) else colorResource(id = R.color.BabyPowder))
    ) {
        Text(text = text, color = color, fontSize = fontSize, fontWeight = FontWeight.Bold)

    }
}

@Composable
fun CalcText(
    text: MutableState<String>,
    errorValue: MutableState<String>,
    isDark: MutableState<Boolean>
) {
    Column {
        BasicTextField(value = TextFieldValue(
            text = text.value,
            selection = TextRange(text.value.length) // TextRange(0, textValue.length) -> Select that text in a color
        ), onValueChange = {},textStyle = TextStyle.Default.copy(color = if (isDark.value) Color.White else Color.Black, fontSize = 25.ssp, fontWeight = FontWeight.Bold, textAlign = TextAlign.End),modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.sdp, end = 10.sdp)
            .testTag("RESULT"), enabled = false, singleLine = true
        )
        Spacer(modifier = Modifier.padding(2.sdp))
        BasicTextField(value = TextFieldValue(
            text = errorValue.value,
            selection = TextRange(errorValue.value.length)  // TextRange(0, textValue.length) -> Select that text in a color
        ), onValueChange = {},textStyle = TextStyle.Default.copy(color = Color.Red, fontSize = 15.ssp, fontWeight = FontWeight.Bold, textAlign = TextAlign.End),modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.sdp, end = 10.sdp)
            .testTag("ERROR"), enabled = false, singleLine = true
        )
    }

}

@Composable
fun LightAndDartCard(modifier: Modifier, isDark: MutableState<Boolean>) {
    Card(
        colors = CardDefaults.cardColors(containerColor = if(isDark.value) colorResource(id = R.color.Gunmetal) else colorResource(id = R.color.SeaSalt)),

        shape = CircleShape, modifier = modifier
            .height(40.sdp)
            .width(100.sdp)

    ) {
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = if(isDark.value)  painterResource(id = R.drawable.outline_wb_sunny_24_4_2) else painterResource(id = R.drawable.outline_wb_sunny_24),
                contentDescription = stringResource(R.string.sun_image),
                modifier = Modifier
                    .weight(1f)
                    .clickable { isDark.value = false }
            )
            Image(
                painter = if(isDark.value) painterResource(id = R.drawable.outline_brightness_2_24_white) else painterResource(id = R.drawable.outline_brightness_2_24),
                contentDescription = stringResource(R.string.crescent_image),
                modifier = Modifier
                    .weight(1f)
                    .clickable { isDark.value = true }
            )
        }
    }
}




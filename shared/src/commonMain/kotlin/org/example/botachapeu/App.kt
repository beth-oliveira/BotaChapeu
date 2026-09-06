package org.example.botachapeu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import botachapeu.shared.generated.resources.Res
import botachapeu.shared.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource

import kotlin.math.roundToInt

@Composable
@Preview
fun App() {

    val listaDeChapeus = listOf(
        Pair(Res.drawable.chef_hat, Res.drawable.chef_hat_sized ),
        Pair(Res.drawable.cowboy_hat, Res.drawable.cowboy_hat_sized),
        Pair(Res.drawable.deluxe_cowboy_hat, Res.drawable.deluxe_cowboy_hat_sized),
        Pair(Res.drawable.propeller_hat, Res.drawable.propeller_hat_sized),
        Pair(Res.drawable.straw_hat, Res.drawable.straw_hat_sized)
    )

    var chapeuAtual by remember { mutableStateOf<DrawableResource?>(null) }

    fun hexColor(hex: String, transp: Int = 100): Long = hex
        .replace("#", (transp.toDouble() * 255).roundToInt().toString(16))
        .toLong(16)

    MaterialTheme {
        Box(
            Modifier.fillMaxSize()
                .background(
                    color = Color(hexColor("#f4f4f2"))
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(25.dp),
            ) {
                Column(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Color(hexColor("#243a69")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(500.dp)
                            .height(500.dp)
                            .padding(10.dp)
                    ) {
                        Image(
                            contentDescription = "Imagem do Estábulo",
                            painter = painterResource(Res.drawable.horse_stable_sized),
                        )
                        Image(
                            contentDescription = "Imagem do Cavalo",
                            painter = painterResource(Res.drawable.horse_sized),
                            modifier = Modifier
                                .clickable{
                                    chapeuAtual = null
                                }
                        )
                        if (chapeuAtual != null) {
                            Image(
                                contentDescription = "Imagem do Chapéu",
                                painter = painterResource(chapeuAtual!!),
                            )
                        }

                    }
                }
                Column(
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            color = Color(hexColor("#5b88a5", 100)),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp)
                ) {
                    listaDeChapeus.forEach { imgRes ->
                        Image(
                            painter = painterResource(imgRes.first),
                            contentDescription = "Miniatura",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(2.dp)
                                .border(1.dp, Color.DarkGray, RoundedCornerShape(6.dp))
                                .padding(3.dp)
                                .clickable {
                                    chapeuAtual = imgRes.second
                                },
                        )
                    }
                }
            }
        }


    }
}
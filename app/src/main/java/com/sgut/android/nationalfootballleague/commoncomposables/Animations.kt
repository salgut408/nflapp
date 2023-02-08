package com.sgut.android.nationalfootballleague.commoncomposables

import android.graphics.RenderEffect
import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.sgut.android.nationalfootballleague.utils.customBlur
import org.intellij.lang.annotations.Language

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun MetaEntity(
    modifier: Modifier,
    blur: Float = 30f,
    metaContent: @Composable BoxScope.() -> Unit,
    content: @Composable BoxScope.() -> Unit = {}

    ) {
        Box(
            modifier = modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier = Modifier
                    .customBlur(blur),
                content = metaContent,
            )
            content()
        }

}

@Language("AGSL")
const val ShaderSource = """
    uniform shader composable;
    
    uniform float cutoff;
    uniform float3 rgb;
    
    half4 main(float2 fragCoord) {
        half4 color = composable.eval(fragCoord);
        color.a = step(cutoff, color.a);
        if (color == half4(0.0, 0.0, 0.0, 1.0)) {
            color.rgb = half3(rgb[0], rgb[1], rgb[2]);
        }
        return color;
    }"""


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MetaContainer(
    modifier: Modifier = Modifier,
    cutoff: Float = .5f,
    color: Color = Color.Black,
    content: @Composable BoxScope.() -> Unit,
) {
    val metaShader = remember {
        RuntimeShader(ShaderSource)
    }
    Box(
        modifier
            .graphicsLayer {
                metaShader.setFloatUniform("cutoff", cutoff)
                metaShader.setFloatUniform("rgb", color.red, color.green, color.blue)
                renderEffect = RenderEffect
                    .createRuntimeShaderEffect(
                        metaShader, "composable"
                    )
                    .asComposeRenderEffect()
            },
        content = content,
    )
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun ExpandableFAB() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        var expanded: Boolean by remember { mutableStateOf(false) }
        val offset by animateDpAsState(
            targetValue = if(expanded) 120.dp else 0.dp,
            spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = 100f,
            )
        )
        MetaContainer(
            modifier = Modifier.fillMaxSize()
        ) {
            FABButton(
                Modifier.offset(y = -offset),
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            FABButton(
                Modifier.offset(y = -offset),
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            FABButton(
                Modifier.offset(y = -offset),
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            
            FABButton(
                Modifier,
                onClick = { 
                    expanded != expanded
                }
            ) {
               val rotation by animateFloatAsState(targetValue = if (expanded) 45f else 0f)
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.rotate(rotation),
                    tint = Color.White,
                )
            }
            
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun BoxScope.FABButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
   MetaEntity(
       modifier = modifier
           .clickable(
               interactionSource = remember { MutableInteractionSource() },
               indication = null,
               onClick = onClick,
           )
           .align(Alignment.Center),
       blur = 50f,
       metaContent = {
           Box(
               modifier = Modifier
                   .background(Color.Black, CircleShape)
                   .fillMaxSize()
           )
       }
   ) {
       Box(
           modifier = Modifier.size(100.dp),
           content = content,
           contentAlignment = Alignment.Center
       )
   }
}